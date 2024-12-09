package toolsforrpg_panpalianos.dados.modelo.enums.equipamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Escudo {

    NENHUM(0,"Nenhum"),
    BROQUEL(1,"Broquel"),
    ESCUDO_MADEIRA(1,"Escudo de madeira"),
    ESCUDO_ACO(2,"Escudo de aco"),
    ESCUDO_TORRE(0, "Escudo torre");
    
    private final int bonusDefesa;
    private final String nome;

    public static Escudo getEscudo(String escudo) {
        for (Escudo e : Escudo.values()){
            if (escudo.equals(e.getNome())){
                return e;
            }
        }
        return NENHUM;
    }

}
