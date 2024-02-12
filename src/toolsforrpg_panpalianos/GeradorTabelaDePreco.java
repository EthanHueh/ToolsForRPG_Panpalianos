package toolsforrpg_panpalianos;

import javax.swing.JOptionPane;

public class GeradorTabelaDePreco {
    
    public static String executar() {
        int preco = 0;
        
        try {
            preco = Integer.parseInt(JOptionPane.showInputDialog("Insira o preco do equipamento:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Insira um número!", null, 0);
            return null;
        }

        String nome = (JOptionPane.showInputDialog("Insira o nome do equipamento:"));
                    
        String tabelaPrecos = "Preço dos upgrades do(a): "+nome+"\n";

        int precoAcumulado = 0;
        for(int i = 0; i <= 4; i++){
            precoAcumulado += (preco * Math.pow(6, i));
            tabelaPrecos += "\t"+(preco * Math.pow(6, i))+"\n";

        }
        
        tabelaPrecos += "\nPreço acumulado do(a) "+nome+":\n"+
                        "\t"+precoAcumulado;

        return tabelaPrecos;
    }

}
