package tarea3;

import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Moneda extends JLabel {

    public Moneda(boolean isVisible) {
        super();
        this.setVisible(isVisible);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                monedaMouseClicked(evt);
            }
        });
    }

    public Moneda getSerie() {
        return this;
    }
    public void setXY(int xPos, int yPos) {
        this.setLocation(xPos, yPos);
    }
    
    public void monedaMouseClicked(MouseEvent evt) {
        System.out.println("Serie de moneda clickeada: " + this.getSerie());
    }

    public abstract int getValor();
}

class Moneda100 extends Moneda {
    
    public Moneda100(boolean isVisible) {
        super(isVisible);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/M100_3.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 100;
    }
    @Override
    public String toString() {
        return ("tarea3.Moneda100@" + Integer.toHexString(this.hashCode()));
    }
}
class Moneda500 extends Moneda{
    public Moneda500(boolean isVisible) {
        super(isVisible);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/M500_3.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 500;
    }
    @Override
    public String toString() {
        return ("tarea3.Moneda500@" + Integer.toHexString(this.hashCode()));
    }
}
class Moneda1000 extends Moneda{
    public Moneda1000(boolean isVisible) {
        super(isVisible);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/M1000_3.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 1000;
    }
    @Override
    public String toString() {
        return ("tarea3.Moneda1000@" + Integer.toHexString(this.hashCode()));
    }
}