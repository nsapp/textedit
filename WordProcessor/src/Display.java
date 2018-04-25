import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Display extends JPanel implements ActionListener {
    private JTextPane textArea;
    private JMenuBar menuBar;
    private JMenu file,font;
    private JMenuItem newWindow,open,save,saveAs,exit;
    private JRadioButtonMenuItem radioButtonMenuItem1, radioButtonMenuItem2, radioButtonMenuItem3;
    private JCheckBoxMenuItem checkBoxMenuItem1, checkBoxMenuItem2;
    private JLabel processorLabel;

    public Display(){
        init();
    }

    private void init(){
        //Construct Components
        //Build File menu
        menuBar = new JMenuBar();
        
        font = new JMenu("Font");
        file = new JMenu("File");
        
        newWindow = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");

        ButtonGroup group = new ButtonGroup();
        radioButtonMenuItem1 = new JRadioButtonMenuItem("Monospaced");
        radioButtonMenuItem2 = new JRadioButtonMenuItem("Serif");
        radioButtonMenuItem3 = new JRadioButtonMenuItem("Sans Serif");
        checkBoxMenuItem1 = new JCheckBoxMenuItem("Italic");
        checkBoxMenuItem2 = new JCheckBoxMenuItem("Bold");
        
        textArea = new JTextPane();

        //Build Font Menu
        
        group.add(radioButtonMenuItem1);
        radioButtonMenuItem2.addActionListener(e -> {});
        radioButtonMenuItem1.addActionListener(e -> {});
        checkBoxMenuItem1.addActionListener(e -> {});
        radioButtonMenuItem3.addActionListener(e -> {});
        checkBoxMenuItem2.addActionListener(e -> {});
        group.add(radioButtonMenuItem2);
        group.add(radioButtonMenuItem3);
        
        font.add(radioButtonMenuItem2);
        font.add(radioButtonMenuItem3);
        font.add(radioButtonMenuItem1);
        font.addSeparator();
        font.add(checkBoxMenuItem1);
        font.add(checkBoxMenuItem2);

        //add label
        processorLabel = new JLabel("Text Editor");
        //Adjust Size and Layout

        file.add(newWindow);
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(exit);
        menuBar.add(file);
        menuBar.add(font);
    }
    
    public JMenuBar getMenuBar()
    {
    		return menuBar;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
