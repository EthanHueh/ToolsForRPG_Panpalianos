package toolsforrpg_panpalianos.view.menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import toolsforrpg_panpalianos.view.menus.opcoes.Opcao;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoAbrirMenuFichas;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoAbrirMenuIniciativa;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoCriarFicha;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoGerarIniciativa;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoGerarTabelaPreco;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoIniciarSimuladorCombate;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoMostrarEstatisticas;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoMostrarFichas;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoMostrarJogadores;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoSair;
import toolsforrpg_panpalianos.view.menus.opcoes.OpcaoVerIniciativa;

public class Menu {
    
    private List<Opcao> opcoes = new ArrayList<>();
    private String titulo;

    public Menu() {
        
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

    public static Menu criarMenuPrincipal() {
        Menu menu = new Menu();
        menu.setTitulo("RPG OLD DRAGON");
        menu.opcoes.add(new OpcaoMostrarJogadores("Mostrar fichas dos jogadores"));
        menu.opcoes.add(new OpcaoMostrarFichas("Mostrar fichas avulsas"));
        menu.opcoes.add(new OpcaoAbrirMenuFichas("Criar ficha avulsa"));
        menu.opcoes.add(new OpcaoGerarTabelaPreco("Cálculo de Preço Equipamento"));
        menu.opcoes.add(new OpcaoAbrirMenuIniciativa("Gerenciar Iniciativa"));
        menu.opcoes.add(new OpcaoIniciarSimuladorCombate("Simular combate"));
        menu.opcoes.add(new OpcaoMostrarEstatisticas("Mostrar estatísticas"));
        menu.opcoes.add(new OpcaoSair());
        return menu;
    }

    public static Menu criarMenuIniciativa(){
        Menu menu = new Menu();
        menu.setTitulo("Menu Iniciativa");
        menu.opcoes.add(new OpcaoGerarIniciativa("Gerar iniciativas"));
        menu.opcoes.add(new OpcaoVerIniciativa("Ver iniciativas"));
        menu.opcoes.add(new OpcaoSair());
        return menu;
    }

    public static Menu criarMenuDeFichas(){
        Menu menu = new Menu();
        menu.setTitulo("Menu de criacao de fichas");
        menu.opcoes.add(new OpcaoCriarFicha("Ficha padrão", 1));
        menu.opcoes.add(new OpcaoCriarFicha("Ficha de jogador", 2));
        menu.opcoes.add(new OpcaoCriarFicha("Ficha com atributos aleatórios",3));
        menu.opcoes.add(new OpcaoSair());
        return menu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
