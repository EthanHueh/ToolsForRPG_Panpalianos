package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoAtualizarIniciativa;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoExcluirIniciativa;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoAdicionarIniciativa;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoSalvarIniciativas;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoVerIniciativa;

public class TelaMenuIniciativas extends TelaMenu {
    
    public TelaMenuIniciativas(){
        super();
    }

    @Override
    protected void construir() {
        setTitulo("Menu Iniciativa");
        addOpcao(new OpcaoAdicionarIniciativa());
        addOpcao(new OpcaoVerIniciativa());
        addOpcao(new OpcaoAtualizarIniciativa());
        addOpcao(new OpcaoExcluirIniciativa());
        addOpcao(new OpcaoSalvarIniciativas());
        addOpcao(new OpcaoSair());
        
    }
}
