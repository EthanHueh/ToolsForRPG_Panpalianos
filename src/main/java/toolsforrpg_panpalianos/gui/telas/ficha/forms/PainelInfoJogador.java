package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;

public class PainelInfoJogador extends JPanel {
    public JTextField lvl = new JTextField();
    public JTextField exp = new JTextField();
    public JComboBox<String> classe = new JComboBox<>();
    public JComboBox<String> especializacao = new JComboBox<>();

    public PainelInfoJogador(){
        setLayout(new GridLayout(4,2));
        add(new JLabel("Classe"));
        for (Classe c: Classe.values()){
            classe.addItem(c.getNome());
        }
        add(classe);

        add(new JLabel("Especialização"));
        for (Especializacao e: Especializacao.values()){
            especializacao.addItem(e.getNome());
        }
        add(especializacao);

        add(new JLabel("Nível"));
        lvl.setText("1");
        add(lvl);

        add(new JLabel("Experiência"));
        exp.setText("0");
        add(exp);
    }
}
