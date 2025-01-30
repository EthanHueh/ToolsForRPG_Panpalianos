package toolsforrpg_panpalianos.gui.telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import toolsforrpg_panpalianos.dominio.servicos.arquivos.EscritorDeArquivos;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

@Getter
public class TelaIniciativas extends JFrame {

    private JComboBox<Object> selecao = new JComboBox<>();
    private JTextField campoIniciativa = new JTextField("0");

    public TelaIniciativas() {
        setTitle("Iniciativa");
        setLayout(new BorderLayout());

        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new GridLayout(5,2));
        pnlPrincipal.setPreferredSize(new Dimension(350,150));

        pnlPrincipal.add(new JLabel("Selecione a ficha"));
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        pnlPrincipal.add(selecao);

        pnlPrincipal.add(new JLabel("Insira valor iniciativa"));
        campoIniciativa.setText("0");
        pnlPrincipal.add(campoIniciativa);

        add(pnlPrincipal);

        JButton btn = new BotaoPadrao("INSERIR");
        btn.addActionListener(e -> adicionarIniciativa());
        pnlPrincipal.add(btn);

        btn = new BotaoPadrao("ATUALIZAR");
        btn.addActionListener(e -> atualizarIniciativa());
        pnlPrincipal.add(btn);

        btn = new BotaoPadrao("MOSTRAR");
        btn.addActionListener(e -> mostrarListaIniciativas());
        pnlPrincipal.add(btn);

        btn = new BotaoPadrao("EXCLUIR");
        btn.addActionListener(e -> excluirIniciativa());
        pnlPrincipal.add(btn);

        btn = new BotaoPadrao("SALVAR");
        btn.addActionListener(e -> salvarArquivo());
        pnlPrincipal.add(btn);

        btn = new BotaoPadrao("ROLAR INICIATIVA");
        btn.addActionListener(e -> rolarIniciativa());
        pnlPrincipal.add(btn);

        pack();
    }

    public void iniciar(){
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        setVisible(true);
    }

    private void rolarIniciativa() {
        Ficha ficha = (Ficha) selecao.getSelectedItem();
        campoIniciativa.setText(String.valueOf(RoladorDeDados.executarIniciativa(ficha)));
    }

    public void adicionarIniciativa(){
        Ficha ficha = (Ficha) selecao.getSelectedItem();
        int valorIniciativa = Integer.parseInt(campoIniciativa.getText());
        
        Iniciativa iniciativa = new Iniciativa(valorIniciativa, ficha);

        try {
            IniciativasRepository.adicionar(iniciativa);
        } catch (Exception e) {
            TelaAviso.mostrarErro(e);
        }
    }

    private void atualizarIniciativa() {

        Ficha ficha = (Ficha) selecao.getSelectedItem();
        
        if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de "+ficha.getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
            try {
                int valorIniciativa = Integer.parseInt(campoIniciativa.getText());
                IniciativasRepository.atualizar(new Iniciativa(valorIniciativa, ficha));
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }         
            
    }

    public void excluirIniciativa(){

        Ficha ficha = (Ficha) selecao.getSelectedItem();

        if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de "+ficha.getNome()+"?", "Confirmacao")){
            try {
                IniciativasRepository.excluir(ficha);
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }

    }

    public void mostrarListaIniciativas() {
        try {
            TelaAviso.avisar(gerarMensagemIniciativa(), "Iniciativas");
        } catch (Exception e){
            TelaAviso.mostrarErro(e);
        }
    }

    public void salvarArquivo(){
        try {
            EscritorDeArquivos.salvarArquivo(gerarMensagemIniciativa(), "arquivos/iniciativas/iniciativas.txt");
            TelaAviso.avisar("Arquivo escrito com sucesso!");
        } catch (IOException e){
            TelaAviso.mostrarErro(e);
        } catch (Exception e){
            TelaAviso.mostrarErro(e);
        }
    }

    public static String gerarMensagemIniciativa() throws Exception {

        List<Iniciativa> iniciativas = IniciativasRepository.retornarIniciativas();

        iniciativas.sort(Comparator.comparing(i -> i.getIniciativa()));
        Collections.reverse(iniciativas);

        String msg = "";
        for (Iniciativa i : iniciativas) {
            msg += i.toString()+"\n";
        }
        return msg;
    }

}
