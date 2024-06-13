package toolsforrpg_panpalianos.view.telas;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.repository.FichasRepository;

public class FichasView {

    public static void mostrarFichas() {
        new TelaJTextArea(gerarMensagemFichas(FichasRepository.getFichasAvulsas()), "Fichas");
    }

    public static void mostrarFichasDeJogador() {
        List<FichaCriatura> fichas = new ArrayList<FichaCriatura>();

        fichas.addAll(FichasRepository.getFichasJogadores());
        
        new TelaJTextArea(gerarMensagemFichas(fichas), "Fichas");
    }

    private static String gerarMensagemFichas(List<FichaCriatura> fichas) {
        String msg = null;
        
        for (FichaCriatura ficha : FichasRepository.getFichasJogadores()) {
            msg += ficha;
        }

        return msg;
    }
}