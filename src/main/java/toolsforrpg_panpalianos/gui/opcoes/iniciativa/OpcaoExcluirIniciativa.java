package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoExcluirIniciativa extends Opcao {
    
    public OpcaoExcluirIniciativa() {
        super("Excluir iniciativa");
    }

    @Override
    public void executar() {
        TelaIniciativas.excluirIniciativa();
    }
    
}
