package toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.acoes;

import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.simulador_de_combate.Personagem;

public class AcaoMago implements AcaoClasse {

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
        
        int quantMissil = Math.round(fichaJogador.getLvl() / 3);
        
        int dano = quantMissil + bonusLvl;
        int danoRecebido = i.tomarDano(dano);

        return p.getFicha().getNome()+" usou missil, "+i.getFicha().getNome()+" recebeu "+danoRecebido+" de dano!";
    }
    
}
