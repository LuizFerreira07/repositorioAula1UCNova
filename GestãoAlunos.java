import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestãoAlunos extends JFrame {

    public GestãoAlunos() {
        setTitle("Sistema de Gestão de Alunos");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 0));

        JPanel panelEsquerdo = new JPanel(new GridBagLayout());
        panelEsquerdo.setPreferredSize(new Dimension(350, 0));
        panelEsquerdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lbLogo = new JLabel();
        lbLogo.setHorizontalAlignment(JLabel.CENTER);
        
        ImageIcon icon = new ImageIcon("imagens/logo.png");
        
        if (icon.getIconWidth() > 0) {
            Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            lbLogo.setIcon(new ImageIcon(img));
        } else {
            lbLogo.setText("[ Logo não encontrada ]");
            lbLogo.setForeground(Color.GRAY);
        }
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panelEsquerdo.add(lbLogo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1; gbc.gridx = 0; panelEsquerdo.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; JTextField txtNome = new JTextField(); panelEsquerdo.add(txtNome, gbc);

        gbc.gridy = 2; gbc.gridx = 0; gbc.weightx = 0; panelEsquerdo.add(new JLabel("Matrícula:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; JTextField txtMatr = new JTextField(); panelEsquerdo.add(txtMatr, gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.weightx = 0; panelEsquerdo.add(new JLabel("Curso:"), gbc);
        gbc.gridx = 1; JComboBox<String> cbCurso = new JComboBox<>(new String[]{"Sistemas", "Engenharia", "Computação", "Outros"}); panelEsquerdo.add(cbCurso, gbc);

        gbc.gridy = 4; gbc.gridx = 0; gbc.weightx = 0; panelEsquerdo.add(new JLabel("E-mail:"), gbc);
        gbc.gridx = 1; JTextField txtEmail = new JTextField(); panelEsquerdo.add(txtEmail, gbc);

        gbc.gridy = 5; gbc.gridx = 0; panelEsquerdo.add(new JLabel("Status:"), gbc);
        JPanel pStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton rbAtivo = new JRadioButton("Ativo", true);
        JRadioButton rbInativo = new JRadioButton("Inativo");
        ButtonGroup bg = new ButtonGroup(); bg.add(rbAtivo); bg.add(rbInativo);
        pStatus.add(rbAtivo); pStatus.add(rbInativo);
        gbc.gridx = 1; panelEsquerdo.add(pStatus, gbc);

        JButton btnSalvar = new JButton("Salvar Aluno");
        gbc.gridy = 6; gbc.gridx = 0; gbc.gridwidth = 2; panelEsquerdo.add(btnSalvar, gbc);

        String[] colunas = {"Nome", "Matrícula", "Curso", "E-mail", "Status"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollTable = new JScrollPane(tabela);

        btnSalvar.addActionListener(e -> {
            if (txtNome.getText().trim().isEmpty() || txtMatr.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha Nome e Matrícula!");
                return;
            }

            String status = rbAtivo.isSelected() ? "Ativo" : "Inativo";
            modelo.addRow(new Object[]{txtNome.getText(), txtMatr.getText(), cbCurso.getSelectedItem(), txtEmail.getText(), status});
            
            txtNome.setText(""); txtMatr.setText(""); txtEmail.setText("");
            cbCurso.setSelectedIndex(0); rbAtivo.setSelected(true);
            txtNome.requestFocus();
        });

        add(panelEsquerdo, BorderLayout.WEST);
        add(scrollTable, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestãoAlunos().setVisible(true));
    }
}