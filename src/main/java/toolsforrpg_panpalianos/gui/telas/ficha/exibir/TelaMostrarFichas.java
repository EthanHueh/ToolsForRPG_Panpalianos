package toolsforrpg_panpalianos.gui.telas.ficha.exibir;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class TelaMostrarFichas extends JFrame {

    private PainelInfoBasica painelInfoBasica = new PainelInfoBasica();
    private PainelAtributos painelAtributos = new PainelAtributos();
    private PainelEquipamento painelEquipamento = new PainelEquipamento();
    private PainelInfoJogador painelInfoJogador = new PainelInfoJogador();
    private PainelSubatributos painelSubatributos = new PainelSubatributos();

    public TelaMostrarFichas(Ficha ficha){
        setTitle("Exibir fichas");
        setPreferredSize(new Dimension(300, 400));

        JPanel painelNorte = new JPanel();
        painelNorte.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(painelNorte, BorderLayout.NORTH);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.add(painelInfoBasica);
        painelPrincipal.add(painelInfoJogador);
        painelPrincipal.add(painelEquipamento);
        add(painelPrincipal, BorderLayout.CENTER);

        JPanel painelLeste = new JPanel();
        painelLeste.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelLeste.setLayout(new BoxLayout(painelLeste, BoxLayout.Y_AXIS));
        painelLeste.add(painelAtributos);
        painelLeste.add(painelSubatributos);
        add(painelLeste, BorderLayout.EAST);

        atualizar(ficha);

        pack();

        setVisible(true);
        
    }

    private void atualizar(Ficha ficha) {
        painelInfoBasica.atualizar(ficha);
        painelAtributos.atualizar(ficha);
        painelEquipamento.atualizar(ficha);
        painelSubatributos.atualizar(ficha);

        if (ficha instanceof FichaCriatura){
            painelInfoJogador.setVisible(false);
        }

        if (ficha instanceof FichaJogador){
            painelInfoJogador.setVisible(true);
            painelInfoJogador.atualizar((FichaJogador) ficha);
        }
        
    }

}
