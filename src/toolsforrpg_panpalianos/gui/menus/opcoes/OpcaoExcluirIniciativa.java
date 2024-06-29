package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoExcluirIniciativa extends Opcao {
    public OpcaoExcluirIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaIniciativas.excluirIniciativa();
    }
    
}
