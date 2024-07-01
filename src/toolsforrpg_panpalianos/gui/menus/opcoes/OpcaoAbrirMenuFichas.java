package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.menus.MenuFichas;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new MenuFichas();
    }

}
