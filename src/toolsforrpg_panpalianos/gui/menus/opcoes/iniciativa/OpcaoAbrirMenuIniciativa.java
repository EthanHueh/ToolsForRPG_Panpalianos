package toolsforrpg_panpalianos.gui.menus.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.menus.MenuIniciativas;
import toolsforrpg_panpalianos.gui.menus.opcoes.Opcao;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new MenuIniciativas();
    }

}
