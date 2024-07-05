package toolsforrpg_panpalianos.dominio.servicos;

public class RegrasHomebrew {

    public static String[][] gerarTabelaDePreco(int preco, String nome) {
        
        String[][] tabelaPrecos = new String[5][3];
        
        int precoAcumulado = preco;
        
        tabelaPrecos[0][0] = nome;
        tabelaPrecos[0][1] = String.valueOf(preco);
        tabelaPrecos [0][2] = String.valueOf(precoAcumulado);
        
        for(int i = 1; i < 5; i++){
            
            tabelaPrecos[i][0] = nome+" +"+i;
            tabelaPrecos[i][1] = String.valueOf(preco * Math.pow(6, i));
            precoAcumulado += (preco * Math.pow(6, i));
            tabelaPrecos [i][2] = String.valueOf(precoAcumulado);
            
        }

        return tabelaPrecos;
    }

}
