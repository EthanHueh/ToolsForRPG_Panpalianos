package toolsforrpg_panpalianos.gui.telas.menus;

import javax.swing.JOptionPane;
import toolsforrpg_panpalianos.gui.GerenciadorTelas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoGerarTabelaPreco;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoIniciarSimuladorCombate;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoMostrarEstatisticas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoAbrirMenuFichas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoAbrirMenuIniciativa;
import toolsforrpg_panpalianos.gui.telas.TelaInput;

public class TelaMenuPrincipal extends TelaMenu {

    public TelaMenuPrincipal(){
        super();
    }

    @Override
    protected void construir() {
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
            JOptionPane.showMessageDialog(null, "Opcao Inexistente!");
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
