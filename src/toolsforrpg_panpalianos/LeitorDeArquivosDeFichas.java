package toolsforrpg_panpalianos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.fichas.FichaCriatura;
import toolsforrpg_panpalianos.fichas.FichaJogador;

public class LeitorDeArquivosDeFichas {
    
    static List<FichaCriatura> converteArquivoEmListaDeFichas(String pathArquivo, int tipoFicha) {

        List<FichaCriatura> fichas = new ArrayList<FichaCriatura>();

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
                        
                        int indiceQuantDVs = 8;
                        int indiceClasseArmadura = 9;
                        int indiceJogadaDeProtecao = 10;
                        int indiceBaseAtaque = 11;

                        int indicePVAdicional = 12;

                        ficha.setNome(valores[indiceNome].trim());
                        ficha.setRaca(valores[indiceRaca].trim());

                        ficha.setForca(Integer.parseInt(valores[indiceForca].trim()));
                        ficha.setDestreza(Integer.parseInt(valores[indiceDestreza].trim()));
                        ficha.setConstituicao(Integer.parseInt(valores[indiceConstituicao].trim()));
                        ficha.setInteligencia(Integer.parseInt(valores[indiceInteligencia].trim()));
                        ficha.setSabedoria(Integer.parseInt(valores[indiceSabedoria].trim()));
                        ficha.setCarisma(Integer.parseInt(valores[indiceCarisma].trim()));

                        ficha.setQuantDVs(Integer.parseInt(valores[indiceQuantDVs].trim()));
                        ficha.setClasseArmadura(Integer.parseInt(valores[indiceClasseArmadura].trim()));
                        ficha.setJogadaDeProtecao(Integer.parseInt(valores[indiceJogadaDeProtecao].trim()));
                        ficha.setBaseAtaque(Integer.parseInt(valores[indiceBaseAtaque].trim()));

                        ficha.setPvAdicional(Integer.parseInt(valores[indicePVAdicional].trim()));

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

                        FichaJogador ficha = new FichaJogador();

                        int indiceNome = 0;
                        int indiceRaca = 1;

                        int indiceForca = 2;
                        int indiceDestreza = 3;
                        int indiceConstituicao = 4;
                        int indiceInteligencia = 5;
                        int indiceSabedoria = 6;
                        int indiceCarisma = 7;
                        
                        int indiceQuantDVs = 8;
                        int indiceClasseArmadura = 9;
                        int indiceJogadaDeProtecao = 10;
                        int indiceBaseAtaque = 11;

                        int indicePVAdicional = 12;

                        int indiceClasse = 13;
                        int indiceLvl = 14;
                        int indiceExp = 15;

                        ficha.setNome(valores[indiceNome].trim());
                        ficha.setRaca(valores[indiceRaca].trim());

                        ficha.setForca(Integer.parseInt(valores[indiceForca].trim()));
                        ficha.setDestreza(Integer.parseInt(valores[indiceDestreza].trim()));
                        ficha.setConstituicao(Integer.parseInt(valores[indiceConstituicao].trim()));
                        ficha.setInteligencia(Integer.parseInt(valores[indiceInteligencia].trim()));
                        ficha.setSabedoria(Integer.parseInt(valores[indiceSabedoria].trim()));
                        ficha.setCarisma(Integer.parseInt(valores[indiceCarisma].trim()));

                        ficha.setQuantDVs(Integer.parseInt(valores[indiceQuantDVs].trim()));
                        ficha.setClasseArmadura(Integer.parseInt(valores[indiceClasseArmadura].trim()));
                        ficha.setJogadaDeProtecao(Integer.parseInt(valores[indiceJogadaDeProtecao].trim()));
                        ficha.setBaseAtaque(Integer.parseInt(valores[indiceBaseAtaque].trim()));

                        ficha.setPvAdicional(Integer.parseInt(valores[indicePVAdicional].trim()));
                        
                        ficha.setClasse(valores[indiceClasse].trim());
                        ficha.setLvl(Integer.parseInt(valores[indiceLvl].trim()));
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
