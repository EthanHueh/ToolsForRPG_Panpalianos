package toolsforrpg_panpalianos.gui.componentes.botoes;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;

public class BotaoPadrao extends JButton {
    public BotaoPadrao(String nome){
        super(nome);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("MV BOLI", Font.PLAIN,14));
        setFocusable(false);
    }

    public BotaoPadrao(Icon icon){
        super(icon);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("MV BOLI", Font.PLAIN,14));
        setFocusable(false);
    }
    
}
