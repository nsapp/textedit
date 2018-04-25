import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Display extends JPanel implements ActionListener {
    public JTextPane textArea;
    public JMenuBar menuBar;
    public JMenu file,font;
    public JMenuItem neww,open,save,saveas,exit;
    public JRadioButtonMenuItem radioButtonMenuItem1, radioButtonMenuItem2, radioButtonMenuItem3;
    public JCheckBoxMenuItem checkBoxMenuItem1, checkBoxMenuItem2;
    public JLabel processorLabel;

    public Display(){
        init();
    }

    public void init(){
        //Construct Components
        //Build File menu
        menuBar = new JMenuBar();
        file = new JMenu("File");
        neww = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveas = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");
        
        file.add(neww);
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.add(saveas);
        file.addSeparator();
        file.add(exit);
        menuBar.add(file);

        //Build Font Menu
        font = new JMenu("Font");
        menuBar.add(font);
        ButtonGroup group = new ButtonGroup();
        radioButtonMenuItem1 = new JRadioButtonMenuItem("Monospaced");
        radioButtonMenuItem1.addActionListener(this);
        group.add(radioButtonMenuItem1);
        font.add(radioButtonMenuItem1);
        radioButtonMenuItem2 = new JRadioButtonMenuItem("Serif");
        radioButtonMenuItem2.addActionListener(this);
        group.add(radioButtonMenuItem2);
        font.add(radioButtonMenuItem2);
        radioButtonMenuItem3 = new JRadioButtonMenuItem("Sans Serif");
        radioButtonMenuItem3.addActionListener(this);
        group.add(radioButtonMenuItem3);
        font.add(radioButtonMenuItem3);
        font.addSeparator();
        checkBoxMenuItem1 = new JCheckBoxMenuItem("Italic");
        checkBoxMenuItem1.addActionListener(this);
        font.add(checkBoxMenuItem1);
        checkBoxMenuItem2 = new JCheckBoxMenuItem("Bold");
        checkBoxMenuItem2.addActionListener(this);
        font.add(checkBoxMenuItem2);

        //add label
        processorLabel = new JLabel("Text Editor");
        //Adjust Size and Layout
        setPreferredSize(new Dimension(817,473));
        setLayout(null);


        textArea.setBounds(10,10,650,450);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
