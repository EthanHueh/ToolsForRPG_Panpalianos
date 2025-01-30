package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;

class PainelAtributos extends JPanel {

    JLabel[] valorAtributos = new JLabel[6];

    PainelAtributos(){
        setToolTipText("Atributos");
        setLayout(new GridLayout(6,2));

        String[] nomesAtributos = {
            "FOR",
            "DES",
            "CON",
            "INT",
            "SAB",
            "CAR"
        };

        for (int i = 0; i <= 5; i++){
            JLabel jLabel = new JLabel(nomesAtributos[i]); 
            jLabel.setAlignmentX(JLabel.CENTER);
            jLabel.setBorder(new LineBorder(Color.BLACK, 1));
            add(jLabel);

            valorAtributos[i] = new JLabel("0");
            valorAtributos[i].setAlignmentX(JLabel.CENTER);
            valorAtributos[i].setBorder(new LineBorder(Color.BLACK, 1));
            add(valorAtributos[i]);
        }


        
    }

    void atualizar(Ficha ficha){
        valorAtributos[0].setText(String.valueOf(ficha.getForca()));
        valorAtributos[1].setText(String.valueOf(ficha.getDestreza()));
        valorAtributos[2].setText(String.valueOf(ficha.getConstituicao()));
        valorAtributos[3].setText(String.valueOf(ficha.getInteligencia()));
        valorAtributos[4].setText(String.valueOf(ficha.getSabedoria()));
        valorAtributos[5].setText(String.valueOf(ficha.getCarisma()));
    }
}
