/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package toolsforrpg_panpalianos.dominio.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import toolsforrpg_panpalianos.dados.modelo.enums.Classe;
import toolsforrpg_panpalianos.dados.modelo.enums.Especializacao;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;

/**
 *
 * @author adest
 */
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
        
        FichaJogador ficha = new FichaJogador();
        ficha.setClasse(Classe.CLERIGO);
        
        System.out.println("Especializacao errada");
        ficha.setEspecializacao(Especializacao.PALADINO);
        boolean esperado = false;
        boolean result = Validador.validarEspecializacao(ficha);
        assertEquals(esperado, result);
        
        System.out.println("Especializacao certa");
        ficha.setEspecializacao(Especializacao.CACADOR);
        esperado = true;
        result = Validador.validarEspecializacao(ficha);
        assertEquals(esperado, result);
        
        System.out.println("Nenhuma especializacao");
        ficha.setEspecializacao(Especializacao.NENHUMA);
        esperado = true;
        result = Validador.validarEspecializacao(ficha);
        assertEquals(esperado, result);
        
        System.out.println("Especializacao nula");
        ficha.setEspecializacao(null);
        esperado = true;
        result = Validador.validarEspecializacao(ficha);
        assertEquals(esperado, result);
    }
}
