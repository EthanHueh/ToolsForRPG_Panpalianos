package toolsforrpg_panpalianos.dominio.utils;

import java.util.Random;

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
        int resultado = 0;
        for(int i = 1; i <= 3; i++){
            resultado += (random.nextInt(6) + 1);
        }
        return resultado;
    }

}