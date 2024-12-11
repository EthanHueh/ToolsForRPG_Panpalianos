package toolsforrpg_panpalianos.gui.telas.ficha.forms;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

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

            FichasRepository.adicionar(ficha);
        }
    }

    @Override
    public void trocarTipoFicha(){
        switch (tipoFichaAtual) {
            default:
            case "Jogador":
                tipoFichaAtual = "Criatura";
                titulo.setText("Cadastrar "+tipoFichaAtual);
                pnlInfoCriatura.setVisible(true);
                pnlInfoJogador.setVisible(false);
                break;

            case "Criatura":
                tipoFichaAtual = "Jogador";
                titulo.setText("Cadastrar "+tipoFichaAtual);
                pnlInfoJogador.setVisible(true);
                pnlInfoCriatura.setVisible(false);
                break;
        }
        
    }
    
}
