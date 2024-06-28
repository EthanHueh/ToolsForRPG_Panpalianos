package toolsforrpg_panpalianos.gui.menus.opcoes;

import java.util.ArrayList;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.TelaMostrarFichas;

public class OpcaoMostrarJogadores extends Opcao {

    public OpcaoMostrarJogadores(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
       new TelaMostrarFichas(new ArrayList<Ficha>(FichasRepository.retornarFichasJogadores()));
    }

}
