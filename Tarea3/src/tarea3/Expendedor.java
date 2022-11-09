package tarea3;

import java.util.ArrayList;
import tarea3.exceptions.*;
import java.awt.*;

public class Expendedor {
    private DepositoVuelto depVuelto;
    private ArrayList<DepositoBebida> depBebidas;
    private int precio;

    public Expendedor(int cantBebidas, int precioUnico) {
        this.precio = precioUnico;       
        this.depBebidas = new ArrayList<DepositoBebida>(3);

        depBebidas.add(new DepositoBebida());
        depBebidas.add(new DepositoBebida());
        depBebidas.add(new DepositoBebida());

        for (int i = 0; i < cantBebidas; i++) {
            depBebidas.get(0).addBebida(new CocaCola(100 + i));
            depBebidas.get(1).addBebida(new Fanta(200 + i));
            depBebidas.get(2).addBebida(new Sprite(300 + i));
        }
        this.depVuelto = new DepositoVuelto();
    }
    public Bebida comprarBebida(Moneda m, int num) {
        boolean devolverMoneda = false; // Flag para verificar si hay devolucion o no
        Bebida compra;

        try {
            // Se ingreso una moneda?
            if (m == null) {
                compra = null;
                throw new PagoIncorrectoException("No se ingreso moneda.");
            } else {
                // Si el valor de la moneda alcanza para comprar bebida
                if (m.getValor() >= precio) {
                    // Pad numérico
                    switch (num) {
                        case 1: compra = depBebidas.get(0).getBebida(); break;
                        case 2: compra = depBebidas.get(1).getBebida(); break;
                        case 3: compra = depBebidas.get(2).getBebida(); break;
                        default: {
                            compra = null;
                            throw new NoHayBebidaException("Elección inválida.");
                        }
                    }

                    // Si no quedan bebidas o hubo eleccion invalida
                    if (compra == null) {
                        devolverMoneda = true;
                        throw new NoHayBebidaException("No quedan bebidas en el deposito del expendedor.");
                    // En caso de compra exitosa
                    } else {
                        // Si la moneda tenia una valor mayor entonces se calcula vuelto
                        if (m.getValor() > precio) {
                            depVuelto.generarVuelto(m.getValor() - precio);
                        }
                        return compra; // Devolver bebida comprada
                    }

                // En el caso de que no alcance la moneda
                } else {
                    devolverMoneda = true;
                    throw new PagoInsuficienteException("Pago insuficiente.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (devolverMoneda) depVuelto.guardarDevolucion(m); // Se guarda moneda para ser devuelta

        return null;
    }
    public Moneda getVuelto() {
        return depVuelto.getVuelto();
    }
    //! WIP
    public void paint(Graphics g) {

    }
}