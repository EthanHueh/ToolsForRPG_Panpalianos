package toolsforrpg_panpalianos.gui.telas.ficha;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoRolaDadosAtributo;

public class PainelAtributos extends JPanel {
    JTextField forca = new JTextField();
    JTextField destreza = new JTextField();
    JTextField constituicao = new JTextField();
    JTextField inteligencia = new JTextField();
    JTextField sabedoria = new JTextField();
    JTextField carisma = new JTextField();

    PainelAtributos(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6,3));

        BotaoRolaDadosAtributo[] botoesAtributos = {
            new BotaoRolaDadosAtributo(forca),
            new BotaoRolaDadosAtributo(destreza),
            new BotaoRolaDadosAtributo(constituicao),
            new BotaoRolaDadosAtributo(inteligencia),
            new BotaoRolaDadosAtributo(sabedoria),
            new BotaoRolaDadosAtributo(carisma)
        };

        JButton btnRolarTudo = new JButton("Rolar tudo");
        for (BotaoRolaDadosAtributo btn : botoesAtributos) {
            for (ActionListener a: btn.getActionListeners()){
                btnRolarTudo.addActionListener(a);
            }
        }
        add(btnRolarTudo);

        forca.setText("10");
        destreza.setText("10");
        constituicao.setText("10");
        inteligencia.setText("10");
        sabedoria.setText("10");
        carisma.setText("10");
        
        painel.add(new JLabel("Força"));
        painel.add(forca);
        painel.add(botoesAtributos[0]);

        painel.add(new JLabel("Destreza"));
        painel.add(destreza);
        painel.add(botoesAtributos[1]);

        painel.add(new JLabel("Constituição"));
        painel.add(constituicao);
        painel.add(botoesAtributos[2]);

        painel.add(new JLabel("Inteligência"));
        painel.add(inteligencia);
        painel.add(botoesAtributos[3]);

        painel.add(new JLabel("Sabedoria"));
        painel.add(sabedoria);
        painel.add(botoesAtributos[4]);

        painel.add(new JLabel("Carisma"));
        painel.add(carisma);
        painel.add(botoesAtributos[5]);

        add(painel);
    }

}
