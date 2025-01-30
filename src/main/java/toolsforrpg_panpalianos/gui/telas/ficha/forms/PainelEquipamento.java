package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Escudo;

public class PainelEquipamento extends JPanel {
    private JComboBox<String> arma = new JComboBox<>();
    private JComboBox<String> armadura = new JComboBox<>();
    private JComboBox<String> escudo = new JComboBox<>();

    public PainelEquipamento(){
        setLayout(new GridLayout(3,2));

        add(new JLabel("Arma"));
        for (Arma a: Arma.values()){
            arma.addItem(a.getNome());
        }
        add(arma);

        add(new JLabel("Armadura"));
        for (Armadura a: Armadura.values()){
            armadura.addItem(a.getNome());
        }
        add(armadura);

        add(new JLabel("Especialização"));
        for (Escudo e: Escudo.values()){
            escudo.addItem(e.getNome());
        }
        add(escudo);
    }

    public String getArma() {
        return arma.getSelectedItem().toString();
    }

    public void setArma(String s) {
        arma.setSelectedItem(s);
    }

    public String getArmadura() {
        return armadura.getSelectedItem().toString();
    }

    public void setArmadura(String s) {
        armadura.setSelectedItem(s);
    }

    public String getEscudo() {
        return escudo.getSelectedItem().toString();
    }

    public void setEscudo(String s) {
        escudo.setSelectedItem(s);
    }
}
