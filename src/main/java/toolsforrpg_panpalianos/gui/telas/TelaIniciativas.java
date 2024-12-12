package toolsforrpg_panpalianos.gui.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Getter;
import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.servicos.GeradorMensagens;
import toolsforrpg_panpalianos.dominio.servicos.arquivos.EscritorDeArquivos;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import toolsforrpg_panpalianos.gui.telas.comum.TelaTexto;

@Getter
public class TelaIniciativas extends JFrame {

    private JComboBox<Object> selecao = new JComboBox<>();
    private JTextField campoIniciativa = new JTextField("0");

    public TelaIniciativas() {
        setTitle("Iniciativa");
        setLayout(new BorderLayout());

        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new GridLayout(5,2));
        pnlPrincipal.setPreferredSize(new Dimension(300,150));

        pnlPrincipal.add(new JLabel("Selecione a ficha"));
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        pnlPrincipal.add(selecao);

        pnlPrincipal.add(new JLabel("Insira valor iniciativa"));
        campoIniciativa.setText("0");
        pnlPrincipal.add(campoIniciativa);

        add(pnlPrincipal);

        JButton btnInserir = new BotaoPadrao("INSERIR");
        btnInserir.addActionListener(e -> adicionarIniciativa());

        JButton btnAtualizar = new BotaoPadrao("ATUALIZAR");
        btnAtualizar.addActionListener(e -> atualizarIniciativa());

        JButton btnMostrar = new BotaoPadrao("MOSTRAR");
        btnMostrar.addActionListener(e -> mostrarListaIniciativas());

        JButton btnExcluir = new BotaoPadrao("EXCLUIR");
        btnExcluir.addActionListener(e -> excluirIniciativa());

        JButton btnSalvar = new BotaoPadrao("SALVAR");
        btnSalvar.addActionListener(e -> salvarArquivo());

        pnlPrincipal.add(btnInserir);
        pnlPrincipal.add(btnAtualizar);
        pnlPrincipal.add(btnMostrar);
        pnlPrincipal.add(btnExcluir);
        pnlPrincipal.add(btnSalvar);

        pack();
    }

    public void adicionarIniciativa(){
        Ficha ficha = (Ficha) selecao.getSelectedItem();
        int valorIniciativa = Integer.parseInt(campoIniciativa.getText());
        
        Iniciativa iniciativa = new Iniciativa(valorIniciativa, ficha);

        try {
            IniciativasRepository.adicionar(iniciativa);
        } catch (Exception e) {
            TelaErro.mostrar(e);
        }
    }

    private void atualizarIniciativa() {

        Ficha ficha = (Ficha) selecao.getSelectedItem();
        
        if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de "+ficha.getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
            try {
                int valorIniciativa = Integer.parseInt(campoIniciativa.getText());
                IniciativasRepository.atualizar(new Iniciativa(valorIniciativa, ficha));
            } catch (Exception e) {
                TelaErro.mostrar(e);
            }
        }         
            
    }

    public void excluirIniciativa(){

        Ficha ficha = (Ficha) selecao.getSelectedItem();

        if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de "+ficha.getNome()+"?", "Confirmacao")){
            try {
                IniciativasRepository.excluir(ficha);
            } catch (Exception e) {
                TelaErro.mostrar(e);
            }
        }

    }

    public void mostrarListaIniciativas() {
        try {
            TelaTexto.iniciar(GeradorMensagens.gerarMensagemIniciativa(), "Iniciativas");
        } catch (Exception e){
            TelaErro.mostrar(e);
        }
    }

    public void salvarArquivo(){
        try {
            EscritorDeArquivos.salvarArquivo(GeradorMensagens.gerarMensagemIniciativa(), "arquivos/iniciativas/iniciativas.txt");
            TelaAviso.avisar("Arquivo escrito com sucesso!");
        } catch (IOException e){
            TelaErro.mostrar(e);
        } catch (Exception e){
            TelaErro.mostrar(e);
        }
    }

}
