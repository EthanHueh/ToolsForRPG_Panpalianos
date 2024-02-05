package toolsforrpg_panpalianos;

import java.util.List;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;

public class SimuladorDeCombate {

    public static void executar(List<FichaJogador> fichasJogadores, List<FichaCriatura> fichasAvulsas) {
        
        FichaJogador primCombatente = fichasJogadores.get(0);

        int primCombatentePV = Regras.calcularPV(primCombatente);

        FichaCriatura segCombatente = fichasJogadores.get(4);
        int segCombatentePV = 33;

        boolean ninguemMorreu = true;

        while(true){

            System.out.println(primCombatente.getNome()+" ataca!");
            int dano = RoladorDeDados.executar(1, 6) + Regras.calcularBonus(primCombatente.getForca());

            System.out.println(segCombatente.getNome()+" toma "+dano+" de dano!");
            segCombatentePV -= dano;

            System.out.println(segCombatente.getNome()+ " esta com "+ segCombatentePV+"PV!!\n");

            ninguemMorreu = (primCombatentePV > 0 && segCombatentePV > 0);
            
            if(!ninguemMorreu){
                break;
            }

            System.out.println(segCombatente.getNome()+" ataca!");
            dano = RoladorDeDados.executar(1, 8) + Regras.calcularBonus(segCombatente.getForca());

            System.out.println(primCombatente.getNome()+" toma "+dano+" de dano!");
            primCombatentePV -= dano;

            System.out.println(primCombatente.getNome()+ " esta com "+ primCombatentePV+"PV!!\n");

            ninguemMorreu = (primCombatentePV > 0 && segCombatentePV > 0);

            if(!ninguemMorreu){
                break;
            }
        }

        if(primCombatentePV > 0){
            System.out.println(primCombatente.getNome()+" venceu!");
        }
        if(segCombatentePV > 0){
            System.out.println(segCombatente.getNome()+" venceu!");
        }




    }

}
