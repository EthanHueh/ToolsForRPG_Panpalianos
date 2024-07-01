package toolsforrpg_panpalianos.dados.modelo.fichas;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.servicos.TabelaClasses;

public class FichaJogador extends Ficha {
    
    private Classe classe;
    private Especializacao especializacao;
    private int lvl;
    private int exp;

    public FichaJogador(){

    }

    @Override
    public String toString() {

        return  
            "------------------------------------------------------------"+"\n"+
            "\t"+getNome()+" ("+getRaca().getNome()+")\n"+
            "\t"+"Classe: "+classe.getNome()+"\n\n"+

            "PVs: "+Calculadora.calcularPV(this)+"\n"+
            "FOR: "+getForca()+"\t"+"DES: "+getDestreza()+"\t"+"CON: "+getConstituicao()+"\n"+
            "INT: "+getInteligencia()+"\t"+"SAB: "+getSabedoria()+"\t"+"CAR: "+getCarisma()+"\n"+
            "Total atributos: "+Calculadora.calcularSomaAtributos(this)+"\n\n"+

            "CA: "+getClasseArmadura()+"\n"+
            "JP: "+getJogadaProtecao()+"\n"+
            "DVs: "+getQuantDVs()+"\n"+
            "BA: "+getBaseAtaque()+"\n\n"+
            
            "Nível atual: "+lvl+"\n"+
            "Exp: "+exp+"\n"+
            "------------------------------------------------------------"+"\n";

    }

    @Override
    public int getClasseArmadura() {
        return Calculadora.calcularClasseArmadura(this);
    }

    @Override
    public int getJogadaProtecao() {
        return TabelaClasses.getJogadaProtecao(this);
    }

    @Override
    public int getBaseAtaque() {
        return Calculadora.calcularBaseAtaque(this);
    }

    @Override
    public int getMovimento() {
        return getRaca().getMovimento();
    }

    public void setClassePorString(String string) {
        
        string = string.toLowerCase();

        switch (string){
            case "clerigo":
                this.classe = Classe.CLERIGO;
                break;

            case "ladrao":
                this.classe = Classe.LADRAO;
                break;

            case "homem_de_armas":
                this.classe = Classe.HOMEM_DE_ARMAS;
                break;

            case "mago":
                this.classe = Classe.MAGO;
                break;

            default:
                this.classe = Classe.CLERIGO;
        }
        
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
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

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }
}
