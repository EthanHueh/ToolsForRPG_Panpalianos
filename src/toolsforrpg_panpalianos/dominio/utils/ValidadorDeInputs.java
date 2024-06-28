package toolsforrpg_panpalianos.dominio.utils;

import javax.swing.JOptionPane;

public class ValidadorDeInputs {

    public static int consistirInteiro(String msg){

        int numero = 0;

        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(msg));
                return numero;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira novamente!", "Input errado", 0);
            }
        }
        while(true);

    }


}
