package tarea3;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Bebida extends JLabel {
    private int serie;

    public Bebida(int serie) {
        super();

        this.serie = serie;
    }
    public int getSerie() {
        return serie;
    }
    public void setXY(int xPos, int yPos) {
        this.setLocation(xPos, yPos);
    }

    public abstract String beber();
}

class CocaCola extends Bebida {

    public CocaCola(int serie) {
        super(serie);

        ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/cocacola.png"));
        this.setIcon(image);
        this.setSize(image.getIconWidth(), image.getIconHeight());
    }
    @Override
    public String beber() {
        return "Coca-cola";
    }
}
class Fanta extends Bebida{
      
    public Fanta(int serie){
        super(serie);

        ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/fanta.png"));
        this.setIcon(image);
        this.setSize(image.getIconWidth(), image.getIconHeight());
    }
    public String beber(){
        return "Fanta";
    }
}
class Sprite extends Bebida{

    public Sprite(int serie){
        super(serie);

        ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/sprite.png"));
        this.setIcon(image);
        this.setSize(image.getIconWidth(), image.getIconHeight());
    }
    public String beber(){
        return "Sprite";
    }
}