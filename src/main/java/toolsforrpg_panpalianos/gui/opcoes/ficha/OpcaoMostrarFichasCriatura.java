package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoMostrarFichasCriatura extends Opcao {

    public OpcaoMostrarFichasCriatura() {
        super("Mostrar fichas de criaturas");
    }
    
    @Override
    public void executar() {
        TelaFichas.mostrarFichasCriatura();
    }
    
}
