package toolsforrpg_panpalianos.gui.telas.simulador_combate;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.SimuladorDeCombate;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaSimuladorDeCombate extends JFrame {

    private SimuladorDeCombate simCom = new SimuladorDeCombate();

    private JComboBox<Object> selecionarFichaJogador = new JComboBox<>();
    private JComboBox<Object> selecionarFichaInimigo = new JComboBox<>();

    public TelaSimuladorDeCombate(){
        SelecaoUtils.mudarParaTodasAsFichas(selecionarFichaJogador);
        SelecaoUtils.mudarParaTodasAsFichas(selecionarFichaInimigo);

        setTitle("Simulador de Combate");
        setLayout(new BorderLayout());
        add(new JLabel("Bem vindo ao simulador de combate"), BorderLayout.NORTH);
        
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout((new GridLayout(2,2)));
        
        painelPrincipal.add(new JLabel("Jogador"));
        painelPrincipal.add(selecionarFichaJogador);
        painelPrincipal.add(new JLabel("Inimigo"));
        painelPrincipal.add(selecionarFichaInimigo);

        JButton btn = new BotaoPadrao("Iniciar");
        btn.addActionListener(
            e -> confirmarCombate()
        );

        add(btn, BorderLayout.SOUTH);

        add(painelPrincipal);

        pack();

    }

    public void iniciar(){
        SelecaoUtils.mudarParaTodasAsFichas(selecionarFichaJogador);
        SelecaoUtils.mudarParaTodasAsFichas(selecionarFichaInimigo);
        
        setVisible(true);
    }

    private void confirmarCombate(){
        Ficha fJogador = (Ficha) selecionarFichaJogador.getSelectedItem();
        Ficha fInimigo = (Ficha) selecionarFichaInimigo.getSelectedItem();

        String msg = "Jogador: "+fJogador.getNome()+"\nInimigo: "+fInimigo.getNome();

        if (TelaInput.desejaRealizarOperacao("Deseja iniciar combate?\n\n"+msg, "Combate")){
            if (fJogador == fInimigo){
                TelaAviso.mostrarErro("As fichas precisam ser diferentes!");
                return;
            }

            simCom.getJogador().setFicha(fJogador);;
            simCom.getInimigo().setFicha(fInimigo);

            TelaAviso.avisar(fJogador.getNome()+" X "+fInimigo.getNome(),"Combate!");
            executarCombate();
        }
    }
    
    private void executarCombate() {

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

    private String msgJogador(Personagem jogador) {
        return new StringBuilder()
            .append("O que fazes, "+jogador.getFicha().getNome()+"?\n")
            .append("1 - Atacar\n")
            .append("2 - Defender\n")
            .append("3 - Desviar\n")
            .append("4 - Usar pocao\n")
            .append("5 - Habilidade Classe ("+jogador.getHabilidadeClasse()+")\n")
            .append("6 - Sair")
        .toString();
    }

}
