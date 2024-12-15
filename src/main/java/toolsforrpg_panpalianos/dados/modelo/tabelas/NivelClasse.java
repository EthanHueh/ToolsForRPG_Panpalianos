package toolsforrpg_panpalianos.dados.modelo.tabelas;

import lombok.Getter;

@Getter
public class NivelClasse {
    private final int nivel;
    private final int xp;
    private final int pvsAdicionais;
    private final String baseAtaque;
    private final int jogadaProtecao;

    public NivelClasse(int nivel, int xp, int pvsAdicionais, String baseAtaque, int jogadaProtecao) {
        this.nivel = nivel;
        this.xp = xp;
        this.pvsAdicionais = pvsAdicionais;
        this.baseAtaque = baseAtaque;
        this.jogadaProtecao = jogadaProtecao;
    }

}
