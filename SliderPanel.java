import javax.swing.*;
/**
 * Classe dedicata agli slider per selezionare la formula
 */
class SliderPanel extends JPanel{
    private JSlider slider2,slider3;
    private DoubleJSlider slider1;
    private JLabel formulaJLabel;
    private JPanel sliderJPanel1,sliderJPanel2,sliderJPanel3;
    CartesianPanel panel;

    public SliderPanel(CartesianPanel panel,JLabel formulaJLabel) {
        this.formulaJLabel = formulaJLabel;
        this.panel=panel;
        setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));

        sliderJPanel1=new JPanel();
        sliderJPanel1.setLayout(new BoxLayout(sliderJPanel1, BoxLayout.PAGE_AXIS));
        slider1 = new DoubleJSlider(-100, 100, 1, 100);
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

        addListeners();
        buildComponents();
    }
    private void buildComponents(){
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
            panel.setC(slider3.getValue()*10);
            updateLabel();
        });
    }
    public void updateLabel(){
        formulaJLabel.setText("Formula mostrata y="+panel.getA()*10+"x^2+"+panel.getB()+"x+"+panel.getC()/10);
    }
}