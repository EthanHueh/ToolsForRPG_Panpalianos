package toolsforrpg_panpalianos;

import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.Fichas.FichaCriatura;
import toolsforrpg_panpalianos.Fichas.FichaJogador;

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

        switch (opcao) {

            case 1:
                return criarFichaPadrao();
            
            case 2:
                return criarFichaJogador();

            case 3:
                return criarFichaJogadorAtributosAleatorios();

            default:
                return null;                
        }
        
    }

    private static FichaCriatura criarFichaPadrao() {

        FichaCriatura ficha = new FichaCriatura();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRaca(JOptionPane.showInputDialog("Insira a raca:"));

        ficha.setForca(Integer.parseInt(JOptionPane.showInputDialog("Insira a forca:")));
        ficha.setDestreza(Integer.parseInt(JOptionPane.showInputDialog("Insira a destreza:")));
        ficha.setConstituicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a constituição:")));
        ficha.setInteligencia(Integer.parseInt(JOptionPane.showInputDialog("Insira a inteligência:")));
        ficha.setSabedoria(Integer.parseInt(JOptionPane.showInputDialog("Insira a sabedoria:")));
        ficha.setCarisma(Integer.parseInt(JOptionPane.showInputDialog("Insira o carisma:")));

        ficha.setQuantDVs(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de PVs:")));
        ficha.setPvAdicional(Integer.parseInt(JOptionPane.showInputDialog("Insira o pv adicional:")));

        return ficha;
    }

    private static FichaCriatura criarFichaJogador() {

        FichaJogador ficha = new FichaJogador();

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

        return ficha;
    }

    private static FichaCriatura criarFichaJogadorAtributosAleatorios() {

        FichaJogador ficha = new FichaJogador();

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

        return ficha;
    }

}