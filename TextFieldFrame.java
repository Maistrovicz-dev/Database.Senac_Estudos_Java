import java.awt.FlowLayout;            // 'import' importação 'awt' componente modulo biblioteca
import java.awt.event.ActionListener;  //importa um componente sub modulo modulo biblioteca
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
public class TextFieldFrame extends JFrame // declaração da classe 'TextFieldFrame' que esta erdando 'extends' JFrame
{ // inicio da classe 'TextFieldFrame'
   private final JTextField textField1; //declarações de variaveis
   private final JTextField textField2; // 'private' uso exclusivo da classe 'TextField' não se pode alterar 'final'
   private final JTextField textField3; 
   private final JPasswordField passwordField; 
   
   public TextFieldFrame() // exportando 'public' o contrutor 'TextFieldFrame'
   { // inicio do bloco de codigos do contrutor 'TextFieldFrame'
      super("Testing JTextField and JPasswordField"); // definição do titulo da janela 'super'
      setLayout(new FlowLayout()); // 'setLayout' renderização da tela
      
      textField1 = new JTextField(10); // atribuindo um novo 'new' JTextField definindo a altura das colunas
      add(textField1); // 'add' esta acionando 'textField1'
      
      textField2 = new JTextField("Enter text here"); // 'textField2' esta sendo atribuido em um novo JTextField com a string 'Enter text here'
      add(textField2);  // 'add' esta acionando 'textField2'
      
      textField3 = new JTextField("Uneditable text field", 21); // 'textField3' esta sendo atribuido e um novo texto
      textField3.setEditable(false); // é um metodo que ira definir que esse 'textField' não sera editado
      add(textField3); // 'add' esta acionando 'textField3'
      
      passwordField = new JPasswordField("Hidden text"); //esta tendo uma atribuição de um novo obejto do 'JPsswordField'
      add(passwordField); // 'add' esta acionando o 'passwordField'
      
      TextFieldHandler handler = new TextFieldHandler(); // 'TextFieldHandler' manipulador dos campos 'textField' campo de texto, 'TextFieldHandler' esta sendo atribuida a variavel 'handler'
      textField1.addActionListener(handler); // adicionando um escutador 'Linstener' de ação 'Action' dentro do parametro sera atribuido o 'handler'
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler); //'handler' tem que ser um objeto
   } // fim do bloco de codigos do contrutor 'TextFieldFrame'
   
   private class TextFieldHandler implements ActionListener //esta sendo ijetado 'implements' como objeto
   { // new ActionListener()
      
      @Override // "passa por cima"
      public void actionPerformed(ActionEvent event) // 'actionPerfomed' ações que ira acontecer no bloco de codigos
      { // inicio do bloco de codigo do 'actionPerfomed'
         String string = ""; // definindo a string que esta atribuindo a essa variavel um texto vazil
         
         if (event.getSource() == textField1) // 'if' algoritimo de validação dois sinais de igual é um operador de comporação
            string = String.format("textField1: %s", //esta executando 'String.format' entrega o texto formatavel. '%s' é um caractere coringa o "s" dps da porcetagem ira retornar o texto
               event.getActionCommand()); // pega o comando da ação 'getActionCommand' o texto dentro do espaço
         
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());
         
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());
         
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());
         
         JOptionPane.showMessageDialog(null, string);  // invocando 'JOptionPane' e exibindo parmetro 'ShowMessageDialog' uma caixa de dialogo
      } // fim do bloco de codigo 'actionPerfomed'
   } // fim do bloco de codigo da classe 'TextFieldHandler'
} // fim da classe 'TextFieldFrame'