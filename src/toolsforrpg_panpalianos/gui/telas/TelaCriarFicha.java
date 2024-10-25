package toolsforrpg_panpalianos.gui.telas;

import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class TelaCriarFicha {
    
    public static FichaCriatura criarFichaCriatura() {

        FichaCriatura ficha = FichaCriatura.Builder.novaCriatura()
            .nome(JOptionPane.showInputDialog("Insira o nome:"))
            .raca(JOptionPane.showInputDialog("Insira a raca:"))
            .forca(TelaInput.obterInteiro("Insira a forca:"))
            .destreza(TelaInput.obterInteiro("Insira a destreza:"))
            .constituicao(TelaInput.obterInteiro("Insira a constituição:"))
            .inteligencia(TelaInput.obterInteiro("Insira a inteligência:"))
            .sabedoria(TelaInput.obterInteiro("Insira a sabedoria:"))
            .carisma(TelaInput.obterInteiro("Insira o carisma:"))
            .quantDVs(TelaInput.obterInteiro("Insira a quantidade de DVs:"))
            .classeArmadura(TelaInput.obterInteiro("Insira a classe de armadura:"))
            .jogadaDeProtecao(TelaInput.obterInteiro("Insira a jogada de proteção:"))
            .baseDeAtaque(TelaInput.obterInteiro("Insira a base de ataque:"))
            .pvsAdicionais(TelaInput.obterInteiro("Insira o PV adicional:"))
        .build();

        return ficha;
    }

    public static Ficha criarFichaJogador() {

        return FichaJogador.Builder.novoJogador()
            .nome(JOptionPane.showInputDialog("Insira o nome:"))
            .raca(JOptionPane.showInputDialog("Insira a raca:"))
            .forca(TelaInput.obterInteiro("Insira a forca:"))
            .destreza(TelaInput.obterInteiro("Insira a destreza:"))
            .constituicao(TelaInput.obterInteiro("Insira a constituição:"))
            .inteligencia(TelaInput.obterInteiro("Insira a inteligência:"))
            .sabedoria(TelaInput.obterInteiro("Insira a sabedoria:"))
            .carisma(TelaInput.obterInteiro("Insira o carisma:"))
            .classe(JOptionPane.showInputDialog("Insira a classe:"))
            .lvl(TelaInput.obterInteiro("Insira o nível:"))
            .exp(TelaInput.obterInteiro("Insira a experiência:"))
        .build();

    }

    public static Ficha criarFichaAtributosAleatorios() {

        return FichaJogador.Builder.novoJogador()
            .nome(JOptionPane.showInputDialog("Insira o nome:"))
            .raca(JOptionPane.showInputDialog("Insira a raca:"))
            .forca(RoladorDeDados.executar(3, 6))
            .destreza(RoladorDeDados.executar(3, 6))
            .constituicao(RoladorDeDados.executar(3, 6))
            .inteligencia(RoladorDeDados.executar(3, 6))
            .sabedoria(RoladorDeDados.executar(3, 6))
            .carisma(RoladorDeDados.executar(3, 6))
            .classe(JOptionPane.showInputDialog("Insira a classe:"))
            .lvl(TelaInput.obterInteiro("Insira o nível:"))
            .exp(TelaInput.obterInteiro("Insira a experiência:"))
        .build();
    }

}
