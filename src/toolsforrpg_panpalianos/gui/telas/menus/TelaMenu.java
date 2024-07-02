package toolsforrpg_panpalianos.gui.telas.menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.dominio.utils.ValidadorDeInputs;
import toolsforrpg_panpalianos.gui.opcoes.*;
import toolsforrpg_panpalianos.gui.telas.TelaInput;

public abstract class TelaMenu {
    
    private List<Opcao> opcoes = new ArrayList<>();
    private String titulo;

    TelaMenu(){
        construir();
        iniciar();
    }

    protected abstract void construir();

    protected void iniciar() {
        do{

            int opcao = ValidadorDeInputs.consistirInteiro(toString());

            if (getOpcao(opcao) instanceof OpcaoSair){
                if (TelaInput.desejaSair()){
                    return;
                }
            }

            executarOpcao(opcao);

        }
        while(true);
    }

    @Override
    public String toString() {
        String msg = getTitulo()+"\n";
        for (int i = 0; i < opcoes.size(); i++) {
            msg += (i+1)+" - "+opcoes.get(i).getNome()+"\n";
        }
        return msg;
    }

    public void addOpcao(Opcao opcao){
        opcoes.add(opcao);
    }

    public Opcao getOpcao(int opcao) {
        if (opcao > opcoes.size()){
            return null;
        }

        return opcoes.get(opcao - 1);
    }

    public void executarOpcao(int opcao) {
        
        if (opcao > opcoes.size()){
            JOptionPane.showMessageDialog(null, "OPÇÃO INEXISTENTE", "X", 0);
            return;
        }
        
        opcoes.get(opcao - 1).executar();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

}
