package toolsforrpg_panpalianos.dominio.utils;

import java.util.Random;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public class RoladorDeDados {

    private final static Random random = new Random();

    public static int executar(int quantDados, int tamanhoDado){ 
        int resultado = 0;
        for(int i = 1; i <= quantDados; i++){
            resultado += (random.nextInt(tamanhoDado) + 1);
        }

        return resultado;
    }

    public static int executarAtributoAleatorio(){
        return executar(3, 6);
    }

    public static int executarIniciativa(Ficha ficha){
        return executar(1, 20) + Calculadora.calcularBonus(ficha.getDestreza());
    }

}