package toolsforrpg_panpalianos.gui.telas.ficha.exibicao;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;

public class TelaMostrarFichas extends JFrame {

    private JComboBox<Object> selecao = new JComboBox<>();

    private PainelInfoBasica painelInfoBasica = new PainelInfoBasica();
    private PainelAtributos painelAtributos = new PainelAtributos();
    private PainelEquipamento painelEquipamento = new PainelEquipamento();
    private PainelInfoJogador painelInfoJogador = new PainelInfoJogador();
    private PainelSubatributos painelSubatributos = new PainelSubatributos();

    public TelaMostrarFichas(){
        setTitle("Exibir fichas");
        setLayout(new BorderLayout());

        JPanel painelNorte = new JPanel();
        
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        selecao.addActionListener(
            e -> atualizar()
        );

        painelNorte.add(selecao);
        add(painelNorte, BorderLayout.NORTH);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.add(painelInfoBasica);
        painelPrincipal.add(painelInfoJogador);
        painelPrincipal.add(painelAtributos);
        painelPrincipal.add(painelEquipamento);
        painelPrincipal.add(painelSubatributos);

        add(painelPrincipal, BorderLayout.CENTER);

        pack();

        atualizar();
        
    }

    public void iniciar(){
        atualizar();
        setVisible(true);
    }

    private void atualizar() {
        Ficha fichaAtual = (Ficha) selecao.getSelectedItem();

        painelInfoBasica.atualizar(fichaAtual);
        painelAtributos.atualizar(fichaAtual);
        painelEquipamento.atualizar(fichaAtual);
        painelSubatributos.atualizar(fichaAtual);

        if (fichaAtual instanceof FichaCriatura){
            painelInfoJogador.setVisible(false);
        }

        if (fichaAtual instanceof FichaJogador){
            painelInfoJogador.setVisible(true);
            painelInfoJogador.atualizar((FichaJogador) fichaAtual);
        }
        
    }
}
