package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaEstatisticas;

public class OpcaoMostrarEstatisticas extends Opcao{

    public OpcaoMostrarEstatisticas() {
        super("Mostrar estatisticas");
    }

    @Override
    public void executar() {
        TelaEstatisticas.iniciar();;
    }

}
