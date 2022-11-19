package tarea3;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class DepositoBebida extends JLabel {
    private ArrayList<Bebida> dep;
   
    public DepositoBebida(int xPos, int yPos) {
        super();

        ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/deposito.png"));
        this.setIcon(image);
        this.setBounds(xPos, yPos, image.getIconWidth(),image.getIconHeight());

        this.dep = new ArrayList<Bebida>();
    }
    
    private void bajarBebida(Bebida b) {
        Timer time = new Timer();

        int totalPixelsY = 80;

        int totalSeg = 1;
        int velocidad = 1;

        int period = (int)(1000 * (0.1 * velocidad));
        int totalIteraciones = (totalSeg * 1000) / period;
        int cantPixels = totalPixelsY / totalIteraciones;

        TimerTask tarea = new TimerTask() {
            private int i = 0;
            @Override
            public void run() {
                b.setLocation(22, b.getY() + cantPixels);
                i++;
                if (i == totalIteraciones) {
                    i = 0;
                    time.cancel();
                }
            }
        };
        time.scheduleAtFixedRate(tarea, 250, period);
    }

    public void addBebida(Bebida b) {
        this.dep.add(b);

        if (dep.size() == 1) {
            b.setXY(22, 415);
            b.setVisible(true);
        } else {
            b.setXY(22, dep.get(dep.size()-2).getY() - 80);
            b.setVisible(dep.size() <= 6);
        }

        this.add(b);
    }
    public Bebida getBebida() {
        if (!dep.isEmpty()) {
            Bebida bebidaRetirada = this.dep.remove(0);

            if ((dep.size() == 6) && !(dep.get(5).isVisible())) {
                dep.get(5).setVisible(true);
            }

            for (Bebida bebida : dep) {
                bajarBebida(bebida);
            }
            return bebidaRetirada;
            
        } else {
            return null;
        }
    }
    public boolean isEmpty() {
        return dep.isEmpty();
    }
}