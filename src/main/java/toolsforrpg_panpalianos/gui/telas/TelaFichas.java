package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;
import toolsforrpg_panpalianos.dominio.servicos.InicializadorFicha;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class TelaFichas {

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
    
    public static void criarFichaJogador() {

        Ficha ficha = FichaJogador.Builder.novoJogador()
            .nome(TelaInput.obterString("Insira o nome:"))
            .raca(TelaInput.obterString("Insira a raca:"))
            .forca(TelaInput.obterInteiro("Insira a forca:"))
            .destreza(TelaInput.obterInteiro("Insira a destreza:"))
            .constituicao(TelaInput.obterInteiro("Insira a constituição:"))
            .inteligencia(TelaInput.obterInteiro("Insira a inteligência:"))
            .sabedoria(TelaInput.obterInteiro("Insira a sabedoria:"))
            .carisma(TelaInput.obterInteiro("Insira o carisma:"))
            .classe(TelaInput.obterString("Insira a classe:"))
            .lvl(TelaInput.obterInteiro("Insira o nível:"))
            .exp(TelaInput.obterInteiro("Insira a experiência:"))
        .build();

        confirmarCadastroFicha(InicializadorFicha.inicializar(ficha));
    }

    public static void criarFichaCriatura() {

        Ficha ficha = FichaCriatura.Builder.novaCriatura()
            .nome(TelaInput.obterString("Insira o nome:"))
            .raca(TelaInput.obterString("Insira a raca:"))
            .forca(TelaInput.obterInteiro("Insira a forca:"))
            .destreza(TelaInput.obterInteiro("Insira a destreza:"))
            .constituicao(TelaInput.obterInteiro("Insira a constituição:"))
            .inteligencia(TelaInput.obterInteiro("Insira a inteligência:"))
            .sabedoria(TelaInput.obterInteiro("Insira a sabedoria:"))
            .carisma(TelaInput.obterInteiro("Insira o carisma:"))
            .quantDVs(TelaInput.obterInteiro("Insira a quantidade de DVs:"))
            .classeArmadura(TelaInput.obterInteiro("Insira a classe de armadura:"))
            .jogadaDeProtecao(TelaInput.obterInteiro("Insira a jogada de proteção:"))
            .baseDeAtaque(TelaInput.obterInteiro("Insira a base de ataque:"))
            .pvsAdicionais(TelaInput.obterInteiro("Insira o PV adicional:"))
        .build();

        confirmarCadastroFicha(InicializadorFicha.inicializar(ficha));
    }

    public static void criarFichaAtributosAleatorios() {

        Ficha ficha = FichaJogador.Builder.novoJogador()
            .nome(TelaInput.obterString("Insira o nome:"))
            .raca(TelaInput.obterString("Insira a raca:"))
            .forca(RoladorDeDados.executar(3, 6))
            .destreza(RoladorDeDados.executar(3, 6))
            .constituicao(RoladorDeDados.executar(3, 6))
            .inteligencia(RoladorDeDados.executar(3, 6))
            .sabedoria(RoladorDeDados.executar(3, 6))
            .carisma(RoladorDeDados.executar(3, 6))
            .classe(TelaInput.obterString("Insira a classe:"))
            .lvl(TelaInput.obterInteiro("Insira o nível:"))
            .exp(TelaInput.obterInteiro("Insira a experiência:"))
        .build();

        confirmarCadastroFicha(InicializadorFicha.inicializar(ficha));
    }
    
    public static void atualizarFicha() {
        TelaAviso.avisar("Tem nada aqui ainda", "Nada");
    }

    public static void excluirFicha(){
        
        if (!existirFichas()){
            return;
        }

        List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

        int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemFichasMenu(fichas)+"\nDe quem voce quer excluir a ficha?","Excluir ficha");

        if (opcao > 0 && opcao <= fichas.size()){
            Ficha ficha = fichas.get(opcao - 1);
            
            if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação de delecao")){
                FichasRepository.excluir(ficha);
            }
        }
    }

    private static void confirmarCadastroFicha(Ficha ficha) {
        if (TelaInput.desejaRealizarOperacao("Quer mesmo cadastrar essa ficha?", "Confirmacao de cadastro de ficha")){
            FichasRepository.adicionar(ficha);
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