package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.ficha.TelaFichas;

public class OpcaoCadastrarFicha extends Opcao {
    
    public OpcaoCadastrarFicha() {
        super("Cadastrar ficha");
    }

    @Override
    public void executar() {
        TelaFichas.cadastrarFicha();
    }

}
