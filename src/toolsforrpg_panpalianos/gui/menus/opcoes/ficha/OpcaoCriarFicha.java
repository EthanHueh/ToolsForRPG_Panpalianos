package toolsforrpg_panpalianos.gui.menus.opcoes.ficha;

import toolsforrpg_panpalianos.gui.menus.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoCriarFicha extends Opcao {

    int opcao;

    public OpcaoCriarFicha(String nome, int opcao) {
        super(nome);
        this.opcao = opcao;
    }

    @Override
    public void executar() {
        TelaFichas.criarFicha(opcao);
    }

}
