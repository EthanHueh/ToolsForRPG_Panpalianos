package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Arma {
    DESARMADO   (0,"Desarmado",1, false),
    ADAGA       (1,"Adaga",4,false),
    ARCO_LONGO  (2,"Arco longo",8,true),
    CAJADO      (3,"Cajado",6,false),
    LANCA_CURTA (4,"Lanca curta",6,false),
    MACHADO     (5,"Machado",6,false),
    MANGUAL     (6,"Mangual",8,false);
    
    private final int codigo;
    private final String nome;
    private final int dadoDano;
    private final boolean isDistancia;

    public static Arma getArmaByCodigo(int codigo) {
		Arma[] armas = values();

        for (Arma arma : armas) {
            if (arma.getCodigo() == codigo){
                return arma;
            }
        }
        return DESARMADO;
	}
    
}
