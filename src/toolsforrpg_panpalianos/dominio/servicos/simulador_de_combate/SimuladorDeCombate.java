package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate;

public class SimuladorDeCombate {
        
    private Personagem jogador = new Personagem();
    private Personagem inimigo = new Personagem();
    private int numeroTurnos = 0;

    public void avancarTurno(){
        numeroTurnos++;
    }

    public void resetar(){
        numeroTurnos = 0;
        jogador.resetar();
        inimigo.resetar();
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

    public int getNumeroTurnos() {
        return numeroTurnos;
    }

    public boolean isGameOver() {
        return !(jogador.isAlive() && inimigo.isAlive());
    }

}
