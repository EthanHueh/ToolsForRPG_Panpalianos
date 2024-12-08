package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;

public class TelaFichas {
    
    public static void criarFichaAtributosAleatorios() {
        confirmarCadastroFicha(TelaCriarFicha.criarFichaAtributosAleatorios());
    }

    public static void criarFichaJogador() {
        confirmarCadastroFicha(TelaCriarFicha.criarFichaJogador());
    }

    public static void criarFichaCriatura() {
        confirmarCadastroFicha(TelaCriarFicha.criarFichaCriatura());
    }

    private static void confirmarCadastroFicha(Ficha ficha) {
        if (TelaInput.desejaRealizarOperacao("Quer mesmo cadastrar essa ficha?", "Confirmacao de cadastro de ficha")){
            FichasRepository.adicionar(ficha);
        }
    }
    
    public static void mostrarFichasJogador(){
        List<Ficha> fichas = new ArrayList<>(FichasRepository.retornarFichasJogador());
        if (existirFichas()){
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemFichas(fichas), "Fichas");
        }
    }
    
    public static void mostrarFichasCriatura(){
        List<Ficha> fichas = new ArrayList<>(FichasRepository.retornarFichasCriatura());
        if (existirFichas()){
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemFichas(fichas), "Fichas");
        }
    }
    
    public static void atualizarFicha() {
        TelaAviso.avisar("Tem nada aqui ainda", "Nada");
    }

    public static void excluirFicha(){
        
        if (existirFichas()){
            List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

            int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemFichasMenu(fichas)+"\nDe quem voce quer excluir a ficha?","Excluir ficha");

            if (opcao > 0 && opcao <= fichas.size()){
                Ficha ficha = fichas.get(opcao - 1);
                
                if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação de delecao")){
                    FichasRepository.excluir(ficha);
                }
            }
        }
    }

    private static boolean existirFichas(){
        if(FichasRepository.isVazio()){
            TelaErro.mostrar("Nenhuma ficha inserida!", "Fichas");
            return false;
        }
        return true;
    }
    
}