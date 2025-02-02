package toolsforrpg_panpalianos.gui.telas.ficha.principal;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import toolsforrpg_panpalianos.dados.modelo.fichas.Ficha;
import toolsforrpg_panpalianos.dados.repositorios.FichasRepository;
import toolsforrpg_panpalianos.dominio.Observador;
import toolsforrpg_panpalianos.gui.telas.comum.TelaAviso;
import toolsforrpg_panpalianos.gui.telas.ficha.cadastrar.FormCadastrar;

public class TelaFichas extends JFrame implements Observador {

    private FormCadastrar formCadastrar = new FormCadastrar();

    private JPanel painelPrincipal = new JPanel();
    
    public TelaFichas() {
        setTitle("Fichas");
        setLayout(new BorderLayout());

        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setAlignmentX(RIGHT_ALIGNMENT);
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JPanel norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
        norte.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        JButton jButton = new JButton("+ Nova Ficha");
        jButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        jButton.addActionListener(
            e -> formCadastrar.iniciar()
        );
        norte.add(jButton);

        jButton = new JButton("+ Adicionar fichas por arquivo");
        jButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        norte.add(jButton);

        add(painelPrincipal, BorderLayout.CENTER);
        add(norte, BorderLayout.NORTH);

        atualizar();
        pack();

        FichasRepository.getInstance().adicionarObservador(this);
        
    }

    public void iniciar(){
        setVisible(true);
    }

    @Override
    public void atualizar(){
        try {

            painelPrincipal.removeAll();

            for (Ficha f : FichasRepository.getInstance().retornarTodasAsFichas()) {
                painelPrincipal.add(new PainelFicha(f));
            }
            
        } catch (Exception e) {
            TelaAviso.mostrarErro(e);
        }

        revalidate();
        repaint();
    }
}
