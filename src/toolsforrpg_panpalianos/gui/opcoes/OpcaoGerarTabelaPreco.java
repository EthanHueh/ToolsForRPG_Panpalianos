package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.gui.telas.TelaTabelaPrecos;

public class OpcaoGerarTabelaPreco extends Opcao {
   
    public OpcaoGerarTabelaPreco(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaTabelaPrecos.iniciar();
    }
}
