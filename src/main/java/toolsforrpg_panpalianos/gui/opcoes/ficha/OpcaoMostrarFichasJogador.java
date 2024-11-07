package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoMostrarFichasJogador extends Opcao {

    public OpcaoMostrarFichasJogador() {
        super("Mostrar fichas de jogador");
    }

    @Override
    public void executar() {
        TelaFichas.mostrarFichasJogador();
    }

}
