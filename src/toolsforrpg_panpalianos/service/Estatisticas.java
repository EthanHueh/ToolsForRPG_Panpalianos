package toolsforrpg_panpalianos.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import toolsforrpg_panpalianos.model.enums.TipoAtributo;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;

public class Estatisticas { 

    public static String executar(List<FichaJogador> fichas){

        String mensagem = "\tEstatísticas\n\n";
        
        //Para cada tipo de atributo, gerar uma mensagem baseado na lista de fichas
        //Ex.: Para o tipo de atributo força, descobrir quem tem a menor força, e quem tem a maior
        TipoAtributo[] tipoAtributos = TipoAtributo.values();
        for (TipoAtributo tipoAtributo : tipoAtributos) {

            Function<FichaCriatura, Integer> getAtributoDaFicha = (ficha) -> ficha.getAtributoByTipo(tipoAtributo);

            fichas.sort(Comparator.comparing(getAtributoDaFicha));
            mensagem += gerarMensagem(fichas, tipoAtributo);

        }

        return mensagem;

    }

    private static String gerarMensagem(List<FichaJogador> fichas, TipoAtributo opcao){

        int mediaAtributos = calcularMediaAtributosDaParty(fichas, opcao);

        String msg = opcao.getNome()+": ";
        String msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getAtributoByTipo(opcao);
        String msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getAtributoByTipo(opcao);
        String msgMedia = "Média da party: "+mediaAtributos+"\n";

        return
            msg+msgMenorAtributo+" / "+msgMaiorAtributo+"\n"+msgMedia+"\n";
  
    }

    private static int calcularMediaAtributosDaParty(List<FichaJogador> fichas, TipoAtributo opcao) {
        int somaAtributos = 0;
        
        for (FichaCriatura fichaCriatura : fichas) {
            somaAtributos += fichaCriatura.getAtributoByTipo(opcao);
        }

        return (somaAtributos/fichas.size());
    }

}