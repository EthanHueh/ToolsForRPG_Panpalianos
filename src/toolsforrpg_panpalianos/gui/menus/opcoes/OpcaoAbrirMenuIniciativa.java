package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.menus.MenuIniciativa;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new MenuIniciativa();
    }

}
