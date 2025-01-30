package toolsforrpg_panpalianos.gui.telas.ficha.atualizar;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;
import toolsforrpg_panpalianos.gui.telas.ficha.forms.FormFicha;

public class FormAtualizar extends FormFicha {

    private JComboBox<Object> selecionarFicha = new JComboBox<>();
    
    public FormAtualizar(){
        super();

        selecionarFicha.addActionListener (
            e -> atualizarCamposFichaAtual()
        );

        remove(pnlNorte);
        pnlNorte.removeAll();

        pnlNorte.add(titulo);
        pnlNorte.add(trocarTipoFicha);
        pnlNorte.add(selecionarFicha);
        pnlNorte.setPreferredSize(new Dimension(150, 40));
        add(pnlNorte, BorderLayout.NORTH);
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

    @Override
    protected void trocarParaJogador(){
        tipoFichaAtual = "Jogador";
        titulo.setText("Atualizar "+tipoFichaAtual);
        SelecaoUtils.mudarParaFichasJogador(selecionarFicha);

        pnlInfoJogador.setVisible(true);
        pnlInfoCriatura.setVisible(false);
        atualizarCamposFichaAtual();
    }

    protected void trocarParaCriatura(){
        tipoFichaAtual = "Criatura";
        titulo.setText("Atualizar "+tipoFichaAtual);
        SelecaoUtils.mudarParaFichasCriatura(selecionarFicha);

        pnlInfoCriatura.setVisible(true);
        pnlInfoJogador.setVisible(false);
        atualizarCamposFichaAtual();
    }

    private void atualizarCamposFichaAtual() {
        if (selecionarFicha.getSelectedItem() == null){
            return;
        }
    
        Ficha fichaAtual = (Ficha) selecionarFicha.getSelectedItem();
    
        pnlInfoBasica.setNome(fichaAtual.getNome());
        pnlInfoBasica.setDescricao(fichaAtual.getDescricao());
        pnlInfoBasica.setAlinhamento(fichaAtual.getAlinhamento().getNome());
        pnlInfoBasica.setRaca(fichaAtual.getRaca().getNome());
        pnlInfoBasica.setIdiomas(fichaAtual.getIdiomas());

        if (fichaAtual instanceof FichaJogador){
            FichaJogador ficha = (FichaJogador) fichaAtual;

            pnlInfoJogador.setClasse(ficha.getClasse().getNome());
            pnlInfoJogador.setEspecializacao(ficha.getEspecializacao().getNome());
            pnlInfoJogador.setLvl(ficha.getLvl());
            pnlInfoJogador.setExp(ficha.getExp());
        }

        if (fichaAtual instanceof FichaCriatura){
            pnlInfoCriatura.setBaseAtaque(fichaAtual.getBaseAtaque());
            pnlInfoCriatura.setClasseArmadura(fichaAtual.getClasseArmadura());
            pnlInfoCriatura.setJogadaDeProtecao(fichaAtual.getJogadaProtecao());
            pnlInfoCriatura.setMovimento(fichaAtual.getMovimento());

            FichaCriatura ficha = (FichaCriatura) fichaAtual;
            pnlInfoCriatura.setPvsAdicionais(ficha.getPvsAdicionais());
        }

        pnlAtributos.setForca(fichaAtual.getForca());
        pnlAtributos.setDestreza(fichaAtual.getDestreza());
        pnlAtributos.setConstituicao(fichaAtual.getConstituicao());
        pnlAtributos.setInteligencia(fichaAtual.getInteligencia());
        pnlAtributos.setSabedoria(fichaAtual.getSabedoria());
        pnlAtributos.setCarisma(fichaAtual.getCarisma());

        Equipamento eq = fichaAtual.getEquipamento();
        pnlEquipamento.setArma(eq.getArma().getNome());
        pnlEquipamento.setArmadura(eq.getArmadura().getNome());
        pnlEquipamento.setEscudo(eq.getEscudo().getNome());
    
    }
    
}
