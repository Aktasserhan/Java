import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MinefieldGame extends JFrame {
    int bombsize = 0;
    private JButton[] buttons = new JButton[100];
    private Set<Integer> bombPositions = new HashSet<>();
    
    public MinefieldGame(int bombCount) {
        // Oyun paneli ayarları
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 10));
        
        // 100 butonu oluştur ve panele ekle
        for (int i = 0; i < 100; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.LIGHT_GRAY);
            panel.add(buttons[i]);
            
            // Her butona tıklama olayı ekle
            final int index = i;  // Lambda ifadesinde kullanmak için sabit bir değişken
            buttons[i].addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (bombPositions.contains(index)) {
                        buttons[index].setBackground(Color.RED);  // Bomba varsa kırmızı
                        //buttons[index].setText("B");
                        bombsize+=1;
                        if(bombsize==4){
                          for (JButton button : buttons) {
                                button.setEnabled(false);
                            }
                          JOptionPane.showMessageDialog(null,"You use whole rights" ,"Game Over",JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        buttons[index].setBackground(Color.BLUE);  // Bomba yoksa mavi
                        //buttons[index].setText("0");
                    }
                    buttons[index].setEnabled(false); // Tıklandıktan sonra devre dışı bırak
                }
            });
        }

        // Rastgele bombaları yerleştir
        placeBombs(bombCount);
        
        add(panel);
        setTitle("Minefield Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Belirtilen sayıda bombayı rastgele yerleştiren metot
    private void placeBombs(int bombCount) {
        Random rand = new Random();
        while (bombPositions.size() < bombCount) {
            int position = rand.nextInt(100); // 0 ile 99 arasında rastgele bir sayı
            bombPositions.add(position);
        }
    }

    public static void main(String[] args) {
        // Örneğin 20 bomba yerleştir
        SwingUtilities.invokeLater(() -> new MinefieldGame(20).setVisible(true));
    }
}
