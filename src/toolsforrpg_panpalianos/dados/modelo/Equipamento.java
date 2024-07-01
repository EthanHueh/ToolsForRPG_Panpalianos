package toolsforrpg_panpalianos.dados.modelo;

import toolsforrpg_panpalianos.dados.modelo.enums.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.Escudo;

public class Equipamento {
    private Arma arma =         Arma.DESARMADO;
    private Armadura armadura = Armadura.NENHUM;
    private Escudo escudo =     Escudo.NENHUM;

    @Override
    public String toString(){
        return new StringBuilder()
            .append("Equipamento:\n")
            .append("Arma: "+arma.getNome()+"\n")
            .append("Armadura: "+armadura.getNome()+"\n")
            .append("Escudo: "+escudo.getNome()+"\n")
            .toString();
    }

    public int getBonusDefesa() {
        return armadura.getBonusDefesa() + escudo.getBonusDefesa();
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public void setArmadura(int codigo) {
        this.armadura = Armadura.getArmaduraByCodigo(codigo);
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

    public void setEscudo(int codigo) {
        this.escudo = Escudo.getEscudoByCodigo(codigo);
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setArma(int codigo) {
        this.arma = Arma.getArmaByCodigo(codigo);
    }
}
