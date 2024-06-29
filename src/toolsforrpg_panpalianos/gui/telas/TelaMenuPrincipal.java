package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.Launcher;
import toolsforrpg_panpalianos.gui.menus.Menu;
import toolsforrpg_panpalianos.gui.menus.opcoes.OpcaoSair;

public class TelaMenuPrincipal {

    public TelaMenuPrincipal() {

        Menu menu = Menu.criarMenuPrincipal();

        do{

            int opcao = ValidadorDeInputs.consistirInteiro(menu.toString());

            menu.executarOpcao(opcao);

            if (menu.getOpcao(opcao) instanceof OpcaoSair){
                if (new TelaSair().usuarioQuerSair()){
                    new Launcher();
                    return;
                }
            }
    
        } while (true);
    }

}