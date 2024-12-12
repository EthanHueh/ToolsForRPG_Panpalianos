package toolsforrpg_panpalianos.gui.telas.comum;

import javax.swing.JOptionPane;

public class TelaErro {
    public static void mostrar(String msg){
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrar(String msg, String titulo){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrar(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrar(Exception e, String titulo){
        JOptionPane.showMessageDialog(null, e.getMessage(), titulo, JOptionPane.ERROR_MESSAGE);
    }
    
}
