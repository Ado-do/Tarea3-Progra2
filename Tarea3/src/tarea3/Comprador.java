package tarea3;

import java.awt.*; 

public class Comprador {
    private Expendedor exp;
    private DepositoBebida compras;
    private int vuelto = 0;
    private String saborBebido;

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
    public Comprador(Expendedor exp) {
        this.exp = exp;
    }

    public void comprarBebida(Moneda m, int numBebida) {
        // Compra la bebida
        this.exp.comprarBebida(m, numBebida);
    }
    public void recogerBebida() {
        Bebida compra = this.exp.getBebida();
        if (compra != null) {
            this.compras.addBebida(compra);
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }
    public String queBebiste() {
        return saborBebido;
    }
    //! WIP
    public void paint(Graphics g) {

    }
}
