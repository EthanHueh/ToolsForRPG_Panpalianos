package toolsforrpg_panpalianos.dados.modelo.enums.equipamentos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Armadura {

    NENHUM      ("Nenhuma",                 0,0, 20),
    ACOLCHOADA  ("Armadura acolchoada",     1,0, 20),
    COURO       ("Armadura de couro",       2,0, 5),
    COURO_BATIDO("Armadura de couro batido",3,0, 6),
    PLACAS      ("Armadura de placas",      6,2, 3),
    COMPLETA    ("Armadura completa",       8,3, 1),
    COTA_MALHA  ("Cota de Malha",           4,1, 2);

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
