package javaapplication97;
import java.io.IOException;
import java.net.URI;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URI;
import java.awt.Desktop;
import java.awt.Font;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




public class JavaApplication97 extends JFrame {
    

    
    public static void youtube() throws URISyntaxException{
        
        try {
            
      

            JLabel label = new JLabel("What do you want to search for?");

            label.setFont(new Font("Times", Font.BOLD, 30));
           
           ImageIcon youtube = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/youtube.png");
           
            Object artistreader = JOptionPane.showInputDialog(null,label,"YouTube",JOptionPane.INFORMATION_MESSAGE,youtube,null,"");
       
            
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI e = new URI("https://www.youtube.com/" +"results?search_query=" + artistreader);
            desktop.browse(e);
            
            System.out.println("YouTube was opened in browser");
            
        } catch (IOException ex) {
            
            Logger.getLogger(JavaApplication97.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        JLabel loopfont = new JLabel("Search again?");
        
        loopfont.setFont(new Font("Times",  Font.BOLD, 30));
        
  
        HashMap hm2 = new HashMap();
      
        
        
        if(hm2.containsKey("yes")){
            
           youtube(); 
           
        } else if (hm2.containsKey("no")){
            
            System.exit(0);
        }

        
   }


    public static String dictionary(){
        
   
            JLabel label1 = new JLabel("What word do you want to define?");
            label1.setFont(new Font("Times", Font.BOLD, 30));
            ImageIcon dictionary = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/dictionary.jpg");
            Object diction = JOptionPane.showInputDialog(null,label1,"",JOptionPane.INFORMATION_MESSAGE,dictionary,null,"");
        
 
        try
        {
            
         Class.forName("org.sqlite.JDBC");
         
        }
        catch (Exception e)
        {
            System.out.println("Exception 1: " + e);
        }
        
        Connection d = null;
        
        try 
        {
            d = DriverManager.getConnection("jdbc:sqlite:/Users/phillipdacosta/Downloads/dictionary_big.db");
        }
        catch (SQLException s)
                {
                  System.out.println("Exception 2:" + s);
                  
                }
        
           
       String sql = "select * from words WHERE word = " + "'" + diction + "'";
       
       
        
        PreparedStatement p = null;
        ResultSet r = null;
        
        try 
        {

            p = d.prepareStatement(sql)  ;
            p.clearParameters();
            r = p.executeQuery();
            
         
            String definition;
            
            if(r.next()) {
                
             
                definition = r.getString("defn");
                
                
                JTextArea textArea = new JTextArea(10, 40);
                
                
                textArea.setWrapStyleWord(true);
                
                textArea.setText(definition);
                textArea.setEditable(false);
                
                ImageIcon definition1 = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/definition.jpg");
      
                // wrap a scrollpane around it
                
                JScrollPane scrollPane = new JScrollPane(textArea);
               // scrollPane.setBorder(border);
                
       
                // display them in a message dialog
                
        JOptionPane.showMessageDialog(null, scrollPane,"Definition:",JOptionPane.INFORMATION_MESSAGE,definition1);
                
        JLabel loopfont = new JLabel("Search again?(Yes or No)");
                 
        ImageIcon magnify = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/magnify.jpg");
                 
        loopfont.setFont(new Font("Times",  Font.BOLD, 30));
        
        Object loop = JOptionPane.showInputDialog(null,loopfont,"Search again",JOptionPane.INFORMATION_MESSAGE,magnify,null,"");
        

        HashMap hm2 = new HashMap();
        hm2.put(loop, null);
         
        if(hm2.containsKey("yes")){
            
           dictionary(); 
           
        } else if (hm2.containsKey("no")){
            
            System.exit(0);
        }

                
                
               } else

               if (!sql.equals(diction)){
                   
                   
            JTextArea textArea = new JTextArea();
    
            textArea.setText("Unable to find word in this dictionary.");
            
            textArea.setFont(new Font("Times", Font.BOLD, 30));
            ImageIcon cantfind = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/cantfind.jpg");
           
           JOptionPane.showMessageDialog(null,textArea, "Oops",JOptionPane.INFORMATION_MESSAGE,cantfind);
           
         JLabel loopfont = new JLabel("Search again?(Yes or No)");
                 
          ImageIcon magnify = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/magnify.jpg");
                 
        loopfont.setFont(new Font("Times",  Font.BOLD, 30));
        
        Object loop = JOptionPane.showInputDialog(null,loopfont,"Search again",JOptionPane.INFORMATION_MESSAGE,magnify,null,"");
        

        HashMap hm2 = new HashMap();
        hm2.put(loop, null);
         
        if(hm2.containsKey("yes")){
            
           dictionary(); 
           
        } else if (hm2.containsKey("no")){
            
            System.exit(0);
         }

       } 
                

            r.close();
            p.close();
            d.close();
            
        }
        
        catch (SQLException s)
            
                {
                  System.out.println("Exception 3:" + s);
                }
                    return null;
         }
    
    public static void begin(){
        
        
             JLabel label = new JLabel("Type 'Dictionary' or 'YouTube' to search.");
             ImageIcon earth = new ImageIcon("/Users/phillipdacosta/Desktop/JavaApplication103/src/javaapplication103/Javaimages/earth.jpg");

            label.setFont(new Font("Times", Font.BOLD, 30));
            Object search = JOptionPane.showInputDialog(null,label,"",JOptionPane.INFORMATION_MESSAGE,earth,null,"");
        

            HashMap hm = new HashMap();
            hm.put(search, null);
     
 
    if(hm.containsKey("dictionary") || hm.containsKey("Dictionary")){
        
    dictionary();
      
    }
     
     
    if(hm.containsKey("Youtube") || hm.containsKey("YouTube") || hm.containsKey("youtube")){
        
        try {
            
            youtube();
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(JavaApplication97.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
      

    
    public static void main(String[] args) throws Exception {
        
        begin();
        
        
        
        }    
        

}