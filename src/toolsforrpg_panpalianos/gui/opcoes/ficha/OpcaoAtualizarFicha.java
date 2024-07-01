package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.telas.TelaFichas;
import toolsforrpg_panpalianos.gui.opcoes.Opcao;

public class OpcaoAtualizarFicha extends Opcao {

    public OpcaoAtualizarFicha(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaFichas.atualizarFicha();    
    }
    
}
