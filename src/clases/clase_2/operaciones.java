package clase_2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class operaciones {
    public static void main(String[] args) {
        int n1, n2, suma, producto;
        float cociente;
        String mensaje;

        n1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un Entero:"));
        n2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce otro Entero:"));
        JFrame frame = new JFrame("Ejemplo de Solapas");
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("La suma de" + n1 + "+" + n2 + " es igual a " + (n1 + n2)));
        tabbedPane.addTab("Suma", panel1);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("La Diferencia de" + n1 + "-" + n2 + " es igual a " + (n1 - n2)));
        tabbedPane.addTab("Diferencia", panel2);

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("El producto de " + n1 + "*" + n2 + " es igual a " + (n1 * n2)));
        tabbedPane.addTab("Producto", panel3);

        JPanel panel4 = new JPanel();
        if (n2 == 0)
            mensaje = "No se permite la división por cero(0)";
        else {
            cociente = (float) n1 / n2;
            mensaje = "El cociente de " + n1 + "/" + n2 + " es igual a " + cociente;
        }
        panel4.add(new JLabel(mensaje));
        tabbedPane.addTab("Cociente", panel4);

        frame.add(tabbedPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
