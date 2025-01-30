package toolsforrpg_panpalianos.gui.telas.ficha.exibir;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

class PainelInfoJogador extends JPanel {
    JLabel lvl = new JLabel();
    JLabel classe = new JLabel();

    PainelInfoJogador(){
        setLayout(new GridLayout(4,2));

        add(classe);
        add(lvl);
    }

    void atualizar(FichaJogador ficha){
        
        if (ficha.getEspecializacao() == Especializacao.NENHUMA){
            classe.setText(ficha.getClasse().getNome());
        } else {
            classe.setText(ficha.getClasse().getNome()+" ("+ficha.getEspecializacao().getNome()+")");
        }
        
        lvl.setText("LVL"+String.valueOf(ficha.getLvl())+" ("+String.valueOf(ficha.getExp())+" EXP)");
    }
}
