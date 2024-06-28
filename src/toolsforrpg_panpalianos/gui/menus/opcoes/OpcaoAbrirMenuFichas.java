package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.menus.MenuDeFichas;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new MenuDeFichas();
    }

}
