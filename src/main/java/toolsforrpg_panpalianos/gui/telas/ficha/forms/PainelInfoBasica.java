package toolsforrpg_panpalianos.gui.telas.ficha.forms;

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

    private JTextField nome = new JTextField();
    private JTextField descricao = new JTextField();
    private JComboBox<String> alinhamento = new JComboBox<String>();
    private JComboBox<String> raca = new JComboBox<>();
    private List<JCheckBox> idiomas = new ArrayList<>();

    public PainelInfoBasica(){
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

    public String getNome(){
        return nome.getText();
    }

    public void setNome(String s){
        nome.setText(s);
    }

    public String getDescricao(){
        return descricao.getText();
    }

    public void setDescricao(String s) {
        descricao.setText(s);
    }

    public String getAlinhamento(){
        return alinhamento.getSelectedItem().toString();
    }

    public void setAlinhamento(String s) {
        alinhamento.setSelectedItem(s);
    }

    public String getRaca(){
        return raca.getSelectedItem().toString();
    }

    public void setRaca(String s) {
        raca.setSelectedItem(s);
    }

    public List<Idioma> getIdiomas(){
        List<Idioma> ids = new ArrayList<>();

        for (JCheckBox jCheckBox : idiomas) {
            if (jCheckBox.isSelected()){
                ids.add(Idioma.getIdioma(jCheckBox.getText()));
            }
        }

        return ids;
    }

    public void setIdiomas(List<Idioma> lista){
        idiomas.stream().forEach(c -> c.setSelected(false));

        for (Idioma i : lista) {
            for (JCheckBox c : idiomas) {
                if (c.getText().equals(i.getNome())){
                    c.setSelected(true);
                }
            }
        }
    }

}