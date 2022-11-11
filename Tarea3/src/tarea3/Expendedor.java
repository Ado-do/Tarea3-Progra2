package tarea3;

import java.util.ArrayList;
import tarea3.exceptions.*;
import java.awt.*;

public class Expendedor {
    private ArrayList<DepositoBebida> depBebidas;
    private DepositoVuelto depVuelto;
    private int precio;
    
    private Bebida depCompra;
    private ArrayList<Moneda> depMonedas;
    private int capDeps;
    private int[] seriesCont;

    public Expendedor(int cantBebidas, int precioUnico) {
        this.precio = precioUnico;
        this.depBebidas = new ArrayList<DepositoBebida>(3);
        
        depBebidas.add(new DepositoBebida());
        depBebidas.add(new DepositoBebida());
        depBebidas.add(new DepositoBebida());
        
        
        this.seriesCont = new int[]{0,0,0};
        for (int i = 0; i < cantBebidas; i++) {
            depBebidas.get(0).addBebida(new CocaCola(100 + (seriesCont[0]++)));
            depBebidas.get(1).addBebida(new Fanta(200 + (seriesCont[1]++)));
            depBebidas.get(2).addBebida(new Sprite(300 + (seriesCont[2]++)));
        }
        
        //* Nuevo, por enunciado
        this.capDeps = cantBebidas;
        this.depVuelto = new DepositoVuelto();
        this.depMonedas = new ArrayList<Moneda>();
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
                            depVuelto.generarVuelto(m.getValor() - precio);
                        }
                        // * Guardar moneda y compra en deps
                        this.depMonedas.add(m);
                        this.depCompra = compra;
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
                for (int j = 0; j < capDeps; j++) {
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
        return depVuelto.getVuelto();
    }
    //! WIP
    public void paint(Graphics g) {

    }
}