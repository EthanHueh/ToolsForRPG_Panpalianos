package toolsforrpg_panpalianos.dominio.servicos;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class InicializadorFicha {
    
    public static Ficha inicializar(Ficha ficha){

        if (ficha instanceof FichaJogador){
            FichaJogador f = (FichaJogador) ficha;

            if (f.getLvl() == 0){
                f.setLvl(1);
            }

            if (f.getClasse() == null){
                f.setClasse(Classe.NENHUMA);
            }
            if (Validador.validarEspecializacao(f) == false){
                f.setEspecializacao(Especializacao.NENHUMA);
            }
        }
        
        if (Validador.validarDadoDeVida(ficha) == false && ficha instanceof FichaCriatura){
            FichaCriatura f = (FichaCriatura) ficha;
            f.setQuantDVs(5);
        }
       
        if (ficha.getEquipamento() == null){
            ficha.setEquipamento(new Equipamento());
        }

        if (ficha.getRaca() == null){
            ficha.setRaca(Raca.INDEFINIDO);
        }

        ficha.setQuantPVsAtual(Calculadora.calcularPV(ficha));

        return ficha;
        
    }
}
