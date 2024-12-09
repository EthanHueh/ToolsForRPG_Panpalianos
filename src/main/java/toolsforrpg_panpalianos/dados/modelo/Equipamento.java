package toolsforrpg_panpalianos.dados.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Arma;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.equipamentos.Escudo;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento {
    private Arma arma =         Arma.DESARMADO;
    private Armadura armadura = Armadura.NENHUM;
    private Escudo escudo =     Escudo.NENHUM;

    public Equipamento(String arma, String armadura, String escudo){
        setArma(arma);
        setArmadura(armadura);
        setEscudo(escudo);
    }

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

    public void setArma(String nome) {
        this.arma = Arma.getArma(nome);
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setArmadura(String nome) {
        this.armadura = Armadura.getArmadura(nome);
    }

    public void setArmadura(Armadura armadura) {
        this.armadura = armadura;
    }

    public void setEscudo(String nome) {
        this.escudo = Escudo.getEscudo(nome);
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }

}
