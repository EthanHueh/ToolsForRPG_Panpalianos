package toolsforrpg_panpalianos.dados.modelo.enums;

public enum Raca {
    
    HUMANO      ("Humano",9),
    ANAO        ("Anao",6),
    ELFO        ("Elfo",9),
    HALFLING    ("Halfling",6),
    GOBLIN      ("Goblin",6);

    private final String nome;
    private final int movimento;

    public String getNome() {
        return nome;
    }

    public int getMovimento() {
        return movimento;
    }

    Raca(String nome, int movimento){
        this.nome = nome;
        this.movimento = movimento;
    }
    
}
