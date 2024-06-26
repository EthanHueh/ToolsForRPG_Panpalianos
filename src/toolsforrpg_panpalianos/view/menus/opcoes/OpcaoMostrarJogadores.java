package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.view.telas.FichasView;

public class OpcaoMostrarJogadores extends Opcao {

    public OpcaoMostrarJogadores(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        FichasView.mostrarFichasDeJogador();
    }

}
