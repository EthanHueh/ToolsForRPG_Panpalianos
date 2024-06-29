package toolsforrpg_panpalianos.gui.telas;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaAtualizarIniciativa {
    
    public TelaAtualizarIniciativa(){
        List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

        int opcao = ValidadorDeInputs.consistirInteiro(gerarMensagemFichas(fichas)+"\nQuem voce deseja atualizar a iniciativa?");

        if (opcao > 0 && opcao <= fichas.size()){
            Ficha ficha = fichas.get(opcao - 1);
            int valorIniciativa = ValidadorDeInputs.consistirInteiro("Insira a iniciativa de "+ficha.getNome());
            Iniciativa iniciativa = new Iniciativa(valorIniciativa, ficha);
            
            IniciativasRepository.atualizarIniciativa(iniciativa);
        }
    }

    private String gerarMensagemFichas(List<Ficha> fichas) {
        String msg = "";

        for (int i = 0; i < fichas.size(); i++){

            if (fichas.get(i) instanceof FichaJogador){
                msg += i+1 +" - "+ fichas.get(i).getNome()+" (Jogador)\n";
            } else {
                msg += i+1 +" - "+ fichas.get(i).getNome()+" (PDM)\n";
            }
            
        }

        return msg;
    }
}
