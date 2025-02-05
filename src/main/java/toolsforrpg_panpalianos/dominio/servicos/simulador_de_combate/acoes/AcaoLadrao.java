package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes;

import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;
import toolsforrpg_panpalianos.utils.RoladorDeDados;

public class AcaoLadrao implements AcaoClasse {

    @Override
    public String acionar(Personagem p, Personagem i) {
       p.gastarPontoHabilidade(1);
       int pocoesEncontradas = RoladorDeDados.executar(1,2);
       
       p.adicionarPocoes(pocoesEncontradas);
       
       return p.getFicha().getNome()+" obteve "+pocoesEncontradas+"!!!";
    }
    
}
