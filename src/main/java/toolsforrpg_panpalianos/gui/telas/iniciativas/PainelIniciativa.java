package toolsforrpg_panpalianos.gui.telas.iniciativas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;

public class PainelIniciativa extends JPanel {

    private Iniciativa iniciativa;

    public PainelIniciativa(Iniciativa iniciativa){
        this.iniciativa = iniciativa;
        
        JLabel jLabel = new JLabel(iniciativa.toString()); 
        jLabel.setPreferredSize(new Dimension(150, 30));
        add(jLabel);

        JButton jButton = new JButton(IconesImagem.EDITAR.getImageIcon());
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

    private void atualizar() {
        TelaIniciativas.getInstance().atualizarIniciativa(iniciativa.getFicha());         
    }

    private void excluir() {
        TelaIniciativas.getInstance().excluirIniciativa(iniciativa.getFicha());
    }

}
