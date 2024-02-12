package toolsforrpg_panpalianos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;
import toolsforrpg_panpalianos.simuladordecombate.SimuladorDeCombate;

public class Menu {

    Menu() {
        
        List<FichaCriatura> fichasAvulsas = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasPadrao("recursos\\fichasAvulsas.csv");
        List<FichaJogador> fichasJogadores = LeitorDeArquivosDeFichas.converteArquivoEmListaDeFichasDeJogador("recursos\\fichasJogadores.csv");
        
        List<Integer>listaIniciativas = null;

        boolean continua = true;

        do{

            String mensagem =
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

            int opcao = 0;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Insira um número!", "X", 0);
                continue;
            }

            final int OPCAO_SAIR = 999;
            
            switch(opcao){
        
                case 1:
                    mostrarFichasDeJogador(fichasJogadores);
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

                case 8:
                    mostrarEstatisticas(fichasJogadores);
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

    private void mostrarEstatisticas(List<FichaJogador> fichasJogadores) {

        List<FichaCriatura> fichas = new ArrayList<FichaCriatura>();

        fichas.addAll(fichasJogadores);

        mostrarJTextArea(Estatisticas.executar(fichas), "Estatística");
        
    }

    private void mostrarFichasDeJogador(List<FichaJogador> fichas) {
        String mensagemFichas = "";

        for (FichaCriatura ficha : fichas) {
            mensagemFichas += ficha;
        }

        mostrarJTextArea(mensagemFichas, "Fichas");

    }

    private void mostrarFichas(List<FichaCriatura> fichas){
        String mensagemFichas = "";

        for (FichaCriatura ficha : fichas) {
            mensagemFichas += ficha;
        }

        mostrarJTextArea(mensagemFichas, "Fichas");
    }

    private void mostrarListaIniciativas(List<Integer> listaIniciativas, List<FichaJogador> fichasJogadores, List<FichaCriatura> fichasAvulsas) {
        if(listaIniciativas == null){
            JOptionPane.showMessageDialog(null, "Nenhuma iniciativa inserida!", "Iniciativas", 0);
            return;
        }

        String msgIniciativas = "Iniciativas dos jogadores:";
        for(int i = 0; i < fichasJogadores.size(); i++){
            msgIniciativas += fichasJogadores.get(i).getNome()+": "+listaIniciativas.get(i)+"\n";
        }

        msgIniciativas += "\nIniciativa:\n";
        for(int i = 0; i < fichasAvulsas.size(); i++){
            msgIniciativas += fichasAvulsas.get(i).getNome()+": "+listaIniciativas.get(i + fichasJogadores.size())+"\n";
        }

        mostrarJTextArea(msgIniciativas, "Iniciativas");

    }

    private void mostrarJTextArea(String msg, String titulo) {

        JTextArea area = new JTextArea(msg);
        area.setRows(20);
        area.setColumns(25);
        area.setLineWrap(true);

        JScrollPane pane = new JScrollPane(area);
        
        JOptionPane.showConfirmDialog(null, pane, titulo,
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

}