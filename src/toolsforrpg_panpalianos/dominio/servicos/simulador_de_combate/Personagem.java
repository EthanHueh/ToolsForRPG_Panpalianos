package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class Personagem {
    
    private Ficha ficha;
    
    private int quantPocoes = 2;
    private int habilidadeClasse = 2;
 
    private boolean bloqueando = false;
    private boolean desviando = false;

    public Personagem(){

    }
    
    public void bloquear(){
        bloqueando = true;
    }
    
    public void desviar(){
        desviando = true;
    }

    private int tomarDano(int dano) {

        if (bloqueando){
            dano /= 2;
        }
        
        ficha.setQuantPVsAtual(ficha.getQuantPVsAtual() - dano);
        
        return dano;
    }
    
    public String realizarAcao(Personagem inimigo) {
        return realizarAcao(1, inimigo);
    }

    public String realizarAcao(int opcao, Personagem inimigo) {
        
        bloqueando = false;
        desviando = false;
        
        FichaJogador fichaJogador = null;
        if (ficha instanceof FichaJogador){
            fichaJogador = (FichaJogador) ficha;
        }
        
        switch (opcao) {
            case 1:
                return atacar(inimigo);
     
            case 2:
                bloquear();
                return ficha.getNome()+" prepara-se para defender-se! Dano reduzido pela metade!!!";
                
            case 3:
                desviar();
                return ficha.getNome()+" prepara-se para desviar! CA +5!!!";
                
            case 4:
                
                if (quantPocoes <= 0){
                    return ficha.getNome()+" esta sem pocoes!!";
                }
                
                int hpCurado = usarPocao();
                return ficha.getNome()+" curou "+hpCurado+"!!!";
                
            case 5:
                
                if (fichaJogador == null){
                    return ficha.getNome()+" fez nada!";
                }
                
                switch(fichaJogador.getClasse()){
                    
                    case CLERIGO:
                        if (habilidadeClasse <= 0){
                            return ficha.getNome()+" fez nada!";
                        }
                        
                        habilidadeClasse--;
                        
                        int bonusLvl = fichaJogador.getLvl();
                        
                        if (bonusLvl > 4){
                            bonusLvl = 4;
                        }
                        
                        hpCurado = RoladorDeDados.executar(1,8) + bonusLvl;

                        return ficha.getNome()+" usou Curar Ferimentos!! Curou "+hpCurado+"!!";
                        
                    case HOMEM_DE_ARMAS:
                        if (habilidadeClasse <= 0){
                            return ficha.getNome()+" fez nada!";
                        }
                        
                        habilidadeClasse--;
                        
                        return
                            ficha.getNome()+" ataca duas vezes!!\n"+
                            atacar(inimigo)+
                            atacar(inimigo);
                        
                    case LADRAO:
                        int pocoesEncontradas = RoladorDeDados.executar(1,2);
                        
                        quantPocoes += pocoesEncontradas;
                        return ficha.getNome()+" obteve "+pocoesEncontradas+"!!!";
                        
                    case MAGO:
                        if (habilidadeClasse <= 0){
                            return ficha.getNome()+" fez nada!";
                        }
                        
                        habilidadeClasse--;
                        
                        bonusLvl = fichaJogador.getLvl();
                        
                        if (bonusLvl > 4){
                            bonusLvl = 4;
                        }
                        
                        int quantMissil = Math.round(fichaJogador.getLvl() / 3);
                        
                        int dano = quantMissil + bonusLvl;
                        int danoRecebido = inimigo.tomarDano(dano);

                        return ficha.getNome()+" usou missil, "+inimigo.getFicha().getNome()+" recebeu "+danoRecebido+" de dano!";
                        
                    default:
                        return ficha.getNome()+" fez nada!";
 
                }

            default:
                return ficha.getNome()+" fez nada!";
        }
        
    }

    private int usarPocao() {
        int hpCurado = RoladorDeDados.executar(1, 8);
        quantPocoes--;
        
        curar(hpCurado);
        
        return hpCurado;
    }
    
    private String atacar(Personagem inimigo) {
        int testeAtaque = 0;
        
        if (ficha.getEquipamento().getArma().isDistancia()){
            testeAtaque = Calculadora.calcularResultadoTeste(ficha, TipoAtributo.DESTREZA);
        } else {
            testeAtaque = Calculadora.calcularResultadoTeste(ficha, TipoAtributo.FORCA);
        }

        String nomeInimigo = inimigo.getFicha().getNome();
        
        int CAInimigo = inimigo.getFicha().getClasseArmadura();
        if (inimigo.isDesviando()){
            CAInimigo += 5;
        }

        if (testeAtaque < CAInimigo){
            return
                ficha.getNome()+" ataca "+nomeInimigo+"\n"+
                ficha.getNome()+" erra o ataque!!\n";
        }

        int dano = Calculadora.calcularDano(this.ficha);
        int danoRecebido = inimigo.tomarDano(dano);

        return
            ficha.getNome()+" ataca "+nomeInimigo+"\n"+
            nomeInimigo+" toma "+danoRecebido+" de dano!\n"+
            nomeInimigo+" esta com "+inimigo.getFicha().getQuantPVsAtual()+"PV!!\n";
    }

    private void curar(int hpCurado) {
        ficha.setQuantPVsAtual(ficha.getQuantPVsAtual() + hpCurado);
        
        if (ficha.getQuantPVsAtual() > Calculadora.calcularPV(ficha)){
            ficha.setQuantPVsAtual(quantPocoes);
        }
        
    }
    

    public boolean isAlive() {
        return (ficha.getQuantPVsAtual() > 0);
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public int getHabilidadeClasse() {
        return habilidadeClasse;
    }
    
    public boolean isDesviando(){
        return desviando;
    }
    
    public boolean isBloqueando(){
        return bloqueando;
    }

    public void resetar() {
        quantPocoes = 2;
        habilidadeClasse = 2;
 
        bloqueando = false;
        desviando = false;
       
    }

}