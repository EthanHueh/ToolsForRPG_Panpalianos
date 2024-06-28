package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Classe {
    
    CLERIGO         ("Clerigo", 8, 5),
    HOMEM_DE_ARMAS  ("Homem de Armas", 10, 6),
    LADRAO          ("Ladrao", 6, 4),
    MAGO            ("Mago", 4, 3);

    private final String nome;
    private final int DADO_VIDA;
    private final int DADO_VIDA_MEDIO;

    public String getNome() {
        return nome;
    }

    public int getDadoVida() {
        return DADO_VIDA;
    }

    public int getDadoVidaMedio() {
        return DADO_VIDA_MEDIO;
    }

    Classe(String nome, int DADO_VIDA, int DADO_VIDA_MEDIO){
        this.nome = nome;
        this.DADO_VIDA = DADO_VIDA;
        this.DADO_VIDA_MEDIO = DADO_VIDA_MEDIO;
    }
    
}
