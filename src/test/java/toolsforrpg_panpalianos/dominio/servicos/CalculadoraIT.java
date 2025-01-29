package toolsforrpg_panpalianos.dominio.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

import static org.junit.Assert.*;

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

        assertEquals(0, Calculadora.calcularBonus(10));
        assertEquals(4, Calculadora.calcularBonus(19));
    }

    /**
     * Test of calcularDVJogador method, of class Calculadora.
     */
    @Test
    public void testCalcularDVJogador() {
        System.out.println("calcularDVJogador");

        FichaJogador ficha = FichaJogador.Builder.novoJogador().classe("clerigo").build();
        
        ficha.setLvl(9);
        assertEquals(9, Calculadora.calcularDVJogador(ficha));
        
        ficha.setLvl(14);
        assertEquals(9, Calculadora.calcularDVJogador(ficha));
    }

    /**
     * Test of calcularPV method, of class Calculadora.
     */
    @Test
    public void testCalcularPV() {
        System.out.println("calcularPV");
        FichaCriatura ficha = FichaCriatura.Builder.novaCriatura().build();
        ficha.setConstituicao(10);
        
        ficha.setQuantDVs(1);
        assertEquals(5, Calculadora.calcularPV(ficha));
        
        ficha.setConstituicao(15);
        assertEquals(7, Calculadora.calcularPV(ficha));
        
        ficha.setConstituicao(10);
        ficha.setQuantDVs(5);
        assertEquals(25, Calculadora.calcularPV(ficha));
        
    }

    /**
     * Test of calcularPVMaximo method, of class Calculadora.
     */
    @Test
    public void testCalcularPVMaximo() {
        System.out.println("calcularPVMaximo");
        
        FichaCriatura ficha = FichaCriatura.Builder.novaCriatura().build();

        ficha.setConstituicao(10);
        ficha.setQuantDVs(1);
        assertEquals(8, Calculadora.calcularPVMaximo(ficha));
        
        ficha.setConstituicao(15);
        assertEquals(10,  Calculadora.calcularPVMaximo(ficha));
        
        ficha.setConstituicao(10);
        ficha.setQuantDVs(5);
        assertEquals(40, Calculadora.calcularPVMaximo(ficha));
    }

    /**
     * Test of calcularPVsAdicionais method, of class Calculadora.
     */
    @Test
    public void testCalcularPVsAdicionais() {
        System.out.println("calcularPVsAdicionais");

        FichaJogador ficha = FichaJogador.Builder.novoJogador().build();
        assertEquals(0, Calculadora.calcularPVsAdicionais(ficha));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularClasseArmadura method, of class Calculadora.
     */
    @Test
    public void testCalcularClasseArmadura() {
        System.out.println("calcularClasseArmadura");
        
        FichaJogador f = FichaJogador.Builder.novoJogador().build();
        assertEquals(0, Calculadora.calcularClasseArmadura(f));


        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
