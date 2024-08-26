package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import toolsforrpg_panpalianos.dominio.servicos.EscritorDeArquivos;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;
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
