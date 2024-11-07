package toolsforrpg_panpalianos.dados.modelo;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class Iniciativa {
    private int iniciativa;
    private Ficha ficha;

    public Iniciativa(int iniciativa, Ficha ficha) {
        this.iniciativa = iniciativa;
        this.ficha = ficha;
    }

    @Override
    public String toString(){
        if (ficha instanceof FichaJogador){
            return ficha.getNome()+" (Jogador): "+iniciativa;
        } else {
            return ficha.getNome()+" (PDM): "+iniciativa;
        }
    }
    
    public int getIniciativa() {
        return iniciativa;
    }
    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }
    public Ficha getFicha() {
        return ficha;
    }
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}
