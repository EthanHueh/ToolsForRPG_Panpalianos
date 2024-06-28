package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.Personagem;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.SimuladorDeCombate;

public class TelaSimuladorDeCombate {
    
    public TelaSimuladorDeCombate(){
        
        JOptionPane.showMessageDialog(null, "Bem vindo ao simulador de combate!", "SIMULADOR DE COMBATE", 0);

        Personagem jogador = new Personagem(FichasRepository.retornarFichasJogadores().get(0));
        Personagem inimigo = new Personagem(FichasRepository.retornarFichasAvulsas().get(0));

        SimuladorDeCombate simCom = new SimuladorDeCombate(jogador, inimigo);

        simCom.executar();

    }

}
