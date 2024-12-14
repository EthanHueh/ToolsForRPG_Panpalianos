package toolsforrpg_panpalianos.dominio.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

import static org.junit.Assert.*;

public class ValidadorIT {
    
    public ValidadorIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarEspecializacao method, of class Validador.
     */
    @Test
    public void testValidarEspecializacao() {
        System.out.println("validarEspecializacao");
        
        FichaJogador ficha = FichaJogador.Builder.novoJogador().build();
        ficha.setClasse(Classe.CLERIGO);
        
        System.out.println("Especializacao errada");
        ficha.setEspecializacao(Especializacao.PALADINO);
        boolean result = Validador.validarEspecializacao(ficha);
        assertFalse(result);
        
        System.out.println("Especializacao certa");
        ficha.setEspecializacao(Especializacao.CACADOR);
        result = Validador.validarEspecializacao(ficha);
        assertTrue(result);
        
        System.out.println("Nenhuma especializacao");
        ficha.setEspecializacao(Especializacao.NENHUMA);
        result = Validador.validarEspecializacao(ficha);
        assertTrue(result);
        
        System.out.println("Especializacao nula");
        ficha.setEspecializacao(Especializacao.NENHUMA);
        result = Validador.validarEspecializacao(ficha);
        assertTrue(result);
    }

    @Test
    public void testValidarAtributo(){
        assertTrue(Validador.validarAtributo(0));
        assertTrue(Validador.validarAtributo(50));
        assertFalse(Validador.validarAtributo(-1));
        assertFalse(Validador.validarAtributo(51));
    }

    @Test
    public void testValidarDadoVida(){
        FichaCriatura f = FichaCriatura.Builder.novaCriatura().build();

        f.setQuantDVs(2);
        assertTrue(Validador.validarDadoDeVida(f));

        f.setQuantDVs(500);
        assertFalse(Validador.validarDadoDeVida(f));
        
        f.setQuantDVs(-2);
        assertFalse(Validador.validarDadoDeVida(f));


        FichaJogador fj = FichaJogador.Builder.novoJogador().build();

        fj.setLvl(20);

        fail("Prototype");

    }

}
