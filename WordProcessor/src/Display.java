import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Display extends JPanel {
    private JTextPane textArea;
    private JMenuBar menuBar;
    private JMenu file,font;
    private JMenuItem newWindow,open,save,saveAs,exit;
    private JRadioButtonMenuItem monospacedButton, serifButton, sansSerifButton;
    private JCheckBoxMenuItem italicBox, boldBox;
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
        monospacedButton = new JRadioButtonMenuItem("Monospaced");
        serifButton = new JRadioButtonMenuItem("Serif");
        sansSerifButton = new JRadioButtonMenuItem("Sans Serif");
        italicBox = new JCheckBoxMenuItem("Italic");
        boldBox = new JCheckBoxMenuItem("Bold");
        
        textArea = new JTextPane();

        //Build Font Menu
        
        serifButton.addActionListener(e -> {
        	textArea.setFont(new Font("Serif", Font.PLAIN, 12));
        });
        monospacedButton.addActionListener(e -> {
        	textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        });
        sansSerifButton.addActionListener(e -> {
        	textArea.setFont(new Font("San Serif", Font.PLAIN, 12));
        });
        boldBox.addItemListener(e -> {
        	if (e.getStateChange() == ItemEvent.SELECTED) {
        	textArea.setFont(textArea.getFont().deriveFont(Font.BOLD));
        	}
        	if (e.getStateChange() == ItemEvent.DESELECTED)
        	{
            	textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
        	}
        });
        italicBox.addActionListener(e -> {
        	textArea.setFont(new Font("San Serif", Font.PLAIN, 12));
        });
        group.add(serifButton);
        group.add(sansSerifButton);
        group.add(monospacedButton);
        
        font.add(serifButton);
        font.add(sansSerifButton);
        font.add(monospacedButton);
        font.addSeparator();
        font.add(italicBox);
        font.add(boldBox);

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
    
    public ScrollPane getTextArea()
    {
    	ScrollPane sp = new ScrollPane();
    	sp.add(textArea);
    	
    	return sp;
    }
}
