package toolsforrpg_panpalianos.gui.telas.ficha;

import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormAtualizar;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormCadastrar;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;

public class TelaFichas extends JFrame {

    private FormCadastrar formCadastrar = new FormCadastrar();
    private FormAtualizar formAtualizar = new FormAtualizar();

    public TelaFichas(){

        setTitle("Fichas");

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(5, 1));
        
        JButton jButton = new JButton("Exibir fichas jogador");
        jButton.addActionListener(
            e -> mostrarFichasJogador()
        );
        painelPrincipal.add(jButton);

        jButton = new JButton("Exibir fichas criatura");
        jButton.addActionListener(
            e -> mostrarFichasCriatura()
        );
        painelPrincipal.add(jButton);

        jButton = new JButton("Cadastrar fichas");
        jButton.addActionListener(
            e -> formCadastrar.setVisible(true)
        );
        painelPrincipal.add(jButton);

        jButton = new JButton("Atualizar fichas");
        jButton.addActionListener(
            e -> formAtualizar.setVisible(true)
        );
        painelPrincipal.add(jButton);

        jButton = new JButton("Excluir fichas");
        jButton.addActionListener(
            e -> excluirFicha()
        );
        painelPrincipal.add(jButton);

        add(painelPrincipal);

        pack();
        
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

    public void excluirFicha(){
        
        try {
            List<Ficha> fichas = FichasRepository.retornarTodasAsFichas();

            int opcao = TelaInput.obterInteiro(GeradorMensagens.gerarMensagemFichasMenu(fichas)+"\nDe quem voce quer excluir a ficha?","Excluir ficha");

            if (opcao > 0 && opcao <= fichas.size()){
                Ficha ficha = fichas.get(opcao - 1);
                
                if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação de delecao")){
                    FichasRepository.excluir(ficha);
                }
            }

        } catch (Exception e) {
           TelaErro.mostrar(e);
        }

    }
    
}