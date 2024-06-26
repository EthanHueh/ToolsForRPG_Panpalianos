package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.view.menus.TelaMenuDeFichas;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuDeFichas();
    }

}
