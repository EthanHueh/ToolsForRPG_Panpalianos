package toolsforrpg_panpalianos.controller;

import java.util.List;

import toolsforrpg_panpalianos.repository.IniciativasRepository;

public class ControllerIniciativas {

    public static List<Integer> getListaIniciativas() {
       return IniciativasRepository.getListaIniciativas();
    }

    public static void adicionar(int iniciativa) {
        IniciativasRepository.adicionar(iniciativa);
    }

    
}
