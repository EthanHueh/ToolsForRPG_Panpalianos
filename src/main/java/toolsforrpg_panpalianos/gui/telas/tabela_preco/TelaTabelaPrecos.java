package toolsforrpg_panpalianos.gui.telas.tabela_preco;

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

import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;

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

    public void iniciar(){
        setVisible(true);
    }

    private void atualizarTabela(){

        try {
            String nome = campoNome.getText();
            int preco = Integer.parseInt(campoPreco.getText());

            painelTabela.removeAll();

            JTable tabela = new JTable(
                new DefaultTableModel(
                    gerarTabelaPreco(preco, nome),
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
            TelaAviso.mostrarErro("Preço precisa ser um numero inteiro");
            return;
        }

    }

    public String[][] gerarTabelaPreco(int preco, String nome){
        String[][] tabelaPrecos = new String[5][3];
        
        tabelaPrecos[0][0] = nome;
        tabelaPrecos[0][1] = String.valueOf(preco);
        tabelaPrecos[0][2] = String.valueOf(preco);
        
        int precoAcumulado = 0;
        for (int i = 1; i < 5; i++){
            
            precoAcumulado += (preco * Math.pow(6, i));
            
            tabelaPrecos[i][0] = nome+" +"+i;
            tabelaPrecos[i][1] = String.valueOf(preco * Math.pow(6, i));
            tabelaPrecos[i][2] = String.valueOf(precoAcumulado);
        }

        return tabelaPrecos;
    }

}
