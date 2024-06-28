package toolsforrpg_panpalianos.dados.repositorios;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.LeitorDeArquivosDeFichas;

public class FichasRepository {
    
    private static List<FichaJogador> fichasJogadores = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasDeJogador("recursos\\fichasJogadores.csv");
    private static List<Ficha> fichasAvulsas = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasPadrao("recursos\\fichasAvulsas.csv");
    
    
    public static void adicionar(Ficha ficha){
        fichasAvulsas.add(ficha);
    }

    public static List<FichaJogador> retornarFichasJogadores() {
        return fichasJogadores;
    }

    public static List<Ficha> retornarFichasAvulsas() {
        return fichasAvulsas;
    }
    
}
