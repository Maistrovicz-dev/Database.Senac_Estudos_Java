// Na linha abaixo está importando a biblioteca (pacote) javax, o modulo swing e o componente JOptimoPane
import javax.swing.JOptionPane; 
//Na linha abaixo está sendo declarada a classe (addition)
public class Addition 
// Linha abaixo está abrindo o bloco de códigos da classe (Addition)
{
   //Na linha abaixo está declarado o método "main" (Principal) que vai executar a apliacação.
   public static void main(String[] args)
   //Na Linha abixo está sendo aberto o bloco de códigos do método main
   {
      String firstNumber = // Está sendo declarada a variavel Firstnumber, onde tem o operador de atribuição tem o declarador de variavel

         JOptionPane.showInputDialog("Enter first integer");// JOptionPane é o ocmponenente importado, quando eu declaro ele, estou invocando ele, showInputDialog 
      String secondNumber =
         JOptionPane.showInputDialog("Enter second integer");

    
      int number1 = Integer.parseInt(firstNumber); 
      int number2 = Integer.parseInt(secondNumber);

      int sum = number1 + number2;

      JOptionPane.showMessageDialog(null, "The sum is " + sum, 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} 


