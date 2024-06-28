package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaInput {

    String msg;

    public TelaInput(String msg){
        this.msg = msg;
    }

    public int obterInput() {
        return ValidadorDeInputs.consistirInteiro(msg);
    }

}
