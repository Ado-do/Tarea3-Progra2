package tarea3;

import java.util.ArrayList;

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
    public void addBebida(Bebida b) {
        this.dep.add(b);

        if (dep.size() <= 6) {
            if (dep.size() == 1) {
                b.setXY(22, 415);
            } else {
                b.setXY(22, dep.get(dep.size()-2).getY() - 80);
            }
            b.setVisible(true);
        } else {
            b.setVisible(false);
        }

        this.add(b);
    }
    public Bebida getBebida() {
        if (!dep.isEmpty()) {
            Bebida bebidaRetirada = this.dep.remove(0);

            for (Bebida bebida : dep) {
                bebida.setXY(22, bebida.getY()+80);
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