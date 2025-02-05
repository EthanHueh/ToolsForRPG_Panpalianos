package toolsforrpg_panpalianos.dominio.servicos;

import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class ValidadorFicha {

    public static void validar(Ficha ficha) throws Exception {
        validarDadoDeVida(ficha);
        validarAtributosPrincipais(ficha);

        if (ficha instanceof FichaJogador){
            validarFichaJogador((FichaJogador) ficha);
        }
        
    }

    public static void validarFichaJogador(FichaJogador ficha) throws Exception{

        if (ficha.getLvl() == 0){
            throw new Exception("Nível do jogador deve estar entre 0 e 20");
        }
        
        validarEspecializacao(ficha);
    }

    public static void validarEspecializacao(FichaJogador ficha) throws Exception {
        
        Especializacao especializacao = ficha.getEspecializacao();

        if (especializacao == null){
            throw new Exception("Especialização inválida!");
        }

        if (especializacao != Especializacao.NENHUMA && especializacao.getClasse() != ficha.getClasse()){
            throw new Exception("Especialização não condiz com a classe do jogador!");
        }
    
    }

    public static void validarAtributosPrincipais(Ficha ficha) throws Exception {
        validarAtributo(ficha, TipoAtributo.FORCA);
        validarAtributo(ficha, TipoAtributo.DESTREZA);
        validarAtributo(ficha, TipoAtributo.CONSTITUICAO);
        validarAtributo(ficha, TipoAtributo.SABEDORIA);
        validarAtributo(ficha, TipoAtributo.INTELIGENCIA);
        validarAtributo(ficha, TipoAtributo.CARISMA);
    }

    public static void validarAtributo(Ficha ficha, TipoAtributo tipoAtributo) throws Exception {
        
        int atributo = ficha.getAtributoByTipo(tipoAtributo);

        if (atributo < 0 || atributo > 20 && ficha instanceof FichaJogador){
            throw new Exception("Atributo de jogador deve estar entre 1 e 20!");
        }
        
        if (atributo < 0 || atributo > 50 && ficha instanceof FichaCriatura){
            throw new Exception("Atributo de criatura deve estar entre 0 e 50!");
        }

    }
    
    public static void validarDadoDeVida(Ficha ficha) throws Exception{
        
        int quantDVs = ficha.getQuantDVs();

        if (quantDVs < 1 || quantDVs > 9 && ficha instanceof FichaJogador){
            throw new Exception("Jogador deve ter entre 1 e 9 dados de vida!");
        }

        if (quantDVs < 1 || quantDVs > 50 && ficha instanceof FichaCriatura){
            throw new Exception("Criatura deve ter entre 1 e 50 dados de vida!");
        }
        
    }        
    
}
