
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Fire{
    private int x;
    private int y;

    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
public class Game extends JPanel implements KeyListener,ActionListener{
    Timer timer = new Timer(5,this);
    
    private int passTime = 0;
    private int spentBullets = 0;
    private BufferedImage image;
    
    private  ArrayList<Fire> bullets = new ArrayList<Fire>();
    
    private int firefY = 10;
    private int balX = 0;
    private int balbX = 4;     
    private int spaceShipX = 0;
    private int SSpaceX = 20;
    public boolean check(){
        for(Fire fire : bullets){
            
            if(new Rectangle(fire.getX(),fire.getY(),10,20).intersects(new Rectangle(balX,0,20,20))){
                return true;
            }
        }
        return false; 
    }
    public Game() {
        
        try {
            image = ImageIO.read(new FileImageInputStream(new File("spaceShip.png")));
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.black);
        
        timer.start();
        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            passTime += 5;
            g.setColor(Color.red);
            g.fillOval(balX, 0, 20, 20);
            
            g.drawImage(image, spaceShipX, 480, image.getWidth()/15,image.getHeight()/15,this);
            
            for(Fire fire : bullets){
                if(fire.getY() < 0 ){
                    bullets.remove(fire);
                }
            }
            g.setColor(Color.blue);
            
            for(Fire fire : bullets){
                g.fillOval(fire.getX()+4, fire.getY()-13, 10, 10);
            }
            if(check()){
                timer.stop();
                String message = "You win....\n"+
                                 "Spended Bullet : "+spentBullets+
                                 "\nPassed Time : "+passTime/1000.0+" Seconts";
                JOptionPane.showMessageDialog(this, message);
                System.exit(0);
            }
    }

    @Override
    public void repaint() {
        super.repaint(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A){
            if(spaceShipX <= 0){
                spaceShipX = 0;
            }
            else{
                spaceShipX -= SSpaceX; 
            }
        }
        else if(c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
            if(spaceShipX >= 735){
                spaceShipX = 735;
            }
            else{
                spaceShipX +=SSpaceX;
            }
        }
        else if(c == KeyEvent.VK_CONTROL || c == KeyEvent.VK_W){
            bullets.add(new Fire(spaceShipX+15,480));
            spentBullets++;
            
            
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(Fire fire : bullets){
             fire.setY(fire.getY() - firefY);
        }
        
        balX += balbX;
        if(balX >= 750){
            balbX = - balbX;
        }
        if(balX <= 0){
            balbX = - balbX;
        }
        repaint();
    }
        
}
