package toolsforrpg_panpalianos.dominio.servicos;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;

public class Estatisticas { 

    public static String[][] executar() throws Exception{
        
        List<Ficha> fichas = FichasRepository.getInstance().retornarTodasAsFichas();

        TipoAtributo[] tipoAtributos = TipoAtributo.values();
        String[][] mensagem = new String[tipoAtributos.length][4];

        for (int i = 0; i < tipoAtributos.length; i++){
            TipoAtributo atributoAtual = tipoAtributos[i];
            Function<Ficha, Integer> getAtributoDaFicha = (ficha) -> ficha.getAtributoByTipo(atributoAtual);
            fichas.sort(Comparator.comparing(getAtributoDaFicha));
            
            mensagem[i] = gerarMensagem(fichas, tipoAtributos[i]);
        }

        return mensagem;

    }

    private static String[] gerarMensagem(List<Ficha> fichas, TipoAtributo opcao){

        return new String[] {
            opcao.getNome(),
            fichas.getFirst().getNome()+": "+fichas.getFirst().getAtributoByTipo(opcao),
            fichas.getLast().getNome()+": "+fichas.getLast().getAtributoByTipo(opcao),
            calcularMediaAtributos(fichas, opcao)+"",
        };
            
    }

    private static int calcularMediaAtributos(List<Ficha> fichas, TipoAtributo opcao) {
        return (int) fichas.stream().
            mapToDouble(f -> f.getAtributoByTipo(opcao)).
            average().orElse(0.0);
    }
    
}