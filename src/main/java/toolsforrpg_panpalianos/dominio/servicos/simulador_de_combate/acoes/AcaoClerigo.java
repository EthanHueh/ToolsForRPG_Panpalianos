package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes;

import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;
import toolsforrpg_panpalianos.utils.RoladorDeDados;

public class AcaoClerigo implements AcaoClasse {

    @Override
    public String acionar(Personagem p, Personagem i) {  
        p.gastarPontoHabilidade(1);

        FichaJogador fichaJogador = null;
        if (p.getFicha() instanceof FichaJogador){
            fichaJogador = (FichaJogador) p.getFicha();
        } else {
            return p.getFicha().getNome()+" fez nada!";
        }
        
        int bonusLvl = fichaJogador.getLvl();
        
        if (bonusLvl > 4){
            bonusLvl = 4;
        }
        
        int hpCurado = RoladorDeDados.executar(1,8) + bonusLvl;

        p.curar(hpCurado);

        return p.getFicha().getNome()+" usou Curar Ferimentos!! Curou "+hpCurado+"!!";
    }
    
}
