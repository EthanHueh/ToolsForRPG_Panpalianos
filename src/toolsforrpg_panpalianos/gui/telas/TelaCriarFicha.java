package toolsforrpg_panpalianos.gui.telas;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;

public class TelaCriarFicha {
    
    public static FichaCriatura criarFichaPadrao() {

        FichaCriatura ficha = new FichaCriatura();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRacaPorString(JOptionPane.showInputDialog("Insira a raca:"));

        ficha.setForca(ValidadorDeInputs.consistirInteiro("Insira a forca:"));
        ficha.setDestreza(ValidadorDeInputs.consistirInteiro("Insira a destreza:"));
        ficha.setConstituicao(ValidadorDeInputs.consistirInteiro("Insira a constituição:"));
        ficha.setInteligencia(ValidadorDeInputs.consistirInteiro("Insira a inteligência:"));
        ficha.setSabedoria(ValidadorDeInputs.consistirInteiro("Insira a sabedoria:"));
        ficha.setCarisma(ValidadorDeInputs.consistirInteiro("Insira o carisma:"));

        ficha.setQuantDVs(ValidadorDeInputs.consistirInteiro("Insira a quantidade de DVs:"));
        ficha.setClasseArmadura(ValidadorDeInputs.consistirInteiro("Insira a classe de armadura:"));
        ficha.setJogadaDeProtecao(ValidadorDeInputs.consistirInteiro("Insira a jogada de proteção:"));
        ficha.setBaseAtaque(ValidadorDeInputs.consistirInteiro("Insira a base de ataque:"));
        ficha.setPvsAdicionais(ValidadorDeInputs.consistirInteiro("Insira o PV adicional:"));

        return ficha;
    }

    public static Ficha criarFichaJogador() {

        FichaJogador ficha = new FichaJogador();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRacaPorString(JOptionPane.showInputDialog("Insira a raca:"));
        
        ficha.setForca(ValidadorDeInputs.consistirInteiro("Insira a forca:"));
        ficha.setDestreza(ValidadorDeInputs.consistirInteiro("Insira a destreza:"));
        ficha.setConstituicao(ValidadorDeInputs.consistirInteiro("Insira a constituição:"));
        ficha.setInteligencia(ValidadorDeInputs.consistirInteiro("Insira a inteligência:"));
        ficha.setSabedoria(ValidadorDeInputs.consistirInteiro("Insira a sabedoria:"));
        ficha.setCarisma(ValidadorDeInputs.consistirInteiro("Insira o carisma:"));

        ficha.setClassePorString(JOptionPane.showInputDialog("Insira a classe:"));
        ficha.setLvl(ValidadorDeInputs.consistirInteiro("Insira o nível:"));
        ficha.setExp(ValidadorDeInputs.consistirInteiro("Insira a experiência:"));

        ficha.setQuantDVs(Calculadora.calcularDVJogador(ficha));

        return ficha;
    }

    public static Ficha criarFichaJogadorAtributosAleatorios() {

        FichaJogador ficha = new FichaJogador();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRacaPorString(JOptionPane.showInputDialog("Insira a raça:"));

        ficha.setForca(RoladorDeDados.executar(3, 6));
        ficha.setDestreza(RoladorDeDados.executar(3, 6));
        ficha.setConstituicao(RoladorDeDados.executar(3, 6));
        ficha.setInteligencia(RoladorDeDados.executar(3, 6));
        ficha.setSabedoria(RoladorDeDados.executar(3, 6));
        ficha.setCarisma(RoladorDeDados.executar(3, 6));

        ficha.setClassePorString(JOptionPane.showInputDialog("Insira a classe:"));
        ficha.setLvl(ValidadorDeInputs.consistirInteiro("Insira o nível:"));
        ficha.setExp(ValidadorDeInputs.consistirInteiro("Insira a experiência:"));

        ficha.setQuantDVs(Calculadora.calcularDVJogador(ficha));
        
        return ficha;
    }

}
