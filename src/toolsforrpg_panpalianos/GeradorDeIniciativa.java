package toolsforrpg_panpalianos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;

public class GeradorDeIniciativa {
    
    public static List<Integer> executar(List<FichaJogador> fichasJogadores, List<FichaCriatura> fichasAvulsas) {
        
        List<Integer>listaIniciativas = new ArrayList<>();

        for (FichaCriatura ficha : fichasJogadores) {
            listaIniciativas.add(inserirIniciativa(ficha));
        }

        for (FichaCriatura ficha : fichasAvulsas) {
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
