package toolsforrpg_panpalianos.gui.telas.ficha;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import toolsforrpg_panpalianos.dados.modelo.enums.Alinhamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;

public class PainelInfoBasica extends JPanel {

    JTextField nome = new JTextField();
    JTextField descricao = new JTextField();
    JComboBox<String> alinhamento = new JComboBox<String>();
    JComboBox<String> raca = new JComboBox<>();
    List<JCheckBox> idiomas = new ArrayList<>();

    PainelInfoBasica(){
        setLayout(new GridLayout(5,2));
        add(new JLabel("Nome"));
        add(nome);

        add(new JLabel("Descriçao"));
        add(descricao);

        add(new JLabel("Alinhamento"));
        for (Alinhamento a: Alinhamento.values()) {
            alinhamento.addItem(a.getNome());
        }
        add(alinhamento);

        add(new JLabel("Raça"));
        for (Raca r: Raca.values()){
            raca.addItem(r.getNome());
        }
        add(raca);
        
        add(new JLabel("Idiomas"));
        for (Idioma i : Idioma.values()) {
            idiomas.add(new JCheckBox(i.getNome()));
        }
        JPanel painelIdiomas = new JPanel(new GridLayout(2,3));
        idiomas.stream().forEach(cB -> painelIdiomas.add(cB));
        add(painelIdiomas);

        setPreferredSize(new Dimension(450, 150));
    }
}