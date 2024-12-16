package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;

class PainelEquipamento extends JPanel {

    JLabel arma = new JLabel();
    JLabel armadura = new JLabel();
    JLabel escudo = new JLabel();

    PainelEquipamento(){
        setLayout(new GridLayout(3,2, 0, 5));
        
        arma.setIcon(IconesImagem.ARMA.getImageIcon());
        add(arma);
        
        armadura.setIcon(IconesImagem.ARMADURA.getImageIcon());
        add(armadura);

        escudo.setIcon(IconesImagem.ESCUDO.getImageIcon());
        add(escudo);
    }

    void atualizar(Ficha ficha){
        Equipamento equipamento = ficha.getEquipamento();
        arma.setText(equipamento.getArma().getNome());
        armadura.setText(equipamento.getArmadura().getNome());
        escudo.setText(equipamento.getArma().getNome());
    }
    
}
