package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;

class PainelInfoBasica extends JPanel {
    JLabel[] info = new JLabel[7];

    PainelInfoBasica(){
        setToolTipText("Informação básica");
        setLayout(new GridLayout(7,2, 10, 4));

        String[] nomes = {
            "Nome",
            "Descricao",
            "Alinhamento",
            "Raça",
            "Idiomas",
            "DVs"
        };

        for (int i = 0; i < info.length - 1; i++){
            add(new JLabel(nomes[i]));
            info[i] = new JLabel("");
            add(info[i]);
        }
    }

    void atualizar(Ficha ficha){
        info[0].setText(ficha.getNome());
        info[1].setText(ficha.getDescricao());
        info[2].setText(ficha.getAlinhamento().getNome());
        info[3].setText(ficha.getRaca().getNome());
        info[4].setText(gerarMensagem(ficha.getIdiomas()));
        info[5].setText(String.valueOf(ficha.getQuantDVs()));
    }
            
    private String gerarMensagem(List<Idioma> idiomas){
        String msg = "";
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
