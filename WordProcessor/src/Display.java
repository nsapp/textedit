import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class Display extends JPanel {
    private JTextPane textArea;
    private JMenuBar menuBar;
    private JMenu file,font;
    private JMenuItem newWindow,open,save,saveAs,exit;
    private JRadioButtonMenuItem monospacedButton, serifButton, sansSerifButton;
    private JCheckBoxMenuItem italicBox, boldBox;
    private JLabel processorLabel;
    private File editFile;

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

        newWindow.addActionListener(e -> {
            textArea.setText("");
        });

        open.addActionListener(e -> {
            openFile();
        });

        save.addActionListener(e -> {
            saveFile(textArea);
        });

        saveAs.addActionListener(e -> {
            saveFile(textArea);
        });

        exit.addActionListener(e -> {
            System.exit(0);
        });

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
        italicBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC));;
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
            }
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
    
    public JMenuBar getMenuBar() {
    		return menuBar;
    }
    
    public ScrollPane getTextArea() {
    	ScrollPane sp = new ScrollPane();
    	sp.add(textArea);
    	
    	return sp;
    }

    public void saveFile(JTextPane text){
        if (text.getText().length() > 0) {
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("RICH TEXT FORMAT", "rtf","rtf");
            chooser.setFileFilter(filter);

            int option = chooser.showSaveDialog(null);
            String filePath = chooser.getSelectedFile().getPath();

            if (!chooser.getSelectedFile().getPath().toLowerCase().endsWith(".rtf")) {
                filePath = chooser.getSelectedFile().getPath() + ".rtf";
            }

            if (option == JFileChooser.APPROVE_OPTION) {
                StyledDocument doc = (StyledDocument)text.getDocument();
                RTFEditorKit kit = new RTFEditorKit();
                FileOutputStream out;

                try {
                    out = new FileOutputStream(filePath);
                    kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                } catch (BadLocationException e) {

                }
            } else {
                System.out.println("Save Cancelled");
            }
        }
    }

    public void openFile() {
        JFileChooser fileDialog = new JFileChooser();
        if (fileDialog == null)
            fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File to be Opened");
        fileDialog.setSelectedFile(null);  // No file is initially selected.
        int option = fileDialog.showOpenDialog(this);
        if (option != JFileChooser.APPROVE_OPTION)
            return;  // User canceled or clicked the dialog's close box.
        File selectedFile = fileDialog.getSelectedFile();
        InputStream in;
        try {
            in = new FileInputStream(selectedFile);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Sorry, but an error occurred while trying to open the file:\n" + e);
            return;
        }
        try {
            Document doc = new DefaultStyledDocument();
            textArea.getEditorKit().read(in,doc,0);
            in.close();
            textArea.setDocument(doc);
            editFile = selectedFile;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Sorry, but an error occurred while trying to read the data:\n" + e);
        }
    }
}
