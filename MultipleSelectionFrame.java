import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame 
{
   private final JList<String> colorJList;
   private final JList<String> copyJList;
   private JButton copyJButton;
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};

   private final JList<String> fruitJList;
   private final JList<String> copyJList2;
   private JButton copyJButton2;
   private static final String[] fruitNames = {"Maçã", "Banana", "Cereja",
      "Tâmara", "Uva", "Kiwi", "Limão", "Manga", "Laranja", "Pêssego", 
      "Pera", "Abacaxi", "Melancia"};

   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      colorJList = new JList<String>(colorNames);
      colorJList.setVisibleRowCount(5);
      colorJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList));

      copyJButton = new JButton("Copy >>>"); 
      copyJButton.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(new String[0]));
            }
         } 
      ); 

      add(copyJButton);

      copyJList = new JList<String>();
      copyJList.setVisibleRowCount(5);
      copyJList.setFixedCellWidth(100);
      copyJList.setFixedCellHeight(15);
      copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList));

      fruitJList = new JList<String>(fruitNames);
      fruitJList.setVisibleRowCount(5);
      fruitJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(fruitJList));

      copyJButton2 = new JButton("Copy >>>"); 
      copyJButton2.addActionListener(
         new ActionListener() 
         {  
            @Override
            public void actionPerformed(ActionEvent event)
            {
               copyJList2.setListData(
                  fruitJList.getSelectedValuesList().toArray(new String[0]));
            }
         } 
      ); 

      add(copyJButton2);

      copyJList2 = new JList<String>();
      copyJList2.setVisibleRowCount(5);
      copyJList2.setFixedCellWidth(100);
      copyJList2.setFixedCellHeight(15);
      copyJList2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList2));
   } 
} 
