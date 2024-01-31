package toolsforrpg_panpalianos;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import toolsforrpg_panpalianos.fichas.FichaCriatura;

public class Menu {

    Menu() {
        
        List<FichaCriatura> fichasAvulsas = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichas("recursos\\fichasAvulsas.csv", 1);
        List<FichaCriatura> fichasJogadores = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichas("recursos\\fichasJogadores.csv", 2);
        
        
        //List<FichaCriatura> fichasAvulsas = new ArrayList<FichaCriatura>();
        List<Integer>listaIniciativas = null;

        boolean continua = true;

        do{

            final int OPCAO_SAIR = 999;

            String mensagem = "";
            mensagem += "\tRPG OLD DRAGON\n";
            mensagem += "1 - Mostrar ficha dos jogador\n";
            mensagem += "2 - Mostrar fichas avulsas\n";
            mensagem += "3 - Criar ficha avulsa\n";
            mensagem += "4 - Cálculo de Preço Equipamento\n";
            mensagem += "5 - Gerenciar Iniciativa\n";
            mensagem += "6 - Ver iniciativa\n\n";
            
            mensagem += "999 - Sair\n";

            int opcao = 0;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "É PRA COLOCAR UM NÚMERO DESGRAÇA", "X", 0);
                continue;
            }
            
            switch(opcao){
        
                case 1:
                    mostrarFichas(fichasJogadores);
                    break;

                case 2:
                    mostrarFichas(fichasAvulsas);
                    break;

                case 3:
                    fichasAvulsas = GeradorDeFichas.subMenu(fichasAvulsas);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, GeradorTabelaDePreco.executar(), "Tabela de precos", 1);    
                    break;

                case 5:
                    listaIniciativas = GeradorDeIniciativa.executar(fichasJogadores, fichasAvulsas);
                    break;

                case 6:
                    mostrarListaIniciativas(listaIniciativas, fichasJogadores, fichasAvulsas);
                    break;

                case 7:
                    SimuladorDeCombate.executar(fichasJogadores, fichasAvulsas);
                    break;
                    
                case OPCAO_SAIR:

                    opcao = JOptionPane.showConfirmDialog(null, "Desejas Sair","Desejas Sair", JOptionPane.YES_NO_OPTION);

                    if (opcao == JOptionPane.YES_OPTION){
                        continua = false;
                        new Launcher();
                    }

                    break;
                          
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA", "X", 0);
                    break;
            }
    
        } while (continua);
    }

    private void mostrarFichas(List<FichaCriatura> fichas){
        String mensagemFichas = "";

        for (FichaCriatura ficha : fichas) {
            mensagemFichas += ficha;
        }

        JTextArea area = new JTextArea(mensagemFichas);
        area.setRows(20);
        area.setColumns(25);
        area.setLineWrap(true);

        JScrollPane pane = new JScrollPane(area);
        
        JOptionPane.showConfirmDialog(null, pane, "Fichas",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    private void mostrarListaIniciativas(List<Integer> listaIniciativas, List<FichaCriatura> fichasJogadores, List<FichaCriatura> fichasAvulsas) {
        if(listaIniciativas == null){
            JOptionPane.showMessageDialog(null, "Nenhuma iniciativa inserida!", "Iniciativas", 0);
            return;
        }

        String msgIniciativas = "";

        for(int i = 0; i < fichasJogadores.size(); i++){
            msgIniciativas += fichasJogadores.get(i).getNome()+": "+listaIniciativas.get(i)+"\n";
        }

        msgIniciativas += "\n\n";

        for(int i = 0; i < fichasAvulsas.size(); i++){
            msgIniciativas += fichasAvulsas.get(i).getNome()+": "+listaIniciativas.get(i + fichasJogadores.size())+"\n";
        }

        JTextArea area = new JTextArea(msgIniciativas);
        area.setRows(20);
        area.setColumns(25);
        area.setLineWrap(true);

        JScrollPane pane = new JScrollPane(area);

        JOptionPane.showConfirmDialog(null, pane, "Iniciativas",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

}