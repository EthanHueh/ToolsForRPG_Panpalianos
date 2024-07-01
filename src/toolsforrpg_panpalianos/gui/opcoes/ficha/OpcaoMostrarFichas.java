package toolsforrpg_panpalianos.gui.opcoes.ficha;

import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.opcoes.Opcao;
import toolsforrpg_panpalianos.gui.telas.TelaFichas;

public class OpcaoMostrarFichas extends Opcao {

    public OpcaoMostrarFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        TelaFichas.mostrarFichas(FichasRepository.retornarFichasAvulsas());
    }
    
}
