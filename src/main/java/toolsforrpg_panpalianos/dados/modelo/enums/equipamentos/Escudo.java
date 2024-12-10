package toolsforrpg_panpalianos.dados.modelo.enums.equipamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Escudo {

    NENHUM("Nenhum",0),
    BROQUEL("Broquel", 1),
    ESCUDO_MADEIRA("Escudo de madeira",1),
    ESCUDO_ACO("Escudo de aco", 2),
    ESCUDO_TORRE("Escudo torre",0);
    
    private final String nome;
    private final int bonusDefesa;

    public static Escudo getEscudo(String nome) {
        for (Escudo e : Escudo.values()){
            if (nome.equals(e.getNome())){
                return e;
            }
        }
        return NENHUM;
    }

}
