package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Classe {
    
    CLERIGO         ("Clerigo", 8, 5),
    HOMEM_DE_ARMAS  ("Homem de Armas", 10, 6),
    LADRAO          ("Ladrao", 6, 4),
    MAGO            ("Mago", 4, 3);

    private final String nome;
    private final int dadoVida;
    private final int dadoVidaMedio;

    public String getNome() {
        return nome;
    }

    public int getDadoVida() {
        return dadoVida;
    }

    public int getDadoVidaMedio() {
        return dadoVidaMedio;
    }

    Classe(String nome, int dadoVida, int dadoVidaMedio){
        this.nome = nome;
        this.dadoVida = dadoVida;
        this.dadoVidaMedio = dadoVidaMedio;
    }
    
}
