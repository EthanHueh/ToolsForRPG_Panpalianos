package toolsforrpg_panpalianos.gui.telas.ficha;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelInfoCriatura extends JPanel {
    
    JTextField classeArmadura = new JTextField();
    JTextField jogadaDeProtecao = new JTextField();
    JTextField baseAtaque = new JTextField();
    JTextField movimento = new JTextField();
    JTextField pvsAdicionais = new JTextField();
    
    PainelInfoCriatura(){
        setLayout(new GridLayout(5,2));

        classeArmadura.setText("0");
        jogadaDeProtecao.setText("0");
        baseAtaque.setText("0");
        movimento.setText("0");
        pvsAdicionais.setText("0");

        add(new JLabel("Classe de Armadura"));
        add(classeArmadura);

        add(new JLabel("Jogada de Proteção"));
        add(jogadaDeProtecao);

        add(new JLabel("Base de Ataque"));
        add(baseAtaque);

        add(new JLabel("Movimento"));
        add(movimento);

        add(new JLabel("PVs Adicionais"));
        add(pvsAdicionais);

    }
}
