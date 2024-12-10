package toolsforrpg_panpalianos.dominio.servicos.arquivos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Alinhamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Escudo;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class LeitorDeArquivos {

    public static List<FichaCriatura> lerArquivoFichasCriatura(String pathArquivo) {

        List<FichaCriatura> fichas = new ArrayList<>();

        try (FileReader reader = new FileReader(pathArquivo)) {

            for (JsonElement jElement : JsonParser.parseReader(reader).getAsJsonArray()) {
                
                JsonObject j = jElement.getAsJsonObject();
                
                FichaCriatura f = new FichaCriatura.Builder()
                    .nome               (j.get("nome").getAsString())
                    .descricao          (j.get("descricao").getAsString())
                    .raca               (Raca.valueOf(j.get("raca").getAsString()))
                    .classeArmadura     (j.get("classeArmadura").getAsInt())
                    .jogadaDeProtecao   (j.get("jogadaDeProtecao").getAsInt())
                    .baseDeAtaque       (j.get("baseAtaque").getAsInt())
                    .movimento          (j.get("movimento").getAsInt())
                    .pvsAdicionais      (j.get("pvsAdicionais").getAsInt())
                    .alinhamento        (Alinhamento.valueOf(j.get("alinhamento").getAsString()))
                    .forca              (j.get("forca").getAsInt())
                    .destreza           (j.get("destreza").getAsInt())
                    .constituicao       (j.get("constituicao").getAsInt())
                    .inteligencia       (j.get("inteligencia").getAsInt())
                    .sabedoria          (j.get("sabedoria").getAsInt())
                    .carisma            (j.get("carisma").getAsInt())
                    .quantDVs           (j.get("quantDVs").getAsInt())
                    .quantPVsAtual      (j.get("quantPVsAtual").getAsInt())
                    .idiomas            (
                        deserializarIdiomas(j.get("idiomas").getAsJsonArray())
                    )    
                    .equipamento        (
                        deserializarEquipamento(j.get("equipamento").getAsJsonObject())  
                    )  
                .build();

                fichas.add(f);

            }
        } catch (IOException e){
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return fichas;     

    }

    public static List<FichaJogador> lerArquivoFichasJogador(String pathArquivo) {

        List<FichaJogador> fichas = new ArrayList<>();

        try (FileReader reader = new FileReader(pathArquivo)) {

            for (JsonElement jElement : JsonParser.parseReader(reader).getAsJsonArray()) {
                
                JsonObject j = jElement.getAsJsonObject();
                
                FichaJogador f = new FichaJogador.Builder()
                    .nome               (j.get("nome").getAsString())
                    .descricao          (j.get("descricao").getAsString())
                    .raca               (Raca.valueOf(j.get("raca").getAsString()))
                    .alinhamento        (Alinhamento.valueOf(j.get("alinhamento").getAsString()))
                    .forca              (j.get("forca").getAsInt())
                    .destreza           (j.get("destreza").getAsInt())
                    .constituicao       (j.get("constituicao").getAsInt())
                    .inteligencia       (j.get("inteligencia").getAsInt())
                    .sabedoria          (j.get("sabedoria").getAsInt())
                    .carisma            (j.get("carisma").getAsInt())
                    .quantDVs           (j.get("quantDVs").getAsInt())
                    .quantPVsAtual      (j.get("quantPVsAtual").getAsInt())
                    .lvl                (j.get("lvl").getAsInt())
                    .exp                (j.get("exp").getAsInt())
                    .classe             (Classe.valueOf(j.get("classe").getAsString()))
                    .especializacao     (Especializacao.valueOf(j.get("especializacao").getAsString()))
                    .idiomas            (
                        deserializarIdiomas(j.get("idiomas").getAsJsonArray())
                    )
                    .equipamento        (
                        deserializarEquipamento(j.get("equipamento").getAsJsonObject())  
                    )  
                .build();

                fichas.add(f);
            }
        } catch (IOException e){
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return fichas;  

    }

    private static Equipamento deserializarEquipamento(JsonObject j) {
        return new Equipamento(
            Arma.valueOf(j.get("arma").getAsString()),
            Armadura.valueOf(j.get("armadura").getAsString()),
            Escudo.valueOf(j.get("escudo").getAsString())
        );
    }

    private static List<Idioma> deserializarIdiomas(JsonArray j){
        List<String> palavras = j.asList().stream()
            .map(JsonElement::getAsString)
            .collect(Collectors.toList());

        List<Idioma> idiomas = new ArrayList<>();
        for (String palavra : palavras) {
            idiomas.add(Idioma.valueOf(palavra));
        }
        return idiomas;
    }
}