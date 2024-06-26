package toolsforrpg_panpalianos.view.menus.opcoes;

import toolsforrpg_panpalianos.controller.ControllerCalculos;
import toolsforrpg_panpalianos.view.telas.TelaJTextArea;

public class OpcaoMostrarEstatisticas extends Opcao{

    public OpcaoMostrarEstatisticas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaJTextArea(ControllerCalculos.gerarEstatisticas(), "Estatística");
    }

}
