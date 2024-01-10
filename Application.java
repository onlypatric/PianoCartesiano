import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    public Application() {
        setTitle("Parabola on Cartesian Plane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());
        // Create a panel to draw the Cartesian plane and parabola
        CartesianPanel cartesianPanel = new CartesianPanel();
        add(cartesianPanel,BorderLayout.CENTER);
        add(new SliderPanel(),BorderLayout.WEST);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::new);
    }
}
class SliderPanel extends JPanel{
    public JSlider slider1,slider2,slider3;

    public SliderPanel() {
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
        JPanel sliderJPanel1=new JPanel();
        sliderJPanel1.setLayout(new BoxLayout(sliderJPanel1, BoxLayout.PAGE_AXIS));
        slider1 = new JSlider(JSlider.VERTICAL, -100, 100, 0);
        slider1.setMajorTickSpacing(10);
        slider1.setMinorTickSpacing(1);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        JPanel sliderJPanel2=new JPanel();
        sliderJPanel2.setLayout(new BoxLayout(sliderJPanel2, BoxLayout.PAGE_AXIS));
        slider2 = new JSlider(JSlider.VERTICAL, -100, 100, 0);
        slider2.setMajorTickSpacing(10);
        slider2.setMinorTickSpacing(1);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        JPanel sliderJPanel3=new JPanel();
        sliderJPanel3.setLayout(new BoxLayout(sliderJPanel3, BoxLayout.PAGE_AXIS));
        slider3 = new JSlider(JSlider.VERTICAL, -100, 100, 0);
        slider3.setMajorTickSpacing(10);
        slider3.setMinorTickSpacing(1);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        sliderJPanel1.add(new JLabel("a"));
        sliderJPanel1.add(slider1);
        sliderJPanel2.add(new JLabel("b"));
        sliderJPanel2.add(slider2);
        sliderJPanel3.add(new JLabel("c"));
        sliderJPanel3.add(slider3);
        add(sliderJPanel1);
        add(sliderJPanel2);
        add(sliderJPanel3);
    }
}
class CartesianPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g.drawLine(0, centerY, getWidth(), centerY);
        g.drawLine(centerX, 0, centerX, getHeight());

        drawParabola(g, centerX, centerY);
    }

    private void drawParabola(Graphics g, int centerX, int centerY) {
        int scale = 20;
        g.setColor(Color.BLUE);

        for (int x = -getWidth(); x <= getWidth(); x++) {
            int y = (x * x) / scale;

            y = -y;

            int xPixel = centerX + x;
            int yPixel = centerY + y;

            g.fillRect(xPixel, yPixel, 1, 1);
        }
    }
}