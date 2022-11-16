package tarea3;

import java.awt.*;
import java.util.ArrayList; 

public class Comprador { //* Adaptado para hacer varias compras
    private ArrayList<Bebida> compras;
    private ArrayList<Moneda> monederoVuelto;

    public Comprador() {
        compras = new ArrayList<Bebida>();
        monederoVuelto = new ArrayList<Moneda>();

        // for (int i = 0; i < 5; i++) monederoVuelto.add(new Moneda100());
        // for (int i = 0; i < 2; i++) monederoVuelto.add(new Moneda500());
        // for (int i = 0; i < 1; i++) monederoVuelto.add(new Moneda1000());
    }
    
    public void comprarBebida(int indexMoneda, int numBebida, Expendedor exp) {
        Moneda m = null;
        switch (indexMoneda) {
            case 0: m = new Moneda1000(); break;
            case 1: m = new Moneda500();  break;
            case 2: m = new Moneda100();  break;
            default: break;
        }

        exp.comprarBebida(m, numBebida);
    }
    public void getBebida(Expendedor exp) {
        Bebida compra = exp.getBebida();
        if (compra != null) {
            this.compras.add(compra);
        }
    }
    public void getVuelto(Expendedor exp) {
        boolean quedaVuelto = true;
        do {
            Moneda vuelto = exp.getVuelto();
            if (vuelto != null) monederoVuelto.add(vuelto);
            else quedaVuelto = false;
        } while (quedaVuelto);
    }
    public String beberBebida(int index) {
        return compras.remove(index).beber();
    }
    //! WIP
    public void paint(Graphics g) {
        
    }
}
