package toolsforrpg_panpalianos;

import java.util.List;

import javax.swing.JOptionPane;

public class GeradorDeFichas {

    public static List<FichaCriatura> subMenu(List<FichaCriatura> fichasAvulsas) {
        
        String  msgFicha = "";
        msgFicha += "Escolha a opcao:\n";
        msgFicha += "1 - Ficha padrão\n";
        msgFicha += "2 - Ficha de jogador\n";
        msgFicha += "3 - Ficha com atributos aleatórios\n";
        msgFicha += "4 - Sair\n";

        int opcao = 0;

        boolean opcaoInvalida = false;


        do{

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(msgFicha));
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "É PRA COLOCAR UM NÚMERO DESGRAÇA", "X", 0);
            }

            opcaoInvalida = (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);

        }
        while(opcaoInvalida);
        

        FichaCriatura ficha = criarNovaFicha(opcao);

        if(ficha != null){
            fichasAvulsas.add(ficha);
        }

        return fichasAvulsas;
    }

    static FichaCriatura criarNovaFicha(int opcao){

        FichaCriatura ficha = new FichaCriatura();

        final int OPCAO_PADRAO = 1;
        final int OPCAO_JOGADOR = 2;
        final int OPCAO_ATRIBUTOS_ALEATORIOS = 3;

        switch (opcao) {

            case OPCAO_PADRAO:
                ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
                ficha.setRaca(JOptionPane.showInputDialog("Insira a raca:"));

                ficha.setForca(Integer.parseInt(JOptionPane.showInputDialog("Insira a forca:")));
                ficha.setDestreza(Integer.parseInt(JOptionPane.showInputDialog("Insira a destreza:")));
                ficha.setConstituicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a constituição:")));
                ficha.setInteligencia(Integer.parseInt(JOptionPane.showInputDialog("Insira a inteligência:")));
                ficha.setSabedoria(Integer.parseInt(JOptionPane.showInputDialog("Insira a sabedoria:")));
                ficha.setCarisma(Integer.parseInt(JOptionPane.showInputDialog("Insira o carisma:")));

                ficha.setLvl(Integer.parseInt(JOptionPane.showInputDialog("Insira o nível:")));
                ficha.setPvAdicional(Integer.parseInt(JOptionPane.showInputDialog("Insira o pv adicional:")));
                
                break;
            
            case OPCAO_JOGADOR:
                ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
                ficha.setRaca(JOptionPane.showInputDialog("Insira a raca:"));
                ficha.setClasse(JOptionPane.showInputDialog("Insira a classe:"));

                ficha.setForca(Integer.parseInt(JOptionPane.showInputDialog("Insira a forca:")));
                ficha.setDestreza(Integer.parseInt(JOptionPane.showInputDialog("Insira a destreza:")));
                ficha.setConstituicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a constituição:")));

                ficha.setInteligencia(Integer.parseInt(JOptionPane.showInputDialog("Insira a inteligência:")));
                ficha.setSabedoria(Integer.parseInt(JOptionPane.showInputDialog("Insira a sabedoria:")));
                ficha.setCarisma(Integer.parseInt(JOptionPane.showInputDialog("Insira o carisma:")));

                ficha.setLvl(Integer.parseInt(JOptionPane.showInputDialog("Insira o nível:")));
                ficha.setExp(Integer.parseInt(JOptionPane.showInputDialog("Insira a experiência:")));
                
                break;

            case OPCAO_ATRIBUTOS_ALEATORIOS:
                ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
                ficha.setRaca(JOptionPane.showInputDialog("Insira a raça:"));
                ficha.setClasse(JOptionPane.showInputDialog("Insira a classe:"));

                ficha.setForca(RoladorDeDados.executar(3, 6));
                ficha.setDestreza(RoladorDeDados.executar(3, 6));
                ficha.setConstituicao(RoladorDeDados.executar(3, 6));
                ficha.setInteligencia(RoladorDeDados.executar(3, 6));
                ficha.setSabedoria(RoladorDeDados.executar(3, 6));
                ficha.setCarisma(RoladorDeDados.executar(3, 6));

                ficha.setLvl(Integer.parseInt(JOptionPane.showInputDialog("Insira o nível:")));
                ficha.setExp(Integer.parseInt(JOptionPane.showInputDialog("Insira a experiência:")));

                break;

            default:
                ficha = null;
                
        }

        return ficha;
        
        

    }

}