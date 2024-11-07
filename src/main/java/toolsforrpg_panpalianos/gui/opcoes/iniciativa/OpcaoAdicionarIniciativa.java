package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoAdicionarIniciativa extends Opcao{

    public OpcaoAdicionarIniciativa() {
        super("Adicionar iniciativa");
    }

    @Override
    public void executar() {
        TelaIniciativas.inserirIniciativa();
    }
    
}
