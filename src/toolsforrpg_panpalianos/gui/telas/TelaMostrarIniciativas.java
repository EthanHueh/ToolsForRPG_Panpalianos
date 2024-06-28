package toolsforrpg_panpalianos.gui.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;

public class TelaMostrarIniciativas {

    public static void mostrarListaIniciativas() {

        if(IniciativasRepository.getListaIniciativas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma iniciativa inserida!", "Iniciativas", 0);
            return;
        }

        String msgJogador = "Iniciativas do jogador\n";
        String msgCriatura = "Outras iniciativas\n";
        
        List<Ficha> fichas = new ArrayList<Ficha>();
        fichas.addAll(FichasRepository.retornarFichasJogadores());
        fichas.addAll(FichasRepository.retornarFichasAvulsas());

        for (Ficha ficha : fichas) {

            String msg = gerarMensagem(ficha, fichas.indexOf(ficha));

            if (ficha instanceof FichaJogador){
                msgJogador += msg;
            } else {
                msgCriatura += msg;
            }
        }

        String msgFinal = msgJogador+"\n\n"+msgCriatura;

        new TelaTexto(msgFinal, "Iniciativas");
    }

    private static String gerarMensagem(Ficha ficha, int i) {

        try {
            return ficha.getNome()+": "+IniciativasRepository.getListaIniciativas().get(i)+"\n";
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }
}