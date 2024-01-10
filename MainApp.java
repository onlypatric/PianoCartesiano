import javax.swing.SwingUtilities;

/**
 * Entry point dell'applicazione
 * 
 * contiene il metodo main per avviare l'app
 * 
 * @author check README
 * @version v1.0
 */
public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::new);
    }
}