package toolsforrpg_panpalianos.dados.modelo.fichas;

import toolsforrpg_panpalianos.dados.modelo.TabelaClasses;
import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public class FichaJogador extends Ficha {
    
    private Classe classe;
    private Especializacao especializacao = Especializacao.NENHUMA;
    private int lvl = 0;
    private int exp = 0;

    public FichaJogador(){

    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("------------------------------------------------------------\n")
            .append("\t"+getNome()+" ("+getRaca().getNome()+")\n")
            .append("\t"+"Classe: "+classe.getNome()+"\n")
            .append("\t"+"Especializacao: "+especializacao.getNome()+"\n\n")

            .append("PVs: "+Calculadora.calcularPV(this)+"\n")
            .append("FOR: "+getForca()+"\t"+"DES: "+getDestreza()+"\t"+"CON: "+getConstituicao()+"\n")
            .append("INT: "+getInteligencia()+"\t"+"SAB: "+getSabedoria()+"\t"+"CAR: "+getCarisma()+"\n")
            .append("Total atributos: "+getSomaAtributos()+"\n\n")
        
            .append("CA: "+getClasseArmadura()+"\n")
            .append("JP: "+getJogadaProtecao()+"\n")
            .append("DVs: "+getQuantDVs()+"\n")
            .append("BA: "+getBaseAtaque()+"\n")
            .append("Movimento: "+getMovimento()+"\n\n")

            .append("Nível atual: "+lvl+"\n")
            .append("Exp: "+exp+"\n\n")
            .append("------------------------------------------------------------\n")
            .append(getEquipamento().toString())
            .append("------------------------------------------------------------\n")
            .toString();

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
        return TabelaClasses.getBaseAtaque(this);
    }

    @Override
    public int getMovimento() {
        return Calculadora.calcularMovimento(this);
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
