package toolsforrpg_panpalianos.gui.telas.comum;

import static javax.swing.JOptionPane.*;

public class TelaAviso {
    public static void avisar(String msg, String titulo){
        showMessageDialog(getRootFrame(), msg, titulo, INFORMATION_MESSAGE);
    }

    public static void avisar(String msg){
        showMessageDialog(null, msg, null, INFORMATION_MESSAGE);
    }

    public static void mostrarErro(String msg){
        showMessageDialog(null, msg, "Erro", ERROR_MESSAGE);
    }

    public static void mostrarErro(String msg, String titulo){
        showMessageDialog(null, msg, titulo, ERROR_MESSAGE);
    }

    public static void mostrarErro(Exception e){
        showMessageDialog(null, e.getMessage(), "Erro", ERROR_MESSAGE);
    }

    public static void mostrarErro(Exception e, String titulo){
        showMessageDialog(null, e.getMessage(), titulo, ERROR_MESSAGE);
    }

}
