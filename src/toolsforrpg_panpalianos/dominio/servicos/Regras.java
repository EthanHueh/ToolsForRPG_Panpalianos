package toolsforrpg_panpalianos.dominio.servicos;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Regras {

    //public static int[] PVsAdicionaisPorLvlClerigo = {1,1,2,2,3,3,4,4,5,5,6};
    //public static int[] PVsAdicionaisPorLvlHdeArmas = {2,2,4,4,5,5,6,6,7,7,8};
    //public static int[] PVsAdicionaisPorLvlLadrao = {1,1,2,2,2,3,3,3,4,4,4};
    //public static int[] PVsAdicionaisPorLvlMago = {1,1,1,1,1,2,2,2,2,2,3}
    
    public static int calcularBonus(int atributo){
        return (atributo - 10)/2;
    }

    public static int calcularDVJogador(FichaJogador ficha) {
        if(ficha.getLvl() <= 9){
            return ficha.getLvl();
        } else {
            return 9;
        }
    }
    
    public static int calcularPV(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            FichaCriatura fichaCriatura = (FichaCriatura) ficha;
            int quantDVs = ficha.getQuantDVs();
            int dadoVida = FichaCriatura.DADO_VIDA_MEDIO;
            int bonusCon = calcularBonus(ficha.getConstituicao());
            int pvAdicional = fichaCriatura.getPvsAdicionais();

            return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
        }

        if (ficha instanceof FichaJogador){
            FichaJogador fichaJogador = (FichaJogador) ficha;
            int dadoVida = fichaJogador.getClasse().getDadoVida();
            int bonusCon = calcularBonus(ficha.getConstituicao());
            int lvl = fichaJogador.getLvl();
            int dadoVidaMedio = (dadoVida/2) + 1;

            return ((dadoVida+bonusCon) + ((lvl-1)*((dadoVidaMedio)+bonusCon)));
        }

        return 0;

    }

    public static int calcularPVMaximo(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            FichaCriatura fichaCriatura = (FichaCriatura) ficha;
            int quantDVs = ficha.getQuantDVs();
            int dadoVida = FichaCriatura.DADO_VIDA;
            int bonusCon = calcularBonus(ficha.getConstituicao());
            int pvAdicional = fichaCriatura.getPvsAdicionais();

            return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
        }

        if (ficha instanceof FichaJogador){
            FichaJogador fichaJogador = (FichaJogador) ficha;
            int dadoVida = fichaJogador.getClasse().getDadoVida();
            int bonusCon = calcularBonus(ficha.getConstituicao());
            int lvl = fichaJogador.getLvl();

            return ((dadoVida+bonusCon) + ((lvl-1)*((dadoVida)+bonusCon)));
        }

        return 0;
    }

    public static int calcularSomaAtributos(Ficha f){
        return f.getForca() + f.getDestreza() + f.getConstituicao()
             + f.getInteligencia() + f.getSabedoria() + f.getCarisma();
    }
}