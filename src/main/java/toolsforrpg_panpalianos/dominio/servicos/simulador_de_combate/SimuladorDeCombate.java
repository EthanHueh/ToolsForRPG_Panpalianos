package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

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

    public Personagem personagemAtual(){
        return personagemAtual;
    }

    public void resetar(){
        numeroTurnos = 1;
        jogador.resetar();
        inimigo.resetar();
    }

    public int turnoAtual() {
        return numeroTurnos;
    }

    public Personagem getJogador() {
        return jogador;
    }

    public void setJogador(Personagem jogador) {
        this.jogador = jogador;
    }

    public Personagem getInimigo() {
        return inimigo;
    }

    public void setInimigo(Personagem inimigo) {
        this.inimigo = inimigo;
    }

}
