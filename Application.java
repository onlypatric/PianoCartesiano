import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.prefs.Preferences;

/**
 * Applicazione principale
 * 
 * @author check readme
 * @version 1.1
 * @see README.md
 */
public class Application extends JFrame {

    private static final String PREF_KEY_X = "frameX";
    private static final String PREF_KEY_Y = "frameY";
    private static final String PREF_KEY_WIDTH = "frameWidth";
    private static final String PREF_KEY_HEIGHT = "frameHeight";
    

    public Application() {
        setTitle("Parabola su piano cartesiano");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Preferences prefs = Preferences.userNodeForPackage(Application.class);
        int x = prefs.getInt(PREF_KEY_X, 100);
        int y = prefs.getInt(PREF_KEY_Y, 100);
        int width = prefs.getInt(PREF_KEY_WIDTH, 400);
        int height = prefs.getInt(PREF_KEY_HEIGHT, 400);

        setBounds(x, y, width, height);

        setLayout(new BorderLayout());

        // Create a panel to draw the Cartesian plane and parabola
        CartesianPanel cartesianPanel = new CartesianPanel();
        JLabel formulaJLabel = new JLabel("Formula mostrata: y=x^2");

        SliderPanel sliderPanel = new SliderPanel(cartesianPanel, formulaJLabel);
        sliderPanel.updateLabel();

        add(cartesianPanel, BorderLayout.CENTER);
        add(sliderPanel, BorderLayout.WEST);
        add(formulaJLabel, BorderLayout.SOUTH);

        addComponentListener(new ComponentAdapter() {
            @Override 
            public void componentMoved(ComponentEvent e) {
                saveFrameLocation();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                saveFrameLocation();
            }
        });

        setVisible(true);
    }

    private void saveFrameLocation() {
        // Save the current position and size
        Preferences prefs = Preferences.userNodeForPackage(Application.class);
        Rectangle bounds = getBounds();
        prefs.putInt(PREF_KEY_X, bounds.x);
        prefs.putInt(PREF_KEY_Y, bounds.y);
        prefs.putInt(PREF_KEY_WIDTH, bounds.width);
        prefs.putInt(PREF_KEY_HEIGHT, bounds.height);
    }
}