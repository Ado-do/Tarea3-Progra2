package tarea3;

import java.util.ArrayList;
import tarea3.exceptions.*;
import java.awt.*;

public class Expendedor {
    private int precio;
    private ArrayList<DepositoBebida> depBebidas;
    private int capacidadDeps;
    private int[] seriesCont;
    private Bebida depCompra;
    private DepositoMoneda depMonedas;
    private DepositoMoneda depVuelto;
    

    public Expendedor(int cantBebidas, int precioUnico) {
        this.precio = precioUnico;
        this.depBebidas = new ArrayList<DepositoBebida>(3);
        depBebidas.add(new DepositoBebida());
        depBebidas.add(new DepositoBebida());
        depBebidas.add(new DepositoBebida());
        
        this.seriesCont = new int[]{1000,2000,3000};
        for (int i = 0; i < cantBebidas; i++) {
            depBebidas.get(0).addBebida(new CocaCola(seriesCont[0]++));
            depBebidas.get(1).addBebida(new Fanta(seriesCont[1]++));
            depBebidas.get(2).addBebida(new Sprite(seriesCont[2]++));
        }
        
        //* Nuevo, por enunciado
        this.capacidadDeps = cantBebidas;
        this.depVuelto = new DepositoMoneda();
        this.depMonedas = new DepositoMoneda();
    }
    public void comprarBebida(Moneda m, int num) {  //* Modificado para compatibilizar con enunciado de la tarea3
        boolean devolverMoneda = false; // Flag para verificar si hay devolucion o no
        Bebida compra;

        try {
            // Se ingreso una moneda?
            if (m == null) {
                compra = null;
                throw new PagoIncorrectoException("No se ingreso moneda.");
            // * Ya había otra compra en proceso?
            } else if (depCompra != null) {
                devolverMoneda = true;
                throw new CompraEnProcesoException("Recoja su anterior compra antes de realizar otra.");
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
                            int vuelto = m.getValor() - precio;
                            for (int i = 0; i < vuelto/100; i++) {
                                depVuelto.addMoneda(new Moneda100());
                            }
                        }
                        // * Guardar moneda y compra en deps
                        depMonedas.addMoneda(m);
                        depCompra = compra;
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

        if (devolverMoneda) depVuelto.addMoneda(m); // Se guarda moneda para ser devuelta
    }
    public Bebida getBebida() {
        Bebida aux = depCompra;
        depCompra = null;
        return aux;
    }
    public void refillDep() {   //* Rellenar depósitos vacíos
        for (int i = 0; i < 3; i++) {
            DepositoBebida dep = depBebidas.get(i);
            if (dep.cantBebidas() == 0) {
                for (int j = 0; j < capacidadDeps; j++) {
                    Bebida aux = null;
                    switch (i) {
                        case 0: aux = new CocaCola(seriesCont[0]++); break;
                        case 1: aux = new Sprite(seriesCont[1]++); break;
                        case 2: aux = new Fanta(seriesCont[2]++); break;
                    }
                    dep.addBebida(aux);
                }
            }
        }
    }
    public Moneda getVuelto() {
        return depVuelto.getMoneda();
    }
    //! WIP
    public void paint(Graphics g) {

    }
}