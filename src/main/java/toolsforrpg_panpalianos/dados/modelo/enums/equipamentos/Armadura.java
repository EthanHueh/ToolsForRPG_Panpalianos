package toolsforrpg_panpalianos.dados.modelo.enums.equipamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Armadura {

    NENHUM      (0,"Nenhuma",0,20, 0),
    ACOLCHOADA  (1, "Armadura acolchoada",0, 20, 1),
    COURO       (2,"Armadura de couro",0,6, 2),
    COURO_BATIDO(3,"Armadura de couro batido",0,6, 3),
    PLACAS      (6,"Armadura de placas",-2,3, 4),
    COMPLETA    (8,"Armadura completa",-3,1, 5),
    COTA_MALHA  (4,"Cota de Malha",-1,2, 6);

    private final int bonusDefesa;
    private final String nome;
    private final int reducaoMov;
    private final int bonMaxDestreza;
    private final int codigo;

    public static Armadura getArmaduraByCodigo(int codigo) {
	Armadura[] armaduras = values();

        for (Armadura armadura : armaduras) {
            if (armadura.getCodigo() == codigo){
                return armadura;
            }
        }
        return NENHUM;
	}

}
