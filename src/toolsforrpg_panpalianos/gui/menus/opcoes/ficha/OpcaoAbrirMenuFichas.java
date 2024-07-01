package toolsforrpg_panpalianos.gui.menus.opcoes.ficha;

import toolsforrpg_panpalianos.gui.menus.MenuFichas;
import toolsforrpg_panpalianos.gui.menus.opcoes.Opcao;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new MenuFichas();
    }

}
