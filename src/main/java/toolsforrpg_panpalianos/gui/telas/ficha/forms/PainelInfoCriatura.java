package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelInfoCriatura extends JPanel {
    
    private JTextField classeArmadura = new JTextField("0");
    private JTextField jogadaDeProtecao = new JTextField("0");
    private JTextField baseAtaque = new JTextField("0");
    private JTextField movimento = new JTextField("0");
    private JTextField dadoVida = new JTextField("0");
    private JTextField pvsAdicionais = new JTextField("0");
    
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

    public int getClasseArmadura() {
        return Integer.parseInt(classeArmadura.getText());
    }

    public void setClasseArmadura(int n) {
        classeArmadura.setText(String.valueOf(n));
    }

    public int getJogadaDeProtecao() {
        return Integer.parseInt(jogadaDeProtecao.getText());
    }

    public void setJogadaDeProtecao(int n) {
        jogadaDeProtecao.setText(String.valueOf(n));
    }

    public int getBaseAtaque() {
        return Integer.parseInt(baseAtaque.getText());
    }

    public void setBaseAtaque(int n) {
        baseAtaque.setText(String.valueOf(n));
    }

    public int getMovimento() {
        return Integer.parseInt(movimento.getText());
    }

    public void setMovimento(int n) {
        movimento.setText(String.valueOf(n));
    }

    public int getDadoVida() {
        return Integer.parseInt(dadoVida.getText());
    }

    public void setDadoVida(int n) {
        dadoVida.setText(String.valueOf(n));
    }

    public int getPvsAdicionais() {
        return Integer.parseInt(pvsAdicionais.getText());
    }

    public void setPvsAdicionais(int n) {
        pvsAdicionais.setText(String.valueOf(n));
    }
}
