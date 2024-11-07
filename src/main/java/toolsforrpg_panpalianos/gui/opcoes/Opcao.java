package toolsforrpg_panpalianos.gui.opcoes;

public abstract class Opcao {

    private String nome;

    public Opcao(String nome){
        setNome(nome);
    }

    public abstract void executar();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
