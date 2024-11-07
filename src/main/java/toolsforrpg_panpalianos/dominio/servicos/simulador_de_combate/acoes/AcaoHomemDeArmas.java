package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes;

import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;

public class AcaoHomemDeArmas implements AcaoClasse{

    @Override
    public String acionar(Personagem p, Personagem i) {

        p.gastarPontoHabilidade(1);
        
        return
            p.getFicha().getNome()+" ataca duas vezes!!\n"+
            p.atacar(i)+
            p.atacar(i);
    }
    
}
