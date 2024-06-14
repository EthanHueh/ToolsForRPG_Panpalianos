package toolsforrpg_panpalianos.view.menus;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.controller.ControllerCalculos;
import toolsforrpg_panpalianos.controller.ControllerSimuladorCombate;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.view.Launcher;
import toolsforrpg_panpalianos.view.telas.FichasView;
import toolsforrpg_panpalianos.view.telas.TelaJTextArea;

public class MenuPrincipal {

    private static ValidadorDeInputs valInp = new ValidadorDeInputs();

    public MenuPrincipal() {

        do{
            final int OPCAO_SAIR = 999;

            int opcao = valInp.consistirInteiro(stringMenuPrincipal());
            
            switch(opcao){
        
                case 1:
                    FichasView.mostrarFichasDeJogador();
                    break;

                case 2:
                    FichasView.mostrarFichas();
                    break;

                case 3:
                    new MenuDeFichas();
                    break;

                case 4:
                    opcaoGerarTabelaDePreco();  
                    break;

                case 5:
                    new MenuIniciativa();
                    break;

                case 6:
                    ControllerSimuladorCombate.executarSimulador();
                    break;

                case 7:
                    new TelaJTextArea(ControllerCalculos.gerarEstatisticas(), "Estatística");
                    break;
                    
                case OPCAO_SAIR:

                    int opcaoSair = JOptionPane.showConfirmDialog(null, "Desejas Sair","Desejas Sair", JOptionPane.YES_NO_OPTION);

                    if (opcaoSair == JOptionPane.YES_OPTION){
                        new Launcher();
                        return;
                    }

                    break;
                          
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", "X", 0);
                    break;
            }
    
        } while (true);
    }

    private String stringMenuPrincipal() {
        return
            "\tRPG OLD DRAGON\n"+
            "1 - Mostrar fichas dos jogadores\n"+
            "2 - Mostrar fichas avulsas\n"+
            "3 - Criar ficha avulsa\n"+
            "4 - Cálculo de Preço Equipamento\n"+
            "5 - Gerenciar Iniciativa\n"+
            "6 - Simular combate\n"+
            "7 - Mostrar estatísticas\n\n"+

            "999 - Sair\n";
    }

    private void opcaoGerarTabelaDePreco() {
        int preco = valInp.consistirInteiro("Insira o preco do equipamento:");
        String nome = (JOptionPane.showInputDialog("Insira o nome do equipamento:"));

        new TelaJTextArea(ControllerCalculos.gerarTabelaDePreco(preco, nome), "Tabela de precos");  
    }

}