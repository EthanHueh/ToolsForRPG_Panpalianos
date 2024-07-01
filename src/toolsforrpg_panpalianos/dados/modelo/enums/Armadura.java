package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Armadura {

    NENHUM      (0,0,20, 0),
    ACOLCHOADA  (1, 0, 20, 1),
    COURO       (2,0,6, 2),
    COURO_BATIDO(3,0,6, 3),
    PLACAS      (6,-2,3, 4),
    COMPLETA    (8,-3,1, 5),
    COTA_MALHA  (4,-1,2, 6);
    

    private int bonusDefesa;
    private int reducaoMov;
    private int bonMaxDestreza;
    private int codigo;

    Armadura(int bonusDefesa, int reducaoMov, int bonMaxDestreza, int codigo){
        this.bonusDefesa = bonusDefesa;
        this.reducaoMov = reducaoMov;
        this.bonMaxDestreza = bonMaxDestreza;
        this.codigo = codigo;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }

    public int getReducaoMov() {
        return reducaoMov;
    }

    public int getBonMaxDestreza() {
        return bonMaxDestreza;
    }

    public int getCodigo() {
        return codigo;
    }

	public static Armadura getArmaduraByCodigo(int codigo) {
		Armadura[] armaduras = values();

        for (Armadura armadura : armaduras) {
            if (armadura.getCodigo() == codigo){
                return armadura;
            }
        }
        return NENHUM;
	}

}
