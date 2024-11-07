package toolsforrpg_panpalianos.dominio.servicos;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.TabelaClasses;
import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

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
            FichaCriatura fichaCriatura = (FichaCriatura) ficha;
            int dadoVida = FichaCriatura.DADO_VIDA_MEDIO;
            int quantDVs = fichaCriatura.getQuantDVs();
            int bonusCon = calcularBonus(fichaCriatura.getConstituicao());
            int pvAdicional = fichaCriatura.getPvsAdicionais();

            return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
        }

        if (ficha instanceof FichaJogador){
            FichaJogador fichaJogador = (FichaJogador) ficha;
            int dadoVida = fichaJogador.getClasse().getDadoVida();
            int dadoVidaMedio = fichaJogador.getClasse().getDadoVidaMedio();
            int lvl = fichaJogador.getLvl();
            int bonusCon = calcularBonus(fichaJogador.getConstituicao());

            return (dadoVida+bonusCon) + (lvl-1)*(dadoVidaMedio+bonusCon) + calcularPVsAdicionais(fichaJogador);
        }

        return 0;
    }

    public static int calcularPVMaximo(Ficha ficha){

        if(ficha instanceof FichaCriatura){
            FichaCriatura fichaCriatura = (FichaCriatura) ficha;
            int dadoVida = FichaCriatura.DADO_VIDA;
            int quantDVs = fichaCriatura.getQuantDVs();
            int bonusCon = calcularBonus(ficha.getConstituicao());
            int pvAdicional = fichaCriatura.getPvsAdicionais();

            return (quantDVs*(dadoVida+bonusCon) + pvAdicional);
        }

        if (ficha instanceof FichaJogador){
            FichaJogador fichaJogador = (FichaJogador) ficha;
            int dadoVida = fichaJogador.getClasse().getDadoVida();
            int lvl = fichaJogador.getLvl();
            int bonusCon = calcularBonus(fichaJogador.getConstituicao());

            return (dadoVida+bonusCon) + (lvl-1)*(dadoVida+bonusCon) + calcularPVsAdicionais(fichaJogador);
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

    public static int calcularSomaAtributos(Ficha f) {
        return f.getForca() + f.getDestreza() + f.getConstituicao() +
               f.getInteligencia() + f.getInteligencia() + f.getCarisma();
    }

    public static int calcularMovimento(FichaJogador f) {
        return f.getRaca().getMovimento() + f.getEquipamento().getArmadura().getReducaoMov();
    }
    
    public static int calcularResultadoTeste(Ficha f, TipoAtributo t){
        int resultadoDado = RoladorDeDados.executar(1, 20);
        int bonus = Calculadora.calcularBonus(f.getAtributoByTipo(t));
        
        return resultadoDado + bonus;
    }
    
    public static int calcularDano(Ficha f){
        return RoladorDeDados.executar(1, f.getEquipamento().getArma().getDadoDano()) + Calculadora.calcularBonus(f.getForca());
    }

}