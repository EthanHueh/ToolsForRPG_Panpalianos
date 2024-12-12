package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import toolsforrpg_panpalianos.dominio.servicos.Estatisticas;

public class TelaEstatisticas extends JFrame {

    private JPanel painelTabela = new JPanel();

    public TelaEstatisticas(){
        setTitle("Estatisticas da Party");

        add(painelTabela);
    }

    public void iniciar(){
        atualizarTabela();
    }

    private void atualizarTabela(){
        try {
            
            JTable tabela = new JTable(
                new DefaultTableModel(
                    Estatisticas.executar(),
                    new String[]{
                        "Nome Atributo",
                        "Per. Menor atributo",
                        "Per. maior atributo",
                        "Media da party"
                    }
                )
            );

            painelTabela.removeAll();

            JScrollPane jScrollPane = new JScrollPane(tabela);
            jScrollPane.setPreferredSize(new Dimension(500,200));

            painelTabela.add(jScrollPane);
            add(painelTabela);

            setVisible(false);
            pack();
            setVisible(true);

        } catch (Exception e) {
            TelaErro.mostrar(e.getMessage());
        }

    }
}
