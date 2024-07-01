package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoAtualizarFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoCriarFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoExcluirFicha;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarFichas;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarJogadores;
public class TelaMenuFichas extends TelaMenu {

    public TelaMenuFichas(){
        super();
    }

    @Override
    protected void construir() {
        setTitulo("Menu de fichas");
        addOpcao(new OpcaoMostrarJogadores("Mostrar fichas dos jogadores"));
        addOpcao(new OpcaoMostrarFichas("Mostrar fichas avulsas"));
        addOpcao(new OpcaoCriarFicha("Ficha padrão", 1));
        addOpcao(new OpcaoCriarFicha("Ficha de jogador", 2));
        addOpcao(new OpcaoCriarFicha("Ficha com atributos aleatórios",3));
        addOpcao(new OpcaoAtualizarFicha("Atualizar ficha"));
        addOpcao(new OpcaoExcluirFicha("Excluir ficha"));
        addOpcao(new OpcaoSair());
    }
    
}
