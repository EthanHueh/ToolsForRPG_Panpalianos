package toolsforrpg_panpalianos.gui.telas.launcher;

import javax.swing.ImageIcon;

import lombok.Getter;

@Getter
public enum IconesImagem {
    LOGO(new ImageIcon("src\\main\\resources\\capa_old_dragon.jpg"));

    private ImageIcon imageIcon;

    IconesImagem(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
