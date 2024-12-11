import javax.swing.JFrame; // Importa a classe JFrame da biblioteca Swing, que é usada para criar uma janela na interface gráfica.

public class MenuTest // Declara a classe pública MenuTest. Esta classe será usada para testar o menu da interface gráfica.
{
   public static void main(String[] args) // O método main é o ponto de entrada do programa.
   { 
      MenuFrame menuFrame = new MenuFrame(); // Cria uma instância de MenuFrame, presumivelmente uma classe que gerencia a interface gráfica.

      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define que o programa será encerrado quando a janela for fechada.

      menuFrame.setSize(500, 200); // Define o tamanho da janela com 500 pixels de largura e 200 pixels de altura.

      menuFrame.setVisible(true); // Torna a janela visível para o usuário.
   } 
} 
