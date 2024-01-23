package toolsforrpg_panpalianos;

public class FichaCriatura {

    private String nome;
    private String raca;

    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;

    private int lvl;

    private String classe;
    private int exp;

    private int pvAdicional;

    private int quantDVs;
    private String quantPVs;

    public FichaCriatura() {
    }

    public FichaCriatura(String nome, String raca, int forca, int destreza, int constituicao, int inteligencia,
            int sabedoria, int carisma, int lvl, int pvAdicional) {
        this.nome = nome;
        this.raca = raca;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.lvl = lvl;
        this.pvAdicional = pvAdicional;

        this.quantDVs = lvl;
        this.quantPVs = Regras.calcularPV(this);
    }

    public FichaCriatura(String nome, String raca, int forca, int destreza, int constituicao,
            int inteligencia, int sabedoria, int carisma, int quantDVs, String classe, int exp) {
        this.nome = nome;
        this.raca = raca;
        this.classe = classe;
        this.forca = forca;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.quantDVs = quantDVs;
        this.exp = exp;

        this.quantPVs = Regras.calcularPV(this);

        
    }

    @Override
    public String toString() {

        boolean ehJogador = (classe != null);

        if(ehJogador){
            return  
                "------------------------------------------------------------"+"\n"+
                "\t"+nome+" ("+raca+")\n"+
                "\t"+"Classe: "+classe+"\n\n"+

                "PVs: "+quantPVs+"\n"+
                "FOR: "+forca+"\t"+"DES: "+destreza+"\t"+"CON: "+constituicao+"\n"+
                "INT: "+inteligencia+"\t"+"SAB: "+sabedoria+"\t"+"CAR: "+carisma+"\n"+
                "Total atributos: "+Regras.calcularSomaAtributos(this)+"\n\n"+
                
                "Nível atual: "+lvl+"\n"+
                "DVs: "+quantDVs+"\n"+
                "Exp: "+exp+"\n"+
                "------------------------------------------------------------"+"\n";
        }

        return  
            "------------------------------------------------------------"+"\n"+
            "\t"+nome+" ("+raca+")\n\n"+

            "PVs: "+quantPVs+"\n"+
            "FOR: "+forca+"\t"+"DES: "+destreza+"\t"+"CON: "+constituicao+"\n"+
            "INT: "+inteligencia+"\t"+"SAB: "+sabedoria+"\t"+"CAR: "+carisma+"\n"+
            "Total atributos: "+Regras.calcularSomaAtributos(this)+"\n\n"+
            
            "DVs: "+quantDVs+"\n"+
            "------------------------------------------------------------"+"\n";
        
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
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

    public int getPvAdicional() {
        return pvAdicional;
    }

    public void setPvAdicional(int pvAdicional) {
        this.pvAdicional = pvAdicional;
    }

}