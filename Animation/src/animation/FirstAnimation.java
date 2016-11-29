package animation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.sun.awt.AWTUtilities;
import java.awt.image.BufferedImage;
public class FirstAnimation extends JFrame {

    private int x, y;
    private float alpha;
    
    public FirstAnimation(String title) {
        super(title);
        x = 50;
        y = 50;
        alpha = .1f;
        Icon bug = new ImageIcon( getClass().getResource( "bug1.gif" ) );
        
        JPanel panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("bug1.gif"));
          Graphics2D g2 = (Graphics2D) g;
            g2.setComposite(AlphaComposite.SrcOver.derive(alpha)); 
            g2.drawImage(icon.getImage(),0, 0, x,y,this);
           
            }
        };

        add(panel);
       
        panel.setOpaque(false); // make the background transparent
        setUndecorated(true); // make the title bar invisible
        AWTUtilities.setWindowOpaque(this, false);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
      
        Timer timer = new Timer(10, new ActionListener() {
            int counter = 0;
            boolean scycle = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println(counter++);
                if(x < 200&&scycle==false) {
                   x++;
                   repaint();              
                }
                if(y<200&&scycle==false){
                    y++;
                    repaint();
                }
                if(x==200&&y==200){
                    scycle=true;
                }
                if(x <= 200&&scycle==true) {
                   x--;
                   repaint();                    
                }
                if(y<=200&&scycle==true){
                    y--;
                    repaint();
                }
                if(x==0&&y==0){
                    scycle=false;
                }
                
                if(scycle==false){
                    alpha += 0.007f;
                }
                else{
                    alpha -= 0.007f;
                }
                
                if (alpha > 1.0f) {
                alpha=1.0f;
                } else {
                repaint();
                }
                if(alpha < 0f){
                    alpha=0f;
                }else{
                    repaint();
                }

            }
        });        
        timer.start();
        
    }

    public static void main(String args[]) {
        new FirstAnimation("FirstAnimation");
    }
}
