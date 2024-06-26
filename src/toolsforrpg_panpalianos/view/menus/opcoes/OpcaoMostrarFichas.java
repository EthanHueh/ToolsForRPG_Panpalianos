package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.view.telas.FichasView;

public class OpcaoMostrarFichas extends Opcao {

    public OpcaoMostrarFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        FichasView.mostrarFichas();
    }
    
}
