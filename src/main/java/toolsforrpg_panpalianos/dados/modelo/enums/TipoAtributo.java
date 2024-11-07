package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAtributo {

    QUANT_PVS           (1, "PVs"),
    FORCA               (2, "Força"),
    DESTREZA            (3, "Destreza"),
    CONSTITUICAO        (4, "Constituição"),
    INTELIGENCIA        (5, "Inteligência"),
    SABEDORIA           (6, "Sabedoria"),
    CARISMA             (7, "Carisma"),
    DADO_VIDA           (8, "Dados de Vida"),
    CLASSE_DE_ARMADURA  (9, "CA"),
    JOGADA_DE_PROTECAO  (10, "JP"),
    BASE_DE_ATAQUE      (11, "BA");

    private final int codigo;
    private final String nome;

}
