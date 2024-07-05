package toolsforrpg_panpalianos.dominio.servicos;

import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Validador {
    public static boolean validarEspecializacao(FichaJogador ficha){
        
        Especializacao especializacao = ficha.getEspecializacao();
        if (especializacao == null || especializacao == Especializacao.NENHUMA){
            return true;
        }
        
        return ficha.getClasse() == especializacao.getClasse();
    }

    public static boolean validarAtributo(int atributo) {
        return atributo >= 0 && atributo <= 50;
    }
    
    public static boolean validarDadoDeVida(Ficha ficha){
        
        int quantDVs = ficha.getQuantDVs();
        
        if (ficha instanceof FichaCriatura){
            return quantDVs >= 0 && quantDVs <= 50;
        }
        
        if (ficha instanceof FichaJogador){
            return quantDVs >= 0 && quantDVs <= 9;
        }
        
        return false;
        
    }
    
}
