package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Escudo {

    NENHUM(0,"Nenhum", 0),
    BROQUEL(1,"Broquel", 1),
    ESCUDO_MADEIRA(1,"Escudo de madeira", 2),
    ESCUDO_ACO(2,"Escudo de aco", 3),
    ESCUDO_TORRE(0, "Escudo torre",4);
    
    private final int bonusDefesa;
    private final String nome;
    private final int codigo;

    public static Escudo getEscudoByCodigo(int codigo) {
	Escudo[] escudos = values();

        for (Escudo escudo : escudos) {
            if (escudo.getCodigo() == codigo){
                return escudo;
            }
        }
        return NENHUM;
    }

}
