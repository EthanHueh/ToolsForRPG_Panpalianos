package toolsforrpg_panpalianos.dominio.servicos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArquivos {
    
    public static void salvarArquivo(String str, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
        writer.close();
  }
}
