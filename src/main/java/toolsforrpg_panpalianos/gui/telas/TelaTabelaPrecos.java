package toolsforrpg_panpalianos.gui.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import toolsforrpg_panpalianos.dominio.servicos.homebrew.GeradorTabelaPreco;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;

public class TelaTabelaPrecos extends JFrame {

    private JTextField campoNome = new JTextField("Adaga");
    private JTextField campoPreco = new JTextField("2");
    
    private JPanel painelTabela = new JPanel();

    public TelaTabelaPrecos(){
        setTitle("Tabela de Precos");
        setLayout(new BorderLayout());

        JPanel painelNorte = new JPanel(new GridLayout(4, 2));

        painelNorte.add(new JLabel("Arma"));
        painelNorte.add(new JLabel());

        painelNorte.add(new JLabel("Nome"));
        painelNorte.add(campoNome);

        painelNorte.add(new JLabel("Preco"));
        painelNorte.add(campoPreco);

        JButton btnSubmit = new BotaoPadrao("Criar tabela");
        btnSubmit.addActionListener(
            e -> atualizarTabela()
        );
        btnSubmit.setFocusable(false);

        painelNorte.add(btnSubmit);

        add(painelNorte, BorderLayout.NORTH);

        pack();
    }

    private void atualizarTabela(){

        try {
            String nome = campoNome.getText();
            int preco = Integer.parseInt(campoPreco.getText());

            painelTabela.removeAll();

            JTable tabela = new JTable(
                new DefaultTableModel(
                    GeradorTabelaPreco.executar(preco, nome),
                    new String[]{
                        "Arma",
                        "Upgrade",
                        "Preco acumulado"
                    }
                )
            );
            
            JScrollPane jScrollPane = new JScrollPane(tabela);
            jScrollPane.setPreferredSize(new Dimension(300,110));

            painelTabela.add(jScrollPane);
            add(painelTabela, BorderLayout.CENTER);

            setVisible(false);
            pack();
            setVisible(true);

        } catch (NumberFormatException e){
            TelaErro.mostrar("Preço precisa ser um numero inteiro");
            return;
        }

    }

}
