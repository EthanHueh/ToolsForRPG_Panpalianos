package toolsforrpg_panpalianos.view.menus.opcoes;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerFichas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.view.telas.TelaCriarFicha;

public class OpcaoCriarFicha extends Opcao {

    int opcao;

    public OpcaoCriarFicha(String nome, int opcao) {
        super(nome);
        this.opcao = opcao;
    }

    @Override
    public void executar() {

        FichaCriatura ficha = new TelaCriarFicha().criarNovaFicha(opcao);

        int opcaoSair = JOptionPane.showConfirmDialog(null, "Quer mesmo cadastrar essa ficha?","Confirmacao de cadastro", JOptionPane.YES_NO_OPTION);
        if (opcaoSair == JOptionPane.YES_OPTION){
            ControllerFichas.cadastrarFicha(ficha);
        }
    }

}
