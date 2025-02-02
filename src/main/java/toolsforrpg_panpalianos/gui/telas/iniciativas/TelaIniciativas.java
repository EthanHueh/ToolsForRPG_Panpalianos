package toolsforrpg_panpalianos.gui.telas.iniciativas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Getter;
import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.Observador;
import toolsforrpg_panpalianos.dominio.servicos.arquivos.EscritorDeArquivos;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

@Getter
public class TelaIniciativas extends JFrame implements Observador {

    private TelaAdicionarIniciativa telaAdicionarIniciativa = new TelaAdicionarIniciativa();

    private JPanel painelPrincipal = new JPanel();

    public TelaIniciativas() {
        setTitle("Iniciativa");
        setLayout(new BorderLayout());
        setSize(new Dimension(300, 600));

        JPanel painelNorte = new JPanel();
        painelNorte = new JPanel();
        painelNorte.setLayout(new GridLayout(5,2));
        painelNorte.setPreferredSize(new Dimension(350,150));

        JButton btn = new BotaoPadrao("+ ADICIONAR INICIATIVA");
        btn.addActionListener(e -> telaAdicionarIniciativa.iniciar());
        painelNorte.add(btn);

        btn = new BotaoPadrao("SALVAR ARQUIVO");
        btn.addActionListener(e -> salvarArquivo());
        painelNorte.add(btn);

        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        add(painelPrincipal, BorderLayout.CENTER);
        add(painelNorte, BorderLayout.NORTH);

        atualizar();

        IniciativasRepository.getInstance().adicionarObservador(this);
    }

    public void iniciar(){
        setVisible(true);
    }

    void atualizarIniciativa(Iniciativa iniciativa) {
        
        if (TelaInput.desejaRealizarOperacao("Deseja mesmo atualizar a iniciativa de "+iniciativa.getFicha().getNome()+"?", "Confirmacao de atualizacao de iniciativa")){
            
            try {
                int novoValor = TelaInput.obterInteiro("Insira nova iniciativa (iniciativa atual = "+iniciativa.getIniciativa()+")");
                IniciativasRepository.getInstance().atualizar(new Iniciativa(novoValor, iniciativa.getFicha()));
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }

        atualizar();
            
    }

    void excluirIniciativa(Iniciativa iniciativa){

        if (TelaInput.desejaRealizarOperacao("Deseja mesmo excluir a iniciativa de "+iniciativa.getFicha().getNome()+"?", "Confirmacao")){
            try {
                IniciativasRepository.getInstance().excluir(iniciativa.getFicha());
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
        for (Iniciativa i : IniciativasRepository.getInstance().retornarIniciativas()) {
            msg += i.toString()+"\n";
        }
        return msg;
    }

    @Override
    public void atualizar(){

        try {
            painelPrincipal.removeAll();
            for (Iniciativa i : IniciativasRepository.getInstance().retornarIniciativas()){
                painelPrincipal.add(new PainelIniciativa(i, this));
            }
            
        } catch (Exception e) {
            
        }

        revalidate();
        repaint();
    }

}
