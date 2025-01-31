package toolsforrpg_panpalianos.gui.telas.iniciativas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
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

    private static TelaIniciativas instance = new TelaIniciativas();

    private JComboBox<Object> selecao = new JComboBox<>();
    private JTextField campoIniciativa = new JTextField("0");
    private JPanel painelPrincipal = new JPanel();

    public TelaIniciativas() {
        setTitle("Iniciativa");
        setLayout(new BorderLayout());

        JPanel painelNorte = new JPanel();
        painelNorte = new JPanel();
        painelNorte.setLayout(new GridLayout(5,2));
        painelNorte.setPreferredSize(new Dimension(350,150));

        painelNorte.add(new JLabel("Selecione a ficha"));
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        painelNorte.add(selecao);

        painelNorte.add(new JLabel("Insira valor iniciativa"));
        campoIniciativa.setText("0");
        painelNorte.add(campoIniciativa);

        JButton btn = new BotaoPadrao("+ Adicionar iniciativa");
        btn.addActionListener(e -> adicionarIniciativa());
        painelNorte.add(btn);

        btn = new BotaoPadrao("SALVAR ARQUIVO");
        btn.addActionListener(e -> salvarArquivo());
        painelNorte.add(btn);

        btn = new BotaoPadrao("ROLAR INICIATIVA");
        btn.addActionListener(e -> rolarIniciativa());
        painelNorte.add(btn);

        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        add(painelPrincipal, BorderLayout.CENTER);
        add(painelNorte, BorderLayout.NORTH);

        atualizar();
        pack();
    }

    public static TelaIniciativas getInstance() {
        return instance;
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

        atualizar();
    }

    void atualizarIniciativa(Ficha ficha) {
        
        if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de "+ficha.getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
            try {
                int valorIniciativa = Integer.parseInt(campoIniciativa.getText());
                IniciativasRepository.atualizar(new Iniciativa(valorIniciativa, ficha));
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }

        atualizar();
            
    }

    void excluirIniciativa(Ficha ficha){

        if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de "+ficha.getNome()+"?", "Confirmacao")){
            try {
                IniciativasRepository.excluir(ficha);
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }

        atualizar();

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

    private static String gerarMensagemIniciativa() throws Exception {
        String msg = "";
        for (Iniciativa i : IniciativasRepository.retornarIniciativas()) {
            msg += i.toString()+"\n";
        }
        return msg;
    }

    public void atualizar(){

        try {
            painelPrincipal.removeAll();
            for (Iniciativa i : IniciativasRepository.retornarIniciativas()){
                painelPrincipal.add(new PainelIniciativa(i));
            }
            
        } catch (Exception e) {
            TelaAviso.mostrarErro(e);
        }

        revalidate();
        repaint();
    }

}
