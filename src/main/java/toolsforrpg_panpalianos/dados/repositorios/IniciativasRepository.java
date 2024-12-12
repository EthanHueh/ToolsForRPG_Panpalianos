package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;

public class IniciativasRepository {
    private final static List<Iniciativa> iniciativas = new ArrayList<>();
    
    public static List<Iniciativa> retornarIniciativas() throws Exception {

        if (iniciativas.isEmpty()){
            throw new Exception("Nenhuma iniciativa inserida");
        }

        return iniciativas;
    }

    public static void adicionar(Iniciativa iniciativa) throws Exception{
        checarIniciativaRepetida(iniciativa);
        iniciativas.add(iniciativa);
    }

    public static void atualizar(Iniciativa iniciativa) throws Exception{

        for (Iniciativa i : iniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                i.setIniciativa(iniciativa.getIniciativa());
                return;
            }
        }

        throw new Exception("Iniciativa nao atualizada!");
    }
    
    public static void excluir(Iniciativa iniciativa) throws Exception {
        for (int i = 0; i < iniciativas.size(); i++){
            if (iniciativas.get(i).getFicha() == iniciativa.getFicha()){
                iniciativas.remove(i);
                return;
            }
        }

        throw new Exception("Iniciativa nao excluida!");
    }

    public static void excluir(Ficha ficha) throws Exception {
        for (int i = 0; i < iniciativas.size(); i++){
            if (iniciativas.get(i).getFicha() == ficha){
                iniciativas.remove(i);
                return;
            }
        }

        throw new Exception("Iniciativa nao excluida!");
    }
    
    public static void checarIniciativaRepetida(Iniciativa iniciativa) throws Exception {
        for (Iniciativa i : iniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                throw new Exception("Iniciativa repetida!");
            }
        }
    }

}
