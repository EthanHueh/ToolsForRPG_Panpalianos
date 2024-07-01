package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuIniciativas;
import toolsforrpg_panpalianos.gui.opcoes.Opcao;

public class OpcaoAbrirMenuIniciativa extends Opcao {

    public OpcaoAbrirMenuIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuIniciativas();
    }

}
