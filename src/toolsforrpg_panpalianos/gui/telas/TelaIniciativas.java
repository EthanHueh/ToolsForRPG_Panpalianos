package toolsforrpg_panpalianos.gui.telas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaIniciativas {

    public static void inserirIniciativa(){

        List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

        int opcao = ValidadorDeInputs.consistirInteiro(gerarMensagemFichas(fichas)+"\nQuem voce deseja inserir iniciativa?");

        if (opcao > 0 && opcao <= fichas.size()){
            Ficha ficha = fichas.get(opcao - 1);

            int valorIniciativa = ValidadorDeInputs.consistirInteiro("Insira a iniciativa de "+ficha.getNome());
            Iniciativa iniciativa = new Iniciativa(valorIniciativa, ficha);

            if (IniciativasRepository.hasIniciativasRepetidas(iniciativa)){
                JOptionPane.showMessageDialog(null, "Ficha repetida!", "Iniciativa", 0);
                return;
            }

            IniciativasRepository.adicionar(iniciativa);
        }
    }

    public static void mostrarListaIniciativas() {

        if (existirIniciativas()){
            TelaTexto.iniciar(gerarMensagemIniciativa(), "Iniciativas");
        }
        
    }

    public static void atualizarIniciativa(){

        if (existirIniciativas()){
            List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

            int opcao = ValidadorDeInputs.consistirInteiro(gerarMensagemIniciativaEnumerada()+"\nQuem voce deseja atualizar a iniciativa?");

            if (opcao > 0 && opcao <= iniciativas.size()){
                Ficha ficha = iniciativas.get(opcao - 1).getFicha();
                
                if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de"+ficha.getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
                    int valorIniciativa = ValidadorDeInputs.consistirInteiro("Insira a iniciativa de "+ficha.getNome());
                    IniciativasRepository.atualizar(new Iniciativa(valorIniciativa, ficha));
                }         
                
            }
        }
        
    }

    public static void excluirIniciativa(){
        
        if (existirIniciativas()){
            List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

            int opcao = ValidadorDeInputs.consistirInteiro(gerarMensagemIniciativaEnumerada()+"\nDe quem voce quer excluir a iniciativa?");

            if (opcao > 0 && opcao <= iniciativas.size()){
                Iniciativa iniciativa = IniciativasRepository.retornarIniciativas().get(opcao - 1);
                
                if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de"+iniciativa.getFicha().getNome()+"?", "Confirmacao de delecao de iniciativa")){
                    IniciativasRepository.excluir(iniciativa);
                }
            }
        }

    }

    private static boolean existirIniciativas(){
        if(IniciativasRepository.retornarIniciativas().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma iniciativa inserida!", "Iniciativas", 0);
            return false;
        }
        return true;
    }

    private static String gerarMensagemFichas(List<Ficha> fichas) {
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

    private static String gerarMensagemIniciativa() {

        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        iniciativas.sort(Comparator.comparing(Iniciativa::getIniciativa));
        Collections.reverse(iniciativas);

        String msg = "";
        for (Iniciativa iniciativa: IniciativasRepository.retornarIniciativas()){
            msg += iniciativa.toString()+"\n";
        }
        return msg;

    }

    private static String gerarMensagemIniciativaEnumerada() {

        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        String msg = "";
        for (int i = 0; i < iniciativas.size(); i++){
            msg += i + 1 + " - "+ iniciativas.get(i).toString()+"\n";
        }
        return msg;

    }

}