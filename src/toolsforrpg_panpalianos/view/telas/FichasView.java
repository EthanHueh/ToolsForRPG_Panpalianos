package toolsforrpg_panpalianos.view.telas;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.controller.ControllerFichas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;

public class FichasView {

    public static void mostrarFichas() {
        new TelaJTextArea(gerarMensagemFichas(ControllerFichas.getFichasAvulsas()), "Fichas");
    }

    public static void mostrarFichasDeJogador() {
        new TelaJTextArea(gerarMensagemFichas(new ArrayList<FichaCriatura>(ControllerFichas.getFichasJogadores())), "Fichas");
    }

    private static String gerarMensagemFichas(List<FichaCriatura> fichas) {
        String msg = "";
        
        for (FichaCriatura ficha : fichas) {
            msg += ficha;
        }

        return msg;
    }
}