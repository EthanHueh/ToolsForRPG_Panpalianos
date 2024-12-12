package toolsforrpg_panpalianos.gui.componentes.botoes;

import javax.swing.JTextField;

import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class BotaoRolaDadosAtributo extends BotaoPadrao {
    
    public BotaoRolaDadosAtributo(JTextField JTextField){
        super("Rolar atributo");
        addActionListener(
            e -> JTextField.setText(String.valueOf(RoladorDeDados.executar(3, 6)))
        );
    }
}
