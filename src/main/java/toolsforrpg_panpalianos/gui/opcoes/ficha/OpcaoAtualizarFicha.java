package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.ficha.TelaFichas;

public class OpcaoAtualizarFicha extends Opcao {

    public OpcaoAtualizarFicha() {
        super("Atualizar ficha");
    }

    @Override
    public void executar() {
        TelaFichas.atualizarFicha();    
    }
    
}
