package toolsforrpg_panpalianos.controller;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.repository.FichasRepository;
import toolsforrpg_panpalianos.repository.IniciativasRepository;
import toolsforrpg_panpalianos.view.menus.MenuIniciativa;

public class ControllerIniciativas {

    public static List<Integer> getListaIniciativas() {
       return IniciativasRepository.getListaIniciativas();
    }

    public static void gerarIniciativas() {
        List<FichaCriatura> fichas = new ArrayList<>();
        fichas.addAll(FichasRepository.getFichasJogadores());
        fichas.addAll(FichasRepository.getFichasAvulsas());

        for (FichaCriatura ficha : fichas) {
            int iniciativa = MenuIniciativa.inserirIniciativa(ficha);
            IniciativasRepository.adicionar(iniciativa);
        }
    }

    
}
