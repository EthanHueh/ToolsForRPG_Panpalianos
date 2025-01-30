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
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;

public abstract class FormFicha extends JFrame {

    protected String tipoFichaAtual;

    protected JLabel titulo = new JLabel();
    protected JButton trocarTipoFicha = new BotaoPadrao("Trocar");

    protected JPanel pnlNorte = new JPanel();

    protected PainelInfoBasica pnlInfoBasica = new PainelInfoBasica();
    protected PainelInfoJogador pnlInfoJogador = new PainelInfoJogador();
    protected PainelInfoCriatura pnlInfoCriatura = new PainelInfoCriatura();
    protected PainelAtributos pnlAtributos = new PainelAtributos();
    protected PainelEquipamento pnlEquipamento = new PainelEquipamento();

    public FormFicha(){
        setLayout(new BorderLayout());

        trocarTipoFicha.addActionListener (e -> trocarTipoFicha());

        pnlNorte.add(titulo);
        pnlNorte.add(trocarTipoFicha);
        add(pnlNorte, BorderLayout.NORTH);

        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.Y_AXIS));
        pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        pnlPrincipal.add(pnlInfoBasica);
        pnlPrincipal.add(pnlInfoJogador);
        pnlPrincipal.add(pnlInfoCriatura);

        JPanel pnlLeste = new JPanel();
        pnlLeste.setLayout(new BoxLayout(pnlLeste, BoxLayout.Y_AXIS));
        pnlLeste.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        pnlLeste.add(pnlAtributos);
        pnlLeste.add(pnlEquipamento);
        
        add(pnlPrincipal, BorderLayout.CENTER);
        add(pnlLeste, BorderLayout.EAST);

        JButton btnSubmit = new BotaoPadrao("OK");
        btnSubmit.setText("OK");
        btnSubmit.addActionListener(
            e -> submeterFicha()
        );

        add(btnSubmit, BorderLayout.SOUTH);

        pack();

        tipoFichaAtual = "Jogador";
    }

    public void iniciar(){
        trocarParaJogador();
        setVisible(true);
    }

    protected abstract void submeterFicha();

    protected void trocarTipoFicha(){
        if (tipoFichaAtual.equals("Jogador")){
            trocarParaCriatura();
        } else {
            trocarParaJogador();
        }
    }

    protected abstract void trocarParaCriatura();
    protected abstract void trocarParaJogador();

    protected Ficha montarFichaJogador() {
        
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

    protected Ficha montarFichaCriatura() {
        
        Ficha ficha = FichaCriatura.Builder.novaCriatura()
            .nome               (pnlInfoBasica.nome.getText())
            .descricao          (pnlInfoBasica.descricao.getText())
            .alinhamento        (pnlInfoBasica.alinhamento.toString())
            .raca               (pnlInfoBasica.raca.getSelectedItem().toString())
            .classeArmadura     (Integer.parseInt(pnlInfoCriatura.classeArmadura.getText()))
            .jogadaDeProtecao   (Integer.parseInt(pnlInfoCriatura.jogadaDeProtecao.getText()))
            .baseDeAtaque       (Integer.parseInt(pnlInfoCriatura.baseAtaque.getText()))
            .movimento          (Integer.parseInt(pnlInfoCriatura.classeArmadura.getText()))
            .quantDVs           (Integer.parseInt(pnlInfoCriatura.dadoVida.getText()))
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

    protected List<Idioma> montarListaIdiomas(){
        List<Idioma> idiomas = new ArrayList<>();
        for (JCheckBox jCheckBox : pnlInfoBasica.idiomas) {
            if (jCheckBox.isSelected()){
                idiomas.add(Idioma.getIdioma(jCheckBox.getText()));
            }
        }
        return idiomas;
    }

}
