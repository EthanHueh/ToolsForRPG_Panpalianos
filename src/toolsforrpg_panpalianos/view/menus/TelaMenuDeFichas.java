package toolsforrpg_panpalianos.view.menus;

import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.view.telas.TelaSair;

public class TelaMenuDeFichas {

    private ValidadorDeInputs valInp;

    public TelaMenuDeFichas(){

        Menu menu = Menu.criarMenuDeFichas();

        valInp = new ValidadorDeInputs();

        do{

            int opcao = valInp.consistirInteiro(menu.toString());

            if (menu.getOpcao(opcao) instanceof OpcaoSair){
                if (new TelaSair().usuarioQuerSair()){
                    return;
                }
            }

            menu.executarOpcao(opcao);

        }
        while(true);
    }

}