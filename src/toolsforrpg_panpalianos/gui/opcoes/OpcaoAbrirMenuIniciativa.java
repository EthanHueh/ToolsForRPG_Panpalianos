package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.GerenciadorTelas;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa() {
        super("Abrir menu de iniciativas");
    }

    @Override
    public void executar() {
        GerenciadorTelas.telaMenuIniciativas.iniciar();
    }

}
