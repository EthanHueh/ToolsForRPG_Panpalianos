package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaSimuladorDeCombate;

public class OpcaoIniciarSimuladorCombate extends Opcao{

    public OpcaoIniciarSimuladorCombate() {
        super("Iniciar simulador de combate");
    }

    @Override
    public void executar() {
        TelaSimuladorDeCombate.iniciar();
    }
    
}
