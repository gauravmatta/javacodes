import javax.swing.JApplet;
import java.awt.Graphics;


public class MyCustomApplet extends JApplet 
{    
    public void init()
    {
        
    }
    
    
    public void paint(Graphics g)
    {
        g.drawString("To climb a ladder, start at the bottom rung", 20, 90);
    }
}
