package toolsforrpg_panpalianos.gui.telas;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.SimuladorDeCombate;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaSimuladorDeCombate {

    private static SimuladorDeCombate simCom = new SimuladorDeCombate();

    public static void iniciar(){
        
        List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();
        Personagem jogador = simCom.getJogador();
        Personagem inimigo = simCom.getInimigo();
        
        String msg = GeradorMensagens.gerarMensagemFichasMenu(fichas);

        TelaAviso.avisar("Bem vindo ao simulador de combate!", "SIMULADOR DE COMBATE");
        
        do {
            int opcao = TelaInput.obterInteiro(msg+"\nQuem você quer que seja o jogador?","Jogador");

            if (opcao > 0 && opcao <= fichas.size()){
                jogador.setFicha(fichas.get(opcao - 1));
                break;
            }

            if (opcao == fichas.size() + 1){
                if(TelaInput.desejaSair()){
                    return;
                }
            }
        }
        while (true);

        do {
            int opcao = TelaInput.obterInteiro(msg+"\nQuem você quer que seja o inimigo?","Inimigo");

            if (opcao > 0 && opcao <= fichas.size()){
                inimigo.setFicha(fichas.get(opcao - 1));
                
                if (inimigo.getFicha() == jogador.getFicha()){
                    TelaErro.mostrar("As fichas precisam ser diferentes!", "Fichas iguais");
                    continue;
                }
                break;
            }

            if (opcao == fichas.size() + 1){
                if(TelaInput.desejaSair()){
                    return;
                }
            }
       
        }
        while (true);

        TelaAviso.avisar(jogador.getFicha().getNome()+" X "+inimigo.getFicha().getNome(),"Combate!");
        
        executar();
    }
    
    private static void executar() {

        Personagem jogador = simCom.getJogador();
        Personagem inimigo = simCom.getInimigo();
        String nomeJogador = jogador.getFicha().getNome();
        String nomeInimigo = inimigo.getFicha().getNome();

        do {
            if (simCom.isTurnoJogador()){
                int opcao = TelaInput.obterInteiro(msgJogador(jogador), "Turno "+simCom.getNumeroTurnos());
            
                if (opcao == 6){
                    if(TelaInput.desejaSair()){
                        return;
                    }
                    continue;
                }

                TelaAviso.avisar(jogador.realizarAcao(opcao, inimigo), "Turno de "+nomeJogador);
    
            } else {
                TelaAviso.avisar(inimigo.realizarAcao(jogador), "Turno de "+nomeInimigo);
            }
    
            if (simCom.isGameOver()){
                String nomeVencedor = jogador.isAlive() ? nomeJogador : nomeInimigo;
                TelaAviso.avisar(nomeVencedor+" venceu!", "Vitoria!");

                simCom.resetar();
                return;
            }
    
            simCom.avancarTurno();
        }
        while(true);

    }

    private static String msgJogador(Personagem jogador) {
        return new StringBuilder()
            .append("O que fazes, "+jogador.getFicha().getNome()+" ?")
            .append("1 - Atacar\n")
            .append("2 - Defender\n")
            .append("3 - Desviar\n")
            .append("4 - Usar pocao\n")
            .append("5 - Habilidade Classe ("+jogador.getHabilidadeClasse()+")")
            .append("6 - Sair")
        .toString();
    }

}
