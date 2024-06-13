package toolsforrpg_panpalianos.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.repository.FichasRepository;

public class GeradorDeIniciativa {
    
    public static List<Integer> executar() {
        
        List<Integer>listaIniciativas = new ArrayList<>();

        for (FichaCriatura ficha : FichasRepository.getFichasJogadores()) {
            listaIniciativas.add(inserirIniciativa(ficha));
        }

        for (FichaCriatura ficha : FichasRepository.getFichasAvulsas()) {
            listaIniciativas.add(inserirIniciativa(ficha));
        }
        
        return listaIniciativas;
    }

    private static int inserirIniciativa(FichaCriatura ficha) {
        int iniciativa = 0;
        boolean opcaoInvalida;
        
        do{
            try {
                iniciativa = Integer.parseInt(JOptionPane.showInputDialog("Insira a iniciativa do(a) "+ficha.getNome()));
                opcaoInvalida = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número!", null, 0);
                opcaoInvalida = true;
                
            }
            
        }
        while(opcaoInvalida);
        
        return iniciativa;
    }

}
