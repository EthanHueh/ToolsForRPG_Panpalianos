package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaMostrarIniciativas;

public class OpcaoVerIniciativa extends Opcao{

    public OpcaoVerIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaMostrarIniciativas.mostrarListaIniciativas();
    }
    
}
