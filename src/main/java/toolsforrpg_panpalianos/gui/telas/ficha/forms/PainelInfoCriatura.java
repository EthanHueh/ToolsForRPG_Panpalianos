package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelInfoCriatura extends JPanel {
    
    public JTextField classeArmadura = new JTextField("0");
    public JTextField jogadaDeProtecao = new JTextField("0");
    public JTextField baseAtaque = new JTextField("0");
    public JTextField movimento = new JTextField("0");
    public JTextField dadoVida = new JTextField("0");
    public JTextField pvsAdicionais = new JTextField("0");
    
    public PainelInfoCriatura(){
        setLayout(new GridLayout(6,2));

        add(new JLabel("Classe de Armadura"));
        add(classeArmadura);

        add(new JLabel("Jogada de Proteção"));
        add(jogadaDeProtecao);

        add(new JLabel("Base de Ataque"));
        add(baseAtaque);

        add(new JLabel("Movimento"));
        add(movimento);

        add(new JLabel("Dados de vida"));
        add(dadoVida);

        add(new JLabel("PVs Adicionais"));
        add(pvsAdicionais);

    }
}
