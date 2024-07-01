package toolsforrpg_panpalianos.dados.modelo;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class Personagem {
    
    private Ficha ficha;
    private int quantPVsAtual;

    public Personagem(Ficha ficha){
        this.ficha = ficha;
        this.quantPVsAtual = Calculadora.calcularPVMaximo(ficha);
    }

    public void atacar(Personagem inimigo){

        System.out.println(ficha.getNome()+" ataca "+inimigo.getFicha().getNome());

        int dano = calcularDano();
        System.out.println(inimigo.getFicha().getNome()+" toma "+dano+" de dano!");

        inimigo.tomarDano(dano);
        System.out.println(inimigo.getFicha().getNome()+ " esta com "+ inimigo.getQuantPVsAtual()+"PV!!\n");
    }

    private void tomarDano(int dano) {
        this.setQuantPVsAtual(getQuantPVsAtual() - dano);
    }

    private int calcularDano(){
        int resultadoDoDado = RoladorDeDados.executar(1, 6);
        return resultadoDoDado + Calculadora.calcularBonus(getFicha().getForca());
    }

    public void falar(){
        System.out.println(ficha.getNome()+" disse oi!");
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public int getQuantPVsAtual() {
        return quantPVsAtual;
    }

    public void setQuantPVsAtual(int quantPVsAtual) {
        this.quantPVsAtual = quantPVsAtual;
    }

    public boolean isAlive() {
        return (quantPVsAtual > 0);
    }
}