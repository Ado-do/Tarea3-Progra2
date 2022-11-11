package tarea3;

import java.awt.*;
import java.util.ArrayList; 

public class Comprador { //* Adaptado para hacer varias compras
    // private int vuelto = 0;
    // private String saborBebido;
    private Expendedor exp;
    private ArrayList<Bebida> compras;
    private ArrayList<Moneda> monedero;

    // public Comprador(Moneda m, int numBebida, Expendedor exp) {
        // Bebida b = exp.comprarBebida(m, numBebida);
        
        // // Si compre una bebida exitosamente
        // if (b != null) {
        //     saborBebido = b.beber();

        //     // Contar vuelto en monedas de 100
        //     while (exp.getVuelto() != null) {
        //         vuelto += 100;
        //     }

        // // Si no pude comprar una bebida
        // } else {
        //     saborBebido = "No he tomado nada =(";
        //     // Comprobar si recibí moneda de vuelta
        //     Moneda devolucion = exp.getVuelto();
        //     if (devolucion != null) {
        //         vuelto += devolucion.getValor();
        //     }
        // }
    // }
    // public int cuantoVuelto() {
    //     return vuelto;
    // }
    // public String queBebiste() {
    //     return saborBebido;
    // }
    public Comprador(Expendedor exp) {
        this.exp = exp;
        compras = new ArrayList<Bebida>();
        monedero = new ArrayList<Moneda>();

        for (int i = 0; i < 5; i++) monedero.add(new Moneda100());
        for (int i = 0; i < 2; i++) monedero.add(new Moneda500());
        for (int i = 0; i < 1; i++) monedero.add(new Moneda1000());
    }
    
    public void comprarBebida(int indexMoneda, int numBebida) {
        Moneda m = monedero.remove(indexMoneda);
        this.exp.comprarBebida(m, numBebida);
    }
    public void recogerBebida() {
        Bebida compra = this.exp.getBebida();
        if (compra != null) {
            this.compras.add(compra);
        }
    }
    public void recogerVuelto() {
        Moneda m = exp.getVuelto();
        if (m != null) {
            monedero.add(m);
        }
    }
    public String tomarBebida(int index) {
        return compras.remove(index).beber();
    }
    //! WIP
    public void paint(Graphics g) {

    }
}
