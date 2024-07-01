package toolsforrpg_panpalianos.gui.telas.menus;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.Launcher;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoGerarTabelaPreco;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoIniciarSimuladorCombate;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoMostrarEstatisticas;
import toolsforrpg_panpalianos.gui.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoAbrirMenuFichas;
import toolsforrpg_panpalianos.gui.opcoes.iniciativa.OpcaoAbrirMenuIniciativa;
import toolsforrpg_panpalianos.gui.telas.TelaSair;

public class TelaMenuPrincipal extends TelaMenu {

    public TelaMenuPrincipal(){
        super();
    }

    @Override
    protected void construir() {
        setTitulo("RPG OLD DRAGON");
        addOpcao(new OpcaoAbrirMenuFichas("Gerenciar fichas"));
        addOpcao(new OpcaoAbrirMenuIniciativa("Gerenciar Iniciativa"));
        addOpcao(new OpcaoGerarTabelaPreco("Cálculo de Preço Equipamento"));
        addOpcao(new OpcaoIniciarSimuladorCombate("Simular combate"));
        addOpcao(new OpcaoMostrarEstatisticas("Mostrar estatísticas"));
        addOpcao(new OpcaoSair());
    }

    @Override
    protected void iniciar(){
        do {

            int opcao = ValidadorDeInputs.consistirInteiro(toString());

            executarOpcao(opcao);

            if (getOpcao(opcao) instanceof OpcaoSair){
                if (new TelaSair().usuarioQuerSair()){
                    new Launcher();
                    return;
                }
            }
    
        } while (true);
    }

    

}
