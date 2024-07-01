package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Escudo {

    NENHUM(0, 0),
    BROQUEL(1, 1),
    ESCUDO_MADEIRA(1, 2),
    ESCUDO_ACO(2, 3),
    ESCUDO_TORRE(0, 4);
    

    private int bonusDefesa;
    private int codigo;

    Escudo(int bonusDefesa, int codigo){
        this.bonusDefesa = bonusDefesa;
        this.codigo = codigo;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }

    public int getCodigo() {
        return codigo;
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

}
