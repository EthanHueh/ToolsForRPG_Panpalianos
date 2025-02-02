package toolsforrpg_panpalianos.dominio;

public interface Sujeito {
    void adicionarObservador(Observador observador);
    void removerObserver(Observador observador);
    void notificarObservadores();
}
