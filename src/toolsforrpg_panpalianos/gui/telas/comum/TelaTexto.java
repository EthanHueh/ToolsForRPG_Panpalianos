package toolsforrpg_panpalianos.gui.telas.comum;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaTexto {

    public static void iniciar(String msg, String titulo) {
        JTextArea area = new JTextArea(msg);
        area.setRows(25);
        area.setColumns(25);
        area.setLineWrap(true);

        JScrollPane pane = new JScrollPane(area);
        
        JOptionPane.showConfirmDialog(null, pane, titulo,
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
}
