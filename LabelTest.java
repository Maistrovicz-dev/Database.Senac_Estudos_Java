// A linha abaixo importará o componente do módulo swing da biblioteca (pacote) javax
import javax.swing.JFrame;

// A liha abaixo está declarando a classe LabelTest
public class LabelTest 
// A linha abaixo está abrindo o bloco de código da classe LabelTest 
{
   // A linha debaixo está declarando o método main
   public static void main(String[] args)
   // A linha abaixo está declarando a váriavel labelFrame 
   { 
      LabelFrame labelFrame = new LabelFrame(); // Váriavel é do tipo LabelFrame, esta sendo criada a partir deo mesmo construtor, labelframe com "l" é para indicar a váriavel
      //Na linha abaixo o método após o ponto irá definir a operação de fechamento padrão.
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Na linha abaixo o SetSize irá definir o tamanho. 
      labelFrame.setSize(260, 180); 
      //Na linha abaixo irá definir a visibilidade.
      labelFrame.setVisible(true); 
      //A linha abaixo está encerrando o cloco de códigos do método main
   } 

} //A linha abaixo está encerrando o cloco de códigos da classe.
