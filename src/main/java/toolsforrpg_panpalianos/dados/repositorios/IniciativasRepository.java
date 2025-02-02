package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dominio.Observador;
import toolsforrpg_panpalianos.dominio.Sujeito;

public class IniciativasRepository implements Sujeito {

    private static IniciativasRepository instance = new IniciativasRepository();

    private List<Iniciativa> iniciativas = new ArrayList<>();
    private List<Observador> observadores = new ArrayList<>();
    
    public List<Iniciativa> retornarIniciativas() throws Exception {

        if (iniciativas.isEmpty()){
            throw new Exception("Nenhuma iniciativa inserida");
        }

        iniciativas.sort(Comparator.comparing(i -> i.getIniciativa()));
        Collections.reverse(iniciativas);

        return iniciativas;
    }

    public void adicionar(Iniciativa iniciativa) throws Exception{
        checarIniciativaRepetida(iniciativa);
        iniciativas.add(iniciativa);
        notificarObservadores();
    }

    public void atualizar(Iniciativa iniciativa) throws Exception{

        for (Iniciativa i : iniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                i.setIniciativa(iniciativa.getIniciativa());
                notificarObservadores();
                return;
            }
        }

        throw new Exception("Iniciativa nao atualizada!");
    }
    
    public void excluir(Iniciativa iniciativa) throws Exception {
        for (int i = 0; i < iniciativas.size(); i++){
            if (iniciativas.get(i).getFicha() == iniciativa.getFicha()){
                iniciativas.remove(i);
                notificarObservadores();
                return;
            }
        }

        throw new Exception("Iniciativa nao excluida!");
    }

    public void excluir(Ficha ficha) throws Exception {
        for (int i = 0; i < iniciativas.size(); i++){
            if (iniciativas.get(i).getFicha() == ficha){
                iniciativas.remove(i);
                notificarObservadores();
                return;
            }
        }

        throw new Exception("Iniciativa nao excluida!");
    }
    
    private void checarIniciativaRepetida(Iniciativa iniciativa) throws Exception {
        for (Iniciativa i : iniciativas) {
            if (i.getFicha() == iniciativa.getFicha()){
                throw new Exception("Iniciativa repetida!");
            }
        }
    }

    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObserver(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.atualizar();
        }
    }

    public static IniciativasRepository getInstance(){
        return instance;
    } 

}
