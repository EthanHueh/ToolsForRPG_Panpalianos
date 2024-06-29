package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoAtualizarIniciativa extends Opcao {

    public OpcaoAtualizarIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaIniciativas.atualizarIniciativa();
    }
    
}
