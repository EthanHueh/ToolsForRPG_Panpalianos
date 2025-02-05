package toolsforrpg_panpalianos.gui;

import java.awt.Font;

import lombok.Getter;

@Getter
public enum Fontes {

    CALIBRI_14      (new Font("Calibri", Font.PLAIN, 14)),
    GEORGIA_14      (new Font("Georgia", Font.PLAIN, 14)),
    MV_BOLI_14      (new Font("MV BOLI", Font.PLAIN, 14)),
    MV_BOLI_20      (new Font("MV BOLI", Font.PLAIN, 20)),
    SANS_SERIF_14   (new Font("SansSerif", Font.PLAIN, 14)),
    TREBUCHET_MS_14 (new Font("Trebuchet MS", Font.PLAIN, 14));
    
    private Font font;

    Fontes(Font font) {
        this.font = font;
    }
    
}