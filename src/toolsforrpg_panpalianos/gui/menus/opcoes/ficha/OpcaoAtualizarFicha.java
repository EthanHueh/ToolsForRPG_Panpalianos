package toolsforrpg_panpalianos.gui.menus.opcoes.ficha;

import toolsforrpg_panpalianos.gui.menus.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoAtualizarFicha extends Opcao {

    public OpcaoAtualizarFicha(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaFichas.atualizarFicha();    
    }
    
}
