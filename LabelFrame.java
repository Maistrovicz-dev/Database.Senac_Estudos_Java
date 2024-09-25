
import java.awt.FlowLayout; // importando
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 
import javax.swing.Icon; 
import javax.swing.ImageIcon; 

public class LabelFrame extends JFrame /** A linha abaixo a classe tem o mesmo nome do arquivo "Obrigatorio"
 *extends esta herdando o componente JFrame "Injetando no bloco de codigos abaixo"
 */
{ // iniciando bloco de codigos da classe LabelFrame
   private final JLabel label1; // Declaraçoes de variaveis, o private "privado" não exporta a variavel, o final serve para declarar uma variavel sómente leitura 
   private final JLabel label2; // "Jlabel" é o tipo da variavel
   private final JLabel label3; // "labe" é a variavel
   
   
   public LabelFrame() // O construtor não pode ser privado, tem que ter o mesmo nome da classe e do arquivo
   { // inicio do bloco de codigos do construtor
      super("Testing JLabel"); // "super" significa que esta sendo definindo o titulo da "janela"
      setLayout(new FlowLayout()); // "setLayout" ira definir o desenho do quadro "renderização", "FlowLayout" ira definir a base das camadas
      
      label1 = new JLabel("Label with text"); // label1 esta recebendo um objeto "JLabel" que esta recebendo um parametro "texto" 
      label1.setToolTipText("This is label1"); // label1 esta invocanto "seToolTipText" um texto de dica ao deixar o mouse em cima
      add(label1); // adicionando "add" label1 add ira mostrar

      
      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); /**  declarando uma variavel do tipo "Icon" que esta recebendo "ImageIcon" que esta recebendo um parametro
      * que é o nome do arquivo "bug1.png"
      */
      label2 = new JLabel("Label with text and icon", bug, /** "label2" esta recebendo um novo objeto do tipo um novo JLabel alem de um novo parametro, 
      * a "," dentro de um codigo de parametro serve como separador de parametro
      */
         SwingConstants.LEFT); // contem informações sobre alinhamento e que esta importando a variavel "LEFT"
      label2.setToolTipText("This is label2");
      add(label2); // adicionando "add" label2 add ira mostrar

      label3 = new JLabel(); // labe13 esta recebendo a variavel
      label3.setText("Label with icon and text at bottom"); // "setText" esta definindo o texto
      label3.setIcon(bug);  // inseriendo o icone "bug" que é a variavel do tipo icon
      label3.setHorizontalTextPosition(SwingConstants.CENTER); // esta definindo a posição horizontal do texto
      label3.setVerticalTextPosition(SwingConstants.BOTTOM); // esta definindo a posição vertical do texto
      label3.setToolTipText("This is label3"); // texto de ferramenta de dica
      add(label3); 
   } 
} 