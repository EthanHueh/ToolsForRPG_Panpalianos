package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoCriarFichaCriatura extends Opcao {

    public OpcaoCriarFichaCriatura() {
        super("Criar ficha criatura");
    }

    @Override
    public void executar() {
        TelaFichas.criarFichaCriatura();
    }

}
