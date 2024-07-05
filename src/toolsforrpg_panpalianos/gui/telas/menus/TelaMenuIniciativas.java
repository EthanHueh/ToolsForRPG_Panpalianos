package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoAtualizarIniciativa;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoExcluirIniciativa;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoInserirIniciativa;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoVerIniciativa;
import toolsforrpg_panpalianos.gui.telas.TelaInput;

public class TelaMenuIniciativas extends TelaMenu {
    
    public TelaMenuIniciativas(){
        super();
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
