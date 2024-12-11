package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoAtualizarFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoCadastrarFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoExcluirFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarFichasCriatura;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarFichasJogador;

public class TelaMenuFichas extends TelaMenu {

    public TelaMenuFichas(){
        setTitulo("Menu de fichas");
        addOpcao(new OpcaoMostrarFichasJogador());
        addOpcao(new OpcaoMostrarFichasCriatura());
        addOpcao(new OpcaoCadastrarFicha());
        addOpcao(new OpcaoAtualizarFicha());
        addOpcao(new OpcaoExcluirFicha());
        addOpcao(new OpcaoSair());
    }
    
}
