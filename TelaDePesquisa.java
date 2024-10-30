import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.sql.*;

public class TelaDePesquisa extends JFrame {
    public static final JTextField txtPesquisa = new JTextField(20);
    public final JButton btnPesquisar;

    public final JLabel lblId;
    public static final JTextField txtId = new JTextField(10);

    public final JLabel lblNome;
    public static final JTextField txtNome = new JTextField(10);

    public final JLabel lblEmail;
    public static final JTextField txtEmail = new JTextField(10);

    public static final JButton btnPrimeiro = new JButton("<<");;
    public static final JButton btnAnterior = new JButton("<");;
    public static final JButton btnProximo = new JButton(">");;
    public static final JButton btnUltimo = new JButton(">>");;

    public static final JLabel lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);

    public TelaDePesquisa() {
        super("Tela de Pesquisa");
        setLayout(new GridLayout(7,1,5,5));

        JPanel linhaInputPesquisa = new JPanel(new GridLayout(1,1));
        // txtPesquisa = new JTextField(20);
        linhaInputPesquisa.add(txtPesquisa);
        add(linhaInputPesquisa);

        JPanel linhaBotaoPesquisar = new JPanel(new GridLayout(1,1));
        btnPesquisar = new JButton("Pesquisar");
        linhaBotaoPesquisar.add(btnPesquisar);
        add(linhaBotaoPesquisar);

        JPanel linhaId = new JPanel(new GridLayout(1,2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        // txtId = new JTextField(10);
        txtId.setEditable(false);
        linhaId.add(lblId);
        linhaId.add(txtId);
        add(linhaId);

        JPanel linhaNome = new JPanel(new GridLayout(1,2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        // txtNome = new JTextField(10);
        txtNome.setEditable(false);
        linhaNome.add(lblNome);
        linhaNome.add(txtNome);
        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1,2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        // txtEmail = new JTextField(10);
        txtEmail.setEditable(false);
        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);
        add(linhaEmail);

        JPanel linhaBotoes = new JPanel(new GridLayout(1,4));
        // btnPrimeiro = new JButton("<<");
        // btnAnterior = new JButton("<");
        // btnProximo = new JButton(">");
        // btnUltimo = new JButton(">>");
        linhaBotoes.add(btnPrimeiro);
        linhaBotoes.add(btnAnterior);
        linhaBotoes.add(btnProximo);
        linhaBotoes.add(btnUltimo);
        add(linhaBotoes);

        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,1));
        // lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linhaNotificacoes.add(lblNotificacoes);
        add(linhaNotificacoes);

        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaPrimeiroRegistro();
                }
            }
        );

        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaRegistroAnterior();
                }
            }
        );

        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaProximoRegistro();
                }
            }
        );

        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.vaParaUltimoRegistro();
                }
            }
        );
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String termoPesquisa = txtPesquisa.getText().trim();
                NavegadorDeRegistro.pesquisarRegistro(termoPesquisa);
            }
        });

        setSize(300,300);
        setVisible(true);

        NavegadorDeRegistro.inicializacaoDeRegistros();
    }

    public static void notificarUsuario(String strTexto) {
        lblNotificacoes.setText(setHtmlFormat(strTexto));
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void habilitarVoltar() {
        btnPrimeiro.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnProximo.setEnabled(false);
        btnUltimo.setEnabled(false);
    }

    public static void habilitarAvancar() {
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
    }

    public static void habilitarTodos() {
        btnPrimeiro.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnProximo.setEnabled(true);
        btnUltimo.setEnabled(true);
    }

    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}