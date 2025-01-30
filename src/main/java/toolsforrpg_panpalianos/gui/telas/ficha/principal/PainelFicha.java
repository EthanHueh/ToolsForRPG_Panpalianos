package toolsforrpg_panpalianos.gui.telas.ficha.principal;

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

    public PainelFicha(Ficha ficha){
        this.ficha = ficha;
        
        add(new JLabel(ficha.toString()));

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
        new TelaMostrarFichas(ficha);
    }

    private void atualizar() {
        FormAtualizar.getInstance().iniciar(ficha);
    }

    private void excluir() {
        TelaExcluirFicha.getInstance().iniciar(ficha);
    }

}
