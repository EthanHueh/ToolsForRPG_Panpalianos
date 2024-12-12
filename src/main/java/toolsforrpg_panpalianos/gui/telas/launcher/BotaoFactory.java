package toolsforrpg_panpalianos.gui.telas.launcher;

import java.awt.Font;

import javax.swing.JButton;

import toolsforrpg_panpalianos.gui.telas.TelaSimuladorDeCombate;
import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuFichas;

public class BotaoFactory {
    public static JButton criarBotao(String msg){
        JButton btn = new JButton();
        btn.setVerticalTextPosition(JButton.CENTER);
        btn.setFont(new Font("MV BOLI", Font.PLAIN,20));
        btn.setFocusable(false);

        switch (msg) {
            case "menu":
                btn.setText("<html>Clique aqui para <br/>abrir o menu<html>");
                btn.setIcon(IconesImagem.LOGO.getImageIcon());
                btn.setForeground(Cores.VERDE.getCor());
                btn.setIconTextGap(20);
                break;

            case "fichas":
                btn.setText("Fichas");
                btn.addActionListener(e -> new TelaMenuFichas().iniciar());
                break;

            case "combate":
                btn.setText("Combate");
                btn.addActionListener(e -> TelaSimuladorDeCombate.iniciar());
                break;
        
            default:
                break;
        }

        return btn;
    }

}