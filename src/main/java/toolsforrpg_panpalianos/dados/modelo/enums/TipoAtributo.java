package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAtributo {

    QUANT_PVS           ("PVs"),
    FORCA               ("Força"),
    DESTREZA            ("Destreza"),
    CONSTITUICAO        ("Constituição"),
    INTELIGENCIA        ("Inteligência"),
    SABEDORIA           ("Sabedoria"),
    CARISMA             ("Carisma"),
    DADO_VIDA           ("Dados de Vida"),
    CLASSE_DE_ARMADURA  ("CA"),
    JOGADA_DE_PROTECAO  ("JP"),
    BASE_DE_ATAQUE      ("BA");

    private final String nome;

}
