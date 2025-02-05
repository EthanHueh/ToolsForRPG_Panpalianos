package toolsforrpg_panpalianos.gui.componentes.botoes;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;

import toolsforrpg_panpalianos.gui.Fontes;

public class BotaoPadrao extends JButton {

    private static int posicaoVertical = JButton.CENTER;
    private static Font font = Fontes.MV_BOLI_14.getFont();
    private static boolean focusable = false;

    public BotaoPadrao(String nome){
        super(nome);
        inicializar();
    }

    public BotaoPadrao(Icon icon){
        super(icon);
        inicializar();
    }

    private void inicializar() {
        setVerticalTextPosition(posicaoVertical);
        setFont(font);
        setFocusable(focusable);
    }
    
}
