package toolsforrpg_panpalianos.controller;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.model.fichas.FichaJogador;
import toolsforrpg_panpalianos.repository.FichasRepository;
import toolsforrpg_panpalianos.service.Estatisticas;
import toolsforrpg_panpalianos.service.Regras;
import toolsforrpg_panpalianos.service.RegrasHomebrew;

public class ControllerCalculos {

    public static String gerarTabelaDePreco(int preco, String nome) {
        return RegrasHomebrew.gerarTabelaDePreco(preco, nome);
    }

    public static String gerarEstatisticas() {
        return Estatisticas.executar(FichasRepository.getFichasJogadores());
    }

    public static int calcularPV(FichaCriatura ficha) {
        return Regras.calcularPV(ficha);
    }

    public static int calcularDVJogador(FichaJogador ficha) {
        return Regras.calcularDVJogador(ficha);
    }

    public static int calcularBonus(int atributo) {
        return Regras.calcularBonus(atributo);
    }
    
}
