package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.Observador;
import toolsforrpg_panpalianos.dominio.Sujeito;
import toolsforrpg_panpalianos.dominio.servicos.InicializadorFicha;
import toolsforrpg_panpalianos.dominio.servicos.arquivos.LeitorDeArquivos;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;

public class FichasRepository implements Sujeito {

    private static FichasRepository instance = new FichasRepository();
   
    private List<Ficha> fichas = new ArrayList<>();
    private List<FichaCriatura> fichasCriatura = new ArrayList<>();
    private List<FichaJogador> fichasJogador = new ArrayList<>();

    private List<Observador> observadores = new ArrayList<>();
    
    static  {
        for (FichaCriatura f : LeitorDeArquivos.lerArquivoFichasCriatura("arquivos/fichas/fichasCriaturas.json")) {
            try {
                instance.adicionar(f);
            } catch (Exception e) {
                TelaAviso.mostrarErro("Erro ao adicionar ficha de "+f.getNome());
            }
        }

        for (FichaJogador f : LeitorDeArquivos.lerArquivoFichasJogador("arquivos/fichas/fichasJogadores.json")) {
            try {
                instance.adicionar(f);
            } catch (Exception e) {
                TelaAviso.mostrarErro("Erro ao adicionar ficha de "+f.getNome());
            }
        }

        instance.notificarObservadores();

    }
    
    public void adicionar(Ficha ficha) throws Exception{
        if (ficha == null){
            throw new Exception("Ficha nula!");
        }
        
        if (fichas.size() == 50){
            throw new Exception("Limite de fichas atingido!");
        }

        for (Ficha f : fichas) {
            if (ficha.getNome().equals(f.getNome())){
                throw new Exception("Não podem haver fichas de nome repetido!");
            }
        }

        fichas.add(InicializadorFicha.inicializar(ficha));

        if (ficha instanceof FichaCriatura){
            fichasCriatura.add((FichaCriatura) ficha);
        }

        if (ficha instanceof FichaJogador){
            fichasJogador.add((FichaJogador) ficha);
        }

        notificarObservadores();
        
    }
    
    public List<Ficha> retornarTodasAsFichas() throws Exception{
        if (fichas.isEmpty()){
            throw new Exception("Nenhuma ficha cadastrada!");
        }

        return fichas;
    }

    public List<FichaCriatura> retornarFichasCriatura() throws Exception {
        if (fichasCriatura.isEmpty()){
            throw new Exception("Nenhuma ficha de criatura cadastrada!");
        }
        
        return fichasCriatura;
    }
    
    public List<FichaJogador> retornarFichasJogador() throws Exception {
        if (fichasJogador.isEmpty()){
            throw new Exception("Nenhuma ficha de jogador cadastrada!");
        }
        return fichasJogador;
    }
    
    public Ficha retornarFichaAleatoria() throws Exception{

        List<Ficha> fichas = retornarTodasAsFichas();

        return fichas.get(
            RoladorDeDados.executar(1, fichas.size() - 1)
        );
    }

    public void atualizar(Ficha ficha) throws Exception {

        for (Ficha f: retornarTodasAsFichas()){
            if (f.getNome().equals(ficha.getNome())){
                
                f.setNome(ficha.getNome());
                f.setDescricao(ficha.getDescricao());
                f.setAlinhamento(ficha.getAlinhamento());
                f.setRaca(ficha.getRaca());
                f.setIdiomas(ficha.getIdiomas());

                f.setForca(ficha.getForca());
                f.setDestreza(ficha.getDestreza());
                f.setConstituicao(ficha.getConstituicao());
                f.setInteligencia(ficha.getInteligencia());
                f.setSabedoria(ficha.getSabedoria());
                f.setCarisma(ficha.getCarisma());

                f.setQuantPVsAtual(ficha.getQuantPVsAtual());

                f.setEquipamento(ficha.getEquipamento());

                if (ficha instanceof FichaCriatura){
                    FichaCriatura fAntiga = (FichaCriatura) f;
                    FichaCriatura fAtualizada = (FichaCriatura) ficha;

                    fAntiga.setClasseArmadura(fAtualizada.getClasseArmadura());
                    fAntiga.setJogadaDeProtecao(fAtualizada.getJogadaDeProtecao());
                    fAntiga.setBaseAtaque(fAtualizada.getBaseAtaque());
                    fAntiga.setMovimento(fAtualizada.getMovimento());
                    fAntiga.setQuantDVs(fAtualizada.getQuantDVs());
                    fAntiga.setPvsAdicionais(fAtualizada.getPvsAdicionais());
                }

                if (ficha instanceof FichaJogador){
                    FichaJogador fAntiga = (FichaJogador) f;
                    FichaJogador fAtualizada = (FichaJogador) ficha;

                    fAntiga.setClasse(fAtualizada.getClasse());
                    fAntiga.setEspecializacao(fAtualizada.getEspecializacao());
                    fAntiga.setLvl(fAtualizada.getLvl());
                    fAntiga.setExp(fAtualizada.getExp());
                }

                notificarObservadores();
                return;
                
            }
        }

        throw new Exception("Ficha nao atualizada");
    }
    
    public void excluir(Ficha ficha) throws Exception {
        for (int i = 0; i < fichas.size(); i++){
            if (fichas.get(i) == ficha){
                fichas.remove(i);
                notificarObservadores();
                return;
            }
        }

        throw new Exception("Ficha nao excluida");
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

    public static FichasRepository getInstance() {
        return instance;
    }
    
}