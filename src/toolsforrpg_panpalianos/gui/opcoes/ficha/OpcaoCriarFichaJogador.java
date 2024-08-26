package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoCriarFichaJogador extends Opcao {
    
    public OpcaoCriarFichaJogador() {
        super("Criar ficha jogador");
    }

    @Override
    public void executar() {
        TelaFichas.criarFichaJogador();
    }

}
