package toolsforrpg_panpalianos.gui.telas.comum;

import javax.swing.JOptionPane;

public class TelaAviso {
    public static void avisar(String msg, String titulo){
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void avisar(String msg){
        JOptionPane.showMessageDialog(null, msg, null, JOptionPane.INFORMATION_MESSAGE);
    }

}
