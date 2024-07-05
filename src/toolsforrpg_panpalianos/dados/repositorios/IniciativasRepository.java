package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;

public class IniciativasRepository {
    private final static List<Iniciativa> iniciativas = new ArrayList<>();
    
    public static List<Iniciativa> retornarIniciativas() {
        return iniciativas;
    }

    public static void adicionar(Iniciativa iniciativa){

        if (hasIniciativasRepetidas(iniciativa)){
            return;
        }

        iniciativas.add(iniciativa);
    }

    public static void atualizar(Iniciativa iniciativa){

        for (Iniciativa i : iniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                i.setIniciativa(iniciativa.getIniciativa());
            }
        }
    }
    
    public static void excluir(Iniciativa iniciativa) {
        for (int i = 0; i < iniciativas.size(); i++){
            if (iniciativas.get(i).getFicha() == iniciativa.getFicha()){
                iniciativas.remove(i);
            }
        }
    }
    
    public static boolean isVazio(){
        return iniciativas.isEmpty();
    }

    public static boolean hasIniciativasRepetidas(Iniciativa iniciativa) {
        for (Iniciativa i : iniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                return true;
            }
        }
        return false;
    }

}
