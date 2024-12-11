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

        try {
            List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();
            int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemFichasMenu(fichas)+"\nQuem voce deseja inserir iniciativa?","Escolha uma ficha");

            if (opcao > 0 && opcao <= fichas.size()){
                Ficha ficha = fichas.get(opcao - 1);
                int valorIniciativa = TelaInput.obterInteiro("Insira a iniciativa de "+ficha.getNome(),"Insira iniciativa");
                
                IniciativasRepository.adicionar(
                    new Iniciativa(valorIniciativa, ficha)
                );
            }
        } catch (Exception e) {
            TelaErro.mostrar(e.getMessage());
        }

    }

    public static void mostrarListaIniciativas() {
        try {
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemIniciativa(), "Iniciativas");
        } catch (Exception e){
            TelaErro.mostrar(e.getMessage());
        }
        
    }

    public static void atualizarIniciativa(){

        try {
            List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

            int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemIniciativaEnumerada()+"\nQuem voce deseja atualizar a iniciativa?","Atualizar iniciativa");

            if (opcao > 0 && opcao <= iniciativas.size()){
                Ficha ficha = iniciativas.get(opcao - 1).getFicha();
                
                if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de"+ficha.getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
                    int valorIniciativa = TelaInput.obterInteiro("Insira a iniciativa de "+ficha.getNome(),"Inserir iniciativa");
                    IniciativasRepository.atualizar(new Iniciativa(valorIniciativa, ficha));
                }         
                
            }
        } catch (Exception e){
            TelaErro.mostrar(e.getMessage());
        }
        
    }

    public static void excluirIniciativa(){

        try {
            List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

            int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemIniciativaEnumerada()+"\nDe quem voce quer excluir a iniciativa?","Excluir iniciativa");
    
            if (opcao > 0 && opcao <= iniciativas.size()){
                Iniciativa iniciativa = IniciativasRepository.retornarIniciativas().get(opcao - 1);
                
                if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de"+iniciativa.getFicha().getNome()+"?", "Confirmacao de delecao de iniciativa")){
                    IniciativasRepository.excluir(iniciativa);
                }
            }
        } catch (Exception e){
            TelaErro.mostrar(e.getMessage());
        }
        
    }

    public static void salvarArquivo() {
        
        try {
            EscritorDeArquivos.salvarArquivo(GeradorMensagens.gerarMensagemIniciativa(), "arquivos/iniciativas/iniciativas.txt");
            TelaAviso.avisar("Arquivo escrito com sucesso!");
        } catch (IOException e){
            TelaErro.mostrar(e.getMessage());
        } catch (Exception e){
            TelaErro.mostrar(e.getMessage());
        }
    }

}