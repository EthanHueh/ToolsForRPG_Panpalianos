package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dominio.servicos.Estatisticas;

public class TelaEstatisticas {
    public static void iniciar(){

        String[][] valoresTabela = Estatisticas.executar();
        
        if (valoresTabela == null){
            JOptionPane.showMessageDialog(null, "Nenhuma ficha cadastrada!", "Erro", 0);
            return;
        }
        
        String[] colunas = {"Nome Atributo", "Per. Menor atributo", "Per. maior atributo", "Media da party"};
        
        TelaTabela.iniciar("Estatisticas", valoresTabela, colunas);
    }
}
