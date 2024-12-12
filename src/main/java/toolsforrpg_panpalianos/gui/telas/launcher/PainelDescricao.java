package toolsforrpg_panpalianos.gui.telas.launcher;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

class PainelDescricao extends JLabel {

    PainelDescricao(){
        super(
            new StringBuilder()
                .append("<html>")
                .append("Este aqui é um utilitário para Old Dragon<br/>")
                .append("Por favor aproveite!<br/><br/>")
                .append("Autoria: Ethan_Hueh<br/>")
                .append("</html>")
            .toString()
        );
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }
}
