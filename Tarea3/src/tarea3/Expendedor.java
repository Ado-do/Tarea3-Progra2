package tarea3;

import tarea3.exceptions.*;

import java.util.ArrayList;

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
    public JLabel logoCocacola,logoSprite,logoFanta;

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

        // Boton Coca Cola
        logoCocacola = new JLabel(new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo1.png")));
        logoCocacola.setBounds(318, 222, logoCocacola.getIcon().getIconWidth(), logoCocacola.getIcon().getIconHeight());
        logoCocacola.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoCocacolaMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoCocacolaMouseExited(evt);
            }
        });
        
        // Boton Sprite
        logoSprite = new JLabel(new ImageIcon(getClass().getResource("/imagenes/spriteLogo1.png")));
        logoSprite.setBounds(318, 258, logoSprite.getIcon().getIconWidth(), logoSprite.getIcon().getIconHeight());
        logoSprite.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoSpriteMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoSpriteMouseExited(evt);
            }
            
        });
        // Boton Fanta 
        logoFanta = new JLabel(new ImageIcon(getClass().getResource("/imagenes/fantaLogo1.png")));
        logoFanta.setBounds(318, 294, logoFanta.getIcon().getIconWidth(), logoFanta.getIcon().getIconHeight());
        logoFanta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoFantaMouseEntered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoFantaMouseExited(evt);
            }
            
        });

        JLabel vuelto = new JLabel(new ImageIcon(getClass().getResource("/imagenes/vuelto1.png")));
        vuelto.setBounds(322, 339, vuelto.getIcon().getIconWidth(), vuelto.getIcon().getIconHeight());

        JLabel depCompra = new JLabel(new ImageIcon(getClass().getResource("/imagenes/depositoCompra1.png")));
        depCompra.setBounds(328, 431, depCompra.getIcon().getIconWidth(), depCompra.getIcon().getIconHeight());

        // Agregar todo
        this.add(depBebidas.get(0));
        this.add(depBebidas.get(1));
        this.add(depBebidas.get(2));
        this.add(pantallaSuperior);
        this.add(logoCocacola);
        this.add(logoSprite);
        this.add(logoFanta);
        this.add(vuelto);
        this.add(depCompra);
        this.add(base);
    }
    public void logoCocacolaMouseEntered(java.awt.event.MouseEvent evt) {                                          
        logoCocacola.setIcon(new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo2.png")));
    }
    public void logoCocacolaMouseExited(java.awt.event.MouseEvent evt){
        logoCocacola.setIcon(new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo1.png")));
    }
    public void logoFantaMouseEntered(java.awt.event.MouseEvent evt){
        logoFanta.setIcon(new ImageIcon(getClass().getResource("/imagenes/fantaLogo2.png")));
    }
    public void logoFantaMouseExited(java.awt.event.MouseEvent evt){
        logoFanta.setIcon(new ImageIcon(getClass().getResource("/imagenes/fantaLogo1.png")));
    }
    public void logoSpriteMouseEntered(java.awt.event.MouseEvent evt){
        logoSprite.setIcon(new ImageIcon(getClass().getResource("/imagenes/spriteLogo2.png")));
    }
    public void logoSpriteMouseExited(java.awt.event.MouseEvent evt){
        logoSprite.setIcon(new ImageIcon(getClass().getResource("/imagenes/spriteLogo1.png")));
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