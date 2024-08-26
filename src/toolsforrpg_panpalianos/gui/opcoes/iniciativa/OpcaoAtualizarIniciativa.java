package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoAtualizarIniciativa extends Opcao {

    public OpcaoAtualizarIniciativa() {
        super("Atualizar iniciativa");
    }

    @Override
    public void executar() {
        TelaIniciativas.atualizarIniciativa();
    }
    
}
