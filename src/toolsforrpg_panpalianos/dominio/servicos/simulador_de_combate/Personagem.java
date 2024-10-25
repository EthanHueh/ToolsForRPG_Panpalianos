package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes.AcaoClasse;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes.AcaoClerigo;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes.AcaoHomemDeArmas;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes.AcaoLadrao;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes.AcaoMago;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes.AcaoNula;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class Personagem {
    
    private Ficha ficha;
    
    private int quantPocoes = 2;
    private int habilidadeClasse = 2;
    private AcaoClasse acaoClasse;
 
    private boolean bloqueando = false;
    private boolean desviando = false;

    public Personagem(){

    }

    public String realizarAcao(Personagem inimigo) {
        return realizarAcao(1, inimigo);
    }

    public String realizarAcao(int opcao, Personagem inimigo) {
        
        bloqueando = false;
        desviando = false;
        
        switch (opcao) {
            case 1:
                return atacar(inimigo);
     
            case 2:
                return bloquear();
                
            case 3:
                return desviar();
                
            case 4:
                return usarPocao();
                
            case 5:
                return usarHabilidadeClasse(inimigo);
                      
            default:
                return ficha.getNome()+" fez nada!";
 
        }
        
    }

    public String atacar(Personagem inimigo) {
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
    
    public String bloquear(){
        bloqueando = true;
        return ficha.getNome()+" prepara-se para defender-se! Dano reduzido pela metade!!!";
    }
    
    public String desviar(){
        desviando = true;
        return ficha.getNome()+" prepara-se para desviar! CA +5!!!";
    }

    public void resetar() {
        quantPocoes = 2;
        habilidadeClasse = 2;
 
        acaoClasse = null;
        bloqueando = false;
        desviando = false;

        ficha.setQuantPVsAtual(Calculadora.calcularPVMaximo(ficha));
       
    }

    private String usarHabilidadeClasse(Personagem inimigo) {

        if (!(ficha instanceof FichaJogador)){
            return ficha.getNome()+" fez nada!";
        }

        if (acaoClasse == null){
            atualizarAcaoClasse();
        }

        if (habilidadeClasse > 0){
            return acaoClasse.acionar(this, inimigo);
        }

        return ficha.getNome()+" fez nada!";
        
    }

    private void atualizarAcaoClasse() {
        FichaJogador fichaJogador = (FichaJogador) ficha;

        switch (fichaJogador.getClasse()) {
            case CLERIGO:
                acaoClasse = new AcaoClerigo();
                break;

            case HOMEM_DE_ARMAS:
                acaoClasse = new AcaoHomemDeArmas();
                break;

            case LADRAO:
                acaoClasse = new AcaoLadrao();
                break;

            case MAGO:
                acaoClasse = new AcaoMago();
                break;

            default:
                acaoClasse = new AcaoNula();
                break;
        }
    }

    public void adicionarPocoes(int pocoesEncontradas) {
        quantPocoes += pocoesEncontradas;
    }

    public void curar(int hpCurado) {
        ficha.setQuantPVsAtual(ficha.getQuantPVsAtual() + hpCurado);
        
        if (ficha.getQuantPVsAtual() > Calculadora.calcularPV(ficha)){
            ficha.setQuantPVsAtual(quantPocoes);
        }
        
    }

    public void gastarPontoHabilidade(int n) {
        if (habilidadeClasse > 0){
            habilidadeClasse -= n;
        }
    }

    public int tomarDano(int dano) {

        if (bloqueando){
            dano /= 2;
        }
        
        ficha.setQuantPVsAtual(ficha.getQuantPVsAtual() - dano);
        
        return dano;
    }
    
    private String usarPocao() {
        if (quantPocoes <= 0){
            return ficha.getNome()+" esta sem pocoes!!";
        }

        quantPocoes--;
        
        int hpCurado = RoladorDeDados.executar(1, 8);
    
        curar(hpCurado);
        
        return ficha.getNome()+" curou "+hpCurado+"!!!";
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

}