package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaCriarFicha;

public class OpcaoCriarFicha extends Opcao {

    int opcao;

    public OpcaoCriarFicha(String nome, int opcao) {
        super(nome);
        this.opcao = opcao;
    }

    @Override
    public void executar() {
        new TelaCriarFicha(opcao);
    }

}
