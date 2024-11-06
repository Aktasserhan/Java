
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class UsingGraphich extends JPanel{

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        g.setColor(Color.blue);
        g.drawRect(100, 10, 30, 40);
        g.fillRect(200, 100, 30, 40);
        
        g.setColor(Color.yellow);
        g.drawOval(200, 200, 50, 50);
        g.fillOval(300, 260, 40, 40);
        
        g.setColor(Color.white);
        g.drawLine(150, 300, 400, 200);
        
    }
 
    public UsingGraphich() {
        
        setBackground(Color.black);
        
    }
    
    
}
