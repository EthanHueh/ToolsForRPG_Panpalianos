package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Classe {
    
    NENHUMA         ("Nenhuma", 8, 5),
    CLERIGO         ("Clerigo", 8, 5),
    HOMEM_DE_ARMAS  ("Homem de Armas", 10, 6),
    LADRAO          ("Ladrao", 6, 4),
    MAGO            ("Mago", 4, 3);
    
    private final String nome;
    private final int dadoVida;
    private final int dadoVidaMedio;

    public static Classe getClasse(String nome){
        if (nome == null){
            return NENHUMA;
        }

        for (Classe c : Classe.values()){
            if (c.getNome().equalsIgnoreCase(nome)){
                return c;
            }
        }
        return NENHUMA;
    } 

}
