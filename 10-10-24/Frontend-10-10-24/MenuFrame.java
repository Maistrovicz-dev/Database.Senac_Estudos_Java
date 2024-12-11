import java.awt.*; // Importa a classe Color para manipulação de cores.
import java.awt.event.*; // Importa a interface ActionListener para lidar com eventos de ação.
import javax.swing.*; // Importa a classe JFrame para criar a janela principal.

public class MenuFrame extends JFrame // Define a classe MenuFrame que estende JFrame, criando uma janela com menus.
{
   private final Color[] colorValues = // Declara um array de cores constantes para as opções de cor.
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   
   private final JRadioButtonMenuItem[] colorItems; // Declara um array para os itens de menu de cor.
   private final JRadioButtonMenuItem[] fonts; // Declara um array para os itens de menu de fontes.
   private final JCheckBoxMenuItem[] styleItems; // Declara um array para os itens de menu de estilo.
   private final JLabel displayJLabel; // Declara um JLabel para exibir texto.
   private final ButtonGroup fontButtonGroup; // Declara um grupo para agrupar os botões de opção de fonte.
   private final ButtonGroup colorButtonGroup; // Declara um grupo para agrupar os botões de opção de cor.
   private int style; // Declara uma variável para armazenar o estilo da fonte.

   public MenuFrame() // Construtor da classe MenuFrame.
   {
      super("Using JMenus"); // Chama o construtor da superclasse com o título da janela.

      JMenu fileMenu = new JMenu("File"); // Cria um menu "File".
      fileMenu.setMnemonic('F'); // Define a tecla de atalho 'F' para o menu "File".

      JMenuItem aboutItem = new JMenuItem("About..."); // Cria um item de menu "About...".
      aboutItem.setMnemonic('A'); // Define a tecla de atalho 'A' para o item "About...".
      fileMenu.add(aboutItem); // Adiciona o item "About..." ao menu "File".
      aboutItem.addActionListener( // Adiciona um listener de ação ao item "About...".
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event) // Método chamado quando o item é acionado.
            {
               JOptionPane.showMessageDialog(MenuFrame.this, // Exibe um diálogo de mensagem.
                  "This is an example\nof using menus", // Mensagem a ser exibida.
                  "About", JOptionPane.PLAIN_MESSAGE); // Título e tipo de diálogo.
            } 
         } 
      ); 

      JMenuItem exitItem = new JMenuItem("Exit"); // Cria um item de menu "Exit".
      exitItem.setMnemonic('x'); // Define a tecla de atalho 'x' para o item "Exit".
      fileMenu.add(exitItem); // Adiciona o item "Exit" ao menu "File".
      exitItem.addActionListener( // Adiciona um listener de ação ao item "Exit".
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event) // Método chamado quando o item é acionado.
            {
               System.exit(0); // Encerra a aplicação.
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // Cria uma barra de menu.
      setJMenuBar(bar); // Define a barra de menu para a janela.
      bar.add(fileMenu); // Adiciona o menu "File" à barra de menu.

      JMenu formatMenu = new JMenu("Format"); // Cria um menu "Format".
      formatMenu.setMnemonic('r'); // Define a tecla de atalho 'r' para o menu "Format".

      String[] colors = {"Black", "Blue", "Red", "Green"}; // Array de nomes de cores.

      JMenu colorMenu = new JMenu("Color"); // Cria um sub-menu "Color".
      colorMenu.setMnemonic('C'); // Define a tecla de atalho 'C' para o menu "Color".

      colorItems = new JRadioButtonMenuItem[colors.length]; // Inicializa o array de itens de menu de cor.
      colorButtonGroup = new ButtonGroup(); // Inicializa o grupo de botões para cores.
      ItemHandler itemHandler = new ItemHandler(); // Cria uma instância do manipulador de itens.

      for (int count = 0; count < colors.length; count++) // Loop para criar itens de cor.
      {
         colorItems[count] = // Cria um novo botão de opção para cada cor.
            new JRadioButtonMenuItem(colors[count]); 
         colorMenu.add(colorItems[count]); // Adiciona o botão ao menu de cor.
         colorButtonGroup.add(colorItems[count]); // Adiciona o botão ao grupo de cores.
         colorItems[count].addActionListener(itemHandler); // Adiciona o manipulador de ação.
      }

      colorItems[0].setSelected(true); // Seleciona a primeira cor como padrão.

      formatMenu.add(colorMenu); // Adiciona o menu de cor ao menu de formatação.
      formatMenu.addSeparator(); // Adiciona um separador no menu de formatação.
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"}; // Array de nomes de fontes.
      JMenu fontMenu = new JMenu("Font"); // Cria um sub-menu "Font".
      fontMenu.setMnemonic('n'); // Define a tecla de atalho 'n' para o menu "Font".

      fonts = new JRadioButtonMenuItem[fontNames.length]; // Inicializa o array de itens de menu de fonte.
      fontButtonGroup = new ButtonGroup(); // Inicializa o grupo de botões para fontes.

      for (int count = 0; count < fonts.length; count++) // Loop para criar itens de fonte.
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]); // Cria um novo botão de opção para cada fonte.
         fontMenu.add(fonts[count]); // Adiciona o botão ao menu de fontes.
         fontButtonGroup.add(fonts[count]); // Adiciona o botão ao grupo de fontes.
         fonts[count].addActionListener(itemHandler); // Adiciona o manipulador de ação.
      } 

      fonts[0].setSelected(true); // Seleciona a primeira fonte como padrão.
      fontMenu.addSeparator(); // Adiciona um separador no menu de fontes.

      String[] styleNames = {"Bold", "Italic"}; // Array de nomes de estilos de fonte.
      styleItems = new JCheckBoxMenuItem[styleNames.length]; // Inicializa o array de itens de menu de estilo.
      StyleHandler styleHandler = new StyleHandler(); // Cria uma instância do manipulador de estilo.

      for (int count = 0; count < styleNames.length; count++) // Loop para criar itens de estilo.
      {
         styleItems[count] = // Cria uma nova caixa de seleção para cada estilo.
            new JCheckBoxMenuItem(styleNames[count]); 
         fontMenu.add(styleItems[count]); // Adiciona a caixa de seleção ao menu de fontes.
         styleItems[count].addItemListener(styleHandler); // Adiciona o manipulador de item.
      }

      formatMenu.add(fontMenu); // Adiciona o menu de fontes ao menu de formatação.
      bar.add(formatMenu); // Adiciona o menu de formatação à barra de menu.
     
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER); // Cria um JLabel com texto centralizado.
      displayJLabel.setForeground(colorValues[0]); // Define a cor do texto como a primeira cor (preto).
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); // Define a fonte do JLabel como Serif, tamanho 72, estilo normal.

      getContentPane().setBackground(Color.CYAN); // Define a cor de fundo do painel da janela como ciano.
      add(displayJLabel, BorderLayout.CENTER); // Adiciona o JLabel ao centro da janela usando o layout BorderLayout.
   } 

   private class ItemHandler implements ActionListener // Classe interna para manipular eventos de ação.
   {
      @Override
      public void actionPerformed(ActionEvent event) // Método chamado quando um item é acionado.
      {
         for (int count = 0; count < colorItems.length; count++) // Loop para verificar qual cor foi selecionada.
         {
            if (colorItems[count].isSelected()) // Se o item de cor estiver selecionado.
            {
               displayJLabel.setForeground(colorValues[count]); // Altera a cor do texto para a cor selecionada.
               break; // Sai do loop após encontrar a cor selecionada.
            } 
         } 

         for (int count = 0; count < fonts.length; count++) // Loop para verificar qual fonte foi selecionada.
         {
            if (event.getSource() == fonts[count]) // Se a fonte acionada for a fonte atual.
            {
               displayJLabel.setFont( // Altera a fonte do JLabel.
                  new Font(fonts[count].getText(), style, 72)); // Cria uma nova fonte com o nome selecionado e o estilo atual.
            }
         }

         repaint(); // Repaint a janela para refletir as mudanças.
      } 
   } 

   private class StyleHandler implements ItemListener // Classe interna para manipular eventos de mudança de estado dos itens de estilo.
   {
      @Override
      public void itemStateChanged(ItemEvent e) // Método chamado quando o estado de um item muda.
      {
         String name = displayJLabel.getFont().getName(); // Obtém o nome da fonte atual.
         Font font; // Declara uma variável para a nova fonte.

         // Verifica quais estilos estão selecionados e cria a fonte correspondente.
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected()) // Se ambos, negrito e itálico, estão selecionados.
            font = new Font(name, Font.BOLD + Font.ITALIC, 72); // Define a fonte como negrito e itálico.
         else if (styleItems[0].isSelected()) // Se apenas negrito está selecionado.
            font = new Font(name, Font.BOLD, 72); // Define a fonte como negrito.
         else if (styleItems[1].isSelected()) // Se apenas itálico está selecionado.
            font = new Font(name, Font.ITALIC, 72); // Define a fonte como itálico.
         else
            font = new Font(name, Font.PLAIN, 72); // Se nenhum estilo está selecionado, define como normal.

         displayJLabel.setFont(font); // Altera a fonte do JLabel para a nova fonte.
         repaint(); // Repaint a janela para refletir as mudanças.
      } 
   } 
} 
