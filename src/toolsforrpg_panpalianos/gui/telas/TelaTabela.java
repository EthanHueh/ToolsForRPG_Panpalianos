/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

/**
 *
 * @author adest
 */
public class TelaTabela {

    public static void iniciar(String nome, String[][] valoresTabela, String[] colunas) {
        JTable tabela = new JTable(new DefaultTableModel(valoresTabela, colunas));
        
        JFrame frame = new JFrame(nome);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(tabela));
        frame.pack(); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
