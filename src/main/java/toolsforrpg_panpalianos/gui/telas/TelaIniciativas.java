package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import java.io.IOException;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;
import toolsforrpg_panpalianos.dominio.servicos.arquivos.EscritorDeArquivos;

public class TelaIniciativas {

    public static void inserirIniciativa(){

        List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

        int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemFichasMenu(fichas)+"\nQuem voce deseja inserir iniciativa?","Escolha uma ficha");

        if (opcao > 0 && opcao <= fichas.size()){
            Ficha ficha = fichas.get(opcao - 1);

            int valorIniciativa = TelaInput.obterInteiro("Insira a iniciativa de "+ficha.getNome(),"Insira iniciativa");
            Iniciativa iniciativa = new Iniciativa(valorIniciativa, ficha);

            if (IniciativasRepository.hasIniciativasRepetidas(iniciativa)){
                TelaErro.mostrar("Ficha repetida!", "Iniciativa");
                return;
            }

            IniciativasRepository.adicionar(iniciativa);
        }
    }

    public static void mostrarListaIniciativas() {

        if (existirIniciativas()){
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemIniciativa(), "Iniciativas");
        }
        
    }

    public static void atualizarIniciativa(){

        if (!existirIniciativas()){
            return;
        }

        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemIniciativaEnumerada()+"\nQuem voce deseja atualizar a iniciativa?","Atualizar iniciativa");

        if (opcao > 0 && opcao <= iniciativas.size()){
            Ficha ficha = iniciativas.get(opcao - 1).getFicha();
            
            if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de"+ficha.getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
                int valorIniciativa = TelaInput.obterInteiro("Insira a iniciativa de "+ficha.getNome(),"Inserir iniciativa");
                IniciativasRepository.atualizar(new Iniciativa(valorIniciativa, ficha));
            }         
            
        }
        
    }

    public static void excluirIniciativa(){

        if (!existirIniciativas()){
            return;
        }
        
        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemIniciativaEnumerada()+"\nDe quem voce quer excluir a iniciativa?","Excluir iniciativa");

        if (opcao > 0 && opcao <= iniciativas.size()){
            Iniciativa iniciativa = IniciativasRepository.retornarIniciativas().get(opcao - 1);
            
            if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de"+iniciativa.getFicha().getNome()+"?", "Confirmacao de delecao de iniciativa")){
                IniciativasRepository.excluir(iniciativa);
            }
        }

    }

    private static boolean existirIniciativas(){
        if(IniciativasRepository.retornarIniciativas().isEmpty()){
            TelaErro.mostrar("Nenhuma iniciativa inserida!", "Iniciativas");
            return false;
        }
        return true;
    }

    public static void salvarArquivo() {
        
        if (!existirIniciativas()){
            return;
        }
        
        try {
            EscritorDeArquivos.salvarArquivo(GeradorMensagens.gerarMensagemIniciativa(), "arquivos/iniciativas/iniciativas.txt");
            TelaAviso.avisar("Arquivo escrito com sucesso!");
        } catch (IOException ex) {
            TelaErro.mostrar("Ocorreu um erro!");
        }
    }

}