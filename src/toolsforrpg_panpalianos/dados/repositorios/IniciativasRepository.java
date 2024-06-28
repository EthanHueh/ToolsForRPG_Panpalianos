package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

public class IniciativasRepository {
    private static List<Integer> listaIniciativas = new ArrayList<Integer>();

    public static void adicionar(int iniciativa){
        listaIniciativas.add(iniciativa);
    }

    public static List<Integer> getListaIniciativas() {
        return listaIniciativas;
    }

    public static void setListaIniciativas(List<Integer> listaIniciativas) {
        IniciativasRepository.listaIniciativas = listaIniciativas;
    }


}
