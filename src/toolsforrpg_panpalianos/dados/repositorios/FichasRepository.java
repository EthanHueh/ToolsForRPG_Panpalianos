package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.LeitorDeArquivos;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class FichasRepository {
    
    private final static List<Ficha> fichas = new ArrayList<>();
    private final static int LIMITE_FICHAS = 1000;
    
    static {
        fichas.addAll(LeitorDeArquivos.lerArquivoFichasCriatura("recursos\\fichasCriaturas.csv"));
        fichas.addAll(LeitorDeArquivos.lerArquivoFichasJogador("recursos\\fichasJogadores.csv"));
    }
    
    public static void adicionar(Ficha ficha){
        if (fichas.size() == LIMITE_FICHAS){
            return;
        }
        
        fichas.add(ficha);
        
    }
    
    public static List<Ficha> retornarTodasAsFichas(){
        return fichas;
    }

    public static List<FichaCriatura> retornarFichasCriatura() {
        List<FichaCriatura> fichasCriaturas = new ArrayList<>();
        
        for (Ficha f : fichas){
            if (f instanceof FichaCriatura){
                fichasCriaturas.add((FichaCriatura) f);
            }
        }
        
        return fichasCriaturas;
    }
    
    public static List<FichaJogador> retornarFichasJogador() {
        
        List<FichaJogador> fichasJogadores = new ArrayList<>();
        
        for (Ficha f : fichas){
            if (f instanceof FichaJogador){
                fichasJogadores.add((FichaJogador) f);
            }
        }
        
        return fichasJogadores;
    }
    
    public static Ficha retornarFichaAleatoria(){
        int resultado = RoladorDeDados.executar(1, fichas.size() - 1);
        return retornarTodasAsFichas().get(resultado);
    }

    
    public static void excluir(Ficha ficha) {
        for (int i = 0; i < fichas.size(); i++){
            if (fichas.get(i) == ficha){
                fichas.remove(i);
                break;
            }
        }
    }
    
    public static boolean isVazio() {
        return fichas.isEmpty();
    }
    
}