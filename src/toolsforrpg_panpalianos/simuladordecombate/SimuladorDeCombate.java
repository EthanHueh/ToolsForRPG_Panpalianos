package toolsforrpg_panpalianos.simuladordecombate;

import java.util.List;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;

public class SimuladorDeCombate {

    public static void executar(List<FichaJogador> fichasJogadores, List<FichaCriatura> fichasAvulsas) {
        
        Personagem jogador = new Personagem(fichasJogadores.get(0));
        Personagem inimigo = new Personagem(fichasAvulsas.get(0));

        while(true){

            jogador.iniciarTurno(inimigo);

            if(isGameOver(jogador, inimigo)){
                anunciarVencendor(jogador, inimigo);
                return;
            }

            inimigo.atacar(jogador);

            if(isGameOver(jogador, inimigo)){
                anunciarVencendor(jogador, inimigo);
                return;
            }
        }

    }

    private static boolean isGameOver(Personagem p1, Personagem p2) {   
        return (!(p1.isAlive()) || !(p2.isAlive()));
    }

    private static void anunciarVencendor(Personagem p1, Personagem p2) {
        if(p1.isAlive()){
            System.out.println(p1.getFicha().getNome()+" venceu!");
        }
        if(p2.isAlive()){
            System.out.println(p2.getFicha().getNome()+" venceu!");
        }
    }

}
