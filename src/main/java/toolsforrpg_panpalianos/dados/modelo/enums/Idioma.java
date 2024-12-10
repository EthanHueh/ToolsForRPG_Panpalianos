package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Idioma {
    COMUM       ("Comum"),
    ANAO        ("Anao"),
    ELFICO      ("Elfico"),
    SILVESTRE   ("Silvestre");
    
    private final String nome;

    public static Idioma getIdioma(String nome){
        for (Idioma i : Idioma.values()){
            if (nome.equals(i.getNome())){
                return i;
            }
        }
        return COMUM;
    } 
}
