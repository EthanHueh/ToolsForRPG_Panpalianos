package toolsforrpg_panpalianos.gui.telas.ficha.cadastrar;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormFicha;

public class FormCadastrar extends FormFicha {

    protected JLabel titulo = new JLabel("Cadastrar "+tipoFichaAtual);

    public FormCadastrar(){
        super();

        JButton trocarTipoFicha = new BotaoPadrao("Trocar");
        trocarTipoFicha.addActionListener(e -> trocarTipoFicha());

        JPanel pnlNorte = new JPanel();
        pnlNorte.add(titulo);
        pnlNorte.add(trocarTipoFicha);
        add(pnlNorte, BorderLayout.NORTH);

    }

    protected void trocarTipoFicha(){
        if (tipoFichaAtual.equals("Jogador")){
            tipoFichaAtual = "Criatura";
            titulo.setText("Cadastrar "+tipoFichaAtual);
            pnlInfoCriatura.setVisible(true);
            pnlInfoJogador.setVisible(false);
            
        } else {
            tipoFichaAtual = "Jogador";
            titulo.setText("Cadastrar "+tipoFichaAtual);
            pnlInfoJogador.setVisible(true);
            pnlInfoCriatura.setVisible(false);
        }
    }

    @Override
    public void submeterFicha() {
        if (TelaInput.desejaRealizarOperacao("Quer mesmo cadastrar essa ficha?", "Confirmacao")){
            Ficha ficha;

            if (tipoFichaAtual.equals("Jogador")){
                ficha = montarFichaJogador();
            } else {
                ficha = montarFichaCriatura();
            }

            try {
                FichasRepository.getInstance().adicionar(ficha);
            } catch (Exception e) {       
                TelaAviso.mostrarErro(e);
            }
        }
    }

}
