package toolsforrpg_panpalianos;

import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;

//TODO colocar programa para pedir o resto dos atributos novos 
public class GeradorDeFichas {

    public static List<FichaCriatura> subMenu(List<FichaCriatura> fichasAvulsas) {
        
        String  msgFicha =
            "Escolha a opcao:\n\n"+

            "1 - Ficha padrão\n"+
            "2 - Ficha de jogador\n"+
            "3 - Ficha com atributos aleatórios\n\n"+
            "4 - Sair\n";

        do{

            int opcao = 0;

            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(msgFicha));
            
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número!", "X", 0);
                
            }

            boolean opcaoValida = (opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4); 

            if(opcaoValida){
                fichasAvulsas.add(criarNovaFicha(opcao));
                
                return fichasAvulsas;
            }

        }
        while(true);

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

        ficha.setQuantDVs(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de DVs:")));
        ficha.setClasseArmadura(Integer.parseInt(JOptionPane.showInputDialog("Insira a classe de armadura:")));
        ficha.setJogadaDeProtecao(Integer.parseInt(JOptionPane.showInputDialog("Insira a jogada de proteção:")));
        ficha.setBaseAtaque(Integer.parseInt(JOptionPane.showInputDialog("Insira a base de ataque:")));
        ficha.setPvAdicional(Integer.parseInt(JOptionPane.showInputDialog("Insira o PV adicional:")));

        ficha.setQuantPVs(Regras.calcularPV(ficha));

        return ficha;
    }

    private static FichaCriatura criarFichaJogador() {

        FichaJogador ficha = new FichaJogador();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRaca(JOptionPane.showInputDialog("Insira a raca:"));
        
        ficha.setForca(Integer.parseInt(JOptionPane.showInputDialog("Insira a forca:")));
        ficha.setDestreza(Integer.parseInt(JOptionPane.showInputDialog("Insira a destreza:")));
        ficha.setConstituicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a constituição:")));
        ficha.setInteligencia(Integer.parseInt(JOptionPane.showInputDialog("Insira a inteligência:")));
        ficha.setSabedoria(Integer.parseInt(JOptionPane.showInputDialog("Insira a sabedoria:")));
        ficha.setCarisma(Integer.parseInt(JOptionPane.showInputDialog("Insira o carisma:")));

        ficha.setClasseArmadura(Integer.parseInt(JOptionPane.showInputDialog("Insira a classe de armadura:")));
        ficha.setJogadaDeProtecao(Integer.parseInt(JOptionPane.showInputDialog("Insira a jogada de proteção:")));
        ficha.setBaseAtaque(Integer.parseInt(JOptionPane.showInputDialog("Insira a base de ataque:")));

        ficha.setClasse(JOptionPane.showInputDialog("Insira a classe:"));
        ficha.setLvl(Integer.parseInt(JOptionPane.showInputDialog("Insira o nível:")));
        ficha.setExp(Integer.parseInt(JOptionPane.showInputDialog("Insira a experiência:")));

        ficha.setQuantDVs(Regras.calcularDVJogador(ficha));
        ficha.setQuantPVs(Regras.calcularPV(ficha));

        return ficha;
    }

    private static FichaCriatura criarFichaJogadorAtributosAleatorios() {

        FichaJogador ficha = new FichaJogador();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRaca(JOptionPane.showInputDialog("Insira a raça:"));

        ficha.setForca(RoladorDeDados.executar(3, 6));
        ficha.setDestreza(RoladorDeDados.executar(3, 6));
        ficha.setConstituicao(RoladorDeDados.executar(3, 6));
        ficha.setInteligencia(RoladorDeDados.executar(3, 6));
        ficha.setSabedoria(RoladorDeDados.executar(3, 6));
        ficha.setCarisma(RoladorDeDados.executar(3, 6));

        ficha.setClasseArmadura(10 + Regras.calcularBonus(ficha.getDestreza()));
        ficha.setJogadaDeProtecao(15);
        ficha.setBaseAtaque(2);

        ficha.setClasse(JOptionPane.showInputDialog("Insira a classe:"));
        ficha.setLvl(Integer.parseInt(JOptionPane.showInputDialog("Insira o nível:")));
        ficha.setExp(Integer.parseInt(JOptionPane.showInputDialog("Insira a experiência:")));

        ficha.setQuantDVs(Regras.calcularDVJogador(ficha));
        ficha.setQuantPVs(Regras.calcularPV(ficha));
        
        return ficha;
    }

}