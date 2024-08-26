package toolsforrpg_panpalianos.dominio.servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.enums.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.Escudo;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class LeitorDeArquivos {
    
    public static List<FichaCriatura> lerArquivoFichasCriatura(String pathArquivo) {

        List<FichaCriatura> fichas = new ArrayList<>();

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
                ficha.setRacaPorString(valores[indiceRaca].trim());

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
                ficha.setPvsAdicionais(Integer.parseInt(valores[indicePVAdicional].trim()));
                ficha.setQuantPVsAtual(Calculadora.calcularPV(ficha));

                fichas.add(ficha);

            }

        } catch (Exception e) {
            System.out.println("Falha na conversao de fichas padrao:\n" + e.getMessage());
        }

        return fichas;

    }

    public static List<FichaJogador> lerArquivoFichasJogador(String pathArquivo) {

        List<FichaJogador> fichas = new ArrayList<>();

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

                int indiceClasse = 8;
                int indiceLvl = 9;
                int indiceExp = 10;

                int indiceArmadura = 11;
                int indiceEscudo = 12;

                int indiceArma = 13;

                ficha.setNome(valores[indiceNome].trim());
                ficha.setRacaPorString(valores[indiceRaca].trim());

                ficha.setForca(Integer.parseInt(valores[indiceForca].trim()));
                ficha.setDestreza(Integer.parseInt(valores[indiceDestreza].trim()));
                ficha.setConstituicao(Integer.parseInt(valores[indiceConstituicao].trim()));
                ficha.setInteligencia(Integer.parseInt(valores[indiceInteligencia].trim()));
                ficha.setSabedoria(Integer.parseInt(valores[indiceSabedoria].trim()));
                ficha.setCarisma(Integer.parseInt(valores[indiceCarisma].trim()));
                
                ficha.setClassePorString(valores[indiceClasse].trim());
                ficha.setLvl(Integer.parseInt(valores[indiceLvl].trim()));
                ficha.setExp(Integer.parseInt(valores[indiceExp].trim()));

                ficha.getEquipamento().setArmadura(Armadura.getArmaduraByCodigo(Integer.parseInt(valores[indiceArmadura].trim())));
                ficha.getEquipamento().setEscudo(Escudo.getEscudoByCodigo(Integer.parseInt(valores[indiceEscudo].trim())));
                ficha.getEquipamento().setArma(Arma.getArmaByCodigo(Integer.parseInt(valores[indiceArma].trim())));

                ficha.setQuantDVs(Calculadora.calcularDVJogador(ficha));
                ficha.setQuantPVsAtual(Calculadora.calcularPV(ficha));
                
                fichas.add(ficha);

            }

        } catch (Exception e) {
            System.out.println("Falha na conversao de fichas de jogador:\n" + e.getMessage());
        }

        return fichas;

    }

}