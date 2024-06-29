package toolsforrpg_panpalianos.dominio.servicos;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;

public class Tabelas {

    private static int[][] tabelaPVsAdicionais =
    {
        {1, 2, 1, 1},
        {1, 2, 1, 1},
        {2, 4, 2, 1},
        {2, 4, 2, 1},
        {3, 5, 2, 1},
        {3, 5, 3, 2},
        {4, 6, 3, 2},
        {4, 6, 3, 2},
        {5, 7, 4, 2},
        {5, 7, 4, 2},
        {6, 8, 4, 3}
    };

    private static int COL_CLERIGO = 0;
    private static int COL_HOMEM_DE_ARMAS = 2;
    private static int COL_LADRAO = 2;
    private static int COL_MAGO = 3;

    public static List<Integer> getColuna(Classe classe) {
        int colunaClasse = 0;
        switch (classe) {
            case CLERIGO:
                colunaClasse = COL_CLERIGO;
                break;
            case HOMEM_DE_ARMAS:
                colunaClasse = COL_HOMEM_DE_ARMAS;
                break;
            case LADRAO:
                colunaClasse = COL_LADRAO;

            case MAGO:
                colunaClasse = COL_MAGO;

            default:
                return null;
        }

        List<Integer> coluna = new ArrayList<>();

        for (int i = 0; i < tabelaPVsAdicionais.length; i++){
            coluna.add(tabelaPVsAdicionais[i][colunaClasse]);
        }

        return coluna;
        
    }

    @Override
    public String toString(){

        String msg = "";

        for (Classe classe: Classe.values()){
            msg += "["+classe.getNome()+"]";
        }
        msg += "\n";

        for (int i = 0; i < tabelaPVsAdicionais.length; i++){
            for (int j = 0; j < tabelaPVsAdicionais[i].length; j++){
                msg += "["+i+"] ";
            }
            msg += "\n";
        }

        return msg;
    }
    
}
