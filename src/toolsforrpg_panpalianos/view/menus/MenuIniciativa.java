package toolsforrpg_panpalianos.view.menus;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerIniciativas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.telas.IniciativasView;

public class MenuIniciativa {

    private static ValidadorDeInputs valInp = new ValidadorDeInputs();

    public static void iniciar() {

        do{

            int opcao = valInp.consistirInteiro(stringMenuIniciativa());

            switch(opcao){
        
                case 1:
                    ControllerIniciativas.gerarIniciativas();
                    break;

                case 2:
                    IniciativasView.mostrarListaIniciativas();
                    break;
                    
                case 3:
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", "X", 0);
                    break;
            }
    
        } while (true);

        

    }

    private static String stringMenuIniciativa() {
        return
            "1 - Adicionar iniciativas\n"+
            "2 - Ver iniciativas\n\n"+

            "3 - Sair";
    }

    public static int inserirIniciativa(FichaCriatura ficha) {
        return valInp.consistirInteiro("Insira a iniciativa do(a) "+ficha.getNome());
    }
    
}
