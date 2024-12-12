package toolsforrpg_panpalianos.gui.componentes.botoes;

import java.awt.Font;

import javax.swing.JButton;

public class BotaoLauncher extends JButton {

    public BotaoLauncher(String nome){
        setText(nome);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("MV BOLI", Font.PLAIN,20));
        setFocusable(false);
    }
    
}
