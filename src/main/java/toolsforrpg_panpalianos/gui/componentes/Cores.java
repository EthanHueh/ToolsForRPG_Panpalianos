package toolsforrpg_panpalianos.gui.componentes;

import java.awt.Color;

import lombok.Getter;

@Getter
public enum Cores {
    CINZA(new Color(200,200,200)),
    VERDE(new Color(128,255,0)),
    VERMELHO(new Color(128,0,0));
    
    private Color cor;
        
    Cores(Color cor) {
        this.cor = cor;
    }
}
