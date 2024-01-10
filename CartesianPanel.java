import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class CartesianPanel extends JPanel {

    private double a = 1.0;  // Default values
    private double b = 0.0;
    private double c = 0.0;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g.drawLine(0, centerY, getWidth(), centerY);
        g.drawLine(centerX, 0, centerX, getHeight());

        drawAxisValues(g, centerX, centerY);
        drawParabola(g, centerX, centerY);
    }

    private void drawParabola(Graphics g, int centerX, int centerY) {
        int scale = 20;
        g.setColor(Color.BLUE);

        for (float x = -getWidth(); x <= getWidth(); x+=0.2) {
            int y = (int) (a * x * x + b * x + c) / scale;
            y = -y;

            int xPixel = (int)(centerX + x);
            int yPixel = centerY + y;

            g.fillRect(xPixel, yPixel, 1, 1);
        }
    }
    private void drawAxisValues(Graphics g, int centerX, int centerY) {
        int scale = 20;
        int axisMarkingLength = 5;

        g.setColor(Color.BLACK);

        // Draw x-axis values
        for (int x = -getWidth() / scale; x <= getWidth() / scale; x++) {
            int xPixel = centerX + x * scale;
            int yPixel = centerY;

            g.drawLine(xPixel, centerY - axisMarkingLength, xPixel, centerY + axisMarkingLength);

            // Set smaller font size
            Font smallFont = new Font("Arial", Font.PLAIN, 8);
            g.setFont(smallFont);

            g.drawString(Integer.toString(x), xPixel - 3, yPixel + 10);
        }

        // Draw y-axis values
        for (int y = -getHeight() / scale; y <= getHeight() / scale; y++) {
            int xPixel = centerX;
            int yPixel = centerY - y * scale;

            g.drawLine(centerX - axisMarkingLength, yPixel, centerX + axisMarkingLength, yPixel);

            // Set smaller font size
            Font smallFont = new Font("Arial", Font.PLAIN, 8);
            g.setFont(smallFont);

            g.drawString(Integer.toString(y), xPixel + 5, yPixel + 5);
        }
    }
    // Setters for updating a, b, and c values
    public void setA(double a) {
        this.a = a;
        repaint();
    }

    public void setB(double b) {
        this.b = b;
        repaint();
    }

    public void setC(double c) {
        this.c = c;
        repaint();
    }
}
