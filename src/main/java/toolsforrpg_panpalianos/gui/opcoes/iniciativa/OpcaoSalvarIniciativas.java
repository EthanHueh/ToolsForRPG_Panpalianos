package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoSalvarIniciativas extends Opcao {

    public OpcaoSalvarIniciativas() {
        super("Salvar iniciativas");
    }

    @Override
    public void executar() {
        TelaIniciativas.salvarArquivo();
    }
    
}
