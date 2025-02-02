package toolsforrpg_panpalianos.gui.telas.ficha.principal;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;
import toolsforrpg_panpalianos.gui.telas.ficha.atualizar.FormAtualizar;
import toolsforrpg_panpalianos.gui.telas.ficha.excluir.TelaExcluirFicha;
import toolsforrpg_panpalianos.gui.telas.ficha.exibir.TelaMostrarFichas;

public class PainelFicha extends JPanel {

    private Ficha ficha;

    private FormAtualizar formAtualizar = new FormAtualizar();
    private TelaMostrarFichas telaMostrarFichas = new TelaMostrarFichas();

    public PainelFicha(Ficha ficha){
        this.ficha = ficha;
        this.telaMostrarFichas = new TelaMostrarFichas();

        JLabel jLabel = new JLabel(ficha.toString());
        jLabel.setPreferredSize(new Dimension(300, 30));
        add(jLabel);

        JButton jButton = new JButton(IconesImagem.OLHO.getImageIcon());
        jButton.addActionListener(
            e -> mostrar()
        );
        add(jButton);

        jButton = new JButton(IconesImagem.EDITAR.getImageIcon());
        jButton.addActionListener(
            e -> atualizar()
        );
        add(jButton);

        jButton = new JButton(IconesImagem.EXCLUIR.getImageIcon());
        jButton.addActionListener(
            e -> excluir()
        );
        add(jButton);

    }

    private void mostrar() {
        telaMostrarFichas.mostrar(ficha);
    }

    private void atualizar() {
        formAtualizar.iniciar(ficha);
    }

    private void excluir() {
        TelaExcluirFicha.iniciar(ficha);
    }

}
