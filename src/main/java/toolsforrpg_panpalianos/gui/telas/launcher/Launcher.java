package toolsforrpg_panpalianos.gui.telas.launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launcher extends JFrame {
    
    public Launcher(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);                
        setSize(1280,720);
        setLayout(new BorderLayout(0, 0));

        setTitle("Tools for RPG - Panpalianos");
        setIconImage(IconesImagem.LOGO.getImageIcon().getImage());
        getContentPane().setBackground(Cores.VERMELHO.getCor());

        initComponents();

        pack();
    }
    
    private void initComponents() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.add(BotaoFactory.criarBotao("menu"));
        painelPrincipal.add(new PainelDescricao());

        JPanel painelNorte = new JPanel();
        painelNorte.setPreferredSize(new Dimension(900, 50));
        painelNorte.setBackground(Cores.CINZA.getCor());
        painelNorte.add(BotaoFactory.criarBotao("fichas"));
        painelNorte.add(BotaoFactory.criarBotao("iniciativas"));
        painelNorte.add(BotaoFactory.criarBotao("tabela_preco"));
        painelNorte.add(BotaoFactory.criarBotao("combate"));
        painelNorte.add(BotaoFactory.criarBotao("estatisticas"));

        JPanel painelSul = new JPanel();
        painelSul.setPreferredSize(new Dimension(900, 50));
        painelSul.setBackground(Cores.CINZA.getCor());
        
        add(painelPrincipal, BorderLayout.CENTER);
        add(painelNorte, BorderLayout.NORTH);
        add(painelSul, BorderLayout.SOUTH);
    }

}
