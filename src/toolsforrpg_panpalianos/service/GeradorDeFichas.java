package toolsforrpg_panpalianos.service;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;
import toolsforrpg_panpalianos.utils.RoladorDeDados;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;

public class GeradorDeFichas {

    private static ValidadorDeInputs valInp = new ValidadorDeInputs();

    public static FichaCriatura criarNovaFicha(int opcao) {

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

        ficha.setForca(valInp.consistirInteiro("Insira a forca:"));
        ficha.setDestreza(valInp.consistirInteiro("Insira a destreza:"));
        ficha.setConstituicao(valInp.consistirInteiro("Insira a constituição:"));
        ficha.setInteligencia(valInp.consistirInteiro("Insira a inteligência:"));
        ficha.setSabedoria(valInp.consistirInteiro("Insira a sabedoria:"));
        ficha.setCarisma(valInp.consistirInteiro("Insira o carisma:"));

        ficha.setQuantDVs(valInp.consistirInteiro("Insira a quantidade de DVs:"));
        ficha.setClasseArmadura(valInp.consistirInteiro("Insira a classe de armadura:"));
        ficha.setJogadaDeProtecao(valInp.consistirInteiro("Insira a jogada de proteção:"));
        ficha.setBaseAtaque(valInp.consistirInteiro("Insira a base de ataque:"));
        ficha.setPvAdicional(valInp.consistirInteiro("Insira o PV adicional:"));

        ficha.setQuantPVs(Regras.calcularPV(ficha));

        return ficha;
    }

    private static FichaCriatura criarFichaJogador() {

        FichaJogador ficha = new FichaJogador();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRaca(JOptionPane.showInputDialog("Insira a raca:"));
        
        ficha.setForca(valInp.consistirInteiro("Insira a forca:"));
        ficha.setDestreza(valInp.consistirInteiro("Insira a destreza:"));
        ficha.setConstituicao(valInp.consistirInteiro("Insira a constituição:"));
        ficha.setInteligencia(valInp.consistirInteiro("Insira a inteligência:"));
        ficha.setSabedoria(valInp.consistirInteiro("Insira a sabedoria:"));
        ficha.setCarisma(valInp.consistirInteiro("Insira o carisma:"));

        ficha.setClasseArmadura(valInp.consistirInteiro("Insira a classe de armadura:"));
        ficha.setJogadaDeProtecao(valInp.consistirInteiro("Insira a jogada de proteção:"));
        ficha.setBaseAtaque(valInp.consistirInteiro("Insira a base de ataque:"));

        ficha.setClasse(JOptionPane.showInputDialog("Insira a classe:"));
        ficha.setLvl(valInp.consistirInteiro("Insira o nível:"));
        ficha.setExp(valInp.consistirInteiro("Insira a experiência:"));

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
        ficha.setLvl(valInp.consistirInteiro("Insira o nível:"));
        ficha.setExp(valInp.consistirInteiro("Insira a experiência:"));

        ficha.setQuantDVs(Regras.calcularDVJogador(ficha));
        ficha.setQuantPVs(Regras.calcularPV(ficha));
        
        return ficha;
    }

}