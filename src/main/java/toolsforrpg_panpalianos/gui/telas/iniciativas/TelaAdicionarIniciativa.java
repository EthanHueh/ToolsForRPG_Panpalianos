package toolsforrpg_panpalianos.gui.telas.iniciativas;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import toolsforrpg_panpalianos.dados.modelo.Iniciativa;
import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.IniciativasRepository;
import toolsforrpg_panpalianos.dominio.utils.RoladorDeDados;
import toolsforrpg_panpalianos.gui.componentes.IconesImagem;
import toolsforrpg_panpalianos.gui.componentes.SelecaoUtils;
import toolsforrpg_panpalianos.gui.componentes.botoes.BotaoPadrao;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;

public class TelaAdicionarIniciativa extends JFrame {

    private JComboBox<Object> selecao = new JComboBox<>();
    private JTextField campoIniciativa = new JTextField("0");
    
    TelaAdicionarIniciativa(){

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Selecione a ficha"));
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        add(selecao);

        add(new JLabel("Insira valor iniciativa"));
        campoIniciativa.setText("0");
        add(campoIniciativa);

        JButton btn = new BotaoPadrao(IconesImagem.DADO.getImageIcon());
        btn.addActionListener(e -> rolarIniciativa());
        add(btn);

        btn = new BotaoPadrao("SALVAR");
        btn.addActionListener(e -> adicionarIniciativa());
        add(btn);

        pack();
    }

    public void iniciar(){
        SelecaoUtils.mudarParaTodasAsFichas(selecao);
        setVisible(true);
    }

    private void rolarIniciativa() {
        Ficha ficha = (Ficha) selecao.getSelectedItem();
        campoIniciativa.setText(String.valueOf(RoladorDeDados.executarIniciativa(ficha)));
    }

    private void adicionarIniciativa(){
        Ficha ficha = (Ficha) selecao.getSelectedItem();
        int valorIniciativa = Integer.parseInt(campoIniciativa.getText());
        
        Iniciativa iniciativa = new Iniciativa(valorIniciativa, ficha);

        try {
            IniciativasRepository.adicionar(iniciativa);
        } catch (Exception e) {
            TelaAviso.mostrarErro(e);
        }

        TelaIniciativas.getInstance().atualizar();
    }
    
}
