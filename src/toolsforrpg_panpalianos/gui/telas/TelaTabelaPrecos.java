package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dominio.servicos.RegrasHomebrew;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaTabelaPrecos {
    public static void iniciar(){
        int preco = ValidadorDeInputs.consistirInteiro("Insira o preco do equipamento:");
        String nome = JOptionPane.showInputDialog("Insira o nome do equipamento:");

        TelaTexto.iniciar(RegrasHomebrew.gerarTabelaDePreco(preco, nome), "Tabela de precos");  
    }
}
