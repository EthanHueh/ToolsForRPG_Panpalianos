package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
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
            .nome           (pnlInfoBasica.getNome())
            .descricao      (pnlInfoBasica.getDescricao())
            .alinhamento    (pnlInfoBasica.getAlinhamento())
            .raca           (pnlInfoBasica.getRaca())
            .classe         (pnlInfoJogador.getClasse())
            .especializacao (pnlInfoJogador.getEspecializacao())
            .lvl            (pnlInfoJogador.getLvl())
            .exp            (pnlInfoJogador.getExp())
            .forca          (pnlAtributos.getForca())
            .destreza       (pnlAtributos.getDestreza())
            .constituicao   (pnlAtributos.getConstituicao())
            .inteligencia   (pnlAtributos.getInteligencia())
            .sabedoria      (pnlAtributos.getSabedoria())
            .carisma        (pnlAtributos.getCarisma())
            .idiomas (
                pnlInfoBasica.getIdiomas()
            )
            .equipamento(
                new Equipamento(
                    pnlEquipamento.getArma(),
                    pnlEquipamento.getArmadura(),
                    pnlEquipamento.getEscudo()
                )                
            )
        .build();

        return ficha;
    }

    protected Ficha montarFichaCriatura() {
        
        Ficha ficha = FichaCriatura.Builder.novaCriatura()
            .nome               (pnlInfoBasica.getNome())
            .descricao          (pnlInfoBasica.getDescricao())
            .alinhamento        (pnlInfoBasica.getAlinhamento())
            .raca               (pnlInfoBasica.getRaca())
            .classeArmadura     (pnlInfoCriatura.getClasseArmadura())
            .jogadaDeProtecao   (pnlInfoCriatura.getJogadaDeProtecao())
            .baseDeAtaque       (pnlInfoCriatura.getBaseAtaque())
            .movimento          (pnlInfoCriatura.getMovimento())
            .quantDVs           (pnlInfoCriatura.getDadoVida())
            .pvsAdicionais      (pnlInfoCriatura.getPvsAdicionais())
            .forca              (pnlAtributos.getForca())
            .destreza           (pnlAtributos.getDestreza())
            .constituicao       (pnlAtributos.getConstituicao())
            .inteligencia       (pnlAtributos.getInteligencia())
            .sabedoria          (pnlAtributos.getSabedoria())
            .carisma            (pnlAtributos.getCarisma())
            .equipamento        (
                new Equipamento(
                    pnlEquipamento.getArma(),
                    pnlEquipamento.getArmadura(),
                    pnlEquipamento.getEscudo()
                )                
            )
        .build();

        return ficha;
    }

}
