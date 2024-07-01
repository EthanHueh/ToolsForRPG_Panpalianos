package toolsforrpg_panpalianos.dados.modelo;

import toolsforrpg_panpalianos.dados.modelo.enums.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.Escudo;

public class Equipamento {
    private Armadura armadura;
    private Escudo escudo;
    private Arma arma;

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
