package toolsforrpg_panpalianos.view.menus.opcoes;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.controller.ControllerFichas;
import toolsforrpg_panpalianos.controller.ControllerIniciativas;
import toolsforrpg_panpalianos.model.fichas.FichaCriatura;
import toolsforrpg_panpalianos.utils.ValidadorDeInputs;

public class OpcaoGerarIniciativa extends Opcao{

    public OpcaoGerarIniciativa(String nome) {
        super(nome);
    }

    @Override
    public void executar() {

        ValidadorDeInputs valInp = new ValidadorDeInputs();

        List<FichaCriatura> fichas = new ArrayList<>();
        fichas.addAll(ControllerFichas.getFichasJogadores());
        fichas.addAll(ControllerFichas.getFichasAvulsas());

        for (FichaCriatura ficha : fichas) {
            int iniciativa = valInp.consistirInteiro("Insira a iniciativa do(a) "+ficha.getNome());
            ControllerIniciativas.adicionar(iniciativa);
        }
    }
    
}
