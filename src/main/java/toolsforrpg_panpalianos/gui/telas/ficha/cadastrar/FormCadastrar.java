package toolsforrpg_panpalianos.gui.telas.ficha.cadastrar;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormFicha;

public class FormCadastrar extends FormFicha {

    public FormCadastrar(){
        super();
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
                FichasRepository.adicionar(ficha);
            } catch (Exception e) {       
                TelaAviso.mostrarErro(e);
            }
        }
    }

    @Override
    protected void trocarParaCriatura() {
        tipoFichaAtual = "Criatura";
        titulo.setText("Cadastrar "+tipoFichaAtual);
        pnlInfoCriatura.setVisible(true);
        pnlInfoJogador.setVisible(false);
    }

    @Override
    protected void trocarParaJogador() {
        tipoFichaAtual = "Jogador";
        titulo.setText("Cadastrar "+tipoFichaAtual);
        pnlInfoJogador.setVisible(true);
        pnlInfoCriatura.setVisible(false);
    }
    
}
