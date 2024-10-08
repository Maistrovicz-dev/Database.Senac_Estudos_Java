import javax.swing.*; //Importou a Biblioteca do Javax */

public class ComboBoxTest //*Declarou a classe */
{//*Abriu o bloco da classe */
   public static void main(String[] args)//*declaração método main  */
   { //*inicia o bloco de codigos do metódo */
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); //*declaração da variável comboboxframe*/
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //* declara a operação de fechamento padrão */
      comboBoxFrame.setSize(350, 150); //*evoca o metódo setsize pra declarar o tamanho da janela */
      comboBoxFrame.setVisible(true); //*evoca o metódo setvisible e torna a janela visivel */
   } //*encerramento do bloco do método main */
} //encerramento do bloco da classe */