package toolsforrpg_panpalianos.service;

public class RegrasHomebrew {

    public static String gerarTabelaDePreco(int preco, String nome) {

        int precoAcumulado = 0;
                    
        String tabelaPrecos = "Preço dos upgrades do(a): "+nome+"\n";
        for(int i = 0; i <= 4; i++){
            precoAcumulado += (preco * Math.pow(6, i));
            tabelaPrecos += (preco * Math.pow(6, i))+"\n";

        }
        
        tabelaPrecos += "\nPreço acumulado do(a) "+nome+":\n"+
                        precoAcumulado;

        return tabelaPrecos;
    }

}
