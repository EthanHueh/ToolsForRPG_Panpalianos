package toolsforrpg_panpalianos.gui.telas;

import java.util.List;
import javax.swing.JOptionPane;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;

import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;
import toolsforrpg_panpalianos.gui.GerenciadorTelas;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaSimuladorDeCombate {
    
    private static Personagem jogador = new Personagem();
    private static Personagem inimigo = new Personagem();
    private static int numeroTurnos = 0;
    
    private static String msg = "1 - Atacar\n2 - Defender\n3 - Desviar\n4 - Usar pocao\n5 - Habilidade Classe";
    
    public static void iniciar(){
        JOptionPane.showMessageDialog(null, "Bem vindo ao simulador de combate!", "SIMULADOR DE COMBATE", 0);

        List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();
        
        String msg = GeradorMensagens.gerarMensagemFichasMenu(fichas);

        int opcao = TelaInput.obterInteiro(msg+"\nQuem você quer que seja o jogador?","Jogador");

        if (opcao > 0 && opcao <= fichas.size()){
            Ficha ficha = fichas.get(opcao - 1);  
            jogador.setFicha(ficha);
        } else {
            iniciar();
            return;
        }
        
        opcao = TelaInput.obterInteiro(msg+"\nQuem você quer que seja o inimigo?","Inimigo");

        if (opcao > 0 && opcao <= fichas.size()){
            Ficha ficha = fichas.get(opcao - 1);  
            inimigo.setFicha(ficha);
        } else {
            iniciar();
            return;
        }
        
        JOptionPane.showMessageDialog(null, jogador.getFicha().getNome()+" X "+inimigo.getFicha().getNome(),"Combate!",2);
        
        executar();

        GerenciadorTelas.telaMenuPrincipal.iniciar();
    }
    
    public static void executar() {
        
        numeroTurnos++;
        int opcao = TelaInput.obterInteiro("O que fazes, "+jogador.getFicha().getNome()+"?\n"+msg+" ("+jogador.getHabilidadeClasse()+")\n6 - Sair", "Turno "+numeroTurnos);
        
        if (opcao == 6){
            if(TelaInput.desejaSair()){
                return;
            }
            
            executar();
            return;
        }
        
        JOptionPane.showMessageDialog(null, jogador.realizarAcao(opcao, inimigo), "Turno de "+jogador.getFicha().getNome(), 1);

        if (isGameOver()){
            return;
        }

        JOptionPane.showMessageDialog(null, inimigo.realizarAcao(jogador), "Turno de "+inimigo.getFicha().getNome(), 1);

        if (isGameOver()){
            return;
        }

        executar();

    }

    private static boolean isGameOver() {   
        boolean isGameOver = !(jogador.isAlive() && inimigo.isAlive());

        if (isGameOver){
            anunciarVencendor();
            resetarSimulador();
        }

        return isGameOver;

    }

    private static void anunciarVencendor() {
      
        String nomeVencedor = jogador.isAlive() ? jogador.getFicha().getNome() : inimigo.getFicha().getNome();
        JOptionPane.showMessageDialog(null,nomeVencedor+" venceu!", "Vitoria!",2);
    }
    
    private static void resetarSimulador(){
        numeroTurnos = 0;
        jogador.resetar();
        inimigo.resetar();
    }

}
