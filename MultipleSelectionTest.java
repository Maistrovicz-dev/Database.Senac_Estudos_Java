
import javax.swing.JFrame;

public class MultipleSelectionTest
{
   public static void main(String[] args)
   { 
      MultipleSelectionFrame multipleSelectionFrame =
         new MultipleSelectionFrame(); 
      multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);
      multipleSelectionFrame.setSize(700, 150); 
      multipleSelectionFrame.setVisible(true); 
   } 
} 