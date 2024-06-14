package toolsforrpg_panpalianos.controller;

import toolsforrpg_panpalianos.repository.FichasRepository;
import toolsforrpg_panpalianos.service.Estatisticas;
import toolsforrpg_panpalianos.service.RegrasHomebrew;

public class ControllerCalculos {

    public static String gerarTabelaDePreco(int preco, String nome) {
        return RegrasHomebrew.gerarTabelaDePreco(preco, nome);
    }

    public static String gerarEstatisticas() {
        return Estatisticas.executar(FichasRepository.getFichasJogadores());
    }
    
}
