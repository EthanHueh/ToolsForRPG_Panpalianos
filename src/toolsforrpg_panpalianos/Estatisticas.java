package toolsforrpg_panpalianos;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

import toolsforrpg_panpalianos.fichas.FichaCriatura;

//TODO colocar média dos status

public class Estatisticas { 

    public static String executar(List<FichaCriatura> fichas){

        //Neste método, estou usando o comparador para ordenar as lista de fichas de forma crescente.
        //A partir disso, consigo ver, por exemplo, qual personagem tem o maior atributo de força

        String mensagem = "\tEstatísticas\n\n";
        
        TipoAtributo[] tipoAtributos = TipoAtributo.values();
        for (TipoAtributo tipoAtributo : tipoAtributos) {

            ToIntFunction<FichaCriatura> keyExtractor = (ficha) -> ficha.getAtributoByTipo(tipoAtributo);

            fichas.sort(Comparator.comparingInt(keyExtractor));
            mensagem += gerarMensagem(fichas, tipoAtributo);

        }

        return mensagem;

    }

    private static String gerarMensagem(List<FichaCriatura> fichas, TipoAtributo opcao){

        int mediaAtributos = calcularMediaAtributosDaParty(fichas, opcao);

        String msg = opcao.getNome()+": ";
        String msgMenorAtributo = fichas.getFirst().getNome()+": "+fichas.getFirst().getAtributoByTipo(opcao);
        String msgMaiorAtributo = fichas.getLast().getNome()+": "+fichas.getLast().getAtributoByTipo(opcao);
        String msgMedia = "Média da party: "+mediaAtributos+"\n";

        return
            msg+msgMenorAtributo+" / "+msgMaiorAtributo+"\n"+msgMedia+"\n";
  
    }

    private static int calcularMediaAtributosDaParty(List<FichaCriatura> fichas, TipoAtributo opcao) {
        int somaAtributos = 0;
        
        for (FichaCriatura fichaCriatura : fichas) {
            somaAtributos += fichaCriatura.getAtributoByTipo(opcao);
        }

        return (somaAtributos/fichas.size());
    }

}