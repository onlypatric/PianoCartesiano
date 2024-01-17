import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * La classe CartesianPanel estende JPanel e rappresenta un pannello in cui
 * viene disegnata una parabola
 * basata sui coefficienti a, b e c. Gli slider della classe SliderPanel possono
 * essere utilizzati per
 * modificare dinamicamente questi coefficienti e visualizzare la parabola
 * aggiornata.
 * 
 * @author check readme
 * @version 1.1
 * @see README.md
 */
class CartesianPanel extends JPanel {

    private double a = 1.0;  // Valori predefiniti
    private double b = 0.0;
    private double c = 0.0;
    private Color currColor = Color.BLUE;

    /**
     * Restituisce il valore corrente del coefficiente a.
     *
     * @return Il valore corrente di a.
     */
    public double getA() {
        return a;
    }

    /**
     * Restituisce il valore corrente del coefficiente b.
     *
     * @return Il valore corrente di b.
     */
    public double getB() {
        return b;
    }

    /**
     * Restituisce il valore corrente del coefficiente c.
     *
     * @return Il valore corrente di c.
     */
    public double getC() {
        return c;
    }

    /**
     * Metodo paintComponent, sovrascritto per disegnare la parabola e gli assi cartesiani.
     *
     * @param g Oggetto Graphics utilizzato per disegnare sul pannello.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Disegna gli assi cartesiani
        g.drawLine(0, centerY, getWidth(), centerY);
        g.drawLine(centerX, 0, centerX, getHeight());

        // Disegna i valori degli assi e la parabola
        drawAxisValues(g, centerX, centerY);
        drawParabola(g, centerX, centerY);
    }

    /**
     * imposta il colore della parabola
     * @param newColor il nuovo colore della parabola
     */
    public void setParabolaColor(Color newColor){
        currColor=newColor;
        revalidate();
        repaint();
    }

    /**
     * Metodo privato per disegnare la parabola sulla finestra.
     *
     * @param g      Oggetto Graphics utilizzato per disegnare.
     * @param centerX Coordinata x del centro della finestra.
     * @param centerY Coordinata y del centro della finestra.
     */
    private void drawParabola(Graphics g, int centerX, int centerY) {
        int scale = 20;
        g.setColor(currColor);

        // Disegna la parabola in base ai valori di a, b e c
        for (float x = -getWidth(); x <= getWidth(); x += 0.1) {
            int y = (int) (a * x * x + b * x + c) / scale;
            y = -y;

            int xPixel = (int) (centerX + x);
            int yPixel = centerY + y;

            // Disegna un punto della parabola
            g.fillRect(xPixel, yPixel, 1, 1);
        }
    }

    /**
     * Metodo privato per disegnare i valori degli assi.
     *
     * @param g      Oggetto Graphics utilizzato per disegnare.
     * @param centerX Coordinata x del centro della finestra.
     * @param centerY Coordinata y del centro della finestra.
     */
    private void drawAxisValues(Graphics g, int centerX, int centerY) {
        int scale = 20;
        int axisMarkingLength = 5;

        g.setColor(Color.WHITE);

        // Disegna i valori sull'asse x
        for (int x = -getWidth() / scale; x <= getWidth() / scale; x++) {
            int xPixel = centerX + x * scale;
            int yPixel = centerY;

            // Disegna una linea e scrive il valore
            g.drawLine(xPixel, centerY - axisMarkingLength, xPixel, centerY + axisMarkingLength);

            Font smallFont = new Font("Arial", Font.PLAIN, 8);
            g.setFont(smallFont);

            g.drawString(Integer.toString(x), xPixel - 3, yPixel + 10);
        }

        // Disegna i valori sull'asse y
        for (int y = -getHeight() / scale; y <= getHeight() / scale; y++) {
            int xPixel = centerX;
            int yPixel = centerY - y * scale;

            // Disegna una linea e scrive il valore
            g.drawLine(centerX - axisMarkingLength, yPixel, centerX + axisMarkingLength, yPixel);

            Font smallFont = new Font("Arial", Font.PLAIN, 8);
            g.setFont(smallFont);

            g.drawString(Integer.toString(y), xPixel + 5, yPixel + 5);
        }
    }

    /**
     * Metodo pubblico per impostare il valore di a e ridisegnare la parabola.
     *
     * @param a Il nuovo valore di a.
     */
    public void setA(double a) {
        this.a = a;
        repaint();
    }

    /**
     * Metodo pubblico per impostare il valore di b e ridisegnare la parabola.
     *
     * @param b Il nuovo valore di b.
     */
    public void setB(double b) {
        this.b = b;
        repaint();
    }

    /**
     * Metodo pubblico per impostare il valore di c e ridisegnare la parabola.
     *
     * @param c Il nuovo valore di c.
     */
    public void setC(double c) {
        this.c = c;
        repaint();
    }
}
