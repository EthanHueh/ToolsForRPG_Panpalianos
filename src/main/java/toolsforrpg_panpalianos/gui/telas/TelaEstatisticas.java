package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.GerenciadorTelas;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaTabela;

import toolsforrpg_panpalianos.dominio.servicos.Estatisticas;

public class TelaEstatisticas {
    public static void iniciar(){

        String[][] valoresTabela = Estatisticas.executar();
        
        if (valoresTabela == null){
            TelaAviso.avisar("Nenhuma ficha cadastrada!", "Erro");
            GerenciadorTelas.telaMenuPrincipal.iniciar();
            return;
        }
        
        String[] colunas = {"Nome Atributo", "Per. Menor atributo", "Per. maior atributo", "Media da party"};
        
        TelaTabela.iniciar("Estatisticas", valoresTabela, colunas);
    }
}
