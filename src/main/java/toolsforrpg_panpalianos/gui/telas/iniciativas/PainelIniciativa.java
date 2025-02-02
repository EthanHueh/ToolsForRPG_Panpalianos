package toolsforrpg_panpalianos.gui.telas.iniciativas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;

public class PainelIniciativa extends JPanel {

    private Iniciativa iniciativa;
    private TelaIniciativas telaIniciativas;

    public PainelIniciativa(Iniciativa iniciativa, TelaIniciativas telaIniciativas){
        this.iniciativa = iniciativa;
        this.telaIniciativas = telaIniciativas;
        
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
        telaIniciativas.atualizarIniciativa(iniciativa);         
    }

    private void excluir() {
        telaIniciativas.excluirIniciativa(iniciativa);
    }

}
