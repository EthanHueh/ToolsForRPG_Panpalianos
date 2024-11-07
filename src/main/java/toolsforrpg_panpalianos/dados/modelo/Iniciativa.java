package toolsforrpg_panpalianos.dados.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

@Getter
@Setter
@AllArgsConstructor
public class Iniciativa {
    private int iniciativa;
    private Ficha ficha;

    @Override
    public String toString(){
        if (ficha instanceof FichaJogador){
            return ficha.getNome()+" (Jogador): "+iniciativa;
        } else {
            return ficha.getNome()+" (PDM): "+iniciativa;
        }
    }
}
