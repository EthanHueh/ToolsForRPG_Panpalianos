package toolsforrpg_panpalianos.dados.modelo.enuns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;

public class ClasseIT {
    @Test
    public void testGetClasse(){
        System.out.println("getClasse");

        assertEquals(Classe.CLERIGO, Classe.getClasse("Clerigo"));
        assertEquals(Classe.CLERIGO, Classe.getClasse("clerigo"));

        assertEquals(Classe.NENHUMA, Classe.getClasse(""));
        assertEquals(Classe.NENHUMA, Classe.getClasse(null));
    }
}
