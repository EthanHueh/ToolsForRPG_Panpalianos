package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.gui.opcoes.ficha.OpcaoMostrarFichasJogador;

public abstract class FormFicha extends JFrame {

    protected String tipoFichaAtual;

    protected JLabel titulo = new JLabel();
    protected JButton trocarTipoFicha = new JButton();

    protected JPanel pnlPrincipal = new JPanel();
    protected JPanel pnlNorte = new JPanel();

    protected PainelInfoBasica pnlInfoBasica = new PainelInfoBasica();
    protected PainelInfoJogador pnlInfoJogador = new PainelInfoJogador();
    protected PainelInfoCriatura pnlInfoCriatura = new PainelInfoCriatura();
    protected PainelAtributos pnlAtributos = new PainelAtributos();
    protected PainelEquipamento pnlEquipamento = new PainelEquipamento();

    protected JButton btnSubmit = new JButton();

    public FormFicha(){
        setLayout(new BorderLayout());

        trocarTipoFicha.addActionListener (e -> trocarTipoFicha());
        trocarTipoFicha.setText("Trocar");

        pnlNorte.add(titulo);
        pnlNorte.add(trocarTipoFicha);
        add(pnlNorte, BorderLayout.NORTH);

        pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.Y_AXIS));
        pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        pnlPrincipal.add(pnlInfoBasica);
        pnlPrincipal.add(pnlInfoJogador);
        pnlPrincipal.add(pnlInfoCriatura);
        pnlPrincipal.add(pnlAtributos);
        pnlPrincipal.add(pnlEquipamento);
        
        add(pnlPrincipal, BorderLayout.CENTER);

        btnSubmit.setText("OK");
        btnSubmit.addActionListener(
            e -> submeterFicha()
        );
        btnSubmit.addActionListener(
            e -> new OpcaoMostrarFichasJogador().executar()
        );

        add(btnSubmit, BorderLayout.SOUTH);

        pack();

        tipoFichaAtual = "Jogador";
        trocarTipoFicha();
    }

    public abstract void submeterFicha();

    public abstract void trocarTipoFicha();

    public Ficha montarFichaJogador() {
        
        Ficha ficha = FichaJogador.Builder.novoJogador()
            .nome           (pnlInfoBasica.nome.getText())
            .descricao      (pnlInfoBasica.descricao.getText())
            .alinhamento    (pnlInfoBasica.alinhamento.toString())
            .raca           (pnlInfoBasica.raca.getSelectedItem().toString())
            .classe         (pnlInfoJogador.classe.getSelectedItem().toString())
            .especializacao (pnlInfoJogador.especializacao.getSelectedItem().toString())
            .lvl            (Integer.parseInt(pnlInfoJogador.lvl.getText()))
            .exp            (Integer.parseInt(pnlInfoJogador.exp.getText()))
            .forca          (Integer.parseInt(pnlAtributos.forca.getText()))
            .destreza       (Integer.parseInt(pnlAtributos.destreza.getText()))
            .constituicao   (Integer.parseInt(pnlAtributos.constituicao.getText()))
            .inteligencia   (Integer.parseInt(pnlAtributos.inteligencia.getText()))
            .sabedoria      (Integer.parseInt(pnlAtributos.sabedoria.getText()))
            .carisma        (Integer.parseInt(pnlAtributos.carisma.getText()))
            .idiomas (
                montarListaIdiomas()
            )
            .equipamento(
                new Equipamento(
                    pnlEquipamento.arma.getSelectedItem().toString(),
                    pnlEquipamento.armadura.getSelectedItem().toString(),
                    pnlEquipamento.escudo.getSelectedItem().toString()
                )                
            )
        .build();

        return ficha;
    }

    public Ficha montarFichaCriatura() {
        
        Ficha ficha = FichaCriatura.Builder.novaCriatura()
            .nome               (pnlInfoBasica.nome.getText())
            .descricao          (pnlInfoBasica.descricao.getText())
            .alinhamento        (pnlInfoBasica.alinhamento.toString())
            .raca               (pnlInfoBasica.raca.getSelectedItem().toString())
            .classeArmadura     (Integer.parseInt(pnlInfoCriatura.classeArmadura.getText()))
            .jogadaDeProtecao   (Integer.parseInt(pnlInfoCriatura.jogadaDeProtecao.getText()))
            .baseDeAtaque       (Integer.parseInt(pnlInfoCriatura.baseAtaque.getText()))
            .movimento          (Integer.parseInt(pnlInfoCriatura.classeArmadura.getText()))
            .pvsAdicionais      (Integer.parseInt(pnlInfoCriatura.pvsAdicionais.getText()))
            .forca              (Integer.parseInt(pnlAtributos.forca.getText()))
            .destreza           (Integer.parseInt(pnlAtributos.destreza.getText()))
            .constituicao       (Integer.parseInt(pnlAtributos.constituicao.getText()))
            .inteligencia       (Integer.parseInt(pnlAtributos.inteligencia.getText()))
            .sabedoria          (Integer.parseInt(pnlAtributos.sabedoria.getText()))
            .carisma            (Integer.parseInt(pnlAtributos.carisma.getText()))
            .equipamento        (
                new Equipamento(
                    pnlEquipamento.arma.getSelectedItem().toString(),
                    pnlEquipamento.armadura.getSelectedItem().toString(),
                    pnlEquipamento.escudo.getSelectedItem().toString()
                )                
            )
        .build();

        return ficha;
    }

    public List<Idioma> montarListaIdiomas(){
        List<Idioma> idiomas = new ArrayList<>();
        for (JCheckBox jCheckBox : pnlInfoBasica.idiomas) {
            if (jCheckBox.isSelected()){
                idiomas.add(Idioma.getIdioma(jCheckBox.getText()));
            }
        }
        return idiomas;
    }

}
