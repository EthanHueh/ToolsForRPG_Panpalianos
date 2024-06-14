package toolsforrpg_panpalianos.controller;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.repository.FichasRepository;

public class ControllerFichas {

    public static void cadastrarFicha(FichaCriatura ficha) {
        FichasRepository.adicionar(ficha);
    }

    public static List<FichaCriatura> getFichasJogadores(){
        return new ArrayList<FichaCriatura>(FichasRepository.getFichasJogadores());
    }

    public static List<FichaCriatura> getFichasAvulsas(){
        return FichasRepository.getFichasAvulsas();
    }

    
}
