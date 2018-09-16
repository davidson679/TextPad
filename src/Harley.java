/**
 * This Program Is Created By Harley Davidson
 * Follow Us on Instagram @top_h4cker
 * Follow us on Facebook www.facebook.com/tophackerjk
 * Follow us on Twitter : @Alex83985613
 */


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.*;

public class Harley extends JFrame{

    JTextArea textarea = new JTextArea(20, 60);
    JFileChooser fc = new JFileChooser();

    public Harley() {

        JScrollPane scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        FileFilter txtFilter = new FileNameExtensionFilter("Plain Text", "txt");

        fc.setFileFilter(txtFilter);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        menuBar.add(file);

        add(scrollPane);

        file.add(Open);
        file.add(Save);
        file.addSeparator();
        file.add(Exit);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);



    }

    Action Open = new AbstractAction("Open File") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                openFile(fc.getSelectedFile().getAbsoluteFile());
            }
        }
    };

    Action Save = new AbstractAction("Save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveFile();
        }
    };

    Action Exit = new AbstractAction("Exit") {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

    public void openFile(File fileName){
        FileReader fr = null;
        try{
            fr = new FileReader(fileName);
            textarea.read(fr, null);

            fr.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveFile(){
        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            FileWriter fw = null;
            try{
                fw = new FileWriter(fc.getSelectedFile().getAbsoluteFile() + ".txt");
                textarea.write(fw);
                fw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] main){
        new Harley();

    }

}