package toolsforrpg_panpalianos.gui.opcoes;

import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.servicos.Estatisticas;
import toolsforrpg_panpalianos.gui.telas.TelaTexto;

public class OpcaoMostrarEstatisticas extends Opcao{

    public OpcaoMostrarEstatisticas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaTexto(Estatisticas.executar(FichasRepository.retornarFichasJogadores()), "Estatística");
    }

}
