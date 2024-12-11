package toolsforrpg_panpalianos.gui.telas.ficha;

import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormAtualizar;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormCadastrar;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;

public class TelaFichas {

    private static FormCadastrar formCadastrar = new FormCadastrar();
    private static FormAtualizar formAtualizar = new FormAtualizar();

    public static void mostrarFichasJogador(){ 
        try {
            List<Ficha> fichas = new ArrayList<>(FichasRepository.retornarFichasJogador());
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemFichas(fichas), "Fichas");
        } catch (Exception e) {
            TelaErro.mostrar(e.getMessage());
        }
    }
    
    public static void mostrarFichasCriatura(){
        try {
            List<Ficha> fichas = new ArrayList<>(FichasRepository.retornarFichasCriatura());
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemFichas(fichas), "Fichas");
        } catch (Exception e) {
            TelaErro.mostrar(e.getMessage());
        }
    }

    public static void cadastrarFicha(){
        formCadastrar.setVisible(true);
    }
    
    public static void atualizarFicha() {
        formAtualizar.setVisible(true);
    }

    public static void excluirFicha(){
        
        try {
            List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

            int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemFichasMenu(fichas)+"\nDe quem voce quer excluir a ficha?","Excluir ficha");

            if (opcao > 0 && opcao <= fichas.size()){
                Ficha ficha = fichas.get(opcao - 1);
                
                if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação de delecao")){
                    FichasRepository.excluir(ficha);
                }
            }

        } catch (Exception e) {
           TelaErro.mostrar(e.getMessage());
        }

    }
    
}