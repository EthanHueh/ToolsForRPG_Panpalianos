package toolsforrpg_panpalianos.gui.componentes.botoes;

import javax.swing.JTextField;

import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;

public class BotaoRolaDadosAtributo extends BotaoPadrao {
    
    public BotaoRolaDadosAtributo(JTextField JTextField){
        super("");
        setIcon(IconesImagem.DADO.getImageIcon());
        addActionListener(
            e -> JTextField.setText(String.valueOf(RoladorDeDados.executar(3, 6)))
        );
    }
}
