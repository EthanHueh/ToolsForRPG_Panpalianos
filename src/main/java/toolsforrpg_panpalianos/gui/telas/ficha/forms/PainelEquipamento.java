package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Escudo;

public class PainelEquipamento extends JPanel {
    public JComboBox<String> arma = new JComboBox<>();
    public JComboBox<String> armadura = new JComboBox<>();
    public JComboBox<String> escudo = new JComboBox<>();

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
}
