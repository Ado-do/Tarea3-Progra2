package tarea3;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Moneda extends JLabel {

    public Moneda() {
        super();
    }

    public Moneda getSerie() {
        return this;
    }
    public void setXY(int xPos, int yPos) {
        this.setLocation(xPos, yPos);
    }

    public abstract int getValor();
}

class Moneda100 extends Moneda {
    
    public Moneda100() {
        super();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/M100_1.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 100;
    }
}
class Moneda500 extends Moneda{
    public Moneda500(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/M500_1.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 500;
  }
}
class Moneda1000 extends Moneda{
    public Moneda1000(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/M1000_1.png"));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
    }
    @Override
    public int getValor() {
        return 1000;
    }
}