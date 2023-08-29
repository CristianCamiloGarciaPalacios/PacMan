import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PacManAnterior extends JFrame {
// 246 cocos
    boolean Esperar = false;
    int Contador = 0, Frecuencia = 50, FrecuenciaF = 100, Direccion = KeyEvent.VK_RIGHT, TPacMan = 0, AnDireccion = 0, Puntuacion = 0, NCoco = 0;
    int DFanR = 0, DFanO = 3, DFanP = 3, DFanB = 1, TipoFanB, Vidas = 3;
    Point PPacMan, PFanR, PFanO, PFanP, PFanB;
    JLabel LPacMan, LMapa, LPuntuacion, LFanR, LFanO, LFanP, LFanB, LPrecionaEspacio, LVidas;
    JLabel LCoco[][] = new JLabel[26][29];
    Point PCoco[][] = new Point[26][29];
    ImageIcon Mapa = new ImageIcon(getClass().getResource("/Imagenes/Mapa.png"));
    ImageIcon PacMan1 = new ImageIcon(getClass().getResource("/Imagenes/PacMan1.png"));
    ImageIcon PacManL2 = new ImageIcon(getClass().getResource("/Imagenes/PacManIzquierda2.png"));
    ImageIcon PacManL3 = new ImageIcon(getClass().getResource("/Imagenes/PacManIzquierda3.png"));
    ImageIcon PacManU2 = new ImageIcon(getClass().getResource("/Imagenes/PacManArriba2.png"));
    ImageIcon PacManU3 = new ImageIcon(getClass().getResource("/Imagenes/PacManArriba3.png"));
    ImageIcon PacManR2 = new ImageIcon(getClass().getResource("/Imagenes/PacManDerecha2.png"));
    ImageIcon PacManR3 = new ImageIcon(getClass().getResource("/Imagenes/PacManDerecha3.png"));
    ImageIcon PacManD2 = new ImageIcon(getClass().getResource("/Imagenes/PacManAbajo2.png"));
    ImageIcon PacManD3 = new ImageIcon(getClass().getResource("/Imagenes/PacManAbajo3.png"));
    ImageIcon ICoco = new ImageIcon(getClass().getResource("/Imagenes/Coco.png"));
    ImageIcon ICocoE = new ImageIcon(getClass().getResource("/Imagenes/CocoEspecial.png"));
    ImageIcon FanRU = new ImageIcon(getClass().getResource("/Imagenes/FanRojoU.png"));
    ImageIcon FanRD = new ImageIcon(getClass().getResource("/Imagenes/FanRojoD.png"));
    ImageIcon FanRL = new ImageIcon(getClass().getResource("/Imagenes/FanRojoL.png"));
    ImageIcon FanRR = new ImageIcon(getClass().getResource("/Imagenes/FanRojoR.png"));
    ImageIcon FanOU = new ImageIcon(getClass().getResource("/Imagenes/FanNaranjaU.png"));
    ImageIcon FanOD = new ImageIcon(getClass().getResource("/Imagenes/FanNaranjaD.png"));
    ImageIcon FanOL = new ImageIcon(getClass().getResource("/Imagenes/FanNaranjaL.png"));
    ImageIcon FanOR = new ImageIcon(getClass().getResource("/Imagenes/FanNaranjaR.png"));
    ImageIcon FanPU = new ImageIcon(getClass().getResource("/Imagenes/FanRosaU.png"));
    ImageIcon FanPD = new ImageIcon(getClass().getResource("/Imagenes/FanRosaD.png"));
    ImageIcon FanPL = new ImageIcon(getClass().getResource("/Imagenes/FanRosaL.png"));
    ImageIcon FanPR = new ImageIcon(getClass().getResource("/Imagenes/FanRosaR.png"));
    ImageIcon FanBU = new ImageIcon(getClass().getResource("/Imagenes/FanAzulU.png"));
    ImageIcon FanBD = new ImageIcon(getClass().getResource("/Imagenes/FanAzulD.png"));
    ImageIcon FanBL = new ImageIcon(getClass().getResource("/Imagenes/FanAzulL.png"));
    ImageIcon FanBR = new ImageIcon(getClass().getResource("/Imagenes/FanAzulR.png"));

    Teclas MTeclas = new Teclas();
    Momento MMomento = new Momento();
    Thread Hilo1 = new Thread(MMomento);
    MomentoF MMomentoF = new MomentoF();
    Thread Hilo2 = new Thread(MMomentoF);

    public PacManAnterior() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("PacMan");
        getContentPane().setBackground(new Color(0, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Icon.png")).getImage());

        TipoFanB = (int) (Math.random() * 3);

        PPacMan = new Point(159, 201); //159, 201
        PFanR = new Point(159, 129); //159, 129
        PFanO = new Point(159, 171); //159, 171
        PFanP = new Point(144, 171); // 144, 171
        PFanB = new Point(135, 165); // 135, 165
        LPrecionaEspacio = new JLabel("Preciona Espacio");
        LPrecionaEspacio.setBounds(25, 111, 400, 100);
        LPrecionaEspacio.setFont(new Font("SansSerif Bold", 3, 36));
        LPrecionaEspacio.setForeground(new Color(255, 255, 255));
        add(LPrecionaEspacio);
        LPacMan = new JLabel(PacMan1);
        LPacMan.setBounds(PPacMan.x, PPacMan.y, 21, 21);
        add(LPacMan);
        LFanR = new JLabel(FanRU);
        LFanR.setBounds(PFanR.x, PFanR.y, 21, 21);
        add(LFanR);
        LFanO = new JLabel(FanOU);
        LFanO.setBounds(PFanO.x, PFanO.y, 21, 21);
        add(LFanO);
        LFanP = new JLabel(FanPU);
        LFanP.setBounds(PFanP.x, PFanP.y, 21, 21);
        add(LFanP);
        LFanB = new JLabel(FanBU);
        LFanB.setBounds(PFanB.x, PFanB.y, 21, 21);
        add(LFanB);

        for (int i = 0; i <= 28; i++) {
            if ((i >= 8 && i <= 18) || (i >= 23 && i <= 24)) {
                PCoco[0][i] = new Point(500, 500);
                PCoco[25][i] = new Point(500, 500);
            } else {
                PCoco[0][i] = new Point(9, 12 * i + 9);
                PCoco[25][i] = new Point(309, 12 * i + 9);
            }
            if ((i >= 1 && i <= 3) || (i >= 5 && i <= 6) || (i >= 8 && i <= 18) || (i >= 20 && i <= 21) || (i >= 23 && i <= 24) || (i >= 26 && i <= 27)) {
                PCoco[1][i] = new Point(500, 500);
                PCoco[24][i] = new Point(500, 500);
            } else {
                PCoco[1][i] = new Point(21, 12 * i + 9);
                PCoco[24][i] = new Point(297, 12 * i + 9);
            }
            if ((i >= 1 && i <= 3) || (i >= 5 && i <= 6) || (i >= 8 && i <= 18) || (i >= 20 && i <= 21) || (i >= 26 && i <= 27)) {
                PCoco[2][i] = new Point(500, 500);
                PCoco[23][i] = new Point(500, 500);
            } else {
                PCoco[2][i] = new Point(33, 12 * i + 9);
                PCoco[23][i] = new Point(285, 12 * i + 9);
            }
            if ((i >= 1 && i <= 3) || (i >= 5 && i <= 6) || (i >= 8 && i <= 18) || (i >= 20 && i <= 24) || (i >= 26 && i <= 27)) {
                PCoco[3][i] = new Point(500, 500);
                PCoco[4][i] = new Point(500, 500);
                PCoco[21][i] = new Point(500, 500);
                PCoco[22][i] = new Point(500, 500);
            } else {
                PCoco[3][i] = new Point(45, 12 * i + 9);
                PCoco[4][i] = new Point(57, 12 * i + 9);
                PCoco[21][i] = new Point(261, 12 * i + 9);
                PCoco[22][i] = new Point(273, 12 * i + 9);
            }
            if (i >= 26 && i <= 27) {
                PCoco[5][i] = new Point(500, 500);
                PCoco[20][i] = new Point(500, 500);
            } else {
                PCoco[5][i] = new Point(69, 12 * i + 9);
                PCoco[20][i] = new Point(249, 12 * i + 9);
            }
            if (i == 4 || i == 0 || i == 19 || i == 22 || i == 28) {
                PCoco[6][i] = new Point(81, 12 * i + 9);
                PCoco[7][i] = new Point(93, 12 * i + 9);
                PCoco[18][i] = new Point(225, 12 * i + 9);
                PCoco[19][i] = new Point(237, 12 * i + 9);
            } else {
                PCoco[6][i] = new Point(500, 500);
                PCoco[7][i] = new Point(500, 500);
                PCoco[18][i] = new Point(500, 500);
                PCoco[19][i] = new Point(500, 500);
            }
            if ((i >= 1 && i <= 3) || (i >= 8 && i <= 18) || (i >= 20 && i <= 21) || (i >= 26 && i <= 27)) {
                PCoco[8][i] = new Point(500, 500);
                PCoco[17][i] = new Point(500, 500);
            } else {
                PCoco[8][i] = new Point(105, 12 * i + 9);
                PCoco[17][i] = new Point(213, 12 * i + 9);
            }
            if ((i >= 1 && i <= 3) || (i >= 5 && i <= 6) || (i >= 8 && i <= 18) || (i >= 20 && i <= 21) || (i >= 23 && i <= 24) || (i >= 26 && i <= 27)) {
                PCoco[9][i] = new Point(500, 500);
                PCoco[10][i] = new Point(500, 500);
                PCoco[15][i] = new Point(500, 500);
                PCoco[16][i] = new Point(500, 500);
            } else {
                PCoco[9][i] = new Point(117, 12 * i + 9);
                PCoco[10][i] = new Point(129, 12 * i + 9);
                PCoco[15][i] = new Point(189, 12 * i + 9);
                PCoco[16][i] = new Point(201, 12 * i + 9);
            }
            if ((i >= 5 && i <= 6) || (i >= 8 && i <= 18) || (i >= 23 && i <= 24)) {
                PCoco[11][i] = new Point(500, 500);
                PCoco[14][i] = new Point(500, 500);
            } else {
                PCoco[11][i] = new Point(141, 12 * i + 9);
                PCoco[14][i] = new Point(177, 12 * i + 9);
            }
            if (i == 4 || i == 22 || i == 28) {
                PCoco[12][i] = new Point(153, 12 * i + 9);
                PCoco[13][i] = new Point(165, 12 * i + 9);
            } else {
                PCoco[12][i] = new Point(500, 500);
                PCoco[13][i] = new Point(500, 500);
            }
        }
        for (int j = 0; j <= 25; j++) {
            for (int i = 0; i <= 28; i++) {
                LCoco[j][i] = new JLabel(ICoco);
                LCoco[j][i].setBounds(PCoco[j][i].x, PCoco[j][i].y, 12, 12);
                add(LCoco[j][i]);
            }
        }
        LCoco[0][0].setIcon(ICocoE);
        LCoco[25][0].setIcon(ICocoE);
        LCoco[0][28].setIcon(ICocoE);
        LCoco[25][28].setIcon(ICocoE);
        LMapa = new JLabel(Mapa);
        LMapa.setBounds(0, 0, 339, 375);
        add(LMapa);
        LPuntuacion = new JLabel("Puntuacion: " + Puntuacion);
        LPuntuacion.setBounds(10, 400, 150, 30);
        LPuntuacion.setForeground(new Color(255, 255, 255));
        LPuntuacion.setBackground(new Color(255, 255, 255));
        add(LPuntuacion);
        LVidas = new JLabel("Vidas: " + Vidas);
        LVidas.setBounds(220, 400, 150, 30);
        LVidas.setForeground(new Color(255, 255, 255));
        LVidas.setBackground(new Color(255, 255, 255));
        add(LVidas);

        this.addKeyListener(MTeclas);
        Hilo1.start();
        Hilo2.start();
    }

    public static void main(String[] args) {
        PacManAnterior PM = new PacManAnterior();
        PM.setBounds(0, 0, 356, 500);
        PM.setVisible(true);
        PM.setLocationRelativeTo(null);
        PM.setResizable(false);
    }

    public void Punto() {
        for (int j = 0; j <= 25; j++) {
            for (int i = 0; i <= 28; i++) {
                if ((PCoco[j][i].x >= PPacMan.x - 6 && PCoco[j][i].x <= PPacMan.x + 9) && (PCoco[j][i].y >= PPacMan.y - 9 && PCoco[j][i].y <= PPacMan.y + 6)) {
                    Puntuacion = Puntuacion + 50;
                    PCoco[j][i].x = 500;
                    PCoco[j][i].y = 500;
                    LCoco[j][i].setBounds(PCoco[j][i].x, PCoco[j][i].y, 12, 12);
                    LPuntuacion.setText("Puntuacion: " + Puntuacion);
                    NCoco++;
                }
            }
        }
    }

    public void MovimientoPac(int Direc) {
        if (Direc == KeyEvent.VK_UP && ColicionUp(PPacMan.x, PPacMan.y) == true) {
            switch (TPacMan) {
                case 1:
                    LPacMan.setIcon(PacManU2);
                    break;
                case 2:
                    LPacMan.setIcon(PacManU3);
                    break;
                case 3:
                    LPacMan.setIcon(PacManU2);
                    break;
                default:
                    break;
            }
            PPacMan.y = PPacMan.y - 3;
            LPacMan.setBounds(PPacMan.x, PPacMan.y, 21, 21);
        }
        if (Direc == KeyEvent.VK_DOWN && ColicionDown(PPacMan.x, PPacMan.y) == true) {
            switch (TPacMan) {
                case 1:
                    LPacMan.setIcon(PacManD2);
                    break;
                case 2:
                    LPacMan.setIcon(PacManD3);
                    break;
                case 3:
                    LPacMan.setIcon(PacManD2);
                    break;
                default:
                    break;
            }
            PPacMan.y = PPacMan.y + 3;
            LPacMan.setBounds(PPacMan.x, PPacMan.y, 21, 21);
        }
        if (Direc == KeyEvent.VK_LEFT && ColicionLeft(PPacMan.x, PPacMan.y) == true) {
            switch (TPacMan) {
                case 1:
                    LPacMan.setIcon(PacManL2);
                    break;
                case 2:
                    LPacMan.setIcon(PacManL3);
                    break;
                case 3:
                    LPacMan.setIcon(PacManL2);
                    break;
                default:
                    break;
            }
            PPacMan.x = PPacMan.x - 3;
            if (PPacMan.x == -21 && PPacMan.y == 165) {
                PPacMan.x = 348;
            }
            LPacMan.setBounds(PPacMan.x, PPacMan.y, 21, 21);
        }
        if (Direc == KeyEvent.VK_RIGHT && ColicionRight(PPacMan.x, PPacMan.y) == true) {
            switch (TPacMan) {
                case 1:
                    LPacMan.setIcon(PacManR2);
                    break;
                case 2:
                    LPacMan.setIcon(PacManR3);
                    break;
                case 3:
                    LPacMan.setIcon(PacManR2);
                    break;
                default:
                    break;
            }
            PPacMan.x = PPacMan.x + 3;
            if (PPacMan.x == 348 && PPacMan.y == 165) {
                PPacMan.x = -21;
            }
            LPacMan.setBounds(PPacMan.x, PPacMan.y, 21, 21);

        }
    }

    public int CambioMoviFanR(int PFanx, int PFany) {
        int DFan;
        if (Math.abs(PFanx - PPacMan.x) > Math.abs(PFany - PPacMan.y)) {
            if (PFanx > PPacMan.x) {
                if (ColicionLeft(PFanx, PFany) == true) {
                    DFan = 2;
                } else {
                    if (PFany > PPacMan.y) {
                        if (ColicionUp(PFanx, PFany) == true) {
                            DFan = 0;
                        } else {
                            if (ColicionDown(PFanx, PFany) == true) {
                                DFan = 1;
                            } else {
                                DFan = 3;
                            }
                        }
                    } else {
                        if (ColicionDown(PFanx, PFany) == true) {
                            DFan = 1;
                        } else {
                            if (ColicionUp(PFanx, PFany) == true) {
                                DFan = 0;
                            } else {
                                DFan = 3;
                            }
                        }
                    }
                }
            } else {
                if (ColicionRight(PFanx, PFany) == true) {
                    DFan = 3;
                } else {
                    if (PFany > PPacMan.y) {
                        if (ColicionUp(PFanx, PFany) == true) {
                            DFan = 0;
                        } else {
                            if (ColicionDown(PFanx, PFany) == true) {
                                DFan = 1;
                            } else {
                                DFan = 2;
                            }
                        }
                    } else {
                        if (ColicionDown(PFanx, PFany) == true) {
                            DFan = 1;
                        } else {
                            if (ColicionUp(PFanx, PFany) == true) {
                                DFan = 0;
                            } else {
                                DFan = 2;
                            }
                        }
                    }
                }
            }
        } else {
            if (PFany > PPacMan.y) {
                if (ColicionUp(PFanx, PFany) == true) {
                    DFan = 0;
                } else {
                    if (PFanx > PPacMan.x) {
                        if (ColicionLeft(PFanx, PFany) == true) {
                            DFan = 2;
                        } else {
                            if (ColicionRight(PFanx, PFany) == true) {
                                DFan = 3;
                            } else {
                                DFan = 1;
                            }
                        }
                    } else {
                        if (ColicionRight(PFanx, PFany) == true) {
                            DFan = 3;
                        } else {
                            if (ColicionLeft(PFanx, PFany) == true) {
                                DFan = 2;
                            } else {
                                DFan = 1;
                            }
                        }
                    }
                }
            } else {
                if (ColicionDown(PFanx, PFany) == true) {
                    DFan = 1;
                } else {
                    if (PFanx > PPacMan.x) {
                        if (ColicionLeft(PFanx, PFany) == true) {
                            DFan = 2;
                        } else {
                            if (ColicionRight(PFanx, PFany) == true) {
                                DFan = 3;
                            } else {
                                DFan = 0;
                            }
                        }
                    } else {
                        if (ColicionRight(PFanx, PFany) == true) {
                            DFan = 3;
                        } else {
                            if (ColicionLeft(PFanx, PFany) == true) {
                                DFan = 2;
                            } else {
                                DFan = 0;
                            }
                        }
                    }
                }
            }
        }
        return DFan;
    }

    public int CambioMoviFanO(int PFanx, int PFany) {
        int DFan = 0;
        boolean Nut = false;

        do {
            DFan = (int) (Math.random() * 4);
            switch (DFan) {
                case 0:
                    if (ColicionUp(PFanx, PFany) == true) {
                        Nut = true;
                    }
                    break;
                case 1:
                    if (ColicionDown(PFanx, PFany) == true) {
                        Nut = true;
                    }
                    break;

                case 2:
                    if (ColicionLeft(PFanx, PFany) == true && (PFany != 165 && PFanx != 69)) {
                        Nut = true;
                    }
                    break;
                case 3:
                    if (ColicionRight(PFanx, PFany) == true && (PFany != 165 && PFanx != 249)) {
                        Nut = true;
                    }
                    break;
            }
        } while (Nut == false);

        return DFan;
    }

    public int CambioMoviFanP(int PFanx, int PFany) {
        int DFan;
        int PPacManx = PPacMan.x;
        int PPacMany = PPacMan.y;
        if (Direccion == KeyEvent.VK_RIGHT) {
            PPacManx = PPacMan.x + 84;
        }
        if (Direccion == KeyEvent.VK_LEFT) {
            PPacManx = PPacMan.x - 84;
        }
        if (Direccion == KeyEvent.VK_UP) {
            PPacMany = PPacMan.y - 84;
        }
        if (Direccion == KeyEvent.VK_DOWN) {
            PPacMany = PPacMan.y + 84;
        }
        if (Math.abs(PFanx - PPacManx) > Math.abs(PFany - PPacMany)) {
            if (PFanx > PPacManx) {
                if (ColicionLeft(PFanx, PFany) == true) {
                    DFan = 2;
                } else {
                    if (PFany > PPacMany) {
                        if (ColicionUp(PFanx, PFany) == true) {
                            DFan = 0;
                        } else {
                            if (ColicionDown(PFanx, PFany) == true) {
                                DFan = 1;
                            } else {
                                DFan = 3;
                            }
                        }
                    } else {
                        if (ColicionDown(PFanx, PFany) == true) {
                            DFan = 1;
                        } else {
                            if (ColicionUp(PFanx, PFany) == true) {
                                DFan = 0;
                            } else {
                                DFan = 3;
                            }
                        }
                    }
                }
            } else {
                if (ColicionRight(PFanx, PFany) == true) {
                    DFan = 3;
                } else {
                    if (PFany > PPacMany) {
                        if (ColicionUp(PFanx, PFany) == true) {
                            DFan = 0;
                        } else {
                            if (ColicionDown(PFanx, PFany) == true) {
                                DFan = 1;
                            } else {
                                DFan = 2;
                            }
                        }
                    } else {
                        if (ColicionDown(PFanx, PFany) == true) {
                            DFan = 1;
                        } else {
                            if (ColicionUp(PFanx, PFany) == true) {
                                DFan = 0;
                            } else {
                                DFan = 2;
                            }
                        }
                    }
                }
            }
        } else {
            if (PFany > PPacMany) {
                if (ColicionUp(PFanx, PFany) == true) {
                    DFan = 0;
                } else {
                    if (PFanx > PPacManx) {
                        if (ColicionLeft(PFanx, PFany) == true) {
                            DFan = 2;
                        } else {
                            if (ColicionRight(PFanx, PFany) == true) {
                                DFan = 3;
                            } else {
                                DFan = 1;
                            }
                        }
                    } else {
                        if (ColicionRight(PFanx, PFany) == true) {
                            DFan = 3;
                        } else {
                            if (ColicionLeft(PFanx, PFany) == true) {
                                DFan = 2;
                            } else {
                                DFan = 1;
                            }
                        }
                    }
                }
            } else {
                if (ColicionDown(PFanx, PFany) == true) {
                    DFan = 1;
                } else {
                    if (PFanx > PPacManx) {
                        if (ColicionLeft(PFanx, PFany) == true) {
                            DFan = 2;
                        } else {
                            if (ColicionRight(PFanx, PFany) == true) {
                                DFan = 3;
                            } else {
                                DFan = 0;
                            }
                        }
                    } else {
                        if (ColicionRight(PFanx, PFany) == true) {
                            DFan = 3;
                        } else {
                            if (ColicionLeft(PFanx, PFany) == true) {
                                DFan = 2;
                            } else {
                                DFan = 0;
                            }
                        }
                    }
                }
            }
        }
        return DFan;
    }

    public void MoviFanR() {
        if ((PFanR.x == 9 || PFanR.x == 309) && (PFanR.y == 9 || PFanR.y == 57 || PFanR.y == 93 || PFanR.y == 237 || PFanR.y == 273 || PFanR.y == 309 || PFanR.y == 345)) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if ((PFanR.x == 33 || PFanR.x == 285) && (PFanR.y == 273 || PFanR.y == 309)) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if ((PFanR.x == 69 || PFanR.x == 249) && (PFanR.y == 9 || PFanR.y == 57 || PFanR.y == 93 || PFanR.y == 165 || PFanR.y == 237 || PFanR.y == 273 || PFanR.y == 309)) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if ((PFanR.x == 105 || PFanR.x == 213) && (PFanR.y == 57 || PFanR.y == 93 || PFanR.y == 129 || PFanR.y == 165 || PFanR.y == 201 || PFanR.y == 237 || PFanR.y == 273 || PFanR.y == 309)) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if ((PFanR.x == 141 || PFanR.x == 177) && (PFanR.y == 9 || PFanR.y == 57 || PFanR.y == 93 || PFanR.y == 129 || PFanR.y == 237 || PFanR.y == 273 || PFanR.y == 309 || PFanR.y == 345)) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if ((PFanR.x < 69 || PFanR.x > 249) && (PFanR.y == 165)) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if (PFanR.x == 159 && PFanR.y == 129) {
            DFanR = CambioMoviFanR(PFanR.x, PFanR.y);
        }
        if (Contador >= 0 && PFanR.x == 159 && PFanR.y == 159) {
            DFanR = 0;
        }
        if (PFanR.x == 135 && PFanR.y == 159) {
            DFanP = 1;
        }
        if (PFanR.x == 135 && PFanR.y == 171) {
            DFanP = 3;
        }
        if (PFanR.x == 183 && PFanR.y == 171) {
            DFanP = 0;
        }
        if (PFanR.x == 183 && PFanR.y == 159) {
            DFanP = 2;
        }
        if (DFanR == 0) {
            LFanR.setIcon(FanRU);
            PFanR.y = PFanR.y - 3;
        }
        if (DFanR == 1) {
            LFanR.setIcon(FanRD);
            PFanR.y = PFanR.y + 3;
        }
        if (DFanR == 2) {
            LFanR.setIcon(FanRL);
            PFanR.x = PFanR.x - 3;
        }
        if (DFanR == 3) {
            LFanR.setIcon(FanRR);
            PFanR.x = PFanR.x + 3;
        }
        LFanR.setBounds(PFanR.x, PFanR.y, 21, 21);
    }

    public void MoviFanO() {
        if ((PFanO.x == 9 || PFanO.x == 309) && (PFanO.y == 9 || PFanO.y == 57 || PFanO.y == 93 || PFanO.y == 237 || PFanO.y == 273 || PFanO.y == 309 || PFanO.y == 345)) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                DFanO = CambioMoviFanO(PFanO.x, PFanO.y);
            }
        }
        if ((PFanO.x == 33 || PFanO.x == 285) && (PFanO.y == 273 || PFanO.y == 309)) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                DFanO = CambioMoviFanO(PFanO.x, PFanO.y);
            }
        }
        if ((PFanO.x == 69 || PFanO.x == 249) && (PFanO.y == 9 || PFanO.y == 57 || PFanO.y == 93 || PFanO.y == 165 || PFanO.y == 237 || PFanO.y == 273 || PFanO.y == 309)) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                DFanO = CambioMoviFanO(PFanO.x, PFanO.y);
            }
        }
        if ((PFanO.x == 105 || PFanO.x == 213) && (PFanO.y == 57 || PFanO.y == 93 || PFanO.y == 129 || PFanO.y == 165 || PFanO.y == 201 || PFanO.y == 237 || PFanO.y == 273 || PFanO.y == 309)) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                DFanO = CambioMoviFanO(PFanO.x, PFanO.y);
            }
        }
        if ((PFanO.x == 141 || PFanO.x == 177) && (PFanO.y == 9 || PFanO.y == 57 || PFanO.y == 93 || PFanO.y == 129 || PFanO.y == 237 || PFanO.y == 273 || PFanO.y == 309 || PFanO.y == 345)) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                DFanO = CambioMoviFanO(PFanO.x, PFanO.y);
            }
        }
        if ((PFanO.x < 69 || PFanO.x > 249) && (PFanO.y == 165)) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                if (PFanO.x < 69) {
                    DFanO = 3;
                } else {
                    DFanO = 2;
                }
            }
        }
        if (PFanO.x == 159 && PFanO.y == 129) {
            if (Math.abs(PFanO.x - PPacMan.x) < 111 && Math.abs(PFanO.y - PPacMan.y) < 111) {
                DFanO = CambioMoviFanR(PFanO.x, PFanO.y);
            } else {
                DFanO = CambioMoviFanO(PFanO.x, PFanO.y);
            }
        }
        if (Contador >= 8000 && PFanO.x == 159 && PFanO.y == 159) {
            DFanO = 0;
        }
        if (PFanO.x == 135 && PFanO.y == 159) {
            DFanO = 1;
        }
        if (PFanO.x == 135 && PFanO.y == 171) {
            DFanO = 3;
        }
        if (PFanO.x == 183 && PFanO.y == 171) {
            DFanO = 0;
        }
        if (PFanO.x == 183 && PFanO.y == 159) {
            DFanO = 2;
        }
        if (DFanO == 0) {
            LFanO.setIcon(FanOU);
            PFanO.y = PFanO.y - 3;
        }
        if (DFanO == 1) {
            LFanO.setIcon(FanOD);
            PFanO.y = PFanO.y + 3;
        }
        if (DFanO == 2) {
            LFanO.setIcon(FanOL);
            PFanO.x = PFanO.x - 3;
        }
        if (DFanO == 3) {
            LFanO.setIcon(FanOR);
            PFanO.x = PFanO.x + 3;
        }
        LFanO.setBounds(PFanO.x, PFanO.y, 21, 21);
    }

    public void MoviFanP() {
        if ((PFanP.x == 9 || PFanP.x == 309) && (PFanP.y == 9 || PFanP.y == 57 || PFanP.y == 93 || PFanP.y == 237 || PFanP.y == 273 || PFanP.y == 309 || PFanP.y == 345)) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if ((PFanP.x == 33 || PFanP.x == 285) && (PFanP.y == 273 || PFanP.y == 309)) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if ((PFanP.x == 69 || PFanP.x == 249) && (PFanP.y == 9 || PFanP.y == 57 || PFanP.y == 93 || PFanP.y == 165 || PFanP.y == 237 || PFanP.y == 273 || PFanP.y == 309)) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if ((PFanP.x == 105 || PFanP.x == 213) && (PFanP.y == 57 || PFanP.y == 93 || PFanP.y == 129 || PFanP.y == 165 || PFanP.y == 201 || PFanP.y == 237 || PFanP.y == 273 || PFanP.y == 309)) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if ((PFanP.x == 141 || PFanP.x == 177) && (PFanP.y == 9 || PFanP.y == 57 || PFanP.y == 93 || PFanP.y == 129 || PFanP.y == 237 || PFanP.y == 273 || PFanP.y == 309 || PFanP.y == 345)) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if (PFanP.x == 159 && PFanP.y == 129) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if ((PFanP.x < 69 || PFanP.x > 249) && (PFanP.y == 165)) {
            if (Math.abs(PFanP.x - PPacMan.x) < 48 && Math.abs(PFanP.y - PPacMan.y) < 48) {
                DFanP = CambioMoviFanR(PFanP.x, PFanP.y);
            } else {
                DFanP = CambioMoviFanP(PFanP.x, PFanP.y);
            }
        }
        if (Contador >= 4000 && PFanP.x == 159 && PFanP.y == 159) {
            DFanP = 0;
        }

        if (PFanP.x == 135 && PFanP.y == 159) {
            DFanP = 1;
        }
        if (PFanP.x == 135 && PFanP.y == 171) {
            DFanP = 3;
        }
        if (PFanP.x == 183 && PFanP.y == 171) {
            DFanP = 0;
        }
        if (PFanP.x == 183 && PFanP.y == 159) {
            DFanP = 2;
        }

        if (DFanP == 0) {
            LFanP.setIcon(FanPU);
            PFanP.y = PFanP.y - 3;
        }
        if (DFanP == 1) {
            LFanP.setIcon(FanPD);
            PFanP.y = PFanP.y + 3;
        }
        if (DFanP == 2) {
            LFanP.setIcon(FanPL);
            PFanP.x = PFanP.x - 3;
        }
        if (DFanP == 3) {
            LFanP.setIcon(FanPR);
            PFanP.x = PFanP.x + 3;
        }
        LFanP.setBounds(PFanP.x, PFanP.y, 21, 21);
    }

    public void MoviFanB() {
        if ((PFanB.x == 9 || PFanB.x == 309) && (PFanB.y == 9 || PFanB.y == 57 || PFanB.y == 93 || PFanB.y == 237 || PFanB.y == 273 || PFanB.y == 309 || PFanB.y == 345)) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanO(PFanB.x, PFanB.y);
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if ((PFanB.x == 33 || PFanB.x == 285) && (PFanB.y == 273 || PFanB.y == 309)) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanO(PFanB.x, PFanB.y);
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if ((PFanB.x == 69 || PFanB.x == 249) && (PFanB.y == 9 || PFanB.y == 57 || PFanB.y == 93 || PFanB.y == 165 || PFanB.y == 237 || PFanB.y == 273 || PFanB.y == 309)) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanO(PFanB.x, PFanB.y);
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if ((PFanB.x == 105 || PFanB.x == 213) && (PFanB.y == 57 || PFanB.y == 93 || PFanB.y == 129 || PFanB.y == 165 || PFanB.y == 201 || PFanB.y == 237 || PFanB.y == 273 || PFanB.y == 309)) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanO(PFanB.x, PFanB.y);
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if ((PFanB.x == 141 || PFanB.x == 177) && (PFanB.y == 9 || PFanB.y == 57 || PFanB.y == 93 || PFanB.y == 129 || PFanB.y == 237 || PFanB.y == 273 || PFanB.y == 309 || PFanB.y == 345)) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanO(PFanB.x, PFanB.y);
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if ((PFanB.x < 69 || PFanB.x > 249) && (PFanB.y == 165)) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    if (PFanB.x < 69) {
                        DFanB = 3;
                    } else {
                        DFanB = 2;
                    }
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if (PFanB.x == 159 && PFanB.y == 129) {
            if (TipoFanB == 0) {
                DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
            }
            if (TipoFanB == 1) {
                if (Math.abs(PFanB.x - PPacMan.x) < 111 && Math.abs(PFanB.y - PPacMan.y) < 111) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanO(PFanB.x, PFanB.y);
                }
            }
            if (TipoFanB == 2) {
                if (Math.abs(PFanB.x - PPacMan.x) < 48 && Math.abs(PFanB.y - PPacMan.y) < 48) {
                    DFanB = CambioMoviFanR(PFanB.x, PFanB.y);
                } else {
                    DFanB = CambioMoviFanP(PFanB.x, PFanB.y);
                }
            }
        }
        if (Contador >= 12000 && PFanB.x == 159 && PFanB.y == 159) {
            DFanB = 0;
        }
        if (PFanB.x == 135 && PFanB.y == 159) {
            DFanB = 1;
        }
        if (PFanB.x == 135 && PFanB.y == 171) {
            DFanB = 3;
        }
        if (PFanB.x == 183 && PFanB.y == 171) {
            DFanB = 0;
        }
        if (PFanB.x == 183 && PFanB.y == 159) {
            DFanB = 2;
        }
        if (DFanB == 0) {
            LFanB.setIcon(FanBU);
            PFanB.y = PFanB.y - 3;
        }
        if (DFanB == 1) {
            LFanB.setIcon(FanBD);
            PFanB.y = PFanB.y + 3;
        }
        if (DFanB == 2) {
            LFanB.setIcon(FanBL);
            PFanB.x = PFanB.x - 3;
        }
        if (DFanB == 3) {
            LFanB.setIcon(FanBR);
            PFanB.x = PFanB.x + 3;
        }
        LFanB.setBounds(PFanB.x, PFanB.y, 21, 21);
    }

    // El retorno falso o verdado de las Coliciones estan invertidas, siendo "false" si choca y "true" si no choca
    public boolean ColicionLeft(int EnX, int EnY) {
        boolean pasar = true;
        if (EnX == 9) {
            if ((EnY >= 9 && EnY <= 150) || (EnY >= 190 && EnY <= 370)) {
                pasar = false;
            }
        }
        if (EnX == 33) {
            if (EnY >= 274 && EnY <= 308) {
                pasar = false;
            }
        }
        if (EnX == 69) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 58 && EnY <= 92) || (EnY >= 94 && EnY <= 164) || (EnY >= 166 && EnY <= 236) || (EnY >= 238 && EnY <= 308)) {
                pasar = false;
            }
        }
        if (EnX == 105) {
            if ((EnY >= 58 && EnY <= 164) || (EnY >= 166 && EnY <= 236) || (EnY >= 274 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 141) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 94 && EnY <= 128) || (EnY >= 238 && EnY <= 272) || (EnY >= 310 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 177) {
            if ((EnY >= 8 && EnY <= 56) || (EnY >= 58 && EnY <= 128) || (EnY >= 202 && EnY <= 272) || (EnY >= 274 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 213) {
            if ((EnY >= 58 && EnY <= 92) || (EnY >= 130 && EnY <= 200) || (EnY >= 202 && EnY <= 236) || (EnY >= 274 && EnY <= 308)) {
                pasar = false;
            }
        }
        if (EnX == 249) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 58 && EnY <= 164) || (EnY >= 166 && EnY <= 236) || (EnY >= 238 && EnY <= 272) || (EnY >= 274 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 285) {
            if (EnY >= 238 && EnY <= 308) {
                pasar = false;
            }
        }
        if (EnX == 309) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 58 && EnY <= 92) || (EnY >= 238 && EnY <= 272) || (EnY >= 310 && EnY <= 344)) {
                pasar = false;
            }
        }
        return pasar;
    }

    public boolean ColicionRight(int EnX, int EnY) {
        boolean pasar = true;
        if (EnX == 309) {
            if ((EnY >= 9 && EnY <= 150) || (EnY >= 190 && EnY <= 370)) {
                pasar = false;
            }
        }
        if (EnX == 285) {
            if (EnY >= 274 && EnY <= 308) {
                pasar = false;
            }
        }
        if (EnX == 249) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 58 && EnY <= 92) || (EnY >= 94 && EnY <= 164) || (EnY >= 166 && EnY <= 236) || (EnY >= 238 && EnY <= 308)) {
                pasar = false;
            }
        }
        if (EnX == 213) {
            if ((EnY >= 58 && EnY <= 164) || (EnY >= 166 && EnY <= 236) || (EnY >= 274 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 177) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 94 && EnY <= 128) || (EnY >= 238 && EnY <= 272) || (EnY >= 310 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 141) {
            if ((EnY >= 8 && EnY <= 56) || (EnY >= 58 && EnY <= 128) || (EnY >= 202 && EnY <= 272) || (EnY >= 274 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 105) {
            if ((EnY >= 58 && EnY <= 92) || (EnY >= 130 && EnY <= 200) || (EnY >= 202 && EnY <= 236) || (EnY >= 274 && EnY <= 308)) {
                pasar = false;
            }
        }
        if (EnX == 69) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 58 && EnY <= 164) || (EnY >= 166 && EnY <= 236) || (EnY >= 238 && EnY <= 272) || (EnY >= 274 && EnY <= 344)) {
                pasar = false;
            }
        }
        if (EnX == 33) {
            if (EnY >= 238 && EnY <= 308) {
                pasar = false;
            }
        }
        if (EnX == 9) {
            if ((EnY >= 10 && EnY <= 56) || (EnY >= 58 && EnY <= 92) || (EnY >= 238 && EnY <= 272) || (EnY >= 310 && EnY <= 344)) {
                pasar = false;
            }
        }
        return pasar;
    }

    public boolean ColicionUp(int EnX, int EnY) {
        boolean pasar = true;
        if (EnY == 9) {
            if (EnX >= 0 && EnX <= 340) {
                pasar = false;
            }
        }
        if (EnY == 57) {
            if ((EnX >= 10 && EnX <= 68) || (EnX >= 70 && EnX <= 140) || (EnX >= 142 && EnX <= 176) || (EnX >= 178 && EnX <= 248) || (EnX >= 250 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 93) {
            if ((EnX >= 10 && EnX <= 68) || (EnX >= 106 && EnX <= 212) || (EnX >= 250 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 129) {
            if ((EnX >= 70 && EnX <= 140) || (EnX >= 142 && EnX <= 176) || (EnX >= 178 && EnX <= 248)) {
                pasar = false;
            }
        }
        if (EnY == 165) {
            if ((EnX >= -30 && EnX <= 68) || (EnX >= 70 && EnX <= 104) || (EnX >= 214 && EnX <= 248) || (EnX >= 250 && EnX <= 350)) {
                pasar = false;
            }
        }
        if (EnY == 201) {
            if (EnX >= 106 && EnX <= 212) {
                pasar = false;
            }
        }
        if (EnY == 237) {
            if ((EnX >= -30 && EnX <= 68) || (EnX >= 70 && EnX <= 104) || (EnX >= 106 && EnX <= 212) || (EnX >= 214 && EnX <= 248) || (EnX >= 250 && EnX <= 350)) {
                pasar = false;
            }
        }
        if (EnY == 273) {
            if ((EnX >= 10 && EnX <= 68) || (EnX >= 70 && EnX <= 140) || (EnX >= 142 && EnX <= 176) || (EnX >= 178 && EnX <= 248) || (EnX >= 250 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 309) {
            if ((EnX >= 0 && EnX <= 32) || (EnX >= 34 && EnX <= 68) || (EnX >= 106 && EnX <= 212) || (EnX >= 250 && EnX <= 284) || (EnX >= 286 && EnX <= 350)) {
                pasar = false;
            }
        }
        if (EnY == 345) {
            if ((EnX >= 10 && EnX <= 140) || (EnX >= 142 && EnX <= 176) || (EnX >= 178 && EnX <= 308)) {
                pasar = false;
            }
        }
        return pasar;
    }

    public boolean ColicionDown(int EnX, int EnY) {
        boolean pasar = true;
        if (EnY == 9) {
            if ((EnX >= 10 && EnX <= 68) || (EnX >= 70 && EnX <= 140) || (EnX >= 178 && EnX <= 248) || (EnX >= 250 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 57) {
            if ((EnX >= 10 && EnX <= 68) || (EnX >= 70 && EnX <= 104) || (EnX >= 106 && EnX <= 212) || (EnX >= 214 && EnX <= 248) || (EnX >= 250 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 93) {
            if ((EnX >= -30 && EnX <= 68) || (EnX >= 70 && EnX <= 140) || (EnX >= 178 && EnX <= 248) || (EnX >= 250 && EnX <= 350)) {
                pasar = false;
            }
        }
        if (EnY == 129) {
            if (EnX >= 106 && EnX <= 212) {
                pasar = false;
            }
        }
        if (EnY == 165) {
            if ((EnX >= -30 && EnX <= 68) || (EnX >= 70 && EnX <= 104) || (EnX >= 214 && EnX <= 248) || (EnX >= 250 && EnX <= 350)) {
                pasar = false;
            }
        }
        if (EnY == 201) {
            if (EnX >= 106 && EnX <= 212) {
                pasar = false;
            }
        }
        if (EnY == 237) {
            if ((EnX >= 10 && EnX <= 68) || (EnX >= 70 && EnX <= 140) || (EnX >= 142 && EnX <= 176) || (EnX >= 178 && EnX <= 248) || (EnX >= 250 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 273) {
            if ((EnX >= 0 && EnX <= 32) || (EnX >= 70 && EnX <= 104) || (EnX >= 106 && EnX <= 212) || (EnX >= 214 && EnX <= 248) || (EnX >= 286 && EnX <= 350)) {
                pasar = false;
            }
        }
        if (EnY == 309) {
            if ((EnX >= 10 && EnX <= 140) || (EnX >= 178 && EnX <= 308)) {
                pasar = false;
            }
        }
        if (EnY == 345) {
            if (EnX >= 0 && EnX <= 340) {
                pasar = false;
            }
        }
        return pasar;
    }

    public void ColicionFantasma(int PFanX, int PFanY) {
        if ((PFanX >= PPacMan.x - 15 && PFanX <= PPacMan.x + 15) && (PFanY >= PPacMan.y - 15 && PFanY <= PPacMan.y + 15)) {
            Vidas--;
            InterfasPerder IP = new InterfasPerder();
            IP.setPuntaje(Puntuacion);
            if (Vidas == 0) {
                IP.setBounds(0, 0, 350, 250);
                IP.setVisible(true);
                IP.setResizable(false);
                IP.setLocationRelativeTo(null);
                this.setVisible(false);
            } else {
                Reiniciar();
            }
        }
    }

    public void Reiniciar() {
        Esperar = false;
        LPrecionaEspacio.setText("Preciona Espacio");
        LPrecionaEspacio.setBounds(25, 111, 400, 100);
        LPrecionaEspacio.setVisible(true);
        DFanR = 0;
        DFanO = 3;
        DFanP = 3;
        DFanB = 1;
        Direccion = KeyEvent.VK_RIGHT;
        LVidas.setText("Vidas: " + Vidas);
        PPacMan.x = 159;
        PPacMan.y = 201; //159, 201
        LPacMan.setBounds(PPacMan.x, PPacMan.y, 21, 21);
        PFanR.x = 159;
        PFanR.y = 129; //159, 129
        LFanR.setBounds(PFanR.x, PFanR.y, 21, 21);
        PFanO.x = 159;
        PFanO.y = 171; //159, 171
        LFanO.setBounds(PFanO.x, PFanO.y, 21, 21);
        PFanP.x = 144;
        PFanP.y = 171; // 144, 171
        LFanP.setBounds(PFanP.x, PFanP.y, 21, 21);
        PFanB.x = 135;
        PFanB.y = 165; // 135, 165
        LFanB.setBounds(PFanB.x, PFanB.y, 21, 21);
        Contador = 0;
    }

    public class Teclas extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                Esperar = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (Direccion != KeyEvent.VK_UP && Direccion != KeyEvent.VK_DOWN) {
                    AnDireccion = Direccion;
                }
                Direccion = KeyEvent.VK_UP;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (Direccion != KeyEvent.VK_DOWN && Direccion != KeyEvent.VK_UP) {
                    AnDireccion = Direccion;
                }
                Direccion = KeyEvent.VK_DOWN;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (Direccion != KeyEvent.VK_LEFT && Direccion != KeyEvent.VK_RIGHT) {
                    AnDireccion = Direccion;
                }
                Direccion = KeyEvent.VK_LEFT;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (Direccion != KeyEvent.VK_RIGHT && Direccion != KeyEvent.VK_LEFT) {
                    AnDireccion = Direccion;
                }
                Direccion = KeyEvent.VK_RIGHT;
            }
        }
    }

    public class Momento extends Thread {

        long Last = 0;

        @Override
        public void run() {
            while (true) {
                if ((java.lang.System.currentTimeMillis() - Last) > Frecuencia) {
                    if (Esperar == true) {
                        if (Contador == 50) {
                            LPrecionaEspacio.setText("2");
                            LPrecionaEspacio.setBounds(156, 111, 100, 100);
                        }
                        if (Contador == 1000) {
                            LPrecionaEspacio.setText("1");
                        }
                        if (Contador == 2000) {
                            LPrecionaEspacio.setVisible(false);
                        }
                        if (Contador >= 2000) {
                            TPacMan++;
                            if (TPacMan == 4) {
                                TPacMan = 0;
                                LPacMan.setIcon(PacMan1);
                            }
                            if (Direccion == KeyEvent.VK_UP) {
                                if (ColicionUp(PPacMan.x, PPacMan.y) == false) {
                                    if (AnDireccion != KeyEvent.VK_DOWN) {
                                        MovimientoPac(AnDireccion);
                                    }
                                } else {
                                    MovimientoPac(Direccion);
                                    AnDireccion = 0;
                                }
                            }
                            if (Direccion == KeyEvent.VK_DOWN) {
                                if (ColicionDown(PPacMan.x, PPacMan.y) == false) {
                                    if (AnDireccion != KeyEvent.VK_UP) {
                                        MovimientoPac(AnDireccion);
                                    }
                                } else {
                                    MovimientoPac(Direccion);
                                    AnDireccion = 0;
                                }
                            }
                            if (Direccion == KeyEvent.VK_RIGHT) {
                                if (ColicionRight(PPacMan.x, PPacMan.y) == false) {
                                    if (AnDireccion != KeyEvent.VK_LEFT) {
                                        MovimientoPac(AnDireccion);
                                    }
                                } else {
                                    MovimientoPac(Direccion);
                                    AnDireccion = 0;
                                }
                            }
                            if (Direccion == KeyEvent.VK_LEFT) {
                                if (ColicionLeft(PPacMan.x, PPacMan.y) == false) {
                                    if (AnDireccion != KeyEvent.VK_RIGHT) {
                                        MovimientoPac(AnDireccion);
                                    }
                                } else {
                                    MovimientoPac(Direccion);
                                    AnDireccion = 0;
                                }
                            }
                            Punto();
                            ColicionFantasma(PFanR.x, PFanR.y);
                            ColicionFantasma(PFanB.x, PFanB.y);
                            ColicionFantasma(PFanP.x, PFanP.y);
                            ColicionFantasma(PFanO.x, PFanO.y);
                        }
                        if (Contador < 12000) {
                            Contador = Contador + Frecuencia;
                        }
                    }
                    Last = java.lang.System.currentTimeMillis();
                }
            }
        }
    }

    public class MomentoF extends Thread {

        long Last = 0;

        @Override
        public void run() {
            while (true) {
                if ((java.lang.System.currentTimeMillis() - Last) > FrecuenciaF) {
                    if (Esperar == true) {
                        if (Contador >= 2000) {
                            MoviFanR();
                            MoviFanO();
                            MoviFanP();
                            MoviFanB();
                        }
                    }
                    Last = java.lang.System.currentTimeMillis();
                }
            }
        }
    }
}