package toolsforrpg_panpalianos.gui.telas.ficha.atualizar;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormFicha;

public class FormAtualizar extends FormFicha {

    private static FormAtualizar instance = new FormAtualizar(); 
    
    public FormAtualizar(){
        super();
    }

    public void iniciar(Ficha ficha){
        if (ficha instanceof FichaJogador){
            trocarParaJogador();
        } else {
            trocarParaCriatura();
        }

        atualizarCampos(ficha);
        setVisible(true);
    }

    @Override
    protected void submeterFicha() {
        if (TelaInput.desejaRealizarOperacao("Quer mesmo atualizar essa ficha?", "Confirmacao")){
            Ficha ficha;

            if (tipoFichaAtual.equals("Jogador")){
                ficha = montarFichaJogador();
            } else {
                ficha = montarFichaCriatura();
            }

            try {
                FichasRepository.atualizar(ficha);
            } catch (Exception e) {
                TelaAviso.mostrarErro(e);
            }
        }
    }

    private void atualizarCampos(Ficha ficha) {
        pnlInfoBasica.setNome(ficha.getNome());
        pnlInfoBasica.setDescricao(ficha.getDescricao());
        pnlInfoBasica.setAlinhamento(ficha.getAlinhamento().getNome());
        pnlInfoBasica.setRaca(ficha.getRaca().getNome());
        pnlInfoBasica.setIdiomas(ficha.getIdiomas());

        if (ficha instanceof FichaJogador){
            FichaJogador f = (FichaJogador) ficha;

            pnlInfoJogador.setClasse(f.getClasse().getNome());
            pnlInfoJogador.setEspecializacao(f.getEspecializacao().getNome());
            pnlInfoJogador.setLvl(f.getLvl());
            pnlInfoJogador.setExp(f.getExp());
        }

        if (ficha instanceof FichaCriatura){
            pnlInfoCriatura.setBaseAtaque(ficha.getBaseAtaque());
            pnlInfoCriatura.setClasseArmadura(ficha.getClasseArmadura());
            pnlInfoCriatura.setJogadaDeProtecao(ficha.getJogadaProtecao());
            pnlInfoCriatura.setMovimento(ficha.getMovimento());

            FichaCriatura f = (FichaCriatura) ficha;
            pnlInfoCriatura.setPvsAdicionais(f.getPvsAdicionais());
        }

        pnlAtributos.setForca(ficha.getForca());
        pnlAtributos.setDestreza(ficha.getDestreza());
        pnlAtributos.setConstituicao(ficha.getConstituicao());
        pnlAtributos.setInteligencia(ficha.getInteligencia());
        pnlAtributos.setSabedoria(ficha.getSabedoria());
        pnlAtributos.setCarisma(ficha.getCarisma());

        Equipamento eq = ficha.getEquipamento();
        pnlEquipamento.setArma(eq.getArma().getNome());
        pnlEquipamento.setArmadura(eq.getArmadura().getNome());
        pnlEquipamento.setEscudo(eq.getEscudo().getNome());
    
    }

    public static FormAtualizar getInstance() {
        return instance;
    }
    
}
