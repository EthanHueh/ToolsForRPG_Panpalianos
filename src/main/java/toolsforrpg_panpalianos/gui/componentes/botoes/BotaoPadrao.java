package toolsforrpg_panpalianos.gui.componentes.botoes;

import java.awt.Font;

import javax.swing.JButton;

public class BotaoPadrao extends JButton {
    public BotaoPadrao(String nome){
        setText(nome);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("MV BOLI", Font.PLAIN,14));
        setFocusable(false);
    }
    
}
