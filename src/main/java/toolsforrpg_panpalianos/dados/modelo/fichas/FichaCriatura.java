package toolsforrpg_panpalianos.dados.modelo.fichas;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Alinhamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;

@Getter
@Setter
public class FichaCriatura extends Ficha {

    public final static int DADO_VIDA = 8;
    public final static int DADO_VIDA_MEDIO = 5;
    
    private int classeArmadura;
    private int jogadaDeProtecao;
    private int baseAtaque;
    private int movimento;
    
    private int quantDVs;
    private int pvsAdicionais;

    private FichaCriatura() {
        
    }

    @Override
    public int getJogadaProtecao() {
        return jogadaDeProtecao;
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

        private int quantDVs     = 1;
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
            if (nome != null){
                this.nome = nome;
            }
            return this;
        }

        public Builder descricao(String descricao){
            if (descricao != null){
                this.descricao = descricao;
            }
            return this;
        }

        public Builder raca(Raca raca){
            if (raca != null){
                this.raca = raca;
            }   
            return this;
        }

        public Builder raca(String raca){
            this.raca = Raca.getRaca(raca);
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
            if (alinhamento != null){
                this.alinhamento = alinhamento;
            }
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
            if (equipamento != null){
                this.equipamento = equipamento;
            }
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

            return ficha;
        }

    }

}