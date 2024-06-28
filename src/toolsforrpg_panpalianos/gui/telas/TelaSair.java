package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

public class TelaSair {
    public TelaSair(){
        
    }

    public boolean usuarioQuerSair(){
        int opcaoSair = JOptionPane.showConfirmDialog(null, "Desejas Sair","Desejas Sair", JOptionPane.YES_NO_OPTION);
        
        return opcaoSair == JOptionPane.YES_OPTION;
    }
}
