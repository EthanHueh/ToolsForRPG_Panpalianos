package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

public class TelaInput {
    
    public static int obterInteiro(String msg) {

        int numero = 0;

        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(msg));
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira novamente!", "Input errado", 0);
            }
        }
        while(true);

    }

    public static int obterInteiro(String msg, String titulo) {

        int numero = 0;

        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, msg, titulo,1));
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira novamente!", "Input errado", 0);
            }
        }
        while(true);

    }

    public static boolean desejaSair(){
        int opcaoSair = JOptionPane.showConfirmDialog(null, "Desejas Sair","Desejas Sair", JOptionPane.YES_NO_OPTION);
        return opcaoSair == JOptionPane.YES_OPTION;
    }
    
    public static boolean desejaRealizarOperacao(String msg, String titulo){
        int opcaoSair = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
        return opcaoSair == JOptionPane.YES_OPTION;
    }

}
