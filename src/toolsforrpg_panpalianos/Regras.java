package toolsforrpg_panpalianos;

public class Regras {

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
        int lvl = ficha.getLvl();
        String classe = ficha.getClasse();
        int pvAdicional = ficha.getPvAdicional();

        boolean ehMonstro = (classe == null);

        if(ehMonstro){
            int dadoVida = 8;
            int dadoVidaMedio = (dadoVida/2) + 1;

            int bonusCon = calcularBonus(constituicao);
            
            return ((lvl*(dadoVidaMedio+bonusCon)+pvAdicional))+"/"+((lvl*(dadoVida+bonusCon))+pvAdicional);
        }

        int dadoVida = 0;
        int dadoVidaMedio = 0;

        int bonusCon = calcularBonus(constituicao);
        
        classe = classe.toLowerCase();

        switch(classe){

            case "h. de armas":
                dadoVida = 10;
                break;

            case "clerigo":
            case "clérigo":
                dadoVida = 8;
                break;

            case "ladrao":
            case "ladrão":
                dadoVida = 6;
                break;

            case "mago":
                dadoVida = 4;
                break;

            default:
                dadoVida = 8;
                dadoVidaMedio = (dadoVida/2) + 1;
            
                return lvl*(dadoVidaMedio+bonusCon)+"/"+lvl*(dadoVida+bonusCon);
            
        }

        dadoVidaMedio = (dadoVida / 2) + 1;

        int pv = dadoVida + bonusCon + ((lvl - 1) * ((dadoVidaMedio) + bonusCon));

        return String.valueOf(pv);

    }

    public static int calcularSomaAtributos(FichaCriatura f) {
        return  f.getForca() + f.getDestreza() + f.getConstituicao() +
                f.getInteligencia() + f.getSabedoria() + f.getCarisma();
    }

}