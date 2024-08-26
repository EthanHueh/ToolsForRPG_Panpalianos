package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.GerenciadorTelas;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas() {
        super("Abrir menu de fichas");
    }

    @Override
    public void executar() {
        GerenciadorTelas.telaMenuFichas.iniciar();
    }

}