package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaTabelaPrecos;

public class OpcaoGerarTabelaPreco extends Opcao {
   
    public OpcaoGerarTabelaPreco() {
        super("Gerar tabela de precos");
    }

    @Override
    public void executar() {
        TelaTabelaPrecos.iniciar();
    }
}
