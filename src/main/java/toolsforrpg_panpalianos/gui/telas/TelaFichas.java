package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.ficha.excluir.TelaExcluirFicha;
import toolsforrpg_panpalianos.gui.telas.ficha.exibir.TelaMostrarFichas;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormAtualizar;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormCadastrar;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaFichas extends JFrame {

    private FormCadastrar formCadastrar = new FormCadastrar();
    private TelaMostrarFichas telaMostrarFichas = new TelaMostrarFichas();
    private FormAtualizar formAtualizar = new FormAtualizar();
    private TelaExcluirFicha telaExcluirFicha = new TelaExcluirFicha();

    public TelaFichas(){
        setTitle("Fichas");

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(5, 1));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton jButton = new BotaoPadrao("Exibir fichas");
        jButton.addActionListener(
            e -> telaMostrarFichas.iniciar()
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
    
}