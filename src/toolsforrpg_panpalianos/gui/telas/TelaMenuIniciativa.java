package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.menus.Menu;
import toolsforrpg_panpalianos.gui.menus.opcoes.OpcaoSair;

public class TelaMenuIniciativa {

    public TelaMenuIniciativa(){

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
