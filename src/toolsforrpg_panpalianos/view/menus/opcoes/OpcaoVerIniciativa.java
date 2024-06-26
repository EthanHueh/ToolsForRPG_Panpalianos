package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.view.telas.IniciativasView;

public class OpcaoVerIniciativa extends Opcao{

    public OpcaoVerIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        IniciativasView.mostrarListaIniciativas();
    }
    
}
