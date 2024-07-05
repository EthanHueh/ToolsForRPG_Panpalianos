package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Escudo {

    NENHUM(0,"Nenhum", 0),
    BROQUEL(1,"Broquel", 1),
    ESCUDO_MADEIRA(1,"Escudo de madeira", 2),
    ESCUDO_ACO(2,"Escudo de aco", 3),
    ESCUDO_TORRE(0, "Escudo torre",4);
    
    private final int bonusDefesa;
    private final String nome;
    private final int codigo;

    Escudo(int bonusDefesa, String nome, int codigo){
        this.bonusDefesa = bonusDefesa;
        this.nome = nome;
        this.codigo = codigo;
    }

    public static Escudo getEscudoByCodigo(int codigo) {
	Escudo[] escudos = values();

        for (Escudo escudo : escudos) {
            if (escudo.getCodigo() == codigo){
                return escudo;
            }
        }
        return NENHUM;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

}
