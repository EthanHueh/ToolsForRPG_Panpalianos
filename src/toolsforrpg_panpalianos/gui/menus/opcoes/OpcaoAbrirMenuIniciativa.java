package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaMenuIniciativa;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuIniciativa();
    }

}
