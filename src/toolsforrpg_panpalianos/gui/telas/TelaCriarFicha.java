package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class TelaCriarFicha {
    
    public static FichaCriatura criarFichaCriatura() {
        
        FichaCriatura ficha = new FichaCriatura();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRacaPorString(JOptionPane.showInputDialog("Insira a raca:"));

        ficha.setForca(TelaInput.obterInteiro("Insira a forca:"));
        ficha.setDestreza(TelaInput.obterInteiro("Insira a destreza:"));
        ficha.setConstituicao(TelaInput.obterInteiro("Insira a constituição:"));
        ficha.setInteligencia(TelaInput.obterInteiro("Insira a inteligência:"));
        ficha.setSabedoria(TelaInput.obterInteiro("Insira a sabedoria:"));
        ficha.setCarisma(TelaInput.obterInteiro("Insira o carisma:"));

        ficha.setQuantDVs(TelaInput.obterInteiro("Insira a quantidade de DVs:"));
        ficha.setClasseArmadura(TelaInput.obterInteiro("Insira a classe de armadura:"));
        ficha.setJogadaDeProtecao(TelaInput.obterInteiro("Insira a jogada de proteção:"));
        ficha.setBaseAtaque(TelaInput.obterInteiro("Insira a base de ataque:"));
        ficha.setPvsAdicionais(TelaInput.obterInteiro("Insira o PV adicional:"));

        return ficha;
    }

    public static Ficha criarFichaJogador() {

        FichaJogador ficha = new FichaJogador();

        ficha.setNome(JOptionPane.showInputDialog("Insira o nome:"));
        ficha.setRacaPorString(JOptionPane.showInputDialog("Insira a raca:"));
        
        ficha.setForca(TelaInput.obterInteiro("Insira a forca:"));
        ficha.setDestreza(TelaInput.obterInteiro("Insira a destreza:"));
        ficha.setConstituicao(TelaInput.obterInteiro("Insira a constituição:"));
        ficha.setInteligencia(TelaInput.obterInteiro("Insira a inteligência:"));
        ficha.setSabedoria(TelaInput.obterInteiro("Insira a sabedoria:"));
        ficha.setCarisma(TelaInput.obterInteiro("Insira o carisma:"));

        ficha.setClassePorString(JOptionPane.showInputDialog("Insira a classe:"));
        ficha.setLvl(TelaInput.obterInteiro("Insira o nível:"));
        ficha.setExp(TelaInput.obterInteiro("Insira a experiência:"));

        ficha.setQuantDVs(Calculadora.calcularDVJogador(ficha));

        return ficha;
    }

    public static Ficha criarFichaAtributosAleatorios() {

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
        ficha.setLvl(TelaInput.obterInteiro("Insira o nível:"));
        ficha.setExp(TelaInput.obterInteiro("Insira a experiência:"));

        ficha.setQuantDVs(Calculadora.calcularDVJogador(ficha));
        
        return ficha;
    }

}
