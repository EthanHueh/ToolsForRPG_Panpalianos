package toolsforrpg_panpalianos.gui.telas.launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.gui.componentes.Cores;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoLauncher;
import toolsforrpg_panpalianos.gui.telas.estatisticas.TelaEstatisticas;
import toolsforrpg_panpalianos.gui.telas.ficha.principal.TelaFichas;
import toolsforrpg_panpalianos.gui.telas.iniciativas.TelaIniciativas;
import toolsforrpg_panpalianos.gui.telas.simulador_combate.TelaSimuladorDeCombate;
import toolsforrpg_panpalianos.gui.telas.tabela_preco.TelaTabelaPrecos;

public class Launcher extends JFrame {
    
    public Launcher(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                
        setSize(1280,720);
        setLayout(new BorderLayout(0, 0));

        setTitle("Tools for RPG - Panpalianos");
        setIconImage(IconesImagem.LOGO.getImageIcon().getImage());

        initComponents();

        pack();

        setVisible(true);
    }
    
    private void initComponents() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.add(new JLabel(IconesImagem.LOGO.getImageIcon()));

        JPanel painelNorte = new JPanel();
        painelNorte.setPreferredSize(new Dimension(900, 50));
        painelNorte.setBackground(Cores.CINZA.getCor());

        JButton jButton = new BotaoLauncher("Fichas");
        jButton.addActionListener(
            e -> TelaFichas.getInstance().iniciar()
        );
        painelNorte.add(jButton);

        jButton = new BotaoLauncher("Iniciativas");
        jButton.addActionListener(
            e -> TelaIniciativas.getInstance().iniciar()
        );
        painelNorte.add(jButton);

        jButton = new BotaoLauncher("Tabela Preço");
        jButton.addActionListener(
            e -> TelaTabelaPrecos.getInstance().iniciar()
        );
        painelNorte.add(jButton);

        jButton = new BotaoLauncher("Estatísticas");
        jButton.addActionListener(
            e -> TelaEstatisticas.getInstance().iniciar()
        );
        painelNorte.add(jButton);

        jButton = new BotaoLauncher("Combate");
        jButton.addActionListener(
            e -> TelaSimuladorDeCombate.getInstance().iniciar()
        );
        painelNorte.add(jButton);

        JPanel painelSul = new JPanel();
        painelSul.setPreferredSize(new Dimension(900, 50));
        painelSul.setBackground(Cores.CINZA.getCor());
        
        add(painelPrincipal, BorderLayout.CENTER);
        add(painelNorte, BorderLayout.NORTH);
        add(painelSul, BorderLayout.SOUTH);
        add(new PainelDescricao(), BorderLayout.EAST);
    }

}
