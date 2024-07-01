package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuIniciativas;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuIniciativas();
    }

}
