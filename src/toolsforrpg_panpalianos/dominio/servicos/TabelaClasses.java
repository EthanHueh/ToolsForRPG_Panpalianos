package toolsforrpg_panpalianos.dominio.servicos;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.NivelClasse;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class TabelaClasses {

    public static List<Integer> retornarPVsAdicionais(FichaJogador ficha) {
        NivelClasse[] niveisClasse = retornarNiveis(ficha);

        List<Integer> pvsAdicionais = new ArrayList<>();

        for (NivelClasse nivelClasse : niveisClasse) {
            pvsAdicionais.add(nivelClasse.getPvsAdicionais());
        }


        return pvsAdicionais;


    }

    public static NivelClasse[] retornarNiveis(FichaJogador ficha){
        switch (ficha.getClasse()){
            case CLERIGO:
                return retornarNiveisClerigo();

            case HOMEM_DE_ARMAS:
                return retornarNiveisHomemDeArmas();

            case LADRAO:
                return retornarNiveisLadrao();

            case MAGO:
                return retornarNiveisMago();

            default:
                return retornarNiveisClerigo();
        }
    }

    private static NivelClasse[] retornarNiveisClerigo(){
        NivelClasse[] niveisClerigo = {
            new NivelClasse(1, 0, 0, "+1", 15),
            new NivelClasse(2, 1500, 0, "+1", 15),
            new NivelClasse(3, 3000, 0, "+2", 15),
            new NivelClasse(4, 6000, 0, "+2", 14),
            new NivelClasse(5, 12000, 0, "+2", 14),
            new NivelClasse(6, 24000, 0, "+3", 14),
            new NivelClasse(7, 48000, 0, "+3", 13),
            new NivelClasse(8, 100000, 0, "+3", 13),
            new NivelClasse(9, 200000, 0, "+4", 13),
            new NivelClasse(10, 300000, 1, "+4", 12),
            new NivelClasse(11, 400000, 1, "+4", 12),
            new NivelClasse(12, 500000, 2, "+5", 12),
            new NivelClasse(13, 600000, 2, "+5", 11),
            new NivelClasse(14, 700000, 3, "+5", 11),
            new NivelClasse(15, 800000, 3, "+6", 11),
            new NivelClasse(16, 900000, 4, "+6", 10),
            new NivelClasse(17, 1000000, 4, "+6", 10),
            new NivelClasse(18, 1100000, 5, "+7", 10),
            new NivelClasse(19, 1200000, 5, "+7", 9),
            new NivelClasse(20, 1300000, 6, "+7", 9)
        };

        return niveisClerigo;
    }

    private static NivelClasse[] retornarNiveisHomemDeArmas(){
        NivelClasse[] niveisHomemDeArmas = {
            new NivelClasse(1, 0, 0, "+1", 16),
            new NivelClasse(2, 2000, 0, "+2", 16),
            new NivelClasse(3, 4000, 0, "+3", 16),
            new NivelClasse(4, 8000, 0, "+4", 15),
            new NivelClasse(5, 16000, 0, "+5", 15),
            new NivelClasse(6, 32000, 0, "+6", 15),
            new NivelClasse(7, 64000, 0, "+7/+1", 14),
            new NivelClasse(8, 128000, 0, "+8/+2", 14),
            new NivelClasse(9, 256000, 0, "+9/+3", 14),
            new NivelClasse(10, 304000, 2, "+10/+4", 13),
            new NivelClasse(11, 408000, 2, "+10/+4", 13),
            new NivelClasse(12, 516000, 4, "+11/+5", 13),
            new NivelClasse(13, 632000, 4, "+11/+5", 12),
            new NivelClasse(14, 704000, 5, "+12/+6", 12),
            new NivelClasse(15, 808000, 5, "+12/+6", 12),
            new NivelClasse(16, 916000, 6, "+13/+7", 11),
            new NivelClasse(17, 1032000, 6, "+13/+7", 11),
            new NivelClasse(18, 1064000, 7, "+14/+8", 11),
            new NivelClasse(19, 1128000, 7, "+14/+8", 10),
            new NivelClasse(20, 1256000, 8, "+15/+9", 10)
        };

        return niveisHomemDeArmas;
    }

    private static NivelClasse[] retornarNiveisLadrao(){
        NivelClasse[] niveisLadrao = {
            new NivelClasse(1, 0, 0, "+1", 15),
            new NivelClasse(2, 1250, 0, "+1", 15),
            new NivelClasse(3, 2500,0, "+2", 15),
            new NivelClasse(4, 5000, 0, "+2", 14),
            new NivelClasse(5, 10000, 0, "+2", 14),
            new NivelClasse(6, 20000, 0, "+3", 14),
            new NivelClasse(7, 40000, 0, "+3", 13),
            new NivelClasse(8, 80000, 0, "+3", 13),
            new NivelClasse(9, 160000, 0, "+4", 13),
            new NivelClasse(10, 240000, 1, "+4", 12),
            new NivelClasse(11, 400000, 1, "+4", 12),
            new NivelClasse(12, 520000, 2, "+5", 12),
            new NivelClasse(13, 640000, 2, "+5", 11),
            new NivelClasse(14, 760000, 2, "+5", 11),
            new NivelClasse(15, 880000, 3, "+6", 11),
            new NivelClasse(16, 1000000, 3, "+6", 10),
            new NivelClasse(17, 1120000, 3, "+6", 10),
            new NivelClasse(18, 1240000, 4, "+7", 10),
            new NivelClasse(19, 1360000, 4, "+7", 9),
            new NivelClasse(20, 1480000, 4, "+7", 9)
        };

        return niveisLadrao;
    }

    private static NivelClasse[] retornarNiveisMago(){
        NivelClasse[] niveisMago = {
            new NivelClasse(1, 0, 0, "+0", 15),
            new NivelClasse(2, 2500, 0, "+0", 14),
            new NivelClasse(3, 5000, 0, "+1", 14),
            new NivelClasse(4, 10000, 0, "+1", 13),
            new NivelClasse(5, 20000,0, "+2", 13),
            new NivelClasse(6, 40000, 0, "+2", 13),
            new NivelClasse(7, 80000, 0, "+3", 12),
            new NivelClasse(8, 160000, 0, "+3", 12),
            new NivelClasse(9, 310000, 0, "+3", 12),
            new NivelClasse(10, 460000, 1, "+4", 11),
            new NivelClasse(11, 510000, 1, "+4", 11),
            new NivelClasse(12, 660000, 1, "+4", 11),
            new NivelClasse(13, 710000, 1, "+5", 10),
            new NivelClasse(14, 860000, 1, "+5", 10),
            new NivelClasse(15, 910000, 2, "+5", 10),
            new NivelClasse(16, 1060000, 2, "+6", 9),
            new NivelClasse(17, 1110000, 2, "+6", 9),
            new NivelClasse(18, 1160000, 2, "+6", 9),
            new NivelClasse(19, 1210000, 2, "+7", 8),
            new NivelClasse(20, 1260000, 3, "+7", 8)
        };

        return niveisMago;
    }

    public static int getJogadaProtecao(FichaJogador fichaJogador) {
        return retornarNiveis(fichaJogador)[fichaJogador.getLvl() - 1].getJogadaProtecao();
    }

    public static int getBaseAtaque(FichaJogador fichaJogador) {
        
        String valorColuna = retornarNiveis(fichaJogador)[fichaJogador.getLvl() - 1].getBaseAtaque();
        
        int baseAtaque = 0;

        try {
            baseAtaque = Integer.parseInt(valorColuna);
        } catch (NumberFormatException e1){

            String ba = "";
            for (int i = 0; i < valorColuna.length(); i++){
                
                if (valorColuna.charAt(i) == '/'){
                    break;
                }
                
                ba += String.valueOf(valorColuna.charAt(i));

            }

            try {
                baseAtaque = Integer.parseInt(ba);
            } catch (NumberFormatException e2){
                baseAtaque = 0;
            }
            
        }


        return baseAtaque;
    }
    
}
