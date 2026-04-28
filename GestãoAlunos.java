import java.awt.*;
import javax.swing.*;

public class GestãoAlunos extends JFrame {

    public GestãoAlunos() {
        setTitle("Gestão de Alunos");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets (5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        JTextField txtNome = new JTextField(20);
        add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Matrícula:"), gbc);
        gbc.gridx = 1;
        JTextField txtMatricula = new JTextField(15);
        add(txtMatricula, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Curso:"), gbc);
        gbc.gridx = 1;
        String[] cursos = {"Sistemas de Informação", "Engenharia", "Computação", "Outros"};
        JComboBox<String> cbCurso = new JComboBox<>(cursos);
        add(cbCurso, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("E-mail:"), gbc);
        gbc.gridx = 1;
        JTextField txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        JPanel panelStatus = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JRadioButton rbAtivo = new JRadioButton("Ativo", true);
        JRadioButton rbInativo = new JRadioButton("Inativo");
        ButtonGroup groupStatus = new ButtonGroup();
        groupStatus.add(rbAtivo);
        groupStatus.add(rbInativo);
        panelStatus.add(rbAtivo);
        panelStatus.add(rbInativo);
        add(panelStatus, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        JButton btnSalvar = new JButton("Salvar Aluno");
        add(btnSalvar, gbc);

        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Salvo!");
        });
    }
 
    public static void main(String[] args) {
        // Executa a interface
        SwingUtilities.invokeLater(() -> {
            new GestãoAlunos().setVisible(true);
        });
    }
}