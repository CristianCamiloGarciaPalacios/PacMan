
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Point;

public class PacMan extends ObjetoDeChoque {
    Map<Integer, ImageIcon[]> icono = new HashMap<>();
    int patronComer, siguienteDireccion;

    public PacMan() {
        ImageIcon iconoPacMan1 = new ImageIcon(getClass().getResource("/Imagenes/PacMan1.png"));
        ImageIcon[] iconosArriba = { iconoPacMan1,
                new ImageIcon(getClass().getResource("/Imagenes/PacManArriba2.png")),
                new ImageIcon(getClass().getResource("/Imagenes/PacManArriba3.png")) };
        ImageIcon[] iconosDerecha = { iconoPacMan1,
                new ImageIcon(getClass().getResource("/Imagenes/PacManDerecha2.png")),
                new ImageIcon(getClass().getResource("/Imagenes/PacManDerecha3.png")) };
        ImageIcon[] iconosAbajo = { iconoPacMan1,
                new ImageIcon(getClass().getResource("/Imagenes/PacManAbajo2.png")),
                new ImageIcon(getClass().getResource("/Imagenes/PacManAbajo3.png")) };
        ImageIcon[] iconosIzquierda = { iconoPacMan1,
                new ImageIcon(getClass().getResource("/Imagenes/PacManIzquierda2.png")),
                new ImageIcon(getClass().getResource("/Imagenes/PacManIzquierda3.png")) };
        icono.put(0, iconosArriba);
        icono.put(1, iconosDerecha);
        icono.put(2, iconosAbajo);
        icono.put(3, iconosIzquierda);

        ubicacion = new Point(159, 201);
        frecuencia = 55;
        direccion = 1;
        siguienteDireccion = 1;
        label = new JLabel(iconoPacMan1);
        label.setBounds(ubicacion.x, ubicacion.y, 21, 21);
        patronComer = 0;
    }

    @Override
    public void movimiento() {
        super.movimiento();
        patronComer = (patronComer + 1) % 4;
        label.setIcon(icono.get(direccion)[-(Math.abs(patronComer - 2)) + 2]);
    }

    @Override
    public void cambioDireccion() {
        switch (siguienteDireccion) {
            case 0:
                if (!colicionArriba()) {
                    direccion = siguienteDireccion;
                }
                break;
            case 1:
                if (!colicionDerecha()) {
                    direccion = siguienteDireccion;
                }
                break;
            case 2:
                if (!colicionAbajo()) {
                    direccion = siguienteDireccion;
                }
                break;
            case 3:
                if (!colicionIzquierda()) {
                    direccion = siguienteDireccion;
                }
                break;
        }
    }
}