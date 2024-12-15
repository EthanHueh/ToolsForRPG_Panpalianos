package toolsforrpg_panpalianos.dados.modelo.fichas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Alinhamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dados.modelo.tabelas.TabelaClasses;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

@Getter
@Setter
public class FichaJogador extends Ficha {
    
    private Classe classe;
    private Especializacao especializacao;
    private int lvl;
    private int exp;

    private FichaJogador(){

    }

    @Override
    public String toString() {
        return super.toString()+" "+classe.getNome();
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

    @Override
    public int getQuantDVs() {
        return Calculadora.calcularDVJogador(this);
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
        
    public static class Builder {

        private String nome      = "Sem nome";
        private String descricao = "Sem descricao";
        private Raca raca        = Raca.INDEFINIDO;
        private List<Idioma> idiomas = new ArrayList<>();
        private Alinhamento alinhamento = Alinhamento.NEUTRO;

        private int forca        = 0;
        private int destreza     = 0;
        private int constituicao = 0;
        private int inteligencia = 0;
        private int sabedoria    = 0;
        private int carisma      = 0;

        private int quantPVsAtual= 0;

        private Equipamento equipamento = new Equipamento();
        
        private Classe classe = Classe.NENHUMA;
        private Especializacao especializacao = Especializacao.NENHUMA;
        private int lvl = 1;
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
            if (raca != null){
                this.raca = raca;
            }   
            return this;
        }

        public Builder raca(String nome){
            this.raca = Raca.getRaca(nome);
            return this;
        }

        public Builder idiomas(List<Idioma> idiomas){
            if (idiomas != null){
                this.idiomas = idiomas;    
            }
            return this;
        }

        public Builder alinhamento(String nome){
            this.alinhamento = Alinhamento.getAlinhamento(nome);
            return this;
        }

        public Builder alinhamento(Alinhamento alinhamento){
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

        public Builder quantPVsAtual(int quantPVsAtual){
            this.quantPVsAtual = quantPVsAtual;
            return this;
        }

        public Builder equipamento(Equipamento equipamento){
            if (equipamento != null){
                this.equipamento = equipamento;
            }
            return this;
        }

        public Builder classe(Classe classe){
            if (classe != null){
                this.classe = classe;
            }
            return this;
        }

        public Builder classe(String nome){
            this.classe = Classe.getClasse(nome);
            return this;
        }

        public Builder especializacao(Especializacao especializacao){
            if (especializacao != null){
                this.especializacao = especializacao;
            }
            return this;
        }

        public Builder especializacao(String nome){
            this.especializacao = Especializacao.getEspecializacao(nome);
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

            ficha.setQuantPVsAtual(quantPVsAtual);

            ficha.setEquipamento(equipamento);

            ficha.setClasse(classe);
            ficha.setEspecializacao(especializacao);
            ficha.setLvl(lvl);
            ficha.setExp(exp);

            return ficha;
        }

    }
}
