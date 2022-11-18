package tarea3;

import tarea3.exceptions.*;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class Expendedor extends JPanel {
    private int precio, dineroIngresado;

    private ArrayList<DepositoBebida> depBebidas;
    private int capacidadDeps;
    private int[] seriesCont;

    private Bebida compra;
    private DepositoMoneda depMonedas, depVuelto;
    private JLabel pantallaSuperior, logoCocacola, logoSprite, logoFanta, vuelto, depCompra,infoPantallita;
    private ImageIcon[][] imagenes;

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
        this.compra = null;

        //* Inicializar imagenes
        ImageIcon imgBase = new ImageIcon(getClass().getResource("/imagenes/baseExpendedor.png"));
        imagenes = new ImageIcon[][] {
            {new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo1.png")), new ImageIcon(getClass().getResource("/imagenes/cocacolaLogo2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/spriteLogo1.png")), new ImageIcon(getClass().getResource("/imagenes/spriteLogo2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/fantaLogo1.png")), new ImageIcon(getClass().getResource("/imagenes/fantaLogo2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/pantallaSuperior1.png")), new ImageIcon(getClass().getResource("/imagenes/pantallaSuperior2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/vuelto1.png")), new ImageIcon(getClass().getResource("/imagenes/vuelto2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/depositoCompra1.png")), new ImageIcon(getClass().getResource("/imagenes/depositoCompra2.png"))}
        };

        //* Configurar este panel
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
        });

        infoPantallita = new JLabel();
        infoPantallita.setText("");
        infoPantallita.setFont(new Font("Arial", Font.PLAIN, 20));
        infoPantallita.setForeground(Color.WHITE);
        infoPantallita.setSize(100, 20);
        infoPantallita.setLocation(325, 130);

        // Boton CocaCola
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
        
        // Boton Sprite
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
        // Boton Fanta 
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

        vuelto = new JLabel(imagenes[4][0]);
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

        depCompra = new JLabel(imagenes[5][0]);
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

        // Agregar todo
        this.add(depBebidas.get(0));
        this.add(depBebidas.get(1));
        this.add(depBebidas.get(2));
        this.add(pantallaSuperior);
        this.add(infoPantallita);
        this.add(logoCocacola);
        this.add(logoSprite);
        this.add(logoFanta);
        this.add(vuelto);
        this.add(depCompra);
        this.add(base);
    }
    
    public void CambiarInfoPantallita(String monea){
        infoPantallita.setText(monea);
    }

    public void comprarBebida(Moneda m, int num) {  //* Modificado para compatibilizar con enunciado de la tarea3
        boolean devolverMoneda = false; // Flag para verificar si hay devolucion o no

        try {
            // * Se ingreso una moneda?
            if (m == null) {
                compra = null;
                throw new PagoIncorrectoException("No se ingreso moneda.");
            // * Ya había otra compra en proceso?
            } else if (compra != null) {
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
                        //* Posicionar compra en deposito de compra y agregar a GUI
                        compra.setXY(340, 433);
                        this.add(compra);

                        // Si la moneda tenia una valor mayor entonces se calcula vuelto
                        if (m.getValor() > precio) {
                            int vuelto = m.getValor() - precio;
                            for (int i = 0; i < vuelto/100; i++) {
                                depVuelto.addMoneda(new Moneda100());
                            }
                        }
                        depMonedas.addMoneda(m); //* Guardar moneda
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
        Bebida aux = compra;
        compra = null;
        this.remove(compra);

        return aux;
    }
    public void refillDep() {   //* Rellenar depósitos vacíos
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
    }
    public Moneda getVuelto() {
        return depVuelto.getMoneda();
    }
    
    //* Eventos de mousee */
    private void pantallaSuperiorMouseEntered(MouseEvent evt) {                                          
        pantallaSuperior.setIcon(imagenes[3][1]);
    }
    private void pantallaSuperiorMouseExited(MouseEvent evt) {
        pantallaSuperior.setIcon(imagenes[3][0]);
    }
    private void vueltoMouseEntered(MouseEvent evt) {                                          
        vuelto.setIcon(imagenes[4][1]);
    }
    private void vueltoMouseExited(MouseEvent evt) {
        vuelto.setIcon(imagenes[4][0]);
    }
    private void depCompraMouseEntered(MouseEvent evt) {                                          
        depCompra.setIcon(imagenes[5][1]);
    }
    private void depCompraMouseExited(MouseEvent evt) {
        depCompra.setIcon(imagenes[5][0]);
    }
    private void logoCocacolaMouseEntered(MouseEvent evt) {                                          
        logoCocacola.setIcon(imagenes[0][1]);
    }
    private void logoCocacolaMouseExited(MouseEvent evt) {
        logoCocacola.setIcon(imagenes[0][0]);
    }
    private void logoSpriteMouseEntered(MouseEvent evt) {
        logoSprite.setIcon(imagenes[1][1]);
    }
    private void logoSpriteMouseExited(MouseEvent evt) {
        logoSprite.setIcon(imagenes[1][0]);
    }
    private void logoFantaMouseEntered(MouseEvent evt) {
        logoFanta.setIcon(imagenes[2][1]);
    }
    private void logoFantaMouseExited(MouseEvent evt) {
        logoFanta.setIcon(imagenes[2][0]);
    }
}