package toolsforrpg_panpalianos.repository;

import java.util.List;

import toolsforrpg_panpalianos.service.GeradorDeIniciativa;

public class IniciativasRepository {
    private static List<Integer> listaIniciativas = GeradorDeIniciativa.executar();

    public static List<Integer> getListaIniciativas() {
        return listaIniciativas;
    }

    public static void setListaIniciativas(List<Integer> listaIniciativas) {
        IniciativasRepository.listaIniciativas = listaIniciativas;
    }


}
