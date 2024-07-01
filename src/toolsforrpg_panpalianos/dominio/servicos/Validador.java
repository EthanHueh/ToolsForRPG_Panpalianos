package toolsforrpg_panpalianos.dominio.servicos;

import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Validador {
    public static boolean validarEspecializacao(FichaJogador ficha){
        if (ficha.getEspecializacao() == null){
            return true;
        }

        if (ficha.getClasse() == ficha.getEspecializacao().getClasse()){
            return true;
        } else {
            return false;
        }
    }
}
