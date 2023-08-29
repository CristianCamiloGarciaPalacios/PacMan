import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Point;

public class ObjetoDeChoque {
    Point ubicacion;
    int frecuencia, direccion;
    JLabel label;
    Thread hilo;

    public ObjetoDeChoque() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/objetoDeChoque.png"));
        ubicacion = new Point(159, 201);
        frecuencia = 60;
        direccion = 1;
        label = new JLabel(icono);
        label.setBounds(ubicacion.x, ubicacion.y, 21, 21);
    }

    public void iniciarMovimiento() {
        hilo = new Momento();
        hilo.start();
    }

    public void movimiento() {
        switch (direccion) {
            case 0:
                if (!colicionArriba()) {
                    ubicacion.y = ubicacion.y - 3;
                }
                break;
            case 1:
                if (!colicionDerecha()) {
                    if (ubicacion.x == 348 && ubicacion.y == 165) {
                        ubicacion.x = -21;
                    }
                    ubicacion.x = ubicacion.x + 3;
                }
                break;
            case 2:
                if (!colicionAbajo()) {
                    ubicacion.y = ubicacion.y + 3;
                }
                break;
            case 3:
                if (!colicionIzquierda()) {
                    if(ubicacion.x == -21 && ubicacion.y == 165) {
                        ubicacion.x = 348;
                    }
                    ubicacion.x = ubicacion.x - 3;
                }
                break;
        }
    }

    public void cambioDireccion() {
        switch (direccion) {
            case 0:
                if (colicionArriba()) {
                    direccion = 3;
                    cambioDireccion();
                }
                break;
            case 1:
                if (colicionDerecha()) {
                    direccion = 0;
                    cambioDireccion();
                }
                break;
            case 2:
                if (colicionAbajo()) {
                    direccion = 1;
                    cambioDireccion();
                }
                break;
            case 3:
                if (colicionIzquierda()) {
                    direccion = 2;
                    cambioDireccion();
                }
                break;
        }
    }

    public boolean colicionIzquierda() {
        if (ubicacion.x == 9) {
            if ((ubicacion.y >= 9 && ubicacion.y <= 150) || (ubicacion.y >= 190 && ubicacion.y <= 370)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 33) {
            if (ubicacion.y >= 274 && ubicacion.y <= 308) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 69) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 92)
                    || (ubicacion.y >= 94 && ubicacion.y <= 164) || (ubicacion.y >= 166 && ubicacion.y <= 236)
                    || (ubicacion.y >= 238 && ubicacion.y <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 105) {
            if ((ubicacion.y >= 58 && ubicacion.y <= 164) || (ubicacion.y >= 166 && ubicacion.y <= 236)
                    || (ubicacion.y >= 274 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 141) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 94 && ubicacion.y <= 128)
                    || (ubicacion.y >= 238 && ubicacion.y <= 272) || (ubicacion.y >= 310 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 177) {
            if ((ubicacion.y >= 8 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 128)
                    || (ubicacion.y >= 202 && ubicacion.y <= 272) || (ubicacion.y >= 274 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 213) {
            if ((ubicacion.y >= 58 && ubicacion.y <= 92) || (ubicacion.y >= 130 && ubicacion.y <= 200)
                    || (ubicacion.y >= 202 && ubicacion.y <= 236) || (ubicacion.y >= 274 && ubicacion.y <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 249) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 164)
                    || (ubicacion.y >= 166 && ubicacion.y <= 236) || (ubicacion.y >= 238 && ubicacion.y <= 272)
                    || (ubicacion.y >= 274 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 285) {
            if (ubicacion.y >= 238 && ubicacion.y <= 308) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 309) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 92)
                    || (ubicacion.y >= 238 && ubicacion.y <= 272) || (ubicacion.y >= 310 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean colicionDerecha() {
        if (ubicacion.x == 309) {
            if ((ubicacion.y >= 9 && ubicacion.y <= 150) || (ubicacion.y >= 190 && ubicacion.y <= 370)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 285) {
            if (ubicacion.y >= 274 && ubicacion.y <= 308) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 249) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 92)
                    || (ubicacion.y >= 94 && ubicacion.y <= 164) || (ubicacion.y >= 166 && ubicacion.y <= 236)
                    || (ubicacion.y >= 238 && ubicacion.y <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 213) {
            if ((ubicacion.y >= 58 && ubicacion.y <= 164) || (ubicacion.y >= 166 && ubicacion.y <= 236)
                    || (ubicacion.y >= 274 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 177) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 94 && ubicacion.y <= 128)
                    || (ubicacion.y >= 238 && ubicacion.y <= 272) || (ubicacion.y >= 310 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 141) {
            if ((ubicacion.y >= 8 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 128)
                    || (ubicacion.y >= 202 && ubicacion.y <= 272) || (ubicacion.y >= 274 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 105) {
            if ((ubicacion.y >= 58 && ubicacion.y <= 92) || (ubicacion.y >= 130 && ubicacion.y <= 200)
                    || (ubicacion.y >= 202 && ubicacion.y <= 236) || (ubicacion.y >= 274 && ubicacion.y <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 69) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 164)
                    || (ubicacion.y >= 166 && ubicacion.y <= 236) || (ubicacion.y >= 238 && ubicacion.y <= 272)
                    || (ubicacion.y >= 274 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 33) {
            if (ubicacion.y >= 238 && ubicacion.y <= 308) {
                return true;
            }
            return false;
        }
        if (ubicacion.x == 9) {
            if ((ubicacion.y >= 10 && ubicacion.y <= 56) || (ubicacion.y >= 58 && ubicacion.y <= 92)
                    || (ubicacion.y >= 238 && ubicacion.y <= 272) || (ubicacion.y >= 310 && ubicacion.y <= 344)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean colicionArriba() {
        if (ubicacion.y == 9) {
            if (ubicacion.x >= 0 && ubicacion.x <= 340) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 57) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 140)
                    || (ubicacion.x >= 142 && ubicacion.x <= 176) || (ubicacion.x >= 178 && ubicacion.x <= 248)
                    || (ubicacion.x >= 250 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 93) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 68) || (ubicacion.x >= 106 && ubicacion.x <= 212)
                    || (ubicacion.x >= 250 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 129) {
            if ((ubicacion.x >= 70 && ubicacion.x <= 140) || (ubicacion.x >= 142 && ubicacion.x <= 176)
                    || (ubicacion.x >= 178 && ubicacion.x <= 248)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 165) {
            if ((ubicacion.x >= -40 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 104)
                    || (ubicacion.x >= 214 && ubicacion.x <= 248) || (ubicacion.x >= 250 && ubicacion.x <= 360)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 201) {
            if (ubicacion.x >= 106 && ubicacion.x <= 212) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 237) {
            if ((ubicacion.x >= -30 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 104)
                    || (ubicacion.x >= 106 && ubicacion.x <= 212) || (ubicacion.x >= 214 && ubicacion.x <= 248)
                    || (ubicacion.x >= 250 && ubicacion.x <= 350)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 273) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 140)
                    || (ubicacion.x >= 142 && ubicacion.x <= 176) || (ubicacion.x >= 178 && ubicacion.x <= 248)
                    || (ubicacion.x >= 250 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 309) {
            if ((ubicacion.x >= 0 && ubicacion.x <= 32) || (ubicacion.x >= 34 && ubicacion.x <= 68)
                    || (ubicacion.x >= 106 && ubicacion.x <= 212) || (ubicacion.x >= 250 && ubicacion.x <= 284)
                    || (ubicacion.x >= 286 && ubicacion.x <= 350)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 345) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 140) || (ubicacion.x >= 142 && ubicacion.x <= 176)
                    || (ubicacion.x >= 178 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean colicionAbajo() {
        if (ubicacion.y == 9) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 140)
                    || (ubicacion.x >= 178 && ubicacion.x <= 248) || (ubicacion.x >= 250 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 57) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 104)
                    || (ubicacion.x >= 106 && ubicacion.x <= 212) || (ubicacion.x >= 214 && ubicacion.x <= 248)
                    || (ubicacion.x >= 250 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 93) {
            if ((ubicacion.x >= -30 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 140)
                    || (ubicacion.x >= 178 && ubicacion.x <= 248) || (ubicacion.x >= 250 && ubicacion.x <= 350)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 129) {
            if (ubicacion.x >= 106 && ubicacion.x <= 212) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 165) {
            if ((ubicacion.x >= -30 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 104)
                    || (ubicacion.x >= 214 && ubicacion.x <= 248) || (ubicacion.x >= 250 && ubicacion.x <= 350)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 201) {
            if (ubicacion.x >= 106 && ubicacion.x <= 212) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 237) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 68) || (ubicacion.x >= 70 && ubicacion.x <= 140)
                    || (ubicacion.x >= 142 && ubicacion.x <= 176) || (ubicacion.x >= 178 && ubicacion.x <= 248)
                    || (ubicacion.x >= 250 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 273) {
            if ((ubicacion.x >= 0 && ubicacion.x <= 32) || (ubicacion.x >= 70 && ubicacion.x <= 104)
                    || (ubicacion.x >= 106 && ubicacion.x <= 212) || (ubicacion.x >= 214 && ubicacion.x <= 248)
                    || (ubicacion.x >= 286 && ubicacion.x <= 350)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 309) {
            if ((ubicacion.x >= 10 && ubicacion.x <= 140) || (ubicacion.x >= 178 && ubicacion.x <= 308)) {
                return true;
            }
            return false;
        }
        if (ubicacion.y == 345) {
            if (ubicacion.x >= 0 && ubicacion.x <= 340) {
                return true;
            }
            return false;
        }
        return false;
    }

    public class Momento extends Thread {

        long Last = 0;

        @Override
        public void run() {
            while (true) {
                if ((java.lang.System.currentTimeMillis() - Last) > frecuencia) {
                    cambioDireccion();
                    movimiento();
                    label.setBounds(ubicacion.x, ubicacion.y, 21, 21);
                    Last = java.lang.System.currentTimeMillis();
                }
            }
        }
    }
}
