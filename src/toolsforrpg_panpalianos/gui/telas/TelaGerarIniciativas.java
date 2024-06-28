package toolsforrpg_panpalianos.gui.telas;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaGerarIniciativas {
    public TelaGerarIniciativas(){
        List<Ficha> fichas = new ArrayList<>();
        fichas.addAll(FichasRepository.retornarFichasJogadores());
        fichas.addAll(FichasRepository.retornarFichasAvulsas());

        for (Ficha ficha : fichas) {
            int iniciativa = ValidadorDeInputs.consistirInteiro("Insira a iniciativa do(a) "+ficha.getNome());
            IniciativasRepository.adicionar(iniciativa);
        }
    }
}
