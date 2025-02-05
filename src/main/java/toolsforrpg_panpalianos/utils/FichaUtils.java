package toolsforrpg_panpalianos.utils;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public class FichaUtils {

    public static void encherMaximoVida(Ficha ficha) {
       ficha.setQuantPVsAtual(Calculadora.calcularPV(ficha));
    }

}
