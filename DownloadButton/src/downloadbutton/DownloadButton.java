package downloadbutton;
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class DownloadButton {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame( "Download news" );
        JButton b = new JButton("Download");
        frame.add(b);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setSize( 400, 200 ); // set frame size
      frame.setVisible( true ); // display frame
      b.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent e) 
				{ 
                                    b.setSelected(true);
					 read(args[0]);
                                         b.setSelected(false);
                                         JOptionPane.showMessageDialog( null, "Download Done" , 
         "Done", JOptionPane.PLAIN_MESSAGE );
				} 
			}); 
       
    }
    public static void read( String strURL ) {
        int chunksize = 4096;
        byte[] chunk = new byte[chunksize];
        int count;
        try  {    
            URL pageUrl = new URL(strURL );
            BufferedInputStream bis = new BufferedInputStream(pageUrl.openStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.html", false));
            while ((count = bis.read(chunk, 0, chunksize)) != -1) {
                bos.write(chunk, 0, count); 
            }
            bos.close();
            bis.close();     
           System.out.println("Done");   
         }catch (IOException e) {
             e.printStackTrace();
         }
      }
    
    
}


