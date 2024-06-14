package toolsforrpg_panpalianos.view.menus;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerFichas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.telas.TelaCriarFicha;

public class MenuDeFichas {

    private ValidadorDeInputs valInp;

    MenuDeFichas(){

        valInp = new ValidadorDeInputs();

        do{

            int opcao = 0;

            try {
                opcao = valInp.consistirInteiro(stringMenuDeFichas());
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número!", "X", 0);
                
            }

            if (opcao > 0 && opcao <= 3){

                FichaCriatura ficha = new TelaCriarFicha().criarNovaFicha(opcao);

                int opcaoSair = JOptionPane.showConfirmDialog(null, "Quer mesmo cadastrar essa ficha?","Confirmacao de cadastro", JOptionPane.YES_NO_OPTION);
                if (opcaoSair == JOptionPane.YES_OPTION){
                    return;
                }

                ControllerFichas.cadastrarFicha(ficha);
            }

            if (opcao == 4){
                return;
            }

        }
        while(true);
    }

    private String stringMenuDeFichas(){
        return
            "Escolha a opcao:\n\n"+

            "1 - Ficha padrão\n"+
            "2 - Ficha de jogador\n"+
            "3 - Ficha com atributos aleatórios\n\n"+
            "4 - Sair\n";
    } 

}