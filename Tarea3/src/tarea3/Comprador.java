package tarea3;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

/* //! WEAS POR HACER (ATENTO KROSSITO)
 * //TODO: DIBUJAR (PONER IMAGENES) DE LOS INVENTARIOS
 * (OPCIONAL) MOSTRAR UN TEXTO DE QUE SE TOMO UNA BEBIDA CUANDO CLIKEA UNA BEBIDA DEL INVENTARIO Y Q DESAPARESCA
 * (OPCIONAL) HACER QUE INVENTARIO SE ABRA Y CIERRE SI CLICKEAS EN EL BOLSILLO Y LA CESTA (INDICAR CON FLECHAS O ALGUNA WEA)
 */

public class Comprador extends JLabel { //* Adaptado para hacer varias compras
    private ArrayList<Bebida> compras;
    private ArrayList<Moneda> monederoVuelto;
    private Moneda monedaElegida;
    private JLabel monedita;
    private ImageIcon[] imgMoneditas;

    public Comprador(int xPos, int yPos) {
        super();

        compras = new ArrayList<Bebida>();
        monederoVuelto = new ArrayList<Moneda>();
        monedaElegida = null;

        ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/comprador.png"));
        this.setIcon(image);
        this.setBounds(xPos, yPos, image.getIconWidth(), image.getIconHeight());

        imgMoneditas = new ImageIcon[] {
            new ImageIcon(getClass().getResource("/imagenes/M1000_3.png")),
            new ImageIcon(getClass().getResource("/imagenes/M500_3.png")),
            new ImageIcon(getClass().getResource("/imagenes/M100_3.png"))
        };

        monedita = new JLabel();
        monedita.setBounds(25, 255, 20, 20);
        monedita.setVisible(false);

        this.add(monedita);
    }
    
    public void comprarBebida(int numBebida, Expendedor exp) {
        exp.comprarBebida(this.monedaElegida, numBebida);
        monedaElegida = null;
    }
    public void getBebida(Expendedor exp) {
        Bebida compra = exp.getBebida();
        if (compra != null) {
            this.compras.add(compra);
        }
    }
    public void setMoneda(int eleccion) {
        switch (eleccion) {
            case 1000: 
                monedaElegida = new Moneda1000();
                monedita.setIcon(imgMoneditas[0]);
                break;
            case 500: 
                monedaElegida = new Moneda500();
                monedita.setIcon(imgMoneditas[1]);
                break;
            case 100: 
                monedaElegida = new Moneda100();
                monedita.setIcon(imgMoneditas[2]);
                break;
            default: 
                break;
        }
        if (!monedita.isVisible()) monedita.setVisible(true);
    }
    public void getVuelto(Expendedor exp) {
        boolean quedaVuelto = true;
        do {
            Moneda vuelto = exp.getVuelto();
            if (vuelto != null) monederoVuelto.add(vuelto);
            else quedaVuelto = false;
        } while (quedaVuelto);
    }
    public Moneda MonedaSeleccionada(){
        return monedaElegida;
    }
    public String beberBebida(int index) {
        return compras.remove(index).beber();
    }
}
