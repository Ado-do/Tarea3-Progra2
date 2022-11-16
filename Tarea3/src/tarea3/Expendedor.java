package tarea3;

import tarea3.exceptions.*;

import java.util.ArrayList;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Expendedor extends JPanel {
    private int precio;
    private int dineroIngresado;

    private ArrayList<DepositoBebida> depBebidas;
    private int capacidadDeps;
    private int[] seriesCont;

    private Bebida depCompra;
    private DepositoMoneda depMonedas;
    private DepositoMoneda depVuelto;

    public Expendedor(int cantBebidas, int precioUnico, int xPos, int yPos) {
        super(null);

        this.precio = precioUnico;
        this.depBebidas = new ArrayList<DepositoBebida>(3);
        depBebidas.add(new DepositoBebida(20, 85));
        depBebidas.add(new DepositoBebida(120, 85));
        depBebidas.add(new DepositoBebida(220, 85));
        this.add(depBebidas.get(0));
        this.add(depBebidas.get(1));
        this.add(depBebidas.get(2));
        
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
        this.depCompra = null;

        //* Configurar JPanel y JComponents
        ImageIcon imgBase = new ImageIcon(getClass().getResource("/imagenes/baseExpendedor.png"));

        // Configurar este panel
        this.setBounds(xPos, yPos, imgBase.getIconWidth(), imgBase.getIconHeight());
        this.setOpaque(false);

        // Configurar JComponents
        JLabel base = new JLabel(imgBase);
        base.setBounds(0, 0, imgBase.getIconWidth(), imgBase.getIconHeight());

        JLabel pantallaSuperior = new JLabel(new ImageIcon(getClass().getResource("/imagenes/pantallaSuperior1.png")));
        pantallaSuperior.setBounds(19, 18, pantallaSuperior.getIcon().getIconWidth(), pantallaSuperior.getIcon().getIconHeight());

        // Agregar todo
        this.add(depBebidas.get(0));
        this.add(depBebidas.get(1));
        this.add(depBebidas.get(2));
        this.add(pantallaSuperior);
        this.add(base);
    }

    public void comprarBebida(Moneda m, int num) {  //* Modificado para compatibilizar con enunciado de la tarea3
        boolean devolverMoneda = false; // Flag para verificar si hay devolucion o no
        Bebida compra;

        try {
            // * Se ingreso una moneda?
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

        if (devolverMoneda) {
            depVuelto.addMoneda(m);
            System.out.println("Moneda devuelta.");
        }
    }
    public Bebida getBebida() {
        Bebida aux = depCompra;
        depCompra = null;
        return aux;
    }
    public void refillDep() {   //* Rellenar depósitos vacíos
        System.out.println("Rellenando depositos vacios...");

        for (int i = 0; i < 3; i++) {
            DepositoBebida dep = depBebidas.get(i);
            if (!dep.isEmpty()) {
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
    // public void paint(Graphics g) {

    // }
}