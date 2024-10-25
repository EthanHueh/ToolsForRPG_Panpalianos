package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes;

import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;

public class AcaoNula implements AcaoClasse{

    @Override
    public String acionar(Personagem p, Personagem i) {
        return p.getFicha().getNome()+" fez nada!";
    }
    
}
