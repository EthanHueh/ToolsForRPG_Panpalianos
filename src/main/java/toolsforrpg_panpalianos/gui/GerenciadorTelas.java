package toolsforrpg_panpalianos.gui;

import toolsforrpg_panpalianos.gui.telas.launcher.Launcher;
import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuFichas;
import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuIniciativas;
import toolsforrpg_panpalianos.gui.telas.menus.TelaMenuPrincipal;

public class GerenciadorTelas {
    
    public static final Launcher launcher = new Launcher();
    public static final TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
    public static final TelaMenuFichas telaMenuFichas = new TelaMenuFichas();
    public static final TelaMenuIniciativas telaMenuIniciativas = new TelaMenuIniciativas();

    public static void iniciarLauncher() {
        launcher.setVisible(true);
    }

    public static void iniciarMenuPrincipal() {
        launcher.dispose();
        telaMenuPrincipal.iniciar();
    }
    
}
