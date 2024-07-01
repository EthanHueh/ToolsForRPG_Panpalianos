package toolsforrpg_panpalianos.dados.modelo.fichas;

import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Armadura;
import toolsforrpg_panpalianos.dados.modelo.enums.Escudo;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public abstract class Ficha {

    private String nome;
    private String descricao;
    private Raca raca;
    private List<String> idiomas;
    private String alinhamento;

    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;

    private int quantDVs;
    private int quantPVsAtual;

    private Equipamento equipamento = new Equipamento();

    public Ficha(){
        equipamento.setArmadura(Armadura.NENHUM);
        equipamento.setEscudo(Escudo.NENHUM);
    }
    
    @Override
    public String toString() {

        return  
            "------------------------------------------------------------"+"\n"+
            "\t"+nome+" ("+raca.getNome()+")\n\n"+

            "PVs: "+Calculadora.calcularPV(this)+"/"+Calculadora.calcularPVMaximo(this)+"\n"+
            "FOR: "+forca+"\t"+"DES: "+destreza+"\t"+"CON: "+constituicao+"\n"+
            "INT: "+inteligencia+"\t"+"SAB: "+sabedoria+"\t"+"CAR: "+carisma+"\n"+
            "Total atributos: "+Calculadora.calcularSomaAtributos(this)+"\n\n"+
            
            "CA: "+getClasseArmadura()+"\n"+
            "JP: "+getJogadaProtecao()+"\n"+
            "DVs: "+quantDVs+"\n"+
            "BA: "+getBaseAtaque()+"\n"+
            "------------------------------------------------------------"+"\n";
        
    }

    public abstract int getClasseArmadura();
    public abstract int getJogadaProtecao();
    public abstract int getBaseAtaque();
    public abstract int getMovimento();

    public int getAtributoByTipo(TipoAtributo opcao) {

        switch (opcao) {

            case QUANT_PVS:
                return Calculadora.calcularPV(this);
            
            case FORCA:
                return getForca();
                
            case DESTREZA:
                return getDestreza();
                
            case CONSTITUICAO:
                return getConstituicao();
                
            case INTELIGENCIA:
                return getInteligencia();
                
            case SABEDORIA:
                return getSabedoria();
                
            case CARISMA:
                return getCarisma();
                
            case DADO_VIDA:
                return getQuantDVs();
                
            case CLASSE_DE_ARMADURA:
                return getClasseArmadura();
                
            case JOGADA_DE_PROTECAO:
                return getJogadaProtecao();
                
            case BASE_DE_ATAQUE:
                return getBaseAtaque();

            default:
                return 0;
                
        }
    }

    public void setRacaPorString(String string) {
        
        string = string.toLowerCase();

        switch (string){
            case "humano":
                this.raca = Raca.HUMANO;
                break;

            case "anao":
                this.raca = Raca.ANAO;
                break;

            case "halfling":
                this.raca = Raca.HALFLING;
                break;

            case "elfo":
                this.raca = Raca.ELFO;
                break;

            case "goblin":
                this.raca = Raca.GOBLIN;
                break;

            default:
                this.raca = Raca.INDEFINIDO;
        }
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public String getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
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

    public int getQuantPVsAtual() {
        return quantPVsAtual;
    }

    public void setQuantPVsAtual(int quantPVsAtual) {
        this.quantPVsAtual = quantPVsAtual;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

}