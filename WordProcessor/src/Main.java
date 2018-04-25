import javax.swing.*;

public class Main {
	
    public static void main(String[] args) 
    {
    		Display display = new Display();
        JFrame frame = new JFrame("Word Processor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(display.getMenuBar());
        frame.setVisible(true);
    }
}
