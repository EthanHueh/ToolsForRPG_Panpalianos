package toolsforrpg_panpalianos.dados.modelo.fichas;

import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public class FichaCriatura extends Ficha {

    public final static int DADO_VIDA = 8;
    public final static int DADO_VIDA_MEDIO = 5;
    
    private int classeArmadura  = 10;
    private int jogadaDeProtecao= 20;
    private int baseAtaque      = 0;
    private int movimento       = 9;
    
    private int pvsAdicionais   = 0;
    
    public FichaCriatura(){
 
    }

    @Override
    public String toString() {

        return new StringBuilder()
            .append("------------------------------------------------------------\n")
            .append("\t"+getNome()+" ("+getRaca().getNome()+")\n\n")

            .append("PVs: "+Calculadora.calcularPV(this)+"/"+Calculadora.calcularPVMaximo(this)+"\n")
            .append("PVs Adicionais: "+pvsAdicionais+"\n\n")
            .append("FOR: "+getForca()+"\t"+"DES: "+getDestreza()+"\t"+"CON: "+getConstituicao()+"\n")
            .append("INT: "+getInteligencia()+"\t"+"SAB: "+getSabedoria()+"\t"+"CAR: "+getCarisma()+"\n")
            .append("Total atributos: "+getSomaAtributos()+"\n\n")
            
            .append("CA: "+getClasseArmadura()+"\n")
            .append("JP: "+getJogadaProtecao()+"\n")
            .append("DVs: "+getQuantDVs()+"\n")
            .append("BA: "+getBaseAtaque()+"\n")
            .append("Movimento: "+getMovimento()+"\n")
            .append("------------------------------------------------------------\n")
            .append(getEquipamento().toString())
            .toString();
        
    }

    @Override
    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    @Override
    public int getJogadaProtecao() {
        return jogadaDeProtecao;
    }

    public void setJogadaDeProtecao(int jogadaDeProtecao) {
        this.jogadaDeProtecao = jogadaDeProtecao;
    }

    @Override
    public int getBaseAtaque() {
        return baseAtaque;
    }

    public void setBaseAtaque(int baseAtaque) {
        this.baseAtaque = baseAtaque;
    }

    @Override
    public int getMovimento() {
        return movimento;
    }

    public void setMovimento(int movimento) {
        this.movimento = movimento;
    }

    public int getJogadaDeProtecao() {
        return jogadaDeProtecao;
    }

    public int getPvsAdicionais() {
        return pvsAdicionais;
    }

    public void setPvsAdicionais(int pvsAdicionais) {
        this.pvsAdicionais = pvsAdicionais;
    }

}