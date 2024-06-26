package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.view.menus.TelaMenuIniciativa;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuIniciativa();
    }

}
