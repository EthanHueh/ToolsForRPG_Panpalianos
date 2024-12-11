package toolsforrpg_panpalianos.dominio.servicos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;


public class GeradorMensagens {
    public static String gerarMensagemFichas(List<Ficha> fichas) {
        String msg = "";
        
        for (Ficha ficha : fichas) {
            msg += ficha.toString();
        }

        return msg;
    }

    public static String gerarMensagemFichasMenu(List<Ficha> fichas) {
        String msg = "";

        for (int i = 0; i < fichas.size(); i++){

            if (fichas.get(i) instanceof FichaJogador){
                msg += i+1 +" - "+ fichas.get(i).getNome()+" (Jogador)\n";
            } else {
                msg += i+1 +" - "+ fichas.get(i).getNome()+" (PDM)\n";
            }
            
        }
        
        msg += (fichas.size() + 1)+" - Sair\n";
       
        return msg;
    }

    public static String gerarMensagemIniciativa() throws Exception {

        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        iniciativas.sort(Comparator.comparing((iniciativa) -> iniciativa.getIniciativa()));
        Collections.reverse(iniciativas);

        String msg = "";
        for (Iniciativa iniciativa: IniciativasRepository.retornarIniciativas()){
            msg += iniciativa.toString()+"\n";
        }
        return msg;

    }

    public static String gerarMensagemIniciativaEnumerada() throws Exception {

        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        String msg = "";
        for (int i = 0; i < iniciativas.size(); i++){
            msg += i + 1 + " - "+ iniciativas.get(i).toString()+"\n";
        }
        
        msg += (iniciativas.size() + 1)+" - Sair\n";
        
        return msg;

    }
}
