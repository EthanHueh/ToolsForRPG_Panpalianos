package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

class PainelSubatributos extends JPanel {

    JLabel[] info = new JLabel[5];

    PainelSubatributos(){
        setLayout(new GridLayout(5,2));

        String[] subatributos = {
            "CA",
            "JP",
            "BA",
            "Mov",
            "PVs"
        };

        for (int i = 0; i < info.length; i++){
            add(new JLabel(subatributos[i]));
            info[i] = new JLabel("");
            add(info[i]);
        }
    }

    void atualizar(Ficha ficha) {
        info[0].setText(String.valueOf(ficha.getClasseArmadura()));
        info[1].setText(String.valueOf(ficha.getJogadaProtecao()));
        info[2].setText(String.valueOf(ficha.getBaseAtaque()));
        info[3].setText(String.valueOf(ficha.getMovimento()));
        info[4].setText(gerarMensagemPvs(ficha));
    }
        
    private String gerarMensagemPvs(Ficha ficha) {
        if (ficha instanceof FichaCriatura){
            FichaCriatura f = (FichaCriatura) ficha;
            return String.valueOf(f.getQuantPVsAtual()+"/"+Calculadora.calcularPV(f)+" (+"+f.getPvsAdicionais()+")");
        }

        return String.valueOf(ficha.getQuantPVsAtual()+"/"+Calculadora.calcularPV(ficha));
    }
}
