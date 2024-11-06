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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Fire {
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

public class Play extends JPanel implements KeyListener, ActionListener {
    Timer timer = new Timer(5, this);
    private int passTime = 0;  // Oyun süresi
    private BufferedImage image; // Yılan resmi
    private ArrayList<Fire> bullets = new ArrayList<>(); // Kurşunlar

    // Yılanın konumu
    private int snakeX = 55;
    private int snakeY = 55;
    
    // Yılanın hareket hızı
    private final int movementSpeed = 4; 

    public Play() {
        try {
            // Yılanın resmini yükleme
            image = ImageIO.read(new FileImageInputStream(new File("Snake.png")));
        } catch (IOException ex) {
            Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBackground(Color.white);
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        timer.start();
    }

    public boolean checkCollisions() {
    // Light gray kutuların sınırlarını tanımlama
    Rectangle leftWall = new Rectangle(0, 0, 50, 565);
    Rectangle topWall = new Rectangle(0, 0, 780, 50);
    Rectangle rightWall = new Rectangle(735, 0, 50, 565);
    Rectangle bottomWall = new Rectangle(0, 513, 750, 50);

    // Ortadaki light gray kutular
    Rectangle[] grayBoxes = {
        new Rectangle(100, 0, 50, 450),   // 100, 0, 50, 450
        new Rectangle(200, 100, 50, 500), // 200, 100, 50, 500
        new Rectangle(300, 0, 50, 450),   // 300, 0, 50, 450
        new Rectangle(400, 100, 50, 500), // 400, 100, 50, 500
        new Rectangle(500, 0, 50, 450),   // 500, 0, 50, 450
        new Rectangle(600, 100, 50, 500), // 600, 100, 50, 500
        new Rectangle(700, 0, 50, 450)    // 700, 0, 50, 450
    };

    // Yılanın dikdörtgeni
    Rectangle snakeRect = new Rectangle(snakeX, snakeY, 20, 20);

    // Kenarlarla çarpışma kontrolü
    if (snakeRect.intersects(leftWall) || snakeRect.intersects(topWall) ||
        snakeRect.intersects(rightWall) || snakeRect.intersects(bottomWall)) {
        return true; // Çarpışma varsa
    }

    // Ortadaki light gray kutularla çarpışma kontrolü
    for (Rectangle box : grayBoxes) {
        if (snakeRect.intersects(box)) {
            return true; // Çarpışma varsa
        }
    }
    

    
    return false; 
}


    public boolean checkRedBoxCollision() {
        // Kırmızı kutunun sınırlarını tanımlama
        Rectangle redBox = new Rectangle(715, 450, 20, 65);
        Rectangle snakeRect = new Rectangle(snakeX, snakeY, 20, 20);

        return snakeRect.intersects(redBox); // Kırmızı kutu ile çarpışma kontrolü
    }

    public boolean checkBoundaries() {
        // Yılanın kenarlara çarpma kontrolü
        return (snakeX < 0 || snakeX > 735 || snakeY < 0 || snakeY > 535);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        passTime += 5;

        // Arka plan ve sınırları çizme
        g.setColor(Color.gray);
        g.fillRect(0, 0, 50, 565);
        g.fillRect(100, 0, 50, 450);
        g.fillRect(200, 100, 50, 500);
        g.fillRect(300, 0, 50, 450);
        g.fillRect(400, 100, 50, 500);
        g.fillRect(500, 0, 50, 450);
        g.fillRect(600, 100, 50, 500);
        g.fillRect(700, 0, 50, 450);
        g.fillRect(0, 0, 780, 50);
        g.fillRect(735, 0, 50, 565);
        g.fillRect(0, 513, 750, 50);

        // Kırmızı kutu çizme
        g.setColor(Color.red);
        g.fillRect(715, 450, 20, 65);

        // Yılan resmi çizme
        g.drawImage(image, snakeX, snakeY, image.getWidth() / 10, image.getHeight() / 10, this);


        // Çarpışma kontrolü
        if (checkCollisions() || checkBoundaries()) {
            timer.stop();
            String message = "You lose....\n" +
                             "\nPassed Time : " + passTime / 1000.0 + " Seconds";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }

        // Kırmızı kutuya çarpma kontrolü
        if (checkRedBoxCollision()) {
            timer.stop();
            String message = "Congratulations, you won!\n" +
                             "\nPassed Time : " + passTime / 1000.0 + " Seconds";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
            if (snakeX > 0) {
                snakeX -= movementSpeed;
            }
        } else if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D) {
            if (snakeX < 735) {
                snakeX += movementSpeed;
            }
        } else if (c == KeyEvent.VK_UP || c == KeyEvent.VK_W) {
            if (snakeY > 0) {
                snakeY -= movementSpeed;
            }
        } else if (c == KeyEvent.VK_DOWN || c == KeyEvent.VK_S) {
            if (snakeY < 535) {
                snakeY += movementSpeed;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
