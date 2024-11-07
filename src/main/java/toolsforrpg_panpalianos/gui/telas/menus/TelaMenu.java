package toolsforrpg_panpalianos.gui.telas.menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import toolsforrpg_panpalianos.gui.GerenciadorTelas;

import toolsforrpg_panpalianos.gui.opcoes.*;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class TelaMenu {
    
    private List<Opcao> opcoes = new ArrayList<>();
    private String titulo;

    TelaMenu(){
        
    }

    public void iniciar() {
        
        do {
            int opcao = TelaInput.obterInteiro(toString(), titulo);

            if (opcao > opcoes.size()){
                JOptionPane.showMessageDialog(null, "Opcao Inexistente!");
                iniciar();
                return;
            }

            if (getOpcao(opcao) instanceof OpcaoSair){
                if (TelaInput.desejaSair()){
                    GerenciadorTelas.telaMenuPrincipal.iniciar();
                    return;
                }
            }

            executarOpcao(opcao);
        }
        while(true);
        

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

    @Override
    public String toString() {
        String msg = "";
        for (int i = 0; i < opcoes.size(); i++) {
            msg += (i+1)+" - "+opcoes.get(i).getNome()+"\n";
        }
        return msg;
    }
    
    public List<Opcao> getOpcoes(){
        return opcoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}