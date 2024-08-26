package toolsforrpg_panpalianos.gui.telas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import toolsforrpg_panpalianos.gui.GerenciadorTelas;

public class TelaTabela {

    public static void iniciar(String nome, String[][] valoresTabela, String[] colunas) {
        JTable tabela = new JTable(new DefaultTableModel(valoresTabela, colunas));
        
        JFrame frame = new JFrame(nome);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.add(new JScrollPane(tabela));
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                
                if (TelaInput.desejaSair()) {
                    
                    frame.dispose();
                    SwingUtilities.invokeLater(() -> {
                        GerenciadorTelas.telaMenuPrincipal.iniciar();
                    });
                }
            }
        });
    }
}
