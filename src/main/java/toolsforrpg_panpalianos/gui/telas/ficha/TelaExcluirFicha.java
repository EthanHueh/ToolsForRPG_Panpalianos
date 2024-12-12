package toolsforrpg_panpalianos.gui.telas.ficha;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaExcluirFicha extends JFrame {
    private JComboBox<Object> selecao = new JComboBox<>();
    
    public TelaExcluirFicha(){
        setTitle("Excluir ficha");
        
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new GridLayout(2,1));
        pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        SelecaoUtils.mudarParaTodasAsFichas(selecao);

        JButton btnExcluir = new BotaoPadrao("Excluir");
        btnExcluir.addActionListener(
            e -> excluirFicha()
        );

        pnlPrincipal.add(selecao);
        pnlPrincipal.add(btnExcluir);

        add(pnlPrincipal);

        pack();
    }
    
    public void iniciar(){
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        setVisible(true);
    }

    private void excluirFicha(){

        if (selecao.getSelectedItem() == null){
            TelaErro.mostrar("Ficha inexistente!");
            return;
        }

        Ficha ficha = (Ficha) selecao.getSelectedItem();

        if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação")){
            try {
                FichasRepository.excluir(ficha);
                selecao.removeItem(ficha);
            } catch (Exception ex) {
                TelaErro.mostrar(ex);
            }
        }
    }
}

