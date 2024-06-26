package toolsforrpg_panpalianos.service;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;

public class Regras {

    public final static int DADO_VIDA_CRIATURA = 5;
    public final static int DADO_VIDA_CRIATURA_MAXIMO = 8;

    public final static int DADO_VIDA_HOMEM_DE_ARMAS = 10;
    public final static int DADO_VIDA_CLERIGO = 8;
    public final static int DADO_VIDA_LADRAO = 6;
    public final static int DADO_VIDA_MAGO = 4;

    //public static int[] PVsAdicionaisPorLvlClerigo = {1,1,2,2,3,3,4,4,5,5,6};
    //public static int[] PVsAdicionaisPorLvlHdeArmas = {2,2,4,4,5,5,6,6,7,7,8};
    //public static int[] PVsAdicionaisPorLvlLadrao = {1,1,2,2,2,3,3,3,4,4,4};
    //public static int[] PVsAdicionaisPorLvlMago = {1,1,1,1,1,2,2,2,2,2,3}
    
    public static int calcularBonus(int atributo){
        return (atributo - 10)/2;
    }

    public static int calcularSomaAtributos(FichaCriatura f) {
        return  f.getForca() + f.getDestreza() + f.getConstituicao() +
                f.getInteligencia() + f.getSabedoria() + f.getCarisma();
    }

    public static int calcularDVJogador(FichaJogador ficha) {
        
        if(ficha.getLvl() <= 9){
            return ficha.getLvl();
        } else {
            return 9;
        }
        
    }
    
    public static int calcularPV(FichaCriatura ficha){

        if(!(ficha instanceof FichaJogador)){

            int quantDVs = ficha.getQuantDVs();
            int dadoVida = Regras.DADO_VIDA_CRIATURA;
            int bonusCon = calcularBonus(ficha.getConstituicao());
            int pvAdicional = ficha.getPvAdicional();

            return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
        }

        FichaJogador fichaJogador = null;

        try {
            fichaJogador = (FichaJogador) ficha;
        } catch (Exception e) {
            System.out.println("Não é uma ficha de jogador");
        }

        String classe = fichaJogador.getClasse().toLowerCase();

        int dadoVida = 0;
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
        
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int lvl = fichaJogador.getLvl();
        int dadoVidaMedio = (dadoVida/2) + 1;

        return ((dadoVida+bonusCon) + ((lvl-1)*((dadoVidaMedio)+bonusCon)));

    }

    public static int calcularPVMaximo(FichaCriatura ficha){

        int quantDVs = ficha.getQuantDVs();
        int dadoVida = Regras.DADO_VIDA_CRIATURA_MAXIMO;
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int pvAdicional = ficha.getPvAdicional();

        return (quantDVs*(dadoVida+bonusCon)+pvAdicional);
    }

}