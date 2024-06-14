package toolsforrpg_panpalianos.view.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerFichas;
import toolsforrpg_panpalianos.controller.ControllerIniciativas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;

public class IniciativasView {

    public static void mostrarListaIniciativas() {

        if(ControllerIniciativas.getListaIniciativas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma iniciativa inserida!", "Iniciativas", 0);
            return;
        }

        String msgJogador = "Iniciativas do jogador\n";
        String msgCriatura = "Outras iniciativas\n";
        
        List<FichaCriatura> fichas = new ArrayList<FichaCriatura>();
        fichas.addAll(ControllerFichas.getFichasJogadores());
        fichas.addAll(ControllerFichas.getFichasAvulsas());

        for (FichaCriatura ficha : fichas) {

            String msg = gerarMensagem(ficha, fichas.indexOf(ficha));

            if (ficha instanceof FichaJogador){
                msgJogador += msg;
            } else {
                msgCriatura += msg;
            }
        }

        String msgFinal = msgJogador+"\n\n"+msgCriatura;

        new TelaJTextArea(msgFinal, "Iniciativas");
    }

    private static String gerarMensagem(FichaCriatura ficha, int i) {

        try {
            return ficha.getNome()+": "+ControllerIniciativas.getListaIniciativas().get(i)+"\n";
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }
}