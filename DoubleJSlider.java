import javax.swing.JSlider;

/**
 * Slider costruito sopra il JSlider predefinito di Swing che consente valori
 * `Double` come output. Questo slider elabora i dati come `Integer`, per poi
 * ridimensionarli a `Double` tramite un valore di scala.
 * @author check readme
 * @version 1.1
 * @see README.md
 */
class DoubleJSlider extends JSlider {

    final int scale;

    /**
     * costruttore dello slider di `Double`
     * @param min minimo valore dello slider
     * @param max massimo valore dello slider
     * @param value valore iniziale dello slider
     * @param scale valore di scala dello slider (valore di divisione)
     * @see DoubleJSlider#getScaledValue()
     * @see DoubleJSlider#scale
     */
    public DoubleJSlider(int min, int max, int value, int scale) {
        super(JSlider.VERTICAL,min, max, value);
        this.scale = scale;
    }

    /**
     * ottieni il valore dello slider ridimensionato per `Double` tramite il valore di scala
     * @return valore dello slider ridimensionato per `Double` tramite il valore di scala
     * @see DoubleJSlider#scale
     */
    public double getScaledValue() {
        return ((double)super.getValue()) / this.scale;
    }
}