package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Arma {
    DESARMADO   (0,1, false),
    ADAGA       (1,4,false),
    ARCO_LONGO  (2,8,true),
    CAJADO      (3,6,false),
    LANCA_CURTA (4,6,false),
    MACHADO     (5,6,false),
    MANGUAL     (6,8,false);
    

    private int codigo;
    private int dadoDano;
    private boolean isDistancia;

    private Arma(int codigo, int dadoDano, boolean isDistancia) {
        this.codigo = codigo;
        this.dadoDano = dadoDano;
        this.isDistancia = isDistancia;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public int getDadoDano() {
        return dadoDano;
    }

    public boolean isDistancia() {
        return isDistancia;
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

}
