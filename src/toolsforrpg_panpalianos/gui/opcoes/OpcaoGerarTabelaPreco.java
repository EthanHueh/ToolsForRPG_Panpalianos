package toolsforrpg_panpalianos.gui.opcoes;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dominio.servicos.RegrasHomebrew;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.telas.TelaTexto;

public class OpcaoGerarTabelaPreco extends Opcao {
   
    public OpcaoGerarTabelaPreco(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        int preco = ValidadorDeInputs.consistirInteiro("Insira o preco do equipamento:");
        String nome = JOptionPane.showInputDialog("Insira o nome do equipamento:");

        new TelaTexto(RegrasHomebrew.gerarTabelaDePreco(preco, nome), "Tabela de precos");  
    }
}
