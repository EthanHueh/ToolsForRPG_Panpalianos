package toolsforrpg_panpalianos.gui.telas.ficha.excluir;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import toolsforrpg_panpalianos.gui.telas.ficha.principal.TelaFichas;

public class TelaExcluirFicha {
    private static TelaExcluirFicha instance = new TelaExcluirFicha();
    
    public static TelaExcluirFicha getInstance(){
        return instance;
    }
    
    public void iniciar(Ficha ficha){
        if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação")){
            try {
                FichasRepository.excluir(ficha);
                TelaFichas.getInstance().atualizar();
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }
    }
    
}
