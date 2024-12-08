package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.gui.GerenciadorTelas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoGerarTabelaPreco;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoIniciarSimuladorCombate;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoMostrarEstatisticas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoAbrirMenuFichas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoAbrirMenuIniciativa;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaMenuPrincipal extends TelaMenu {

    public TelaMenuPrincipal(){
        setTitulo("RPG OLD DRAGON");
        addOpcao(new OpcaoAbrirMenuFichas());
        addOpcao(new OpcaoAbrirMenuIniciativa());
        addOpcao(new OpcaoGerarTabelaPreco());
        addOpcao(new OpcaoIniciarSimuladorCombate());
        addOpcao(new OpcaoMostrarEstatisticas());
        addOpcao(new OpcaoSair());
    }
    
    @Override
    public void iniciar() {

        int opcao = TelaInput.obterInteiro(toString(), getTitulo());
        
        if (opcao > getOpcoes().size()){
            TelaErro.mostrar("Opcao Inexistente!");
            iniciar();
            return;
        }

        if (getOpcao(opcao) instanceof OpcaoSair){
            if (TelaInput.desejaSair()){
                GerenciadorTelas.iniciarLauncher();
                return;
            }
        }

        executarOpcao(opcao);

    }
}
