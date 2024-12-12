package toolsforrpg_panpalianos.gui.componentes;

import javax.swing.JComboBox;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;

public class SelecaoUtils extends JComboBox<Object> {

    public static void mudarParaTodasAsFichas(JComboBox<Object> selecao){
        try {
            selecao.removeAllItems();
            for (Ficha f : FichasRepository.retornarTodasAsFichas()) {
                selecao.addItem(f);
            }
        } catch (Exception e) {
            TelaErro.mostrar(e);
        }
    }

    public static void mudarParaFichasJogador(JComboBox<Object> selecao){
        try {
            selecao.removeAllItems();
            for (Ficha f : FichasRepository.retornarFichasJogador()) {
                selecao.addItem(f);
            }
        } catch (Exception e) {
            TelaErro.mostrar(e);
        }
    }

    public static void mudarParaFichasCriatura(JComboBox<Object> selecao){
        try {
            selecao.removeAllItems();
            for (Ficha f : FichasRepository.retornarFichasCriatura()) {
                selecao.addItem(f);
            }
        } catch (Exception e) {
            TelaErro.mostrar(e);
        }
    }


}
