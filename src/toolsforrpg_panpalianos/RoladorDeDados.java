package toolsforrpg_panpalianos;

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

}