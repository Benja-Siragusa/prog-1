package clase_2;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class panel {
    public static void main(String[] args) {           
        
        /* Instanciamos a la clase JTabbedPane */
        /* Crea una ventana contenedora */
        JFrame frame = new JFrame("Ejemplo de Solapas");
        
        /* Crea una contenedor de Solapas */
        JTabbedPane tabbedPane = new JTabbedPane();

        /* Creamos 2 Solapas */
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Contenido de la Solapa 1"));
        tabbedPane.addTab("Solapa 1", panel1);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido de la Solapa 2"));
        tabbedPane.addTab("Solapa 2", panel2);

        /* Establecemos las propiedades de la Ventana */
        /* La hacemos visible */
        frame.add(tabbedPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
