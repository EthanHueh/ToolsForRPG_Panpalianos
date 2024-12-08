package toolsforrpg_panpalianos.gui.telas.comum;

import javax.swing.JOptionPane;

public class TelaErro {
    public static void mostrar(String msg){
        JOptionPane.showMessageDialog(null, msg, null, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrar(String msg, String titulo){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
