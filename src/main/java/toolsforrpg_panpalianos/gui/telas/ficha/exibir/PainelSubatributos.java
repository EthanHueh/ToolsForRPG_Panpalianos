package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

class PainelSubatributos extends JPanel {

    JLabel[] info = new JLabel[6];

    PainelSubatributos(){
        setLayout(new GridLayout(6,2));

        for (int i = 0; i < info.length; i++){
            info[i] = new JLabel("");
            add(info[i]);
        }
    }

    void atualizar(Ficha ficha) {
        info[0].setText("DV "+String.valueOf(ficha.getQuantDVs()));
        info[1].setText(gerarMensagemPvs(ficha));
        info[2].setText("CA "+String.valueOf(ficha.getClasseArmadura()));
        info[3].setText("JP "+String.valueOf(ficha.getJogadaProtecao()));
        info[4].setText("BA +"+String.valueOf(ficha.getBaseAtaque()));
        info[5].setText("Mov. "+String.valueOf(ficha.getMovimento()+"m"));
    }
        
    private String gerarMensagemPvs(Ficha ficha) {
        if (ficha instanceof FichaCriatura){
            FichaCriatura f = (FichaCriatura) ficha;
            return "PV: "+String.valueOf(f.getQuantPVsAtual()+"/"+Calculadora.calcularPV(f)+" (+"+f.getPvsAdicionais()+")");
        }

        return "PV: "+String.valueOf(ficha.getQuantPVsAtual()+"/"+Calculadora.calcularPV(ficha));
    }
}
