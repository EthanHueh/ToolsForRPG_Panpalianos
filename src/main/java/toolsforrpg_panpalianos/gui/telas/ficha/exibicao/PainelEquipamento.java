package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;

class PainelEquipamento extends JPanel {

    JLabel arma = new JLabel();
    JLabel armadura = new JLabel();
    JLabel escudo = new JLabel();

    PainelEquipamento(){
        setLayout(new GridLayout(3,2));

        add(new JLabel("Arma"));
        add(arma);

        add(new JLabel("Armadura"));
        add(armadura);

        add(new JLabel("Arma"));
        add(escudo);
    }

    void atualizar(Ficha ficha){
        Equipamento equipamento = ficha.getEquipamento();
        arma.setText(equipamento.getArma().getNome());
        armadura.setText(equipamento.getArmadura().getNome());
        escudo.setText(equipamento.getArma().getNome());
    }
    
}
