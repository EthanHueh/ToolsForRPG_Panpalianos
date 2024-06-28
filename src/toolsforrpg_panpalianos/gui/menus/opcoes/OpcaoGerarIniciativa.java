package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaGerarIniciativas;

public class OpcaoGerarIniciativa extends Opcao{

    public OpcaoGerarIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaGerarIniciativas();
    }
    
}
