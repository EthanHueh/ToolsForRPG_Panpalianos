package toolsforrpg_panpalianos;

import toolsforrpg_panpalianos.dados.modelo.enums.TipoAtributo;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.servicos.Calculadora;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.gui.GerenciadorTelas;

public class Main {
 
    public static void main(String[] args) {
        GerenciadorTelas.iniciarLauncher();
   }
    
    public static int realizarTeste(Ficha f, TipoAtributo t){
        int resultadoDado = RoladorDeDados.executar(1, 20);
        int bonus = Calculadora.calcularBonus(f.getAtributoByTipo(t));

        return resultadoDado + bonus;
    }

}

/*
TODO
fazer o programa gerar txts

fazer a iniciativa ser rolada automaticamente
*/
