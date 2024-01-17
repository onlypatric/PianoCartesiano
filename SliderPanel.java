import java.awt.Color;

import javax.swing.*;

/**
 * La classe SliderPanel è dedicata alla gestione degli slider per la selezione
 * dei valori a, b e c della formula.
 * 
 * @author check readme
 * @version 1.1
 * @see README.md
 */
class SliderPanel extends JPanel{
    private JSlider slider2,slider3;
    private DoubleJSlider slider1;
    private JLabel formulaJLabel;
    private JPanel sliderJPanel1,sliderJPanel2,sliderJPanel3;
    CartesianPanel panel;

    /**
     * Costruttore della classe SliderPanel.
     *
     * @param panel         Il pannello CartesianPanel a cui questa classe è
     *                      associata.
     * @param formulaJLabel JLabel utilizzato per visualizzare la formula corrente.
     */
    public SliderPanel(CartesianPanel panel,JLabel formulaJLabel) {
        this.formulaJLabel = formulaJLabel;
        this.panel=panel;
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));

        sliderJPanel1=new JPanel();
        sliderJPanel1.setLayout(new BoxLayout(sliderJPanel1, BoxLayout.PAGE_AXIS));
        slider1 = new DoubleJSlider(-100, 100, 50, 100);
        slider1.setMajorTickSpacing(10);
        slider1.setMinorTickSpacing(1);
        slider1.setPaintTicks(true);

        sliderJPanel2=new JPanel();
        sliderJPanel2.setLayout(new BoxLayout(sliderJPanel2, BoxLayout.PAGE_AXIS));
        slider2 = new JSlider(JSlider.VERTICAL, -100, 100, 0);
        slider2.setMajorTickSpacing(10);
        slider2.setMinorTickSpacing(1);
        slider2.setPaintTicks(true);

        sliderJPanel3=new JPanel();
        sliderJPanel3.setLayout(new BoxLayout(sliderJPanel3, BoxLayout.PAGE_AXIS));
        slider3 = new JSlider(JSlider.VERTICAL, -100, 100, 0);
        slider3.setMajorTickSpacing(10);
        slider3.setMinorTickSpacing(1);
        slider3.setPaintTicks(true);

        sliderJPanel1.setBackground(Color.BLACK);
        sliderJPanel2.setBackground(Color.BLACK);
        sliderJPanel3.setBackground(Color.BLACK);

        addListeners();
        buildComponents();
    }

    private JLabel whiteLabel(String text){
        JLabel lbl = new JLabel(text);
        lbl.setForeground(getBackground());
        return lbl;
    }

    /**
     * Metodo privato utilizzato per costruire e posizionare gli slider nella
     * finestra.
     */
    private void buildComponents(){
        sliderJPanel1.add(whiteLabel("a"));
        sliderJPanel1.add(slider1);
        sliderJPanel2.add(whiteLabel("b"));
        sliderJPanel2.add(slider2);
        sliderJPanel3.add(whiteLabel("c"));
        sliderJPanel3.add(slider3);
        add(sliderJPanel1);
        add(sliderJPanel2);
        add(sliderJPanel3);
    }

    /**
     * Metodo privato utilizzato per aggiungere gli ascoltatori agli slider per
     * l'aggiornamento della formula.
     */
    private void addListeners(){
        slider1.addChangeListener(e->{
            panel.setA(slider1.getScaledValue());
            updateLabel();
        });
        slider2.addChangeListener(e->{
            panel.setB(slider2.getValue());
            updateLabel();
        });
        slider3.addChangeListener(e->{
            panel.setC(slider3.getValue()*100);
            updateLabel();
        });
    }

    /**
     * Metodo pubblico utilizzato per aggiornare la JLabel con la formula corrente
     * basata sui valori degli slider.
     */
    public void updateLabel(){
        formulaJLabel.setText("Formula mostrata y="+panel.getA()*50+"x^2+"+panel.getB()/100*6+"x+"+panel.getC()/100/4);
    }
}