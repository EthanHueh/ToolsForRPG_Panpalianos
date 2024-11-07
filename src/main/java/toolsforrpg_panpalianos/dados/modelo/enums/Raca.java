package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Raca {
    
    HUMANO      ("Humano",9),
    ANAO        ("Anao",6),
    ELFO        ("Elfo",9),
    HALFLING    ("Halfling",6),
    GOBLIN      ("Goblin",6),
    INDEFINIDO  ("Indefinido", 9);

    private final String nome;
    private final int movimento;

}
