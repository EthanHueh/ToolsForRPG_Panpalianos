package toolsforrpg_panpalianos.dados.modelo.enums.equipamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Armadura {

    NENHUM      ("Nenhuma",0,20, 0),
    ACOLCHOADA  ("Armadura acolchoada",0, 20, 1),
    COURO       ("Armadura de couro",0,6, 2),
    COURO_BATIDO("Armadura de couro batido",0,6, 3),
    PLACAS      ("Armadura de placas",-2,3, 4),
    COMPLETA    ("Armadura completa",-3,1, 5),
    COTA_MALHA  ("Cota de Malha",-1,2, 6);

    private final String nome;
    private final int bonusDefesa;
    private final int reducaoMov;
    private final int bonMaxDestreza;

    public static Armadura getArmadura(String nome) {
        for (Armadura a : Armadura.values()){
            if (nome.equals(a.getNome())){
                return a;
            }
        }
        return NENHUM;
    }

}
