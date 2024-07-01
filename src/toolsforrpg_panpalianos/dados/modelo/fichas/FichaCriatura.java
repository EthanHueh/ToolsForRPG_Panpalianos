package toolsforrpg_panpalianos.dados.modelo.fichas;

public class FichaCriatura extends Ficha {

    public final static int DADO_VIDA = 8;
    public final static int DADO_VIDA_MEDIO = 5;
    
    private int classeArmadura;
    private int jogadaDeProtecao;
    private int baseAtaque;
    private int movimento;
    
    private int pvsAdicionais = 0;
    
    public FichaCriatura(){
 
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