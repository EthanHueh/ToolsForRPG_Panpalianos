package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoAtualizarFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoCriarFichaAtributosAleatorios;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoCriarFichaCriatura;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoCriarFichaJogador;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoExcluirFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarFichasCriatura;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarFichasJogador;

public class TelaMenuFichas extends TelaMenu {

    public TelaMenuFichas(){
        super();
    }

    @Override
    protected void construir() {
        setTitulo("Menu de fichas");
        addOpcao(new OpcaoMostrarFichasJogador());
        addOpcao(new OpcaoMostrarFichasCriatura());
        addOpcao(new OpcaoCriarFichaCriatura());
        addOpcao(new OpcaoCriarFichaJogador());
        addOpcao(new OpcaoCriarFichaAtributosAleatorios());
        addOpcao(new OpcaoAtualizarFicha());
        addOpcao(new OpcaoExcluirFicha());
        addOpcao(new OpcaoSair());
    }
    
}
