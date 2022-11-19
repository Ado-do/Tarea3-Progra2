package tarea3;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* //! WEAS POR HACER (ATENTO KROSSITO)
 * //TODO: DIBUJAR (PONER IMAGENES) DE LOS INVENTARIOS
 * (OPCIONAL) MOSTRAR UN TEXTO DE QUE SE TOMO UNA BEBIDA CUANDO CLIKEA UNA BEBIDA DEL INVENTARIO Y Q DESAPARESCA
 * (OPCIONAL) HACER QUE INVENTARIO SE ABRA Y CIERRE SI CLICKEAS EN EL BOLSILLO Y LA CESTA (INDICAR CON FLECHAS O ALGUNA WEA)
 * 
 * //TODO HACER QUE COMPRADOR PRESIONE LOS BOTONES, (USAR SUS METODOS DE COMPRA, QUE EL INGRESE LA MONEDA)
 */

public class Comprador extends JPanel { //* Adaptado para hacer varias compras
    private ArrayList<Bebida> compras;
    private ArrayList<Moneda> monederoVuelto;
    private Moneda monedaParaCompra;
    

    //* Para dibujar en Panel Principal */
    public ArrayList<Bebida> getCompras() {
        return compras;
    }
    public ArrayList<Moneda> getMonedero() {
        return monederoVuelto;
    }

    public Comprador(int xPos, int yPos) {
        super();

        compras = new ArrayList<Bebida>();
        monederoVuelto = new ArrayList<Moneda>();
        monedaParaCompra = null;

        ImageIcon imgComp = new ImageIcon(getClass().getResource("/imagenes/comprador.png"));
        
        this.setLayout(null);
        this.setBounds(xPos, yPos, imgComp.getIconWidth(), imgComp.getIconHeight());
        this.setOpaque(false);

        JLabel comp = new JLabel(imgComp);
        comp.setBounds(0, 0, imgComp.getIconWidth(), imgComp.getIconHeight());

        this.add(comp);
    }
    
    public void comprarBebida(int numBebida, Expendedor exp) {
        exp.comprarBebida(numBebida);
    }

    public void getBebida(Expendedor exp) {
        Bebida compra = exp.getBebida();
        if (compra != null) {
            this.compras.add(compra);
        }
    }
    
    public void setMoneda(Moneda m) {
        if (tieneMonedaParaComprar()) remove(monedaParaCompra);

        monedaParaCompra = m;
        monedaParaCompra.setLocation(20, 255);
        monedaParaCompra.setVisible(true);
        this.add(monedaParaCompra);
        this.setComponentZOrder(monedaParaCompra, 0);

        this.updateUI();
    }
    
    public void getVuelto(Expendedor exp) {
        boolean quedaVuelto = true;
        do {
            Moneda vuelto = exp.getVuelto();
            if (vuelto != null) {
                System.out.println("Moneda de $"+vuelto.getValor()+" recibida");
                monederoVuelto.add(vuelto);
            } else {
                quedaVuelto = false;
            }
        } while (quedaVuelto);
    }

    public void ingresarMoneda(Expendedor exp) {
        if (monedaParaCompra != null) {
            monedaParaCompra.setVisible(false);
            exp.ingresarMoneda(monedaParaCompra);
            this.remove(monedaParaCompra);
            monedaParaCompra = null;
        }
    }
    
    public boolean tieneMonedaParaComprar() {
        return (monedaParaCompra != null) ? true : false;
    }
   
    public String beberBebida(int index) {
        return compras.remove(index).beber();
    }
}
