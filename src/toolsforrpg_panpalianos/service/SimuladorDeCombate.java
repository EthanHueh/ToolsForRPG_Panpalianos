package toolsforrpg_panpalianos.service;

import toolsforrpg_panpalianos.model.Personagem;
import toolsforrpg_panpalianos.repository.FichasRepository;

public class SimuladorDeCombate {

    public static void executar() {
        
        Personagem jogador = new Personagem(FichasRepository.getFichasJogadores().get(0));
        Personagem inimigo = new Personagem(FichasRepository.getFichasAvulsas().get(0));

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
