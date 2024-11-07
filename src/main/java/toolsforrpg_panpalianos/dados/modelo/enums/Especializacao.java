package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Especializacao {
    NENHUMA("Nenhuma", Classe.NENHUMA),
    
    CACADOR("Caçador", Classe.CLERIGO),
    CULTISTA("Cultista", Classe.CLERIGO),
    DRUIDA("Druida", Classe.CLERIGO),

    BARBARO("Barbaro", Classe.HOMEM_DE_ARMAS),
    GUERREIRO("Guerreiro", Classe.HOMEM_DE_ARMAS),
    PALADINO("Paladino",Classe.HOMEM_DE_ARMAS),

    ASSASINO("Assassino", Classe.LADRAO),
    BARDO("Bardo", Classe.LADRAO),
    RANGER("Ranger",Classe.LADRAO),

    ILUSIONISTA("Ilusionista",Classe.MAGO),
    NECROMANTE("Necromante",Classe.MAGO),
    ADIVINHADOR("Adivinhador",Classe.MAGO);

    private final String nome;
    private final Classe classe;

}
