package toolsforrpg_panpalianos.gui.telas;

import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaFichas {

    public static void criarFicha(int opcao){
        Ficha ficha = null;
        switch (opcao) {

            case 1:
                ficha = TelaCriarFicha.criarFichaPadrao();
                break;
            
            case 2:
                ficha = TelaCriarFicha.criarFichaJogador();
                break;

            case 3:
                ficha = TelaCriarFicha.criarFichaJogadorAtributosAleatorios();
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opcao de ficha indisponível");
                return;
        }

        if (TelaInput.desejaRealizarOperacao("Quer mesmo cadastrar essa ficha?", "Confirmacao de cadastro de ficha")){
            FichasRepository.adicionar(ficha);
        }
    }

    public static void mostrarFichas(List<Ficha> fichas){
        if (existirFichas()){
            TelaTexto.iniciar(gerarMensagemFichas(fichas), "Fichas");
        }
    }
    
    public static void atualizarFicha() {
        JOptionPane.showMessageDialog(null, "Tem nada aqui ainda", "Nada", 0);
    }

    public static void excluirFicha(){
        
        if (existirFichas()){
            List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

            int opcao = ValidadorDeInputs.consistirInteiro(gerarMensagemFichasMenu(fichas)+"\nDe quem voce quer excluir a ficha?");

            if (opcao > 0 && opcao <= fichas.size()){
                Ficha ficha = FichasRepository.retornarTodasAsFichas().get(opcao - 1);
                
                if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação de delecao")){
                    FichasRepository.excluir(ficha);
                }
            }
        }
    }
    
    private static String gerarMensagemFichas(List<Ficha> fichas) {
        String msg = "";
        
        for (Ficha ficha : fichas) {
            msg += ficha.toString();
        }

        return msg;
    }

    private static String gerarMensagemFichasMenu(List<Ficha> fichas) {
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

    private static boolean existirFichas(){
        if(FichasRepository.isVazio()){
            JOptionPane.showMessageDialog(null, "Nenhuma ficha inserida!", "Fichas", 0);
            return false;
        }
        return true;
    }
}
