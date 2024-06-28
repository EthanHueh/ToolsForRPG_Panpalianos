package toolsforrpg_panpalianos.gui.menus.opcoes;

import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.TelaMostrarFichas;

public class OpcaoMostrarFichas extends Opcao {

    public OpcaoMostrarFichas(String nome) {
        super(nome);
    }

    @Override
    public void executar() {
        new TelaMostrarFichas(FichasRepository.retornarFichasAvulsas());
    }
    
}
