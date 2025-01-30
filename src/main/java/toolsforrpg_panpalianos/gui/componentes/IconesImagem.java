package toolsforrpg_panpalianos.gui.componentes;

import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;

@Getter
public enum IconesImagem {

    LOGO("src/main/resources/images/capa_old_dragon.jpg"),
    ARMA("src/main/resources/images/icones/espada.png",20,20),
    ARMADURA("src/main/resources/images/icones/armaduras.png",20,20),
    ESCUDO("src/main/resources/images/icones/escudo.png",20,20),
    
    OLHO("src/main/resources/images/icones/olho-aberto.png",20,20),
    EDITAR("src/main/resources/images/icones/botao-editar.png",20,20),
    EXCLUIR("src/main/resources/images/icones/lixo.png",20,20);

    private ImageIcon imageIcon;

    IconesImagem(String path) {
        this.imageIcon = new ImageIcon(path);
    }

    IconesImagem(String path, int altura, int largura) {
        Image image = new ImageIcon(path).getImage();
        Image newimg = image.getScaledInstance(altura, largura,  java.awt.Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(newimg);
    }

    
}
