package toolsforrpg_panpalianos.gui.menus.opcoes.iniciativa;

import toolsforrpg_panpalianos.gui.menus.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaIniciativas;

public class OpcaoVerIniciativa extends Opcao{

    public OpcaoVerIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaIniciativas.mostrarListaIniciativas();
    }
    
}
