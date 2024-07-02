package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

import toolsforrpg_panpalianos.gui.telas.TelaInput;
import toolsforrpg_panpalianos.gui.telas.TelaTexto;

public class SimuladorDeCombate {

    private Personagem jogador;
    private Personagem inimigo;

    public SimuladorDeCombate(Personagem jogador, Personagem inimigo){
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void executar() {
        iniciarTurnoJogador();
    }

    private void iniciarTurnoJogador() {

        int opcao = TelaInput.obterInteiro("O que fazes?"+jogador.getFicha().getNome());
        
        switch (opcao) {
            case 1:
                jogador.atacar(inimigo);
                break;
        
            default:
                jogador.falar();
                break;
        }

        if(!(isGameOver())){
            iniciarTurnoInimigo();
        }
    }

    private void iniciarTurnoInimigo() {
        inimigo.atacar(jogador);

        if(!(isGameOver())){
            iniciarTurnoJogador();
        }
    }

    private boolean isGameOver() {   
        boolean isGameOver = !(jogador.isAlive() && inimigo.isAlive());

        if (isGameOver){
            anunciarVencendor();
        }

        return isGameOver;
        
    }

    private void anunciarVencendor() {

        String nomeVencedor = "";
        if(jogador.isAlive()){
            nomeVencedor = jogador.getFicha().getNome();
        } else {
            nomeVencedor = inimigo.getFicha().getNome();
        }
        
        TelaTexto.iniciar(nomeVencedor+" venceu!", "Vitoria!");
    }

}