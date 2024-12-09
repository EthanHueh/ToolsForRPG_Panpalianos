package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Raca {
    
    INDEFINIDO  ("Indefinido", 9),
    HUMANO      ("Humano",9),
    ANAO        ("Anao",6),
    ELFO        ("Elfo",9),
    HALFLING    ("Halfling",6),
    GOBLIN      ("Goblin",6);
    
    private final String nome;
    private final int movimento;

    public static Raca getRaca(String nome){
        for (Raca r : Raca.values()){
            if (nome.equals(r.getNome())){
                return r;
            }
        }
        return INDEFINIDO;
    } 

}
