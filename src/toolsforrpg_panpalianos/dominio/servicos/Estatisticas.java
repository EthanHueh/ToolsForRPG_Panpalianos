package toolsforrpg_panpalianos.dominio.servicos;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Estatisticas { 

    public static String executar(List<FichaJogador> fichas){

        String mensagem = "\tEstatísticas\n\n";
        
        //Para cada tipo de atributo, gerar uma mensagem baseado na lista de fichas
        //Ex.: Para o tipo de atributo força, descobrir quem tem a menor força, e quem tem a maior
        TipoAtributo[] tipoAtributos = TipoAtributo.values();
        for (TipoAtributo tipoAtributo : tipoAtributos) {

            Function<Ficha, Integer> getAtributoDaFicha = (ficha) -> ficha.getAtributoByTipo(tipoAtributo);

            fichas.sort(Comparator.comparing(getAtributoDaFicha));
            mensagem += gerarMensagem(fichas, tipoAtributo);

        }

        return mensagem;

    }

    private static String gerarMensagem(List<FichaJogador> fichas, TipoAtributo opcao){

        int mediaAtributos = calcularMediaAtributosDaParty(fichas, opcao);

        String msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getAtributoByTipo(opcao);
        String msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getAtributoByTipo(opcao);
        String msgMedia = "Média da party: "+mediaAtributos+"\n";

        return
            opcao.getNome()+":"+msgMenorAtributo+" / "+msgMaiorAtributo+"\n"+msgMedia+"\n";
  
    }

    private static int calcularMediaAtributosDaParty(List<FichaJogador> fichas, TipoAtributo opcao) {
        int somaAtributos = 0;
        
        for (Ficha fichaCriatura : fichas) {
            somaAtributos += fichaCriatura.getAtributoByTipo(opcao);
        }

        return (somaAtributos/fichas.size());
    }

}