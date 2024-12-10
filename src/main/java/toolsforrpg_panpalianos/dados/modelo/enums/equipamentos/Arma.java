package toolsforrpg_panpalianos.dados.modelo.enums.equipamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Arma {
    DESARMADO   ("Desarmado",1, false),
    ADAGA       ("Adaga",4,false),
    ARCO_LONGO  ("Arco longo",8,true),
    CAJADO      ("Cajado",6,false),
    LANCA_CURTA ("Lanca curta",6,false),
    MACHADO     ("Machado",6,false),
    MANGUAL     ("Mangual",8,false);
    
    private final String nome;
    private final int dadoDano;
    private final boolean isDistancia;

    public static Arma getArma(String nome) {
        for (Arma a : Arma.values()){
            if (nome.equals(a.getNome())){
                return a;
            }
        }
        return DESARMADO;
    }
    
}
