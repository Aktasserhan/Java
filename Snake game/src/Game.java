
import java.awt.HeadlessException;
import javax.swing.JFrame;


public class Game extends JFrame{
    
    public Game(String title) throws HeadlessException {
        super(title); 
    }
    
    public static void main(String[] args) {
        Game screen = new Game("Snake Game");
        screen.setResizable(false);
        screen.setFocusable(false);
        screen.setSize(800,600);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Play ply = new Play();
        ply.requestFocus();
        ply.addKeyListener(ply);
        ply.setFocusable(true);
        ply.setFocusTraversalKeysEnabled(false);
        
        screen.add(ply);
        screen.setVisible(true);
    }
}
