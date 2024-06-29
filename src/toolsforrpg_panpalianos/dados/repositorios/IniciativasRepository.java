package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;

public class IniciativasRepository {
    private static List<Iniciativa> listaIniciativas = new ArrayList<>();

    public static void inserirIniciativa(Iniciativa iniciativa){

        if (houverFichasRepetidas(iniciativa)){
            return;
        }

        listaIniciativas.add(iniciativa);
    }

    public static void atualizarIniciativa(Iniciativa iniciativa){

        for (Iniciativa i : listaIniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                i.setIniciativa(iniciativa.getIniciativa());
            }
        }
    }

    public static boolean houverFichasRepetidas(Iniciativa iniciativa) {
        for (Iniciativa i : listaIniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                return true;
            }
        }
        return false;
    }

    public static List<Iniciativa> retornarIniciativas() {
        return listaIniciativas;
    }

    public static void excluirIniciativa(Iniciativa iniciativa) {
        for (int i = 0; i < listaIniciativas.size(); i++){
            if (listaIniciativas.get(i).getFicha() == iniciativa.getFicha()){
                listaIniciativas.remove(i);
            }
        }
    }


}
