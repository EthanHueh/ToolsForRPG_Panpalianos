package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.SimuladorDeCombate;
import toolsforrpg_panpalianos.gui.GerenciadorTelas;

public class TelaSimuladorDeCombate {

    public static void iniciar(){
        JOptionPane.showMessageDialog(null, "Bem vindo ao simulador de combate!", "SIMULADOR DE COMBATE", 0);

        Personagem jogador = new Personagem(FichasRepository.retornarFichaAleatoria());
        Personagem inimigo = new Personagem(FichasRepository.retornarFichaAleatoria());

        new SimuladorDeCombate(jogador, inimigo).executar();
        
        GerenciadorTelas.telaMenuPrincipal.iniciar();
    }

}
