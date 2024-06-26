package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.controller.ControllerSimuladorCombate;

public class OpcaoIniciarSimuladorCombate extends Opcao{

    public OpcaoIniciarSimuladorCombate(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        ControllerSimuladorCombate.executarSimulador();
    }
    
    
}
