package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.Estatisticas;

public class TelaEstatisticas {
    public static void iniciar(){

        String[][] valoresTabela = Estatisticas.executar(FichasRepository.retornarFichasJogadores());
        String[] colunas = {"Nome Atributo", "Per. Menor atributo", "Per. maior atributo", "Media da party"};
        
        JTable tabela = new JTable(new DefaultTableModel(valoresTabela, colunas));
        
        JFrame frame = new JFrame("Estatisticas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tabela));
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}


