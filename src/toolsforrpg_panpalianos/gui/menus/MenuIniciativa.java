package toolsforrpg_panpalianos.gui.menus;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.menus.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.telas.TelaSair;

public class MenuIniciativa {

    public MenuIniciativa(){

        Menu menu = Menu.criarMenuIniciativa();

        do {

            int opcao = ValidadorDeInputs.consistirInteiro(menu.toString());

            if (menu.getOpcao(opcao) instanceof OpcaoSair){
                if (new TelaSair().usuarioQuerSair()){
                    return;
                }
            }

            menu.executarOpcao(opcao);


        } while (true);

    }

}
