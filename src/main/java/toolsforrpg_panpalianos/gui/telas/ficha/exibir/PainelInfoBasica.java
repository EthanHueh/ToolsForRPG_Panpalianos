package toolsforrpg_panpalianos.gui.telas.ficha.exibir;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;

class PainelInfoBasica extends JPanel {

    JLabel[] info = new JLabel[4];

    PainelInfoBasica(){
        setToolTipText("Informação básica");
        setLayout(new GridLayout(4,1, 0, 5));

        for (int i = 0; i < info.length; i++){
            info[i] = new JLabel("");
            add(info[i]);
        }
    }

    void atualizar(Ficha ficha){
        info[0].setText(ficha.getNome()+" ("+ficha.getRaca().getNome()+")");
        info[1].setText(ficha.getDescricao());
        info[2].setText("Alinhamento "+ficha.getAlinhamento().getNome());
        info[3].setText(gerarMensagem(ficha.getIdiomas()));
    }
            
    private String gerarMensagem(List<Idioma> idiomas){
        String msg = "Idiomas - ";
        for (Idioma i : idiomas) {
            if (idiomas.indexOf(i) == idiomas.size() - 1){
                msg += i.getNome();
            } else {
                msg += i.getNome()+", ";
            }
        }
        return msg;
    }


}
