package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoCriarFichaAtributosAleatorios extends Opcao {

    public OpcaoCriarFichaAtributosAleatorios() {
        super("Criar ficha com atributos aleatorios");
    }

    @Override
    public void executar() {
        TelaFichas.criarFichaAtributosAleatorios();
    }

}
