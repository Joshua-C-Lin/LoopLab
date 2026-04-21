import javax.swing.*;
import java.awt.*;

public class LoopLab extends JPanel {
    String type;
    int sizeNum;

    public LoopLab() {
      type = JOptionPane.showInputDialog(null, "Do you want an addition table or a multiplication table? (A/M)");
      sizeNum = Integer.parseInt(JOptionPane.showInputDialog(null, "How big do you want the table to be?").trim());
    }

    @Override
    public void paintComponent(Graphics g) {
      int dialogWith = getWidth();
      int dialogHeight = getHeight();

      int x = 0;
      int y = 0;
      int cellWidth = dialogWith / sizeNum;
      int cellHeight = dialogHeight / sizeNum;

      // Nested loops to draw the table
      for (int j = 1; j <= sizeNum; j++) {
        for (int i = 1; i <= sizeNum; i++) {
          if (i == 1 || j == 1) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, cellWidth, cellHeight);
          }
          g.setColor(Color.BLACK);
          g.drawRect(x, y, cellWidth, cellHeight);

          if (i == 1) {
            g.drawString("" + j, x + 5, y + 15);
          } else if (j == 1) {
            g.drawString("" + i, x + 5, y + 15);
          } else {
            if(type.toLowerCase().equals("a")) {
              g.drawString("" + (i + j), x + 5, y + 15);
            } else {
              g.drawString("" + (i * j), x + 5, y + 15);
            }
          }

          x += cellWidth;
        }

        x = 0;
        y += cellHeight;
      }
    }

    public static void main(String[] args) {
      JFrame frame = new JFrame("Loop Lab");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 400);
      frame.setContentPane(new LoopLab());
      frame.setVisible(true);
    }
}