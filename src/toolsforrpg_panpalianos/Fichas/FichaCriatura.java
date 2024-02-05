package toolsforrpg_panpalianos.fichas;

public class FichaCriatura {

    private String nome;
    private String raca;

    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;

    private int quantDVs;
    private int classeArmadura;
    private int jogadaDeProtecao;
    private int baseAtaque;

    private int pvAdicional;

    private int quantPVs;
    private int quantPVsMaximo;

    public FichaCriatura(){

    }
    
    @Override
    public String toString() {

        return  
            "------------------------------------------------------------"+"\n"+
            "\t"+nome+" ("+raca+")\n\n"+

            "PVs: "+quantPVs+"/"+quantPVsMaximo+"\n"+
            "FOR: "+forca+"\t"+"DES: "+destreza+"\t"+"CON: "+constituicao+"\n"+
            "INT: "+inteligencia+"\t"+"SAB: "+sabedoria+"\t"+"CAR: "+carisma+"\n"+
            "Total atributos: "+calcularSomaAtributos(this)+"\n\n"+
            
            "CA: "+classeArmadura+"\n"+
            "JP: "+jogadaDeProtecao+"\n"+
            "DVs: "+quantDVs+"\n"+
            "BA: "+baseAtaque+"\n"+
            "------------------------------------------------------------"+"\n";
        
    }

    public static int calcularSomaAtributos(FichaCriatura f) {
        return  f.getForca() + f.getDestreza() + f.getConstituicao() +
                f.getInteligencia() + f.getSabedoria() + f.getCarisma();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getQuantDVs() {
        return quantDVs;
    }

    public void setQuantDVs(int quantDVs) {
        this.quantDVs = quantDVs;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public int getJogadaDeProtecao() {
        return jogadaDeProtecao;
    }

    public void setJogadaDeProtecao(int jogadaDeProtecao) {
        this.jogadaDeProtecao = jogadaDeProtecao;
    }

    public int getBaseAtaque() {
        return baseAtaque;
    }

    public void setBaseAtaque(int baseAtaque) {
        this.baseAtaque = baseAtaque;
    }

    public int getPvAdicional() {
        return pvAdicional;
    }

    public void setPvAdicional(int pvAdicional) {
        this.pvAdicional = pvAdicional;
    }

    public int getQuantPVs() {
        return quantPVs;
    }

    public void setQuantPVs(int quantPVs) {
        this.quantPVs = quantPVs;
    }

    public int getQuantPVsMaximo() {
        return quantPVsMaximo;
    }

    public void setQuantPVsMaximo(int quantPVsMaximo) {
        this.quantPVsMaximo = quantPVsMaximo;
    }

}