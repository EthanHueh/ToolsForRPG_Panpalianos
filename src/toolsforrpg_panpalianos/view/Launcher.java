package toolsforrpg_panpalianos.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.view.menus.MenuPrincipal;

public class Launcher extends JFrame{
    
    

    JPanel painel;
    JButton botaoMenu;
    
    //Construtor do Frame
    public Launcher(){
        initComponents();
    }

    private void eventoBotaoMenuPrincipal() {
        this.dispose();
        new MenuPrincipal();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                //Se eu fechar a janela, o programa para de rodar
        this.setResizable(true);                                 //Dá pra eu deixar ou não o usuário aumentar/diminuir a janela
        this.setSize(1280,720);
        this.getContentPane().setBackground(new Color(128, 0, 0));
        this.setTitle("Tools for RPG - Panpalianos");
        this.setLayout(new BorderLayout(0, 0));
        
        ImageIcon logo = new ImageIcon("recursos\\capa_old_dragon.jpg");
        this.setIconImage(logo.getImage());                               //Ícone do programa

        botaoMenu = new JButton();
        botaoMenu.setText("Clique aqui para abrir o menu");
        botaoMenu.setIcon(logo);

        botaoMenu.setVerticalTextPosition(JButton.CENTER);

        botaoMenu.setForeground(new Color(128,255,0));
        botaoMenu.setFont(new Font("MV BOLI", Font.PLAIN,20));
        botaoMenu.setIconTextGap(20);
        botaoMenu.setFocusable(false);
        
        botaoMenu.addActionListener(e -> eventoBotaoMenuPrincipal());

        String mensagem =   "Este aqui é um utilitário para Old Dragon\n"+
                            "Por favor aproveite!\n\n"+

                            "Autoria: Ethan_Hueh\n";

        JOptionPane descricao = new JOptionPane(mensagem, JOptionPane.INFORMATION_MESSAGE);

        JPanel painel = new JPanel();
        painel.add(botaoMenu);
        painel.add(descricao);

        Color cinza = new Color(200,200,200);

        JPanel painelCinzaNorte = new JPanel();
        painelCinzaNorte.setPreferredSize(new Dimension(900, 50));
        painelCinzaNorte.setBackground(cinza);

        JPanel painelCinzaSul = new JPanel();
        painelCinzaSul.setPreferredSize(new Dimension(900, 50));
        painelCinzaSul.setBackground(cinza);
        
        this.add(painelCinzaNorte, BorderLayout.NORTH);
        this.add(painelCinzaSul, BorderLayout.SOUTH);

        this.add(painel, BorderLayout.CENTER);

        this.pack();

        this.setVisible(true);
    }

}
