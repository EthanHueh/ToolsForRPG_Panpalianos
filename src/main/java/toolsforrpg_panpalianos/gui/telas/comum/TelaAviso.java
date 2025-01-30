package toolsforrpg_panpalianos.gui.telas.comum;

import javax.swing.JOptionPane;

public class TelaAviso {
    public static void avisar(String msg, String titulo){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void avisar(String msg){
        JOptionPane.showMessageDialog(null, msg, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarErro(String msg){
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErro(String msg, String titulo){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErro(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarErro(Exception e, String titulo){
        JOptionPane.showMessageDialog(null, e.getMessage(), titulo, JOptionPane.ERROR_MESSAGE);
    }

}
