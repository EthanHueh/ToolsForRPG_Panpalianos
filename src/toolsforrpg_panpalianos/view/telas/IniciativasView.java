package toolsforrpg_panpalianos.view.telas;

import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;
import toolsforrpg_panpalianos.repository.FichasRepository;
import toolsforrpg_panpalianos.repository.IniciativasRepository;

public class IniciativasView {

    public static void mostrarListaIniciativas() {
        List<Integer> listaIniciativas = IniciativasRepository.getListaIniciativas();

        if(listaIniciativas == null){
            JOptionPane.showMessageDialog(null, "Nenhuma iniciativa inserida!", "Iniciativas", 0);
            return;
        }

        List<FichaCriatura> fichasAvulsas = FichasRepository.getFichasAvulsas();
        List<FichaJogador> fichasJogadores = FichasRepository.getFichasJogadores();
    

        String msgIniciativas = "Iniciativas dos jogadores:";
        for(int i = 0; i < fichasJogadores.size(); i++){
            msgIniciativas += fichasJogadores.get(i).getNome()+": "+listaIniciativas.get(i)+"\n";
        }

        msgIniciativas += "\nIniciativa:\n";
        for(int i = 0; i < fichasAvulsas.size(); i++){
            msgIniciativas += fichasAvulsas.get(i).getNome()+": "+listaIniciativas.get(i + fichasJogadores.size())+"\n";
        }

        new TelaJTextArea(msgIniciativas, "Iniciativas");
    }
}