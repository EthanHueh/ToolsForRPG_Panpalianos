package toolsforrpg_panpalianos.view.menus;

import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.Launcher;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.view.telas.TelaSair;

public class TelaMenuPrincipal {

    private static ValidadorDeInputs valInp = new ValidadorDeInputs();

    public TelaMenuPrincipal() {

        Menu menu = Menu.criarMenuPrincipal();

        do{

            int opcao = valInp.consistirInteiro(menu.toString());

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