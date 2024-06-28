package toolsforrpg_panpalianos.gui.telas;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;

public class TelaMostrarFichas {

    public TelaMostrarFichas(List<Ficha> fichas){
        new TelaTexto(gerarMensagemFichas(fichas), "Fichas");
    }

    private static String gerarMensagemFichas(List<Ficha> fichas) {
        String msg = "";
        
        for (Ficha ficha : fichas) {
            msg += ficha;
        }

        return msg;
    }
}