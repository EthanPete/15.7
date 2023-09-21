import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleColorChange extends JFrame {
    private Color currentColor = Color.WHITE;

    public CircleColorChange() {
        setTitle("Circle Color Changer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a custom JPanel to draw the circle
        JPanel circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int diameter = Math.min(getWidth(), getHeight());
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;
                g.setColor(currentColor);
                g.fillOval(x, y, diameter, diameter);
            }
        };

        circlePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentColor = Color.BLACK;
                circlePanel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentColor = Color.WHITE;
                circlePanel.repaint();
            }
        });

        getContentPane().add(circlePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CircleColorChange circleColorChange = new CircleColorChange();
            circleColorChange.setVisible(true);
        });
    }
}
