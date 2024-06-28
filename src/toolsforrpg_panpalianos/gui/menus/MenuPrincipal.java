package toolsforrpg_panpalianos.gui.menus;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.Launcher;
import toolsforrpg_panpalianos.gui.menus.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.telas.TelaSair;

public class MenuPrincipal {

    public MenuPrincipal() {

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