package toolsforrpg_panpalianos.gui.menus;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.menus.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.menus.opcoes.iniciativa.OpcaoAtualizarIniciativa;
import toolsforrpg_panpalianos.gui.menus.opcoes.iniciativa.OpcaoExcluirIniciativa;
import toolsforrpg_panpalianos.gui.menus.opcoes.iniciativa.OpcaoInserirIniciativa;
import toolsforrpg_panpalianos.gui.menus.opcoes.iniciativa.OpcaoVerIniciativa;
import toolsforrpg_panpalianos.gui.telas.TelaSair;

public class MenuIniciativas extends Menu {
    public MenuIniciativas(){
        
        do {

            int opcao = ValidadorDeInputs.consistirInteiro(toString());

            if (getOpcao(opcao) instanceof OpcaoSair){
                if (new TelaSair().usuarioQuerSair()){
                    return;
                }
            }

            executarOpcao(opcao);


        } while (true);


    }

    @Override
    protected void construir() {
        setTitulo("Menu Iniciativa");
        addOpcao(new OpcaoInserirIniciativa("Inserir iniciativa"));
        addOpcao(new OpcaoVerIniciativa("Ver iniciativas"));
        addOpcao(new OpcaoAtualizarIniciativa("Atualizar iniciativa"));
        addOpcao(new OpcaoExcluirIniciativa("Excluir iniciativa"));
        addOpcao(new OpcaoSair());
    }
}
