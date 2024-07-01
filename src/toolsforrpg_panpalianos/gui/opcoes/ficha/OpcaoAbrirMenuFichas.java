package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuFichas;
import toolsforrpg_panpalianos.gui.opcoes.Opcao;

public class OpcaoAbrirMenuFichas extends Opcao {

    public OpcaoAbrirMenuFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMenuFichas();
    }

}
