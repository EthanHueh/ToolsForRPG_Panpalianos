package toolsforrpg_panpalianos.gui.opcoes.ficha;

import java.util.ArrayList;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoMostrarJogadores extends Opcao {

    public OpcaoMostrarJogadores(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaFichas.mostrarFichas(new ArrayList<Ficha>(FichasRepository.retornarFichasJogadores()));
    }

}
