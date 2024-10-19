import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*; 

public class TelaDeLogin extends JFrame 
{
 private final JLabel LblLogin;
 private final JTextField textLogin;
 private final JLabel LblSenha;
 private final JPasswordField textSenha;
 private final JButton btnLogar;
 private final JLabel lblNotificacoes;

 public TelaDeLogin()
 {
 setLayout(new FlowLayout());

 LblLogin = new JLabel("Login");
 add(LblLogin);

 textLogin = new JTextField(10);
 add(textLogin);

 LblSenha = new JLabel("Senha");
 add(LblSenha);

 textSenha = new JPasswordField(10);
 add(textSenha);

 btnLogar = new JButton("Logar");
 add(btnLogar);

 lblNotificacoes = new JLabel("Notificações");
 add(lblNotificacoes);

 ButtonHandler buttonHandler = new ButtonHandler();
 btnLogar. addActionListener(buttonHandler);

 }

 private class ButtonHandler implements ActionListener 
 {
    @Override
    public void actionPerformed (ActionEvent event)
    {
      try{
        Connection conexao = MySQLConnector.conectar();
        String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '"+textLogin.getText() + "' and senha = '" + String.valueOf(textSenha.getPassword()) +"';";
        Statement stmSqllogin = conexao.createStatement();
        ResultSet rstSqlLogin = stmSqllogin.executeQuery(strSqlLogin) ;
        if (rstSqlLogin.next()) {
            lblNotificacoes.setText("Login estabelecido!");
        
          } 
          else 
            {
               lblNotificacoes.setText("Não foi possivel encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente.");

            }

      } catch (Exception e){
        lblNotificacoes.setText("Houve um problema e não será possivel realizar o login neste momento. Por favor, tente novamente maus tarde.");
        System.err.println("erro"+e);
      }
      
    }
  }

 public static void main (String[] args) 
 {
 TelaDeLogin appTelaDeLogin = new TelaDeLogin();

 appTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 appTelaDeLogin.setSize(600, 140);
 appTelaDeLogin.setVisible(true);
 
 }
}

