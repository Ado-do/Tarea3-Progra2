package tarea3;

import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Bebida extends JLabel {
    private int serie;

    public Bebida(int serie) {
        super();

        this.serie = serie;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                bebidaMouseClicked(evt);
            }
        });
    }
    public int getSerie() {
        return serie;
    }
    public void setXY(int xPos, int yPos) {
        this.setLocation(xPos, yPos);
    }

    public void bebidaMouseClicked(MouseEvent evt) {
        System.out.println("Serie de bebida clickeada: " + this.getSerie());
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