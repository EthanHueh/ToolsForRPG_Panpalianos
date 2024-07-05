package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.LeitorDeArquivosDeFichas;

public class FichasRepository {
    
    private final static List<FichaJogador> fichasJogadores = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasDeJogador("recursos\\fichasJogadores.csv");
    private final static List<Ficha> fichasAvulsas = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasPadrao("recursos\\fichasAvulsas.csv");
    
    public static void adicionar(Ficha ficha){
        fichasAvulsas.add(ficha);
    }

    public static List<FichaJogador> retornarFichasJogadores() {
        return fichasJogadores;
    }

    public static List<Ficha> retornarFichasAvulsas() {
        return fichasAvulsas;
    }

    public static List<Ficha> retornarTodasAsFichas() {
        
        List<Ficha> fichas = new ArrayList<>();
        fichas.addAll(fichasJogadores);
        fichas.addAll(fichasAvulsas);

        return fichas;

    }
    
    public static void excluir(Ficha ficha) {
         
        for (int i = 0; i < fichasAvulsas.size(); i++){
            if (fichasAvulsas.get(i) == ficha){
                fichasAvulsas.remove(i);
            }
        }

        for (int i = 0; i < fichasJogadores.size(); i++){
            if (fichasJogadores.get(i) == ficha){
                fichasJogadores.remove(i);
            }
        }
    }

    public static boolean isVazio() {
        return FichasRepository.fichasAvulsas.isEmpty() && FichasRepository.fichasJogadores.isEmpty();
    }
    
}
