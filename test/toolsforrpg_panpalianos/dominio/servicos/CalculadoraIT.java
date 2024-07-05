package toolsforrpg_panpalianos.dominio.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

public class CalculadoraIT {
    
    public CalculadoraIT() {
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
     * Test of calcularBonus method, of class Calculadora.
     */
    @Test
    public void testCalcularBonus() {
        System.out.println("calcularBonus");
        int atributo = 10;
        int expResult = 0;
        int result = Calculadora.calcularBonus(atributo);
        assertEquals(expResult, result);
        
        atributo = 19;
        expResult = 4;
        result = Calculadora.calcularBonus(atributo);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularDVJogador method, of class Calculadora.
     */
    @Test
    public void testCalcularDVJogador() {
        System.out.println("calcularDVJogador");
        FichaJogador ficha = new FichaJogador();
        
        ficha.setLvl(9);
        int expResult = 9;
        int result = Calculadora.calcularDVJogador(ficha);
        assertEquals(expResult, result);
        
        ficha.setLvl(14);
        expResult = 9;
        result = Calculadora.calcularDVJogador(ficha);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularPV method, of class Calculadora.
     */
    @Test
    public void testCalcularPV() {
        System.out.println("calcularPV");
        Ficha ficha = new FichaCriatura();
        ficha.setConstituicao(10);
        
        ficha.setQuantDVs(1);
        int expResult = 5;
        int result = Calculadora.calcularPV(ficha);
        assertEquals(expResult, result);
        
        ficha.setConstituicao(15);
        expResult = 7;
        result = Calculadora.calcularPV(ficha);
        assertEquals(expResult, result);
        
        ficha.setConstituicao(10);
        ficha.setQuantDVs(5);
        expResult = 25;
        result = Calculadora.calcularPV(ficha);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of calcularPVMaximo method, of class Calculadora.
     */
    @Test
    public void testCalcularPVMaximo() {
        System.out.println("calcularPVMaximo");
        
        Ficha ficha = new FichaCriatura();
        ficha.setConstituicao(10);
        ficha.setQuantDVs(1);
        
        int expResult = 8;
        int result = Calculadora.calcularPVMaximo(ficha);
        assertEquals(expResult, result);
        
        ficha.setConstituicao(15);
        expResult = 10;
        result = Calculadora.calcularPVMaximo(ficha);
        assertEquals(expResult, result);
        
        ficha.setConstituicao(10);
        ficha.setQuantDVs(5);
        expResult = 40;
        result = Calculadora.calcularPVMaximo(ficha);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularPVsAdicionais method, of class Calculadora.
     */
    @Test
    public void testCalcularPVsAdicionais() {
        System.out.println("calcularPVsAdicionais");
        FichaJogador ficha = null;
        int expResult = 0;
        int result = Calculadora.calcularPVsAdicionais(ficha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularClasseArmadura method, of class Calculadora.
     */
    @Test
    public void testCalcularClasseArmadura() {
        System.out.println("calcularClasseArmadura");
        FichaJogador f = null;
        int expResult = 0;
        int result = Calculadora.calcularClasseArmadura(f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
