package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;
import toolsforrpg_panpalianos.gui.telas.ficha.FormAtualizar;
import toolsforrpg_panpalianos.gui.telas.ficha.FormCadastrar;
import toolsforrpg_panpalianos.gui.telas.ficha.TelaExcluirFicha;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;

public class TelaFichas extends JFrame {

    private FormCadastrar formCadastrar = new FormCadastrar();
    private FormAtualizar formAtualizar = new FormAtualizar();
    private TelaExcluirFicha telaExcluirFicha = new TelaExcluirFicha();

    public TelaFichas(){
        setTitle("Fichas");

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(5, 1));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JButton jButton = new BotaoPadrao("Exibir fichas jogador");
        jButton.addActionListener(
            e -> mostrarFichasJogador()
        );
        painelPrincipal.add(jButton);

        jButton = new BotaoPadrao("Exibir fichas criatura");
        jButton.addActionListener(
            e -> mostrarFichasCriatura()
        );
        painelPrincipal.add(jButton);

        jButton = new BotaoPadrao("Cadastrar fichas");
        jButton.addActionListener(
            e -> formCadastrar.iniciar()
        );
        painelPrincipal.add(jButton);

        jButton = new BotaoPadrao("Atualizar fichas");
        jButton.addActionListener(
            e -> formAtualizar.iniciar()
        );
        painelPrincipal.add(jButton);

        jButton = new BotaoPadrao("Excluir fichas");
        jButton.addActionListener(
            e -> telaExcluirFicha.iniciar()
        );
        painelPrincipal.add(jButton);

        add(painelPrincipal);

        pack();
        
    }

    public void iniciar(){
        setVisible(true);
    }

    public void mostrarFichasJogador(){ 
        try {
            List<Ficha> fichas = new ArrayList<>(FichasRepository.retornarFichasJogador());
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemFichas(fichas), "Fichas");
        } catch (Exception e) {
            TelaErro.mostrar(e);
        }
    }
    
    public void mostrarFichasCriatura(){
        try {
            List<Ficha> fichas = new ArrayList<>(FichasRepository.retornarFichasCriatura());
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemFichas(fichas), "Fichas");
        } catch (Exception e) {
            TelaErro.mostrar(e);
        }
    }
    
}