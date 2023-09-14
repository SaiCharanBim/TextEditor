/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.acciotexteditor;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;




/**
 *
 * @author BIM SAI CHARAN
 */
public class AccioTexteditor implements ActionListener {
 
    
    JFrame frame ;
    JMenuBar menubar ;
    JMenu file, edit ;
    JMenuItem newfile , openfile, savefile, cut , copy , paste , select , close ;
    JTextArea Textarea;
    JPanel panel ;
    JScrollPane scrollpane ;
    
    
    
    AccioTexteditor(){
        // creating a frame for our project ;
        frame = new JFrame(); 
        // creating menu bar for the project ;
        menubar = new JMenuBar();
        // creating the  text area 
        Textarea = new JTextArea();
        // creating menu 
        file = new JMenu("file");
        edit = new JMenu("edit");
        // creating menu items 
        newfile =  new JMenuItem("newfile"); 
        openfile =  new JMenuItem("openfile"); 
        savefile =  new JMenuItem("savefile"); 
        cut =  new JMenuItem("cut"); 
        copy =  new JMenuItem("copy"); 
        paste =  new JMenuItem("paste"); 
        select =  new JMenuItem("select"); 
        close =  new JMenuItem("close"); 
         //adding menu items to action listener
        newfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        select.addActionListener(this);
        close.addActionListener(this);
        
        // adding menuitems to menu 
        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(select);
        edit.add(close);
       
        
        // adding menu to the menubar ;
        menubar.add(file);
        menubar.add(edit);
        //adding menubar to the frame ;
        frame.setJMenuBar(menubar);
        // frame.add(Textarea);
        // creating content panel 
        panel = new JPanel();
        EmptyBorder brd = new EmptyBorder(5,5,5,5);
        panel.setBorder(brd);
        panel.setLayout(new BorderLayout(0,0));
        panel.add(Textarea ,BorderLayout.CENTER);
        // creating scroll pane 
        scrollpane = new JScrollPane(Textarea , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollpane);
        frame.add(panel);
        
        frame.setBounds( 600 ,300 ,600 , 400);
        frame.setTitle("Charan TextEditor");
        frame.setVisible(true);
        frame.setLayout(null);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent ){
        if(actionEvent.getSource()== cut ){
            Textarea.cut();
        }
        if(actionEvent.getSource()== copy ){
            Textarea.copy();
        }
        if(actionEvent.getSource()== paste ){
            Textarea.paste();
        }
        if(actionEvent.getSource()== select ){
            Textarea.selectAll();
        }
        if(actionEvent.getSource()== close ){
            System.exit(0);
        }
        if(actionEvent.getSource() == openfile){
            JFileChooser filechooser = new JFileChooser("D:");
            int chooseoption = filechooser.showOpenDialog(null); // return whether we selected or not 
            if( chooseoption == JFileChooser.APPROVE_OPTION){
                File file = filechooser.getSelectedFile();
                String filepath = file.getPath();
                try {
                    FileReader fileReader = new FileReader(filepath); // intilizing file reader 
                    BufferedReader bufferedreader = new BufferedReader(fileReader); // for reading file 
                    String inter = "";
                    String output = "";
                    while ( ( inter = bufferedreader.readLine()) != null ){
                        output = output+inter + "\n";
                    }
                    // set text to output area
                    Textarea.setText(output);
                }
                catch( FileNotFoundException fileNotFoundException ){
                    fileNotFoundException.printStackTrace();
                }
                catch(IOException ioException ){
                    ioException.printStackTrace();
                }
                
            }
        }
        
        if ( actionEvent.getSource() == savefile ){
            JFileChooser filechooser = new JFileChooser("d:");
            int chooseOption = filechooser.showSaveDialog(null);
            if( chooseOption == JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath()+".txt");
                try{
                    FileWriter filewriter = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(filewriter);
                    Textarea.write(bw);
                    bw.close();
                }
                catch(IOException ioexc){
                    ioexc.printStackTrace();
                }
            }
        }
        
        if(actionEvent.getSource() == newfile ){
             AccioTexteditor newsample = new AccioTexteditor();
        }
    }

    public static void main(String[] args) {
       AccioTexteditor sample = new AccioTexteditor();
        
    }

    
   
}
