package toolsforrpg_panpalianos.dados.modelo.fichas;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

public class FichaCriatura extends Ficha {

    public final static int DADO_VIDA = 8;
    public final static int DADO_VIDA_MEDIO = 5;
    
    private int classeArmadura;
    private int jogadaDeProtecao;
    private int baseAtaque;
    private int movimento;
    
    private int pvsAdicionais;

    private FichaCriatura() {

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
        
        private int classeArmadura  = 10;
        private int jogadaDeProtecao= 20;
        private int baseAtaque      = 0;
        private int movimento       = 9;
        
        private int pvsAdicionais   = 0;

        public static Builder novaCriatura(){
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

        public Builder classeArmadura(int classeArmadura){
            this.classeArmadura = classeArmadura;
            return this;
        }

        public Builder jogadaDeProtecao(int jogadaDeProtecao){
            this.jogadaDeProtecao = jogadaDeProtecao;
            return this;
        }

        public Builder baseDeAtaque(int baseAtaque){
            this.baseAtaque = baseAtaque;
            return this;
        }
        
        public Builder movimento(int movimento){
            this.movimento = movimento;
            return this;
        }

        public Builder pvsAdicionais(int pvsAdicionais){
            this.pvsAdicionais = pvsAdicionais;
            return this;
        }
        

        public FichaCriatura build(){
            FichaCriatura ficha = new FichaCriatura();

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

            ficha.setBaseAtaque(baseAtaque);
            ficha.setJogadaDeProtecao(jogadaDeProtecao);
            ficha.setClasseArmadura(classeArmadura);
            ficha.setMovimento(movimento);

            ficha.setPvsAdicionais(pvsAdicionais);
            ficha.setQuantPVsAtual(Calculadora.calcularPV(ficha));

            return ficha;
        }

    }

}