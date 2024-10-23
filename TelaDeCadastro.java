import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaDeCadastro extends JFrame {
    public final JLabel lblNome;
    public final JTextField txtNome;
    
    public final JLabel lblEmail;
    public final JTextField txtEmail;
    
    public final JLabel lblSenha;
    public final JPasswordField txtSenha;
    
    public final JButton btnCadastrar;
    public final JButton btnCancelar;
    
    public final JLabel lblNotificacoes;
    
    public TelaDeCadastro() {
        super ("Tela de Cadastro");
        setLayout(new GridLayout(5,1,5,5));

        JPanel linhaNome = new JPanel(new GridLayout(1,2));

        lblNome =new JLabel("Nome", SwingConstants.CENTER);
        txtNome = new JTextField(10);

        linhaNome.add(lblNome);
        linhaNome.add(txtNome);

        add(linhaNome);
        
        JPanel linhaEmail = new JPanel(new GridLayout(1,2));
        lblEmail = new JLabel("Email", SwingConstants.CENTER);
        txtEmail = new JTextField(10);

        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);

        add(linhaEmail);

        JPanel linhaSenha = new JPanel(new GridLayout(1,2));
        lblSenha = new JLabel("Senha", SwingConstants.CENTER);
        txtSenha = new JPasswordField(10);

        linhaSenha.add(lblSenha);
        linhaSenha.add(txtSenha);

        add(linhaSenha);

        JPanel linhaBotoes = new JPanel(new GridLayout(1,2));
        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");

        linhaBotoes.add(btnCadastrar);
        linhaBotoes.add(btnCancelar);

        add(linhaBotoes);
        
        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,2));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linhaNotificacoes.add(lblNotificacoes);

        add(linhaNotificacoes);

            btnCadastrar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        if (txtNome.getText().trim().length() == 0) {
                            lblNotificacoes.setText("É necessário digitar alguma coisa no campo --Nome-- para prosseguir.");
                            txtNome.requestFocus();
                            return;
                        }

                        if(txtEmail.getText().trim().length() == 0) {
                            lblNotificacoes.setText("É necessário digitar alguma coisa no campo Email. Por favor, digite um caracter válido no campo Emial para prosseguir.");
                            txtEmail.requestFocus();
                            return;
                        }
                
                        if(String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
                            lblNotificacoes.setText("É necessário digitar alguma coisa no campo --Senha--. Por favor, digite um caracter válido no campo Senha para prosseguir.");
                            txtSenha.requestFocus();
                            return;
                        }

                        String strSqlCadastrar = "insert into `db_senac`.`tbl_senac`(`nome`,`email`, `senha`) values ('" +txtNome.getText()+ "','"+ txtEmail.getText()+ "','" + String.valueOf(txtSenha.getPassword())+"');";
                        try{
                        Connection conexao = MySQLConnector.conectar();
                        Statement stmSqlCadastrar = conexao.createStatement();
                        stmSqlCadastrar.addBatch(strSqlCadastrar);
                        stmSqlCadastrar.executeBatch();
                        lblNotificacoes.setText("Cadastro realizado com sucesso!");
                        } catch(Exception e){
                            lblNotificacoes.setText("Ops! Ocorreu um problema e não será possivel cadastrar nesse momento. Por favor, tente novamente mais tarde.");
                            System.err.println("Erro:" + e);
                        }

        
                    }
                
                }

            );

            setSize(300,300);
            setVisible(true);
        }

    public static void main(String[] args) {
        TelaDeCadastro appTelaDeCadastro= new TelaDeCadastro();
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}