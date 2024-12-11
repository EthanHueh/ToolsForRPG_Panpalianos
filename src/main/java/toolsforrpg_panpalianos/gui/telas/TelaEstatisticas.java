package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaTabela;

import toolsforrpg_panpalianos.dominio.servicos.Estatisticas;

public class TelaEstatisticas {
    public static void iniciar(){
        
        try {
            TelaTabela.iniciar(
                "Estatisticas",
                Estatisticas.executar(),
                new String[]{
                    "Nome Atributo",
                    "Per. Menor atributo",
                    "Per. maior atributo",
                    "Media da party"
                }
            );
        } catch (Exception e) {
            TelaErro.mostrar(e.getMessage(), "Erro");
        }
        
    }
}
