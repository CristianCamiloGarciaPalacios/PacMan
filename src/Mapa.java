import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mapa {
    JLabel label;
    ImageIcon icono;
    public Mapa(){
        icono = new ImageIcon(getClass().getResource("/Imagenes/Mapa.png"));
        label = new JLabel(icono);
        label.setBounds(0, 0, 339, 375);
    }
}
