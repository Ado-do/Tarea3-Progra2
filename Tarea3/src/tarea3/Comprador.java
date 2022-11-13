package tarea3;

import java.awt.*;
import java.util.ArrayList; 

public class Comprador { //* Adaptado para hacer varias compras
    private Expendedor exp;
    private ArrayList<Bebida> compras;
    private ArrayList<Moneda> monedero;

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
        exp.comprarBebida(m, numBebida);
    }
    public void getBebida() {
        Bebida compra = exp.getBebida();
        if (compra != null) {
            this.compras.add(compra);
        }
    }
    public void getVuelto() {
        Moneda m = exp.getVuelto();
        if (m != null) {
            monedero.add(m);
        }
    }
    public String beberBebida(int index) {
        return compras.remove(index).beber();
    }
    //! WIP
    public void paint(Graphics g) {
        
    }
}
