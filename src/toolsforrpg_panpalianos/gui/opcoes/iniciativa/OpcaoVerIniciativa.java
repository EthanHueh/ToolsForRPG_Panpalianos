package toolsforrpg_panpalianos.gui.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoVerIniciativa extends Opcao{

    public OpcaoVerIniciativa() {
        super("Ver iniciativa");
    }

    @Override
    public void executar() {
        TelaIniciativas.mostrarListaIniciativas();
    }
    
}
