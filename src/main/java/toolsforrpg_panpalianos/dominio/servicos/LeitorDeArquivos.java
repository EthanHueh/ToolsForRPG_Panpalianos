package toolsforrpg_panpalianos.dominio.servicos;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class LeitorDeArquivos {

    public static List<FichaCriatura> lerArquivoFichasCriatura(String pathArquivo) {

        List<FichaCriatura> fichas = new ArrayList<>();

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 

        try (FileReader reader = new FileReader(pathArquivo)) {
            Type fichaListType = new TypeToken<List<FichaCriatura>>() {}.getType();
            fichas = gson.fromJson(reader, fichaListType);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        for (Ficha f: fichas){
            InicializadorFicha.inicializar(f);
        }

        return fichas;     

    }

    public static List<FichaJogador> lerArquivoFichasJogador(String pathArquivo) {

        List<FichaJogador> fichas = new ArrayList<>();

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 

        try (FileReader reader = new FileReader(pathArquivo)) {
            Type fichaListType = new TypeToken<List<FichaJogador>>() {}.getType();
            fichas = gson.fromJson(reader, fichaListType);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        for (Ficha f: fichas){
            InicializadorFicha.inicializar(f);
        }

        return fichas;    

    }

}
