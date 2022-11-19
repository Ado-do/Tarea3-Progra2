package tarea3;

import tarea3.exceptions.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Expendedor extends JPanel {
    private int precio;
    private ArrayList<DepositoBebida> depBebidas;
    private int capacidadDeps;
    private int[] seriesCont;

    private Bebida compra;
    private Moneda monedaDeCompra;
    private DepositoMoneda depMonedasDeCompras, depVuelto;

    private JLabel infoPantallaSuperior, insertar, logoCocacola, logoSprite, logoFanta, vuelto, depCompra,infoPantallita, pantallaSuperior;
    private ImageIcon[][] imagenes;

    //* Constructor */
    public Expendedor(int cantBebidas, int precioUnico, int xPos, int yPos) {
        super();

        //* Inicializar componentes del expendedor */
        this.precio = precioUnico;
        this.capacidadDeps = cantBebidas;

        this.depBebidas = new ArrayList<DepositoBebida>(3);
        depBebidas.add(new DepositoBebida(20, 85));
        depBebidas.add(new DepositoBebida(120, 85));
        depBebidas.add(new DepositoBebida(220, 85));
        this.add(depBebidas.get(0));
        this.add(depBebidas.get(1));
        this.add(depBebidas.get(2));
        this.seriesCont = new int[]{1000,2000,3000};
        for (int i = 0; i < capacidadDeps; i++) {
            depBebidas.get(0).addBebida(new CocaCola(seriesCont[0]++));
            depBebidas.get(1).addBebida(new Sprite(seriesCont[1]++));
            depBebidas.get(2).addBebida(new Fanta(seriesCont[2]++));
        }
        this.depVuelto = new DepositoMoneda();
        this.depMonedasDeCompras = new DepositoMoneda();
        this.monedaDeCompra = null;
        this.compra = null;

        //* Inicializar imagenes
        ImageIcon imgBase = new ImageIcon(getClass().getResource("/imagenes/baseExpendedor.png"));
        imagenes = new ImageIcon[][] {
            {new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo1.png")), new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/spriteLogo1.png")), new ImageIcon(getClass().getResource("/imagenes/spriteLogo2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/fantaLogo1.png")), new ImageIcon(getClass().getResource("/imagenes/fantaLogo2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/pantallaSuperior1.png")), new ImageIcon(getClass().getResource("/imagenes/pantallaSuperior2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/insertar1.png")), new ImageIcon(getClass().getResource("/imagenes/insertar2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/vuelto1.png")), new ImageIcon(getClass().getResource("/imagenes/vuelto2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/depositoCompra1.png")), new ImageIcon(getClass().getResource("/imagenes/depositoCompra2.png"))}
        };

        //* Configurar este panel
        this.setLayout(null);
        this.setBounds(xPos, yPos, imgBase.getIconWidth(), imgBase.getIconHeight());
        this.setOpaque(false);

        //* Configurar JComponents
        JLabel base = new JLabel(imgBase);
        base.setBounds(0, 0, imgBase.getIconWidth(), imgBase.getIconHeight());
        
        pantallaSuperior = new JLabel(imagenes[3][0]);
        pantallaSuperior.setBounds(19, 18, pantallaSuperior.getIcon().getIconWidth(), pantallaSuperior.getIcon().getIconHeight());
        pantallaSuperior.addMouseListener(new MouseAdapter() { // Se creara una clase con literal
            @Override
            public void mouseEntered(MouseEvent evt) {
                pantallaSuperiorMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                pantallaSuperiorMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                pantallaSuperiorMouseCliked(evt);
            }
        });
        
        infoPantallaSuperior = new JLabel();
        infoPantallaSuperior.setText("Bienvenido!");
        infoPantallaSuperior.setFont(new Font("Arial", Font.PLAIN, 20));
        infoPantallaSuperior.setForeground(Color.WHITE);
        infoPantallaSuperior.setSize(1000, 20);
        infoPantallaSuperior.setLocation(40, 40);

        infoPantallita = new JLabel();
        infoPantallita.setText("$ 0");
        infoPantallita.setFont(new Font("Arial", Font.PLAIN, 20));
        infoPantallita.setForeground(Color.WHITE);
        infoPantallita.setSize(100, 20);
        infoPantallita.setLocation(325, 130);

        insertar = new JLabel(imagenes[4][0]);
        insertar.setBounds(320, 170, insertar.getIcon().getIconWidth(), insertar.getIcon().getIconHeight());
        insertar.addMouseListener(new MouseAdapter() { // Se creara una clase con literal
            @Override
            public void mouseEntered(MouseEvent evt) {
                insertarMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                insertarMouseExited(evt);
            }
        });

        logoCocacola = new JLabel(imagenes[0][0]);
        logoCocacola.setBounds(318, 222, logoCocacola.getIcon().getIconWidth(), logoCocacola.getIcon().getIconHeight());
        logoCocacola.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                logoCocacolaMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                logoCocacolaMouseExited(evt);
            }
        });
        
        logoSprite = new JLabel(imagenes[1][0]);
        logoSprite.setBounds(318, 258, logoSprite.getIcon().getIconWidth(), logoSprite.getIcon().getIconHeight());
        logoSprite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                logoSpriteMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                logoSpriteMouseExited(evt);
            }
        });

        logoFanta = new JLabel(imagenes[2][0]);
        logoFanta.setBounds(318, 294, logoFanta.getIcon().getIconWidth(), logoFanta.getIcon().getIconHeight());
        logoFanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                logoFantaMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                logoFantaMouseExited(evt);
            }
        });

        vuelto = new JLabel(imagenes[5][0]);
        vuelto.setBounds(322, 339, vuelto.getIcon().getIconWidth(), vuelto.getIcon().getIconHeight());
        vuelto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                vueltoMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                vueltoMouseExited(evt);
            }
        });

        depCompra = new JLabel(imagenes[6][0]);
        depCompra.setBounds(328, 431, depCompra.getIcon().getIconWidth(), depCompra.getIcon().getIconHeight());
        depCompra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                depCompraMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                depCompraMouseExited(evt);
            }
        });

        // Agregar todo al JPanel
        this.add(depBebidas.get(0));
        this.add(depBebidas.get(1));
        this.add(depBebidas.get(2));
        this.add(infoPantallaSuperior);
        this.add(pantallaSuperior);
        this.add(infoPantallita);
        this.add(insertar);
        this.add(logoCocacola);
        this.add(logoSprite);
        this.add(logoFanta);
        this.add(vuelto);
        this.add(depCompra);
        this.add(base);
    }
    
    //* Cambiar informacion mostrada en pantalla de expendedor */
    private void updateInfoPantallita(String monea) {
        infoPantallita.setText(monea);
    }
    private void updateInfoPantallaSup(String info) {
        infoPantallaSuperior.setText(info);
    }

    //* Funciones para obterner coordenadas y tamaño de Jlabels */
    public Rectangle getInsertarBounds() {
        return insertar.getBounds();
    }
    public Rectangle getVueltoBounds() {
        return vuelto.getBounds();
    }
    public Rectangle getDepCompraBounds() {
        return depCompra.getBounds();
    }
    public Rectangle getCocacolaBounds() {
        return logoCocacola.getBounds();
    }
    public Rectangle getSpriteBounds() {
        return logoSprite.getBounds();
    }
    public Rectangle getFantaBounds() {
        return logoFanta.getBounds();
    }

    //* Logica del expendedor */
    public void comprarBebida(int num) {  //! Modificado para compatibilizar con enunciado de la tarea3
        boolean devolverMoneda = false; // Flag para verificar si hay devolucion o no

        try {
            // * Se ingreso una moneda?
            if (monedaDeCompra == null) {
                throw new PagoIncorrectoException("No se ingreso moneda.");

            // * Ya había otra compra en proceso?
            } else if (compra != null) {
                this.updateInfoPantallaSup("Recoja su compra para continuar");

                devolverMoneda = true;
                throw new CompraEnProcesoException("Recoja su anterior compra antes de realizar otra.");
            
            // * Seguir con proceso de compra
            } else {
                // Si el valor de la moneda alcanza para comprar bebida
                if (monedaDeCompra.getValor() >= precio) {
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

                    //* En caso de compra exitosa
                    } else {
                        this.updateInfoPantallaSup("Compra exitosa, disfrute!");

                        //* Posicionar compra en deposito de compra y agregar a GUI
                        compra.setXY(340, 438);
                        compra.setVisible(true);
                        this.add(compra);
                        this.setComponentZOrder(compra, 0);
                        this.updateUI();

                        // Si la moneda tenia una valor mayor entonces se calcula vuelto
                        if (monedaDeCompra.getValor() > precio) {
                            int vuelto = monedaDeCompra.getValor() - precio;
                            for (int i = 0; i < vuelto/100; i++) {
                                depVuelto.addMoneda(new Moneda100(false));
                            }
                        }

                        //* Guardar moneda y actualizar pantalla
                        this.updateInfoPantallita("$ 0");
                        depMonedasDeCompras.addMoneda(monedaDeCompra); //* Guardar moneda
                        monedaDeCompra = null;
                    }
                // En el caso de que no alcance la moneda
                } else {
                    this.updateInfoPantallaSup("Valor insuficiente, moneda devuelta.");
                    devolverMoneda = true;
                    throw new PagoInsuficienteException("Pago insuficiente.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (devolverMoneda) {
            this.updateInfoPantallita("$ 0");

            depVuelto.addMoneda(monedaDeCompra);
            monedaDeCompra = null;
            System.out.println("Moneda devuelta.");
        }
    }
    public Bebida getBebida() {
        if (compra != null) {
            System.out.println("Compra recogida desde expendedor.");

            compra.setVisible(false);
            this.remove(compra);
            this.updateUI();
            Bebida aux = compra;
            compra = null;
            return aux;
        } else {
            return null;
        }
    }
    public void refillDep() {   //TODO: Crear funcion de rellenado en la clase DepositoBebida
        System.out.println("Rellenando depositos vacios...");

        for (int i = 0; i < 3; i++) {
            DepositoBebida dep = depBebidas.get(i);
            if (dep.isEmpty()) {
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
        this.updateUI();
    }
    public Moneda getVuelto() {
        return depVuelto.getMoneda();
    }
    public void ingresarMoneda(Moneda m) {   
        if (monedaDeCompra != null) {
            updateInfoPantallaSup("Terminar compra en proceso.");
            System.out.println("Moneda ingresada devuelta.");

            depVuelto.addMoneda(monedaDeCompra);
        } else {
            updateInfoPantallaSup("Moneda de $"+m.getValor()+" ingresada.");
            updateInfoPantallita("$"+m.getValor());

            this.monedaDeCompra = m;
        }
    }
    public boolean hayCompra() {
        return (compra != null) ? true : false;
    }
    public boolean hayVuelto() {
        return (!depVuelto.isEmpty()) ? true : false; 
    }
    
    //* Administracion de eventos */
    private void pantallaSuperiorMouseEntered(MouseEvent evt) {                                          
        pantallaSuperior.setIcon(imagenes[3][1]);
    }
    private void pantallaSuperiorMouseExited(MouseEvent evt) {
        pantallaSuperior.setIcon(imagenes[3][0]);
    }
    private void pantallaSuperiorMouseCliked(MouseEvent evt) {
        this.refillDep();
    }
    
    public void insertarMouseEntered(MouseEvent evt) {                                          
        insertar.setIcon(imagenes[4][1]);
    }
    public void insertarMouseExited(MouseEvent evt) {
        insertar.setIcon(imagenes[4][0]);
    }
    
    public void vueltoMouseEntered(MouseEvent evt) {                                          
        vuelto.setIcon(imagenes[5][1]);
    }
    public void vueltoMouseExited(MouseEvent evt) {
        vuelto.setIcon(imagenes[5][0]);
    }
    
    public void depCompraMouseEntered(MouseEvent evt) {                                          
        depCompra.setIcon(imagenes[6][1]);
    }
    public void depCompraMouseExited(MouseEvent evt) {
        depCompra.setIcon(imagenes[6][0]);
    }
    
    public void logoCocacolaMouseEntered(MouseEvent evt) {                                          
        logoCocacola.setIcon(imagenes[0][1]);
    }
    public void logoCocacolaMouseExited(MouseEvent evt) {
        logoCocacola.setIcon(imagenes[0][0]);
    }
    
    public void logoSpriteMouseEntered(MouseEvent evt) {
        logoSprite.setIcon(imagenes[1][1]);
    }
    public void logoSpriteMouseExited(MouseEvent evt) {
        logoSprite.setIcon(imagenes[1][0]);
    }
    
    public void logoFantaMouseEntered(MouseEvent evt) {
        logoFanta.setIcon(imagenes[2][1]);
    }
    public void logoFantaMouseExited(MouseEvent evt) {
        logoFanta.setIcon(imagenes[2][0]);
    }
}