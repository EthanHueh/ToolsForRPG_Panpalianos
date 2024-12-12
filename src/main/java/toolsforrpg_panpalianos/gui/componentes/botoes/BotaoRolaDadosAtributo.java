package toolsforrpg_panpalianos.gui.componentes.botoes;

import javax.swing.JButton;
import javax.swing.JTextField;

import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class BotaoRolaDadosAtributo extends JButton {
    public BotaoRolaDadosAtributo(JTextField JTextField){
        setText("Rolar atributo");
        addActionListener(
            e -> JTextField.setText(String.valueOf(RoladorDeDados.executar(3, 6)))
        );
    }
}
