package toolsforrpg_panpalianos.view.menus;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.repository.FichasRepository;
import toolsforrpg_panpalianos.service.Estatisticas;
import toolsforrpg_panpalianos.service.GeradorDeIniciativa;
import toolsforrpg_panpalianos.service.GeradorTabelaDePreco;
import toolsforrpg_panpalianos.service.SimuladorDeCombate;
import toolsforrpg_panpalianos.view.Launcher;
import toolsforrpg_panpalianos.view.telas.FichasView;
import toolsforrpg_panpalianos.view.telas.IniciativasView;
import toolsforrpg_panpalianos.view.telas.TelaJTextArea;

public class MenuPrincipal {

    public MenuPrincipal() {

        do{
            final int OPCAO_SAIR = 999;

            int opcao = 0;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(stringMenuPrincipal()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número!", "X", 0);
                continue;
            }
            
            switch(opcao){
        
                case 1:
                    FichasView.mostrarFichasDeJogador();
                    break;

                case 2:
                    FichasView.mostrarFichas();
                    break;

                case 3:
                    MenuDeFichas.subMenu();
                    break;

                case 4:
                    new TelaJTextArea(GeradorTabelaDePreco.executar(), "Tabela de precos");    
                    break;

                case 5:
                    GeradorDeIniciativa.executar();
                    break;

                case 6:
                    IniciativasView.mostrarListaIniciativas();
                    break;

                case 7:
                    SimuladorDeCombate.executar();
                    break;

                case 8:
                    new TelaJTextArea(Estatisticas.executar(FichasRepository.getFichasJogadores()), "Estatística");
                    break;
                    
                case OPCAO_SAIR:

                    opcao = JOptionPane.showConfirmDialog(null, "Desejas Sair","Desejas Sair", JOptionPane.YES_NO_OPTION);

                    if (opcao == JOptionPane.YES_OPTION){
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

    private Object stringMenuPrincipal() {
        return
            "\tRPG OLD DRAGON\n"+
            "1 - Mostrar fichas dos jogadores\n"+
            "2 - Mostrar fichas avulsas\n"+
            "3 - Criar ficha avulsa\n"+
            "4 - Cálculo de Preço Equipamento\n"+
            "5 - Gerenciar Iniciativa\n"+
            "6 - Ver iniciativa\n"+
            "7 - Simular combate\n"+
            "8 - Mostrar estatísticas\n\n"+

            "999 - Sair\n";
    }

}