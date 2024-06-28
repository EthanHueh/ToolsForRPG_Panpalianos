package toolsforrpg_panpalianos.dominio.servicos;

import toolsforrpg_panpalianos.dados.modelo.Personagem;
import toolsforrpg_panpalianos.gui.telas.TelaInput;

public class SimuladorDeCombate {

    private Personagem jogador;
    private Personagem inimigo;

    public SimuladorDeCombate(Personagem jogador, Personagem inimigo){
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void executar() {

        while(true){

            iniciarTurnoJogador();

            if(isGameOver()){
                anunciarVencendor();
                return;
            }

            iniciarTurnoInimigo();

            if(isGameOver()){
                anunciarVencendor();
                return;
            }
        }

    }

    private void iniciarTurnoJogador() {

        int opcao = new TelaInput("O que fazes?"+jogador.getFicha().getNome()).obterInput();
        
        switch (opcao) {
            case 1:
                jogador.atacar(inimigo);
                break;
        
            default:
                inimigo.falar();
                break;
        }
    }

    private void iniciarTurnoInimigo() {
        inimigo.atacar(jogador);
    }

    private boolean isGameOver() {   
        return !(jogador.isAlive() && inimigo.isAlive());
    }

    private void anunciarVencendor() {
        if(jogador.isAlive()){
            System.out.println(jogador.getFicha().getNome()+" venceu!");
        }
        if(inimigo.isAlive()){
            System.out.println(inimigo.getFicha().getNome()+" venceu!");
        }
    }

}
