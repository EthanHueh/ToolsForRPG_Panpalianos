package toolsforrpg_panpalianos.dominio.servicos;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Estatisticas { 

    public static String[][] executar(List<FichaJogador> fichas){

        TipoAtributo[] tipoAtributos = TipoAtributo.values();
        int nLinhas =  tipoAtributos.length;
        int nColunas = fichas.size();

        String[][] mensagem = new String[nLinhas][nColunas];

        for (int i = 0; i < tipoAtributos.length; i++){
            TipoAtributo tipoAtributo = tipoAtributos[i];
            Function<Ficha, Integer> getAtributoDaFicha = (ficha) -> ficha.getAtributoByTipo(tipoAtributo);

            fichas.sort(Comparator.comparing(getAtributoDaFicha));
            mensagem[i] = gerarMensagem(fichas, tipoAtributos[i]);

        }

        return mensagem;

    }

    private static String[] gerarMensagem(List<FichaJogador> fichas, TipoAtributo opcao){

        int mediaAtributos = calcularMediaAtributosDaParty(fichas, opcao);
        String nomeAtributo = opcao.getNome();

        Ficha fichaMenorAtributo = fichas.getFirst();
        Ficha fichaMaiorAtributo = fichas.getLast();

        String[] msg = {
            nomeAtributo,
            fichaMenorAtributo.getNome()+": "+fichaMenorAtributo.getAtributoByTipo(opcao),
            fichaMaiorAtributo.getNome()+": "+fichaMaiorAtributo.getAtributoByTipo(opcao),
            mediaAtributos+"",
        };

        return msg;
            
    }

    private static int calcularMediaAtributosDaParty(List<FichaJogador> fichas, TipoAtributo opcao) {
        int somaAtributos = 0;
        
        for (Ficha fichaCriatura : fichas) {
            somaAtributos += fichaCriatura.getAtributoByTipo(opcao);
        }

        return (somaAtributos/fichas.size());
    }

}