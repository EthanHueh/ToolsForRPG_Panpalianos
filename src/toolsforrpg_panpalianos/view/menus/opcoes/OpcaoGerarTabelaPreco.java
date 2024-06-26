package toolsforrpg_panpalianos.view.menus.opcoes;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerCalculos;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.telas.TelaJTextArea;

public class OpcaoGerarTabelaPreco extends Opcao {
   
    public OpcaoGerarTabelaPreco(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        ValidadorDeInputs valInp = new ValidadorDeInputs();
        int preco = valInp.consistirInteiro("Insira o preco do equipamento:");
        String nome = (JOptionPane.showInputDialog("Insira o nome do equipamento:"));

        new TelaJTextArea(ControllerCalculos.gerarTabelaDePreco(preco, nome), "Tabela de precos");  
    }
}
