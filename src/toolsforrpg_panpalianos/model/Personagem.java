package toolsforrpg_panpalianos.model;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.service.Regras;
import toolsforrpg_panpalianos.utils.RoladorDeDados;

public class Personagem {
    
    private FichaCriatura ficha;
    private int quantPVsAtual;

    public Personagem(FichaCriatura ficha){
        this.ficha = ficha;
        this.quantPVsAtual = ficha.getQuantPVs();
    }

    public void atacar(Personagem inimigo){
        System.out.println(ficha.getNome()+" ataca "+inimigo.getFicha().getNome());

        int resultadoDoDado = RoladorDeDados.executar(1, 6);
        int dano = resultadoDoDado + Regras.calcularBonus(getFicha().getForca());
        System.out.println(inimigo.getFicha().getNome()+" toma "+dano+" de dano!");

        inimigo.setQuantPVsAtual(inimigo.getQuantPVsAtual() - dano);
        System.out.println(inimigo.getFicha().getNome()+ " esta com "+ inimigo.getQuantPVsAtual()+"PV!!\n");
    }

    public void falar(){
        System.out.println(ficha.getNome()+" disse oi!");
    }

    public FichaCriatura getFicha() {
        return ficha;
    }

    public void setFicha(FichaCriatura ficha) {
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

    public void iniciarTurno(Personagem inimigo) {
        int opcao = 0;

        try {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "O que fazes?", getFicha().getNome(), 0));
        } catch (NumberFormatException e) {
            opcao = 0;
        }
        
        switch (opcao) {
            case 1:
                this.atacar(inimigo);
                break;
        
            default:
                this.falar();
                break;
        }
    }
}