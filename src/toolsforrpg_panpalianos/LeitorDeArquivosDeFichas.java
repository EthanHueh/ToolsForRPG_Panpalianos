package toolsforrpg_panpalianos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivosDeFichas {
    
    static List<FichaCriatura> converteArquivoEmListaDeFichas(String pathArquivo, int tipoFicha) {

        List<FichaCriatura> fichas = new ArrayList<>();

        final int OPCAO_PADRAO = 1;
        final int OPCAO_JOGADOR = 2;
        
        switch (tipoFicha) {

            case OPCAO_PADRAO:
                try (BufferedReader br = new BufferedReader(new FileReader(pathArquivo))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        String[] valores = line.split(",");

                        FichaCriatura ficha = new FichaCriatura();

                        int indiceNome = 0;
                        int indiceRaca = 1;

                        int indiceForca = 2;
                        int indiceDestreza = 3;
                        int indiceConstituicao = 4;
                        int indiceInteligencia = 5;
                        int indiceSabedoria = 6;
                        int indiceCarisma = 7;
                        
                        int indiceLvl = 8;
                        int indicePvAdicional = 9;

                        ficha.setNome(valores[indiceNome].trim());
                        ficha.setRaca(valores[indiceRaca].trim());

                        ficha.setForca(Integer.parseInt(valores[indiceForca].trim()));
                        ficha.setDestreza(Integer.parseInt(valores[indiceDestreza].trim()));
                        ficha.setConstituicao(Integer.parseInt(valores[indiceConstituicao].trim()));
                        ficha.setInteligencia(Integer.parseInt(valores[indiceInteligencia].trim()));
                        ficha.setSabedoria(Integer.parseInt(valores[indiceSabedoria].trim()));
                        ficha.setCarisma(Integer.parseInt(valores[indiceCarisma].trim()));

                        ficha.setLvl(Integer.parseInt(valores[indiceLvl].trim()));
                        ficha.setPvAdicional(Integer.parseInt(valores[indicePvAdicional].trim()));

                        fichas.add(ficha);

                    }

                } catch (Exception e) {
                    System.out.println("Ferrou:\n" + e.getMessage());
                }

                break;


            case OPCAO_JOGADOR:
                try (BufferedReader br = new BufferedReader(new FileReader(pathArquivo))) {

                    String line;

                    while ((line = br.readLine()) != null) {
                        String[] valores = line.split(",");

                        FichaCriatura ficha = new FichaCriatura();

                        int indiceNome = 0;
                        int indiceRaca = 1;

                        int indiceForca = 2;
                        int indiceDestreza = 3;
                        int indiceConstituicao = 4;
                        int indiceInteligencia = 5;
                        int indiceSabedoria = 6;
                        int indiceCarisma = 7;
                        
                        int indiceLvl = 8;
                        int indiceClasse = 9;
                        int indiceExp = 10;

                        ficha.setNome(valores[indiceNome].trim());
                        ficha.setRaca(valores[indiceRaca].trim());

                        ficha.setForca(Integer.parseInt(valores[indiceForca].trim()));
                        ficha.setDestreza(Integer.parseInt(valores[indiceDestreza].trim()));
                        ficha.setConstituicao(Integer.parseInt(valores[indiceConstituicao].trim()));
                        ficha.setInteligencia(Integer.parseInt(valores[indiceInteligencia].trim()));
                        ficha.setSabedoria(Integer.parseInt(valores[indiceSabedoria].trim()));
                        ficha.setCarisma(Integer.parseInt(valores[indiceCarisma].trim()));

                        ficha.setLvl(Integer.parseInt(valores[indiceLvl].trim()));

                        ficha.setClasse(valores[indiceClasse].trim());
                        ficha.setExp(Integer.parseInt(valores[indiceExp].trim()));

                        fichas.add(ficha);

                    }

                } catch (Exception e) {
                    System.out.println("Ferrou:\n" + e.getMessage());
                }
                
                break;

            default:
                break;
        }

        return fichas;

    }

}
