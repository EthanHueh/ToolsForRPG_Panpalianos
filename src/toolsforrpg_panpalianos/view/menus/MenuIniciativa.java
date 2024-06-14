package toolsforrpg_panpalianos.view.menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerFichas;
import toolsforrpg_panpalianos.controller.ControllerIniciativas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.telas.IniciativasView;

public class MenuIniciativa {

    private ValidadorDeInputs valInp;

    MenuIniciativa(){

        valInp = new ValidadorDeInputs();

        do {

            int opcao = valInp.consistirInteiro(stringMenuIniciativa());

            switch(opcao){
        
                case 1:
                    opcaoGerarIniciativas();
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

    private String stringMenuIniciativa() {
        return
            "1 - Adicionar iniciativas\n"+
            "2 - Ver iniciativas\n\n"+

            "3 - Sair";
    }

    private void opcaoGerarIniciativas() {

        List<FichaCriatura> fichas = new ArrayList<>();
        fichas.addAll(ControllerFichas.getFichasJogadores());
        fichas.addAll(ControllerFichas.getFichasAvulsas());

        for (FichaCriatura ficha : fichas) {
            int iniciativa = valInp.consistirInteiro("Insira a iniciativa do(a) "+ficha.getNome());
            ControllerIniciativas.adicionar(iniciativa);
        }
    }

}
