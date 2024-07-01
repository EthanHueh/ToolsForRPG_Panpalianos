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
        if(ficha.getLvl() <= 9){
            return ficha.getLvl();
        } else {
            return 9;
        }
    }
    
    public static int calcularPV(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            return calcularPVCriatura(ficha);
            
        }

        if (ficha instanceof FichaJogador){
            return calcularPVJogador(ficha);
            
        }

        return 0;

    }

    private static int calcularPVJogador(Ficha ficha) {
        FichaJogador fichaJogador = (FichaJogador) ficha;
        int dadoVida = fichaJogador.getClasse().getDadoVida();
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int lvl = fichaJogador.getLvl();
        int dadoVidaMedio = (dadoVida/2) + 1;

        return (dadoVida+bonusCon) + (lvl-1)*(dadoVidaMedio+bonusCon) + calcularPVsAdicionais(fichaJogador);
    }

    private static int calcularPVCriatura(Ficha ficha) {
        FichaCriatura fichaCriatura = (FichaCriatura) ficha;
        int quantDVs = ficha.getQuantDVs();
        int dadoVida = FichaCriatura.DADO_VIDA_MEDIO;
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int pvAdicional = fichaCriatura.getPvsAdicionais();

        return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
    }

    public static int calcularPVMaximo(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            return calcularPVMaximoCriatura(ficha);
        }

        if (ficha instanceof FichaJogador){
            return calcularPVMaximoJogador(ficha);
        }

        return 0;
    }

    private static int calcularPVMaximoJogador(Ficha ficha) {
        FichaJogador fichaJogador = (FichaJogador) ficha;
        int dadoVida = fichaJogador.getClasse().getDadoVida();
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int lvl = fichaJogador.getLvl();

        return (dadoVida+bonusCon) + (lvl-1)*(dadoVida+bonusCon) + calcularPVsAdicionais(fichaJogador);
    }

    private static int calcularPVMaximoCriatura(Ficha ficha) {
        FichaCriatura fichaCriatura = (FichaCriatura) ficha;
        int quantDVs = ficha.getQuantDVs();
        int dadoVida = FichaCriatura.DADO_VIDA;
        int bonusCon = calcularBonus(ficha.getConstituicao());
        int pvAdicional = fichaCriatura.getPvsAdicionais();

        return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
    }

    public static int calcularSomaAtributos(Ficha f){
        return f.getForca() + f.getDestreza() + f.getConstituicao()
             + f.getInteligencia() + f.getSabedoria() + f.getCarisma();
    }

    public static int calcularPVsAdicionais(FichaJogador ficha){

        List<Integer> PVsAdicionais = TabelaClasses.retornarPVsAdicionais(ficha);

        int soma = 0;
        for (int i = 0; i < ficha.getLvl(); i++){
            soma += PVsAdicionais.get(i);
        }

        System.out.println("Soma do "+ficha.getNome()+soma);

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

    public static int calcularBaseAtaque(FichaJogador fichaJogador) {

        int baseAtaque = 0;
        String valorColuna = String.valueOf(TabelaClasses.getBaseAtaque(fichaJogador));
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