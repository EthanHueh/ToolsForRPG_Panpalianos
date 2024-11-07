package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoExcluirFicha extends Opcao {

    public OpcaoExcluirFicha() {
        super("Excluir ficha");
    }

    @Override
    public void executar() {
        TelaFichas.excluirFicha();
    }
    
}
