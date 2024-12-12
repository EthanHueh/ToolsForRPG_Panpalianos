package toolsforrpg_panpalianos.dominio.servicos.homebrew;
public class GeradorTabelaPreco {

    public static String[][] executar(int preco, String nome) {
        
        String[][] tabelaPrecos = new String[5][3];
        
        tabelaPrecos[0][0] = nome;
        tabelaPrecos[0][1] = String.valueOf(preco);
        tabelaPrecos[0][2] = String.valueOf(preco);
        
        int precoAcumulado = 0;
        for (int i = 1; i < 5; i++){
            
            precoAcumulado += (preco * Math.pow(6, i));
            
            tabelaPrecos[i][0] = nome+" +"+i;
            tabelaPrecos[i][1] = String.valueOf(preco * Math.pow(6, i));
            tabelaPrecos[i][2] = String.valueOf(precoAcumulado);
        }

        return tabelaPrecos;
    }

}
