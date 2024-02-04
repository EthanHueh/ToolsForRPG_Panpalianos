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
            
            int iniciativa = 0;

            boolean opcaoInvalida;

            do{
                try {
                    iniciativa = Integer.parseInt(JOptionPane.showInputDialog("Insira a iniciativa do(a) "+ficha.getNome()));
                    opcaoInvalida = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Insira um número, sua mula!", null, 0);
                    opcaoInvalida = true;
                    
                }
                
            }
            while(opcaoInvalida);

            listaIniciativas.add(iniciativa);
        }

        for (FichaCriatura ficha : fichasAvulsas) {

            int iniciativa = 0;

            boolean opcaoInvalida;

            do{
                try {
                    iniciativa = Integer.parseInt(JOptionPane.showInputDialog("Insira a iniciativa do(a) "+ficha.getNome()));
                    opcaoInvalida = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Insira um número, sua mula!", null, 0);
                    opcaoInvalida = true;
                }
                
            }
            while(opcaoInvalida);

            listaIniciativas.add(iniciativa);
        }
        
        return listaIniciativas;
    }


}
