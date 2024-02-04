package toolsforrpg_panpalianos;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;

public class Regras {

    public final static int DADO_VIDA_CRIATURA = 8;
    public final static int DADO_VIDA_CRIATURA_MEDIO = 5;

    public final static int DADO_VIDA_HOMEM_DE_ARMAS = 10;
    public final static int DADO_VIDA_CLERIGO = 8;
    public final static int DADO_VIDA_LADRAO = 6;
    public final static int DADO_VIDA_MAGO = 4;

    //public static int[] PVsAdicionaisPorLvlClerigo = {1,1,2,2,3,3,4,4,5,5,6};
    //public static int[] PVsAdicionaisPorLvlHdeArmas = {2,2,4,4,5,5,6,6,7,7,8};
    //public static int[] PVsAdicionaisPorLvlLadrao = {1,1,2,2,2,3,3,3,4,4,4};
    //public static int[] PVsAdicionaisPorLvlMago = {1,1,1,1,1,2,2,2,2,2,3};

    public static int calcularBonus(int atributo){
        return (atributo - 10)/2;
    }

    public static int calcularDVJogador(int lvl) {
        
        if(lvl <= 9){
            return lvl;
        } else {
            return 9;
        }
        
    }
    
    public static String calcularPV(FichaCriatura ficha){

        int constituicao = ficha.getConstituicao();
        int pvAdicional = ficha.getPvAdicional();

        int quantDVs = ficha.getQuantDVs();

        int bonusCon = calcularBonus(constituicao);

        int quantPVsMedio = (quantDVs*(Regras.DADO_VIDA_CRIATURA_MEDIO+bonusCon)+pvAdicional);
        int quantPVsMaximo = (quantDVs*(Regras.DADO_VIDA_CRIATURA+bonusCon)+pvAdicional);
        
        return quantPVsMedio+"/"+quantPVsMaximo;

    }

    public static int calcularPVJogador(FichaJogador ficha){
        int dadoVida = 0;
        int dadoVidaMedio = 0;

        int bonusCon = calcularBonus(ficha.getConstituicao());

        int lvl = ficha.getLvl();

        String classe = ficha.getClasse();
        
        classe = classe.toLowerCase();

        switch(classe){

            case "h. de armas":
                dadoVida = DADO_VIDA_HOMEM_DE_ARMAS;
                break;

            case "clerigo":
            case "clérigo":
                dadoVida = DADO_VIDA_CLERIGO;
                break;

            case "ladrao":
            case "ladrão":
                dadoVida = DADO_VIDA_LADRAO;
                break;

            case "mago":
                dadoVida = DADO_VIDA_MAGO;
                break;
            
        }

        dadoVidaMedio = (dadoVida / 2) + 1;

        int pv = dadoVida + bonusCon + ((lvl - 1) * ((dadoVidaMedio) + bonusCon));

        return pv;
    }

}