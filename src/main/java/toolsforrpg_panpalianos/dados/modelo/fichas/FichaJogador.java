package toolsforrpg_panpalianos.dados.modelo.fichas;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.TabelaClasses;
import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public class FichaJogador extends Ficha {
    
    private Classe classe;
    private Especializacao especializacao;
    private int lvl;
    private int exp;

    private FichaJogador(){

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

    public void setClasse(String string) {
        
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

    public static class Builder {

        private String nome      = "Sem nome";
        private String descricao = "Sem descricao";
        private Raca raca        = Raca.INDEFINIDO;
        private List<String> idiomas = new ArrayList<>();
        private String alinhamento = "Neutro";

        private int forca        = 0;
        private int destreza     = 0;
        private int constituicao = 0;
        private int inteligencia = 0;
        private int sabedoria    = 0;
        private int carisma      = 0;

        private int quantDVs     = 0;
        private int quantPVsAtual= 0;

        private Equipamento equipamento = new Equipamento();
        
        private Classe classe = Classe.NENHUMA;
        private Especializacao especializacao = Especializacao.NENHUMA;
        private int lvl = 0;
        private int exp = 0;

        public static Builder novoJogador(){
            return new Builder();
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao){
          this.descricao = descricao;
         return this;
        }

        public Builder raca(Raca raca){
            this.raca = raca;
            return this;
        }

        public Builder raca(String raca){
            
            raca = raca.toLowerCase();

            switch (raca){
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

            return this;
        }

        public Builder idiomas(List<String> idiomas){
            this.idiomas = idiomas;
            return this;
        }

        public Builder alinhamento(String alinhamento){
            this.alinhamento = alinhamento;
            return this;
        }

        public Builder forca(int forca){
            this.forca = forca;
            return this;
        }

        public Builder destreza(int destreza){
            this.destreza = destreza;
            return this;
        }

        public Builder constituicao(int constituicao){
            this.constituicao = constituicao;
            return this;
        }

        public Builder inteligencia(int inteligencia){
            this.inteligencia = inteligencia;
            return this;
        }

        public Builder sabedoria(int sabedoria){
            this.sabedoria = inteligencia;
            return this;
        }

        public Builder carisma(int carisma){
            this.carisma = carisma;
            return this;
        }

        public Builder quantDVs(int quantDVs){
            this.quantDVs = quantDVs;
            return this;
        }

        public Builder quantPVsAtual(int quantPVsAtual){
            this.quantPVsAtual = quantPVsAtual;
            return this;
        }

        public Builder equipamento(Equipamento equipamento){
            this.equipamento = equipamento;
            return this;
        }

        public Builder classe(Classe classe){
            this.classe = classe;
            return this;
        }

        public Builder classe(String string){
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

            return this;
        }

        public Builder especializacao(Especializacao especializacao){
            this.especializacao = especializacao;
            return this;
        }

        public Builder lvl(int lvl){
            this.lvl = lvl;
            return this;
        }

        public Builder exp(int exp){
            this.exp = exp;
            return this;
        }

        public FichaJogador build(){
            FichaJogador ficha = new FichaJogador();

            ficha.setNome(nome);
            ficha.setDescricao(descricao);
            ficha.setRaca(raca);
            ficha.setIdiomas(idiomas);
            ficha.setAlinhamento(alinhamento);

            ficha.setForca(forca);
            ficha.setDestreza(destreza);
            ficha.setConstituicao(constituicao);
            ficha.setInteligencia(inteligencia);
            ficha.setSabedoria(sabedoria);
            ficha.setCarisma(carisma);

            ficha.setQuantDVs(quantDVs);
            ficha.setQuantPVsAtual(quantPVsAtual);

            ficha.setEquipamento(equipamento);

            ficha.setClasse(classe);
            ficha.setEspecializacao(especializacao);
            ficha.setLvl(lvl);
            ficha.setExp(exp);

            ficha.setQuantDVs(Calculadora.calcularDVJogador(ficha));
            ficha.setQuantPVsAtual(Calculadora.calcularPV(ficha));

            return ficha;
        }

    }
}
