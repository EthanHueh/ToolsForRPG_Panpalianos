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
        for (Alinhamento a : Alinhamento.values()){
            if (nome.equals(a.getNome())){
                return a;
            }
        }
        return NEUTRO;
    } 
}
