
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InterfasPerder extends JFrame implements ActionListener {

    private JLabel L1, L2;
    private JButton B1, B2;
    private static int Puntaje;

    public InterfasPerder() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("PacMan");
        getContentPane().setBackground(new Color(180, 20, 20));
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Icon.png")).getImage());

        L1 = new JLabel("GAME OVER");
        L1.setBounds(45, 20, 300, 50);
        L1.setFont(new Font("SansSerif Bold", 3, 40));
        L1.setForeground(new Color(0, 0, 0));
        add(L1);
        int s = Integer.toString(Puntaje).length();
        L2 = new JLabel("Tu puntaje fue de: " + Puntaje + " puntos");
        L2.setBounds(45 - (s * 6), 40, 270 + (s * 10), 100);
        L2.setFont(new Font("SansSerif Bold", 1, 20));
        L2.setForeground(new Color(0, 0, 0));
        add(L2);
        B1 = new JButton("REINTENTAR");
        B1.setBounds(70, 110, 200, 30);
        B1.setForeground(new Color(255, 255, 255));
        B1.setFont(new Font("SansSerif Bold", 3, 20));
        B1.setBackground(new Color(0, 0, 0));
        B1.addActionListener(this);
        add(B1);
        B2 = new JButton("SALIR");
        B2.setBounds(120, 160, 100, 30);
        B2.setForeground(new Color(255, 255, 255));
        B2.setFont(new Font("SansSerif Bold", 3, 20));
        B2.setBackground(new Color(0, 0, 0));
        B2.addActionListener(this);
        add(B2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == B1) {
            this.setVisible(false);
            PacManAnterior PM = new PacManAnterior();
            PM.setBounds(0, 0, 356, 500);
            PM.setVisible(true);
            PM.setLocationRelativeTo(null);
            PM.setResizable(false);
        }
        if (e.getSource() == B2) {
            System.exit(0);
        }
    }

    public void setPuntaje(int Puntaje) {
        this.Puntaje = Puntaje;
    }

    public static void main(String args[]) {
        InterfasPerder IP = new InterfasPerder();
        IP.setBounds(0, 0, 350, 250);
        IP.setVisible(true);
        IP.setResizable(false);
        IP.setLocationRelativeTo(null);
    }
}
