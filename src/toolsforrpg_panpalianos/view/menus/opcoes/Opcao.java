package toolsforrpg_panpalianos.view.menus.opcoes;

public abstract class Opcao {

    private String nome;

    public Opcao(String nome){
        this.nome = nome;
    }

    public abstract void executar();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
