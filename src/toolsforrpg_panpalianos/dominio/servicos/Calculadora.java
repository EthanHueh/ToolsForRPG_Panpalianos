package toolsforrpg_panpalianos.dominio.servicos;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Calculadora {

    public static int calcularBonus(int atributo){
        return (atributo - 10)/2;
    }

    public static int calcularDVJogador(FichaJogador ficha) {
        if(ficha.getLvl() < 10){
            return ficha.getLvl();
        } else {
            return 9;
        }
    }

    public static int calcularPV(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            return calcularPVCriatura((FichaCriatura) ficha);
        }

        if (ficha instanceof FichaJogador){
            return calcularPVJogador((FichaJogador) ficha);      
        }

        return 0;
    }

    public static int calcularPVMaximo(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            return calcularPVMaximoCriatura((FichaCriatura) ficha);
        }

        if (ficha instanceof FichaJogador){
            return calcularPVMaximoJogador((FichaJogador) ficha);
        }

        return 0;
    }

    public static int calcularPVsAdicionais(FichaJogador ficha){

        List<Integer> PVsAdicionais = TabelaClasses.retornarPVsAdicionais(ficha);

        int soma = 0;
        for (int i = 0; i < ficha.getLvl(); i++){
            soma += PVsAdicionais.get(i);
        }
        return soma;

    }

    public static int calcularClasseArmadura(FichaJogador f) {

        int bonDestreza = calcularBonus(f.getDestreza());
        int bonMaxDestreza = f.getEquipamento().getArmadura().getBonMaxDestreza();

        if (bonDestreza > bonMaxDestreza){
            bonDestreza = bonMaxDestreza;
        }

        return 10 + bonDestreza + f.getEquipamento().getBonusDefesa();
    }

    private static int calcularPVJogador(FichaJogador ficha) {
        int dadoVida = ficha.getClasse().getDadoVida();
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int lvl = ficha.getLvl();
        int dadoVidaMedio = ficha.getClasse().getDadoVidaMedio();

        return (dadoVida+bonusCon) + (lvl-1)*(dadoVidaMedio+bonusCon) + calcularPVsAdicionais(ficha);
    }

    private static int calcularPVCriatura(FichaCriatura ficha) {
        int dadoVida = FichaCriatura.DADO_VIDA_MEDIO;
        int quantDVs = ficha.getQuantDVs();
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int pvAdicional = ficha.getPvsAdicionais();

        return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
    }

    private static int calcularPVMaximoCriatura(FichaCriatura ficha) {
        int quantDVs = ficha.getQuantDVs();
        int dadoVida = FichaCriatura.DADO_VIDA;
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int pvAdicional = ficha.getPvsAdicionais();

        return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
    }

    private static int calcularPVMaximoJogador(FichaJogador ficha) {
        int dadoVida = ficha.getClasse().getDadoVida();
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int lvl = ficha.getLvl();

        return (dadoVida+bonusCon) + (lvl-1)*(dadoVida+bonusCon) + calcularPVsAdicionais(ficha);
    }

}