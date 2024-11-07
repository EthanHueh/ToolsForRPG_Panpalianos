package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Arma {
    DESARMADO   (0,"Desarmado",1, false),
    ADAGA       (1,"Adaga",4,false),
    ARCO_LONGO  (2,"Arco longo",8,true),
    CAJADO      (3,"Cajado",6,false),
    LANCA_CURTA (4,"Lanca curta",6,false),
    MACHADO     (5,"Machado",6,false),
    MANGUAL     (6,"Mangual",8,false);
    

    private final int codigo;
    private final String nome;

    private final int dadoDano;
    private final boolean isDistancia;

    private Arma(int codigo, String nome, int dadoDano, boolean isDistancia) {
        this.codigo = codigo;
        this.nome = nome;
        this.dadoDano = dadoDano;
        this.isDistancia = isDistancia;
    }

    public static Arma getArmaByCodigo(int codigo) {
		Arma[] armas = values();

        for (Arma arma : armas) {
            if (arma.getCodigo() == codigo){
                return arma;
            }
        }
        return DESARMADO;
	}
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getDadoDano() {
        return dadoDano;
    }

    public boolean isDistancia() {
        return isDistancia;
    }

}
