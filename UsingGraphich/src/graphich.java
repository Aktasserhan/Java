
import java.awt.HeadlessException;
import javax.swing.JFrame;


public class graphich extends JFrame{

    public graphich(String title) throws HeadlessException {
        super(title);
    }
    public static void main(String[] args) {
        UsingGraphich graphich = new UsingGraphich();
        
        graphich screen = new graphich("Using Graphich");
        screen.setVisible(true);
        screen.setResizable(true);
        screen.setSize(800,600);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        screen.add(graphich);
        
        
    }
}
