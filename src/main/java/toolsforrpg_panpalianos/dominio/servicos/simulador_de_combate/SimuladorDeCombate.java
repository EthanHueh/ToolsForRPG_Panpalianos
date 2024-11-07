package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

import lombok.Getter;

@Getter
public class SimuladorDeCombate {
        
    private Personagem jogador = new Personagem();
    private Personagem inimigo = new Personagem();
    private Personagem personagemAtual = jogador;
    private int numeroTurnos = 1;
    
    public void avancarTurno(){
        numeroTurnos++;
        if (personagemAtual == jogador){
            personagemAtual = inimigo;
        } else {
            personagemAtual = jogador;
        }

    }

    public boolean isGameOver() {
        return !(jogador.isAlive() && inimigo.isAlive());
    }

    public boolean isTurnoJogador() {
        return personagemAtual == jogador;
    }

    public void resetar(){
        numeroTurnos = 1;
        jogador.resetar();
        inimigo.resetar();
    }

}
