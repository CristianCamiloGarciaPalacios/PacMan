import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaJuego extends JFrame {
    Mapa mapa;
    PacMan pacMan;
    public VentanaJuego(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("PacMan");
        getContentPane().setBackground(new Color(0, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Icon.png")).getImage());
        setBounds(0, 0, 356, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        pacMan = new PacMan();
        add(pacMan.label);

        mapa = new Mapa();
        add(mapa.label);

        this.addKeyListener(new Teclas());
    }

    public void inicioDelJuego(){
        pacMan.iniciarMovimiento();
    }

    public class Teclas extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                inicioDelJuego();
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                pacMan.siguienteDireccion = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                pacMan.siguienteDireccion = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                pacMan.siguienteDireccion = 2;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                pacMan.siguienteDireccion = 3;
            }
        }
    }
}
