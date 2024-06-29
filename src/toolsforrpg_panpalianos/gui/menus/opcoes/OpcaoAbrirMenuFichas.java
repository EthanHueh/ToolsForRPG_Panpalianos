package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaMenuDeFichas;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuDeFichas();
    }

}
