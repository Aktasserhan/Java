
import java.awt.HeadlessException;
import javax.swing.JFrame;


public class gameScreen extends JFrame{

    public gameScreen(String title) throws HeadlessException {
        super(title); 
    }
    
    
    public static void main(String[] args) {
        gameScreen screen = new gameScreen("Game Screen");
        screen.setResizable(false);
        screen.setFocusable(false);
        screen.setSize(800,600);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Game game = new Game();
        game.requestFocus();
        game.addKeyListener(game);
        game.setFocusable(true);
        game.setFocusTraversalKeysEnabled(false);
        
        screen.add(game);
        
        screen.setVisible(true);
    }
}
