package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

class PainelInfoJogador extends JPanel {
    JLabel lvl = new JLabel();
    JLabel exp = new JLabel();
    JLabel classe = new JLabel();
    JLabel especializacao = new JLabel();

    PainelInfoJogador(){
        setLayout(new GridLayout(4,2));
        
        add(new JLabel("Classe"));
        add(classe);

        add(new JLabel("Especialização"));
        add(especializacao);

        add(new JLabel("Nível"));
        add(lvl);

        add(new JLabel("Experiência"));
        add(exp);
    }

    void atualizar(FichaJogador ficha){
        classe.setText(ficha.getClasse().getNome());
        especializacao.setText(ficha.getEspecializacao().getNome());
        lvl.setText(String.valueOf(ficha.getLvl()));
        exp.setText(String.valueOf(ficha.getExp()));
    }
}
