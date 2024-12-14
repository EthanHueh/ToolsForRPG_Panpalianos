package toolsforrpg_panpalianos.dados.modelo.fichas;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Alinhamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.enums.Raca;
import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;

@Getter
@Setter
public abstract class Ficha {

    private String nome      = "Sem nome";
    private String descricao = "Sem descricao";
    private Raca raca        = Raca.INDEFINIDO;
    private List<Idioma> idiomas;
    private Alinhamento alinhamento;

    private int forca        = 0;
    private int destreza     = 0;
    private int constituicao = 0;
    private int inteligencia = 0;
    private int sabedoria    = 0;
    private int carisma      = 0;

    private int quantDVs     = 0;
    private int quantPVsAtual= 0;

    private Equipamento equipamento = new Equipamento();

    protected Ficha(){
        
    }

    public int getSomaAtributos(){
        return Calculadora.calcularSomaAtributos(this);
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

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public void setRaca(String string) {
        this.raca = Raca.getRaca(string);
    }

    @Override
    public String toString() {
        return nome+", "+raca.getNome();
    }

}