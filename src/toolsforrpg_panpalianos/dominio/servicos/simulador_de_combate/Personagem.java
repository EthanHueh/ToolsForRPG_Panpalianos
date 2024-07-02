package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.gui.telas.TelaTexto;

public class Personagem {
    
    private Ficha ficha;

    public Personagem(Ficha ficha){
        this.ficha = ficha;
    }

    public void atacar(Personagem inimigo){

        String nomeInimigo = inimigo.getFicha().getNome();
        int dano = calcularDano();
        inimigo.tomarDano(dano);

        String msg =    ficha.getNome()+" ataca "+nomeInimigo+"\n"+
                        nomeInimigo+" toma "+dano+" de dano!\n"+
                        nomeInimigo+" esta com "+inimigo.getFicha().getQuantPVsAtual()+"PV!!\n";

        TelaTexto.iniciar(msg, "Turno de "+ficha.getNome());
    }

    public void falar(){
        TelaTexto.iniciar(ficha.getNome()+" disse oi!", "Acao");
    }

    private void tomarDano(int dano) {
        ficha.setQuantPVsAtual(ficha.getQuantPVsAtual() - dano);
    }

    private int calcularDano(){
        return RoladorDeDados.executar(1, getDadoDano()) + Calculadora.calcularBonus(getFicha().getForca());
    }

    private int getDadoDano(){
        return ficha.getEquipamento().getArma().getDadoDano();
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

}