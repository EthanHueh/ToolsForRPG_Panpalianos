package toolsforrpg_panpalianos.dados.repositorios;

import java.util.ArrayList;
import java.util.List;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dominio.servicos.InicializadorFicha;
import toolsforrpg_panpalianos.dominio.servicos.arquivos.LeitorDeArquivos;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;

public class FichasRepository {
    
    private final static List<Ficha> fichas = new ArrayList<>();
    private final static int LIMITE_FICHAS = 1000;
    
    static {
        fichas.addAll(LeitorDeArquivos.lerArquivoFichasCriatura("arquivos/fichas/fichasCriaturas.json"));
        fichas.addAll(LeitorDeArquivos.lerArquivoFichasJogador("arquivos/fichas/fichasJogadores.json"));
    }
    
    public static void adicionar(Ficha ficha){
        if (fichas.size() == LIMITE_FICHAS){
            return;
        }
        
        fichas.add(InicializadorFicha.inicializar(ficha));
        
    }
    
    public static List<Ficha> retornarTodasAsFichas() throws Exception{
        if (fichas.isEmpty()){
            throw new Exception("Nenhuma ficha cadastrada");
        }

        return fichas;
    }

    public static List<FichaCriatura> retornarFichasCriatura() throws Exception {
        List<FichaCriatura> fichasCriaturas = new ArrayList<>();
        
        for (Ficha f : fichas){
            if (f instanceof FichaCriatura){
                fichasCriaturas.add((FichaCriatura) f);
            }
        }

        if (fichasCriaturas.isEmpty()){
            throw new Exception("Nenhuma ficha de criatura cadastrada");
        }
        
        return fichasCriaturas;
    }
    
    public static List<FichaJogador> retornarFichasJogador() throws Exception {
        
        List<FichaJogador> fichasJogadores = new ArrayList<>();
        
        for (Ficha f : fichas){
            if (f instanceof FichaJogador){
                fichasJogadores.add((FichaJogador) f);
            }
        }

        if (fichasJogadores.isEmpty()){
            throw new Exception("Nenhuma ficha de jogador cadastrada");
        }
        
        return fichasJogadores;
    }
    
    public static Ficha retornarFichaAleatoria() throws Exception{

        List<Ficha> fichas = retornarTodasAsFichas();

        return fichas.get(
            RoladorDeDados.executar(1, fichas.size() - 1)
        );
    }

    public static void atualizar(Ficha ficha) throws Exception {

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

                f.setQuantDVs(ficha.getQuantDVs());
                f.setQuantPVsAtual(ficha.getQuantPVsAtual());

                f.setEquipamento(ficha.getEquipamento());

                if (ficha instanceof FichaCriatura){
                    FichaCriatura fAntiga = (FichaCriatura) f;
                    FichaCriatura fAtualizada = (FichaCriatura) ficha;

                    fAntiga.setClasseArmadura(fAtualizada.getClasseArmadura());
                    fAntiga.setJogadaDeProtecao(fAtualizada.getJogadaDeProtecao());
                    fAntiga.setBaseAtaque(fAtualizada.getBaseAtaque());
                    fAntiga.setMovimento(fAtualizada.getMovimento());
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

                return;
                
            }
        }

        throw new Exception("Ficha nao atualizada");
    }
    
    public static void excluir(Ficha ficha) throws Exception {
        for (int i = 0; i < fichas.size(); i++){
            if (fichas.get(i) == ficha){
                fichas.remove(i);
                return;
            }
        }

        throw new Exception("Ficha nao excluida");
    }
    
}