package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaSimuladorDeCombate;

public class OpcaoIniciarSimuladorCombate extends Opcao{

    public OpcaoIniciarSimuladorCombate(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaSimuladorDeCombate();
    }
    
}
