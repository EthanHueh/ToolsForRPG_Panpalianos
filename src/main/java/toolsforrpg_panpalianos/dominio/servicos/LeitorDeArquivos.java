package toolsforrpg_panpalianos.dominio.servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
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

                for (int i = 0; i < valores.length; i++){
                    valores[i] = valores[i].trim();
                }

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

                FichaCriatura ficha = FichaCriatura.Builder.novaCriatura()
                    .nome(valores[indiceNome])
                    .raca(valores[indiceRaca])
                    .forca(Integer.parseInt(valores[indiceForca]))
                    .destreza(Integer.parseInt(valores[indiceDestreza]))
                    .constituicao(Integer.parseInt(valores[indiceConstituicao]))
                    .inteligencia(Integer.parseInt(valores[indiceInteligencia]))
                    .sabedoria(Integer.parseInt(valores[indiceSabedoria]))
                    .carisma(Integer.parseInt(valores[indiceCarisma]))
                    .quantDVs(Integer.parseInt(valores[indiceQuantDVs]))
                    .classeArmadura(Integer.parseInt(valores[indiceClasseArmadura]))
                    .jogadaDeProtecao(Integer.parseInt(valores[indiceJogadaDeProtecao]))
                    .baseDeAtaque(Integer.parseInt(valores[indiceBaseAtaque]))
                    .pvsAdicionais(Integer.parseInt(valores[indicePVAdicional]))
                .build();

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

                for (int i = 0; i < valores.length; i++){
                    valores[i] = valores[i].trim();
                }

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

                Equipamento eq = new Equipamento();
                eq.setArmadura(Armadura.getArmaduraByCodigo(Integer.parseInt(valores[indiceArmadura])));
                eq.setEscudo(Escudo.getEscudoByCodigo(Integer.parseInt(valores[indiceEscudo])));
                eq.setArma(Arma.getArmaByCodigo(Integer.parseInt(valores[indiceArma])));

                FichaJogador ficha = FichaJogador.Builder.novoJogador()
                    .nome(valores[indiceNome])
                    .raca(valores[indiceRaca])
                    .forca(Integer.parseInt(valores[indiceForca]))
                    .destreza(Integer.parseInt(valores[indiceDestreza]))
                    .constituicao(Integer.parseInt(valores[indiceConstituicao]))
                    .inteligencia(Integer.parseInt(valores[indiceInteligencia]))
                    .sabedoria(Integer.parseInt(valores[indiceSabedoria]))
                    .carisma(Integer.parseInt(valores[indiceCarisma]))
                    .equipamento(eq)
                    .classe(valores[indiceClasse])
                    .lvl(Integer.parseInt(valores[indiceLvl]))
                    .exp(Integer.parseInt(valores[indiceExp]))           
                .build();

                fichas.add(ficha);

            }

        } catch (Exception e) {
            System.out.println("Falha na conversao de fichas de jogador:\n" + e.getMessage());
        }

        return fichas;

    }

}