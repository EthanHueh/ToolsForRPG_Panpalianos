package toolsforrpg_panpalianos.dados.modelo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Alinhamento {
    NEUTRO      ("Neutro"),
    ORDEIRO     ("Ordeiro"),
    CAOTICO     ("Caotico");
    
    private final String nome;

    public static Alinhamento getAlinhamento(String nome){
        if (nome == null){
            return NEUTRO;
        }

        for (Alinhamento a : Alinhamento.values()){
            if (a.getNome().equalsIgnoreCase(nome)){
                return a;
            }
        }
        return NEUTRO;
    } 
}
