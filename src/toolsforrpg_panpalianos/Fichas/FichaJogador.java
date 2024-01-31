package toolsforrpg_panpalianos.Fichas;

import toolsforrpg_panpalianos.Regras;

public class FichaJogador extends FichaCriatura{
    
    private String classe;
    private int lvl;
    private int exp;

    public FichaJogador(){
        super();
    }

    @Override
    public String toString() {

        return  
            "------------------------------------------------------------"+"\n"+
            "\t"+getNome()+" ("+getRaca()+")\n"+
            "\t"+"Classe: "+classe+"\n\n"+

            "PVs: "+Regras.calcularPVJogador(this)+"\n"+
            "FOR: "+getForca()+"\t"+"DES: "+getDestreza()+"\t"+"CON: "+getConstituicao()+"\n"+
            "INT: "+getInteligencia()+"\t"+"SAB: "+getSabedoria()+"\t"+"CAR: "+getCarisma()+"\n"+
            "Total atributos: "+calcularSomaAtributos(this)+"\n\n"+

            "CA: "+getClasseArmadura()+"\n"+
            "JP: "+getJogadaDeProtecao()+"\n"+
            "DVs: "+getQuantDVs()+"\n"+
            "BA: "+getBaseAtaque()+"\n"+
            
            "Nível atual: "+lvl+"\n"+
            "DVs: "+getQuantDVs()+"\n"+
            "Exp: "+exp+"\n"+
            "------------------------------------------------------------"+"\n";

    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    
}
