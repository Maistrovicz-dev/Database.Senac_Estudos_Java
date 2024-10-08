
import java.awt.*; // Importa componentes gráficos AWT
import java.awt.event.*; // Importa eventos de AWT
import javax.swing.*; // Importa componentes gráficos Swing

public class ComboBoxFrame extends JFrame 
{
   private final JComboBox<String> imagesJComboBox; // ComboBox de seleção de imagens
   private final JLabel label; // Label que exibirá o ícone da imagem

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"}; // Nomes dos arquivos de imagem
   private final Icon[] icons = { 
      new ImageIcon(getClass().getResource(names[0])), // Ícone para bug1.gif
      new ImageIcon(getClass().getResource(names[1])), // Ícone para bug2.gif
      new ImageIcon(getClass().getResource(names[2])), // Ícone para travelbug.gif
      new ImageIcon(getClass().getResource(names[3]))}; // Ícone para buganim.gif

   
   public ComboBoxFrame() // Declara o construtor 
   {
      super("Testing JComboBox"); // Título da janela
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout (saída de camadas por fluxo)

      imagesJComboBox = new JComboBox<String>(names); // Cria ComboBox com os nomes das imagens
      imagesJComboBox.setMaximumRowCount(3); // Define número máximo de itens visíveis

      imagesJComboBox.addItemListener(
         new ItemListener() 
         {
            
            @Override
            public void itemStateChanged(ItemEvent event)
            {
               // Verifica se um item foi selecionado e altera o ícone do label
               if (event.getStateChange() == ItemEvent.SELECTED)
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]); // Atualiza ícone conforme o item selecionado
            } 
         } 
      ); 

      add(imagesJComboBox); // Adiciona ComboBox ao JFrame
      label = new JLabel(icons[0]); // Exibe o primeiro ícone por padrão
      add(label); // Adiciona o JLabel ao JFrame
   }
} 
