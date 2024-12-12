package toolsforrpg_panpalianos.gui.telas.ficha;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import toolsforrpg_panpalianos.dados.modelo.Equipamento;
import toolsforrpg_panpalianos.dados.modelo.enums.Idioma;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaCriatura;
import toolsforrpg_panpalianos.dados.modelo.fichas.FichaJogador;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.telas.comum.TelaErro;
import toolsforrpg_panpalianos.gui.telas.comum.TelaInput;

public class FormAtualizar extends FormFicha {

    private JComboBox<Object> selecionarFicha;
    
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

        trocarTipoFicha();
    }

    @Override
    public void submeterFicha() {
        if (TelaInput.desejaRealizarOperacao("Quer mesmo cadastrar essa ficha?", "Confirmacao")){
            Ficha ficha;

            if (tipoFichaAtual.equals("Jogador")){
                ficha = montarFichaJogador();
            } else {
                ficha = montarFichaCriatura();
            }

            try {
                FichasRepository.atualizar(ficha);
            } catch (Exception e) {
                TelaErro.mostrar(e);
            }
        }
    }

    @Override
    public void trocarTipoFicha(){

        if (selecionarFicha == null){
            selecionarFicha = new JComboBox<>();
        }

        switch (tipoFichaAtual) {
            default:
            case "Jogador":
                tipoFichaAtual = "Criatura";
                titulo.setText("Atualizar "+tipoFichaAtual);
                SelecaoUtils.mudarParaFichasCriatura(selecionarFicha);

                pnlInfoCriatura.setVisible(true);
                pnlInfoJogador.setVisible(false);
                break;

            case "Criatura":
                tipoFichaAtual = "Jogador";
                titulo.setText("Atualizar "+tipoFichaAtual);
                SelecaoUtils.mudarParaFichasJogador(selecionarFicha);

                pnlInfoJogador.setVisible(true);
                pnlInfoCriatura.setVisible(false);
                break;

        }
        
    }

    private void atualizarCamposFichaAtual() {
        if (selecionarFicha.getSelectedItem() == null){
            return;
        }
    
        Ficha fichaAtual = (Ficha) selecionarFicha.getSelectedItem();
    
        pnlInfoBasica.nome.setText(fichaAtual.getNome());
        pnlInfoBasica.descricao.setText(fichaAtual.getDescricao());
        pnlInfoBasica.alinhamento.setSelectedItem(fichaAtual.getAlinhamento().getNome());
        pnlInfoBasica.raca.setSelectedItem(fichaAtual.getRaca().getNome());
    
        pnlInfoBasica.idiomas.stream().forEach(c -> c.setSelected(false));
    
        for (Idioma i : fichaAtual.getIdiomas()) {
            for (JCheckBox c : pnlInfoBasica.idiomas) {
                if (c.getText().equals(i.getNome())){
                    c.setSelected(true);
                }
            }
        }

        if (fichaAtual instanceof FichaJogador){
            FichaJogador ficha = (FichaJogador) fichaAtual;

            pnlInfoJogador.classe.setSelectedItem(ficha.getClasse().getNome());
            pnlInfoJogador.especializacao.setSelectedItem(ficha.getEspecializacao().getNome());
            pnlInfoJogador.lvl.setText(String.valueOf(ficha.getLvl()));
            pnlInfoJogador.exp.setText(String.valueOf(ficha.getExp()));
        }

        if (fichaAtual instanceof FichaCriatura){
            pnlInfoCriatura.baseAtaque.setText(String.valueOf(fichaAtual.getBaseAtaque()));
            pnlInfoCriatura.classeArmadura.setText(String.valueOf(fichaAtual.getClasseArmadura()));
            pnlInfoCriatura.jogadaDeProtecao.setText(String.valueOf(fichaAtual.getJogadaProtecao()));
            pnlInfoCriatura.movimento.setText(String.valueOf(fichaAtual.getMovimento()));

            FichaCriatura ficha = (FichaCriatura) fichaAtual;
            pnlInfoCriatura.pvsAdicionais.setText(String.valueOf(ficha.getPvsAdicionais()));
        }

        pnlAtributos.forca.setText(String.valueOf(fichaAtual.getForca()));
        pnlAtributos.destreza.setText(String.valueOf(fichaAtual.getDestreza()));
        pnlAtributos.constituicao.setText(String.valueOf(fichaAtual.getConstituicao()));
        pnlAtributos.inteligencia.setText(String.valueOf(fichaAtual.getInteligencia()));
        pnlAtributos.sabedoria.setText(String.valueOf(fichaAtual.getSabedoria()));
        pnlAtributos.carisma.setText(String.valueOf(fichaAtual.getCarisma()));

        Equipamento eq = fichaAtual.getEquipamento();
        pnlEquipamento.arma.setSelectedItem(eq.getArma().getNome());
        pnlEquipamento.armadura.setSelectedItem(eq.getArmadura().getNome());
        pnlEquipamento.escudo.setSelectedItem(eq.getEscudo().getNome());
    
    }
    
}
