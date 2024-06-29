package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoInserirIniciativa extends Opcao{

    public OpcaoInserirIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaIniciativas.inserirIniciativa();
    }
    
}
