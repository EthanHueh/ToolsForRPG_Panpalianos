package toolsforrpg_panpalianos.gui.telas.ficha.excluir;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaExcluirFicha {
    
    public static void iniciar(Ficha ficha){
        if (TelaInput.desejaRealizarOperacao("Deseja deletar a ficha de "+ficha.getNome()+"?", "Confirmação")){
            try {
                FichasRepository.getInstance().excluir(ficha);
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }
    }
    
}
