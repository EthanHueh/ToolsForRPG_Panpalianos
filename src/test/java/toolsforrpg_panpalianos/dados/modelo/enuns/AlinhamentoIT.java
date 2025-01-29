package toolsforrpg_panpalianos.dados.modelo.enuns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toolsforrpg_panpalianos.dados.modelo.enums.Alinhamento;

public class AlinhamentoIT {
    @Test
    public void testGetAlinhamento(){
        System.out.println("getAlinhamento");

        assertEquals(Alinhamento.NEUTRO, Alinhamento.getAlinhamento("Neutro"));
        assertEquals(Alinhamento.NEUTRO, Alinhamento.getAlinhamento("neutro"));

        assertEquals(Alinhamento.NEUTRO, Alinhamento.getAlinhamento(""));
        assertEquals(Alinhamento.NEUTRO, Alinhamento.getAlinhamento(null));
    }
}
