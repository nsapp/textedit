import javax.swing.*;

public class Main extends Display {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Word Processor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Display());
        frame.pack();
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);
    }
}
