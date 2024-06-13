package toolsforrpg_panpalianos.view.menus;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.repository.FichasRepository;
import toolsforrpg_panpalianos.service.GeradorDeFichas;

public class MenuDeFichas {

    public static void subMenu() {

        do{

            int opcao = 0;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(stringMenuDeFichas()));
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número!", "X", 0);
                
            }

            if (opcao > 0 && opcao <= 3){
                FichasRepository.adicionar(GeradorDeFichas.criarNovaFicha(opcao));
            }
            
            if (opcao == 4){
                return;
            }

        }
        while(true);

    }

    private static String stringMenuDeFichas(){
        return
            "Escolha a opcao:\n\n"+

            "1 - Ficha padrão\n"+
            "2 - Ficha de jogador\n"+
            "3 - Ficha com atributos aleatórios\n\n"+
            "4 - Sair\n";
    }        

}