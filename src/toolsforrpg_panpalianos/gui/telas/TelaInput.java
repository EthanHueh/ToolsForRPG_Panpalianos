package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaInput {

    public static int obterInteiro(String msg) {
        return ValidadorDeInputs.consistirInteiro(msg);
    }

    public static boolean desejaSair(){
        int opcaoSair = JOptionPane.showConfirmDialog(null, "Desejas Sair","Desejas Sair", JOptionPane.YES_NO_OPTION);
        return opcaoSair == JOptionPane.YES_OPTION;
    }

}
