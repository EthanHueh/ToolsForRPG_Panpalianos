package toolsforrpg_panpalianos.gui.opcoes;

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
