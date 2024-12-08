package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaTabela;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

import toolsforrpg_panpalianos.dominio.servicos.RegrasHomebrew;

public class TelaTabelaPrecos {
    public static void iniciar(){
        
        int preco = TelaInput.obterInteiro("Insira o preco do equipamento:","Preco equipamento");
        String nome = TelaInput.obterString("Insira o nome do equipamento:");
        
        String[][] valoresTabela = RegrasHomebrew.gerarTabelaDePreco(preco, nome);
        String[] colunas = {"","Preco upgrade "+nome, "Preco acumulado dos upgrades"};
        TelaTabela.iniciar("Tabela de precos", valoresTabela, colunas);  
    }
}
