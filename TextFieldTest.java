//  A linha abaixo está importando o componente JFrame do modulo Swing, da biblioteca JAVAX
import javax.swing.JFrame;

public class TextFieldTest// declarando a classe que tem o mesmo nome do arquivo
//Inicio do bloco de código da classe
{

   public static void main(String[] args)//Declaração do método main
   { //inicio do bloco de códigos do metodo main
      TextFieldFrame textFieldFrame = new TextFieldFrame();  
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//definir a operação de encerramento padrão
      textFieldFrame.setSize(350, 100); //definir o tamanho 
      textFieldFrame.setVisible(true); //definir visibilidade
   } //encerramento do bloco de codigo do merodo main
} //encerramento do bloco de codigo da classe


