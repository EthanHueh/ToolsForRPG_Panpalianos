package toolsforrpg_panpalianos.repository;

import java.util.List;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;
import toolsforrpg_panpalianos.utils.LeitorDeArquivosDeFichas;

public class FichasRepository {
    
    private static List<FichaJogador> fichasJogadores = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasDeJogador("recursos\\fichasJogadores.csv");
    private static List<FichaCriatura> fichasAvulsas = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasPadrao("recursos\\fichasAvulsas.csv");
    
    
    public static void adicionar(FichaCriatura ficha){
        fichasAvulsas.add(ficha);
    }

    public static void adicionar(FichaJogador ficha){
        fichasJogadores.add(ficha);
    }

    public static List<FichaCriatura> getFichasAvulsas() {
        return fichasAvulsas;
    }

    public static void setFichasAvulsas(List<FichaCriatura> fichasAvulsas) {
        FichasRepository.fichasAvulsas = fichasAvulsas;
    }

    public static List<FichaJogador> getFichasJogadores() {
        return fichasJogadores;
    }

    public static void setFichasJogadores(List<FichaJogador> fichasJogadores) {
        FichasRepository.fichasJogadores = fichasJogadores;
    }
        
    
}
