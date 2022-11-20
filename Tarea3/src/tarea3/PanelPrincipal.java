package tarea3;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private Comprador comp;
    private Expendedor exp;
    
    private JPanel invBebidas, invMonedas;
    private JButton botonMonedero;

    private ImageIcon[][] imagenes;
    private Image fondo;

    //* Constructor */
    public PanelPrincipal() {
        super(null);

        //* Imagen de fondo del panel */
        fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();

        //* Inicializar OBJETOS PRINCIPALES */
        exp = new Expendedor(7, 800, 80, 50);
        comp = new Comprador(exp.getX() + 460, exp.getY() + 160);
        
        //* Inicializar imagenes a reutilizar
        imagenes = new ImageIcon[][] {
            {new ImageIcon(getClass().getResource("/imagenes/M1000_1.png")), new ImageIcon(getClass().getResource("/imagenes/M1000_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/M500_1.png")), new ImageIcon(getClass().getResource("/imagenes/M500_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/M100_1.png")), new ImageIcon(getClass().getResource("/imagenes/M100_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/cocacola.png")), new ImageIcon(getClass().getResource("/imagenes/cocacola2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/sprite.png")), new ImageIcon(getClass().getResource("/imagenes/sprite2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/fanta.png")), new ImageIcon(getClass().getResource("/imagenes/fanta2.png"))}
        };
       
        this.inicializarInterfazMonedas(); //* Inicializar interfaz de monedas seleccionables */
        this.inicializarBotonesExpendedor(); //* Inicializar interfaz de botones de interaccion Comprador-Expendedor */
        this.inicializarInterfazInventarios(); //* JLabels de inventarios de Comprador */

        this.add(comp);
        this.add(exp);
    }

    //* Agregar JComponents al panel principal */
    private void inicializarInterfazMonedas() {
        JLabel m1000 = new JLabel(imagenes[0][0]);
        m1000.setBounds(exp.getX() + 410, exp.getY() + 120, 54, 54);
        m1000.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                m1000.setIcon(imagenes[0][1]);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                m1000.setIcon(imagenes[0][0]);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                m1000MouseClicked(evt);
            }
        });

        JLabel m500 = new JLabel(imagenes[1][0]);
        m500.setBounds(exp.getX() + 410, exp.getY() + 180, 54, 54);
        m500.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                m500.setIcon(imagenes[1][1]);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                m500.setIcon(imagenes[1][0]);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                m500MouseClicked(evt);
            }
        });

        JLabel m100 = new JLabel(imagenes[2][0]);
        m100.setBounds(exp.getX() + 410, exp.getY() + 240, 54, 54);
        m100.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                m100.setIcon(imagenes[2][1]);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                m100.setIcon(imagenes[2][0]);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                m100MouseClicked(evt);    
            }
        });
        
        this.add(m1000);
        this.add(m500);        
        this.add(m100);
    }
    private void inicializarBotonesExpendedor() {
        JLabel insertar = new JLabel();
        Rectangle insertarBounds = exp.getInsertarBounds();
        insertarBounds.setLocation((int)insertarBounds.getX() + exp.getX(), (int)insertarBounds.getY() + exp.getY());
        insertar.setBounds(insertarBounds);
        insertar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (comp.tieneMonedaParaComprar()) exp.insertarMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                exp.insertarMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                insertarMouseClicked(evt);
            }
        });

        JLabel botonCocacola = new JLabel();
        Rectangle cocacolaBounds = exp.getCocacolaBounds();
        cocacolaBounds.setLocation((int)cocacolaBounds.getX() + exp.getX(), (int)cocacolaBounds.getY() + exp.getY());
        botonCocacola.setBounds(cocacolaBounds);
        botonCocacola.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                exp.logoCocacolaMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                exp.logoCocacolaMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonCocacolaMouseClicked(evt);
            }
        });

        JLabel botonSprite = new JLabel();
        Rectangle spriteBounds = exp.getSpriteBounds();
        spriteBounds.setLocation((int)spriteBounds.getX() + exp.getX(), (int)spriteBounds.getY() + exp.getY());
        botonSprite.setBounds(spriteBounds);
        botonSprite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                exp.logoSpriteMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                exp.logoSpriteMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonSpriteMouseClicked(evt);
            }
        });

        JLabel botonFanta = new JLabel();
        Rectangle fantaBounds = exp.getFantaBounds();
        fantaBounds.setLocation((int)fantaBounds.getX() + exp.getX(), (int)fantaBounds.getY() + exp.getY());
        botonFanta.setBounds(fantaBounds);
        botonFanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                exp.logoFantaMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                exp.logoFantaMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonFantaMouseClicked(evt);
            }
        });

        JLabel vuelto = new JLabel();
        Rectangle vueltoBounds = exp.getVueltoBounds();
        vueltoBounds.setLocation((int)vueltoBounds.getX() + exp.getX(), (int)vueltoBounds.getY() + exp.getY());
        vuelto.setBounds(vueltoBounds);
        vuelto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (exp.hayVuelto()) exp.vueltoMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                exp.vueltoMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                vueltoMouseClicked(evt);
            }
        });

        JLabel depCompra = new JLabel();
        Rectangle depCompraBounds = exp.getDepCompraBounds();
        depCompraBounds.setLocation((int)depCompraBounds.getX() + exp.getX(), (int)depCompraBounds.getY() + exp.getY());
        depCompra.setBounds(depCompraBounds);
        depCompra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (exp.hayCompra()) exp.depCompraMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                exp.depCompraMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                depCompraMouseClicked(evt);
            }
        });

        this.add(insertar);
        this.add(botonCocacola);
        this.add(botonSprite);
        this.add(botonFanta);
        this.add(vuelto);
        this.add(depCompra);
    }
    private void inicializarInterfazInventarios() {
        ImageIcon imgInventario = new ImageIcon(getClass().getResource("/imagenes/inventario.png"));
        ImageIcon imgBolsillo = new ImageIcon(getClass().getResource("/imagenes/bolsillo.png"));

        invMonedas = new JPanel(null);
        invMonedas.setBounds(comp.getX() + 205, comp.getY() + 40, imgBolsillo.getIconWidth(), imgBolsillo.getIconHeight());
        invMonedas.setOpaque(false);
        JLabel bolsillo = new JLabel(imgBolsillo);
        bolsillo.setBounds(0, 0, imgBolsillo.getIconWidth(), imgBolsillo.getIconHeight());
        invMonedas.add(bolsillo);

        invBebidas = new JPanel(null);
        invBebidas.setBounds(comp.getX() + 205, comp.getY() + 140, imgInventario.getIconWidth(), imgInventario.getIconHeight());
        invBebidas.setOpaque(false);
        JLabel inventario = new JLabel(imgInventario);
        inventario.setBounds(0, 0, imgInventario.getIconWidth(), imgInventario.getIconHeight());
        invBebidas.add(inventario);

        JLabel cesta = new JLabel(new ImageIcon(getClass().getResource("/imagenes/cestaCompras.png")));
        cesta.setBounds(comp.getX() + 110, comp.getY() + 340, cesta.getIcon().getIconWidth(), cesta.getIcon().getIconHeight());

        botonMonedero = new JButton("Vaciar monedero");
        botonMonedero.setSize(140, 22);
        botonMonedero.setLocation(invMonedas.getX() + 136, invMonedas.getY());
        botonMonedero.setEnabled(false);
        botonMonedero.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonMonederoMouseCliked(evt);
            }
        });

        this.add(cesta);
        this.add(botonMonedero);
        this.add(invBebidas);
        this.add(invMonedas);
    }

    //* Actualizar interfaz de invetarios de comprador */
    private void actualizarMonedero() {
        if (!botonMonedero.isEnabled()) botonMonedero.setEnabled(true);

        ArrayList<Moneda> monedasComprador = comp.getMonedero();

        for (int i = 0, posicion = 0, ypos = 26; i < monedasComprador.size(); i++, posicion += 20) {
            Moneda actual = monedasComprador.get(i);
            if (posicion ==260) {
                posicion = 0;
                ypos += 20;              
            }
            if(ypos == 86) {
                System.out.println("Monedero lleno!!");    
                break;
            }
            actual.setLocation(10 + posicion, ypos);
            actual.setVisible(true);

            invMonedas.add(actual);
            invMonedas.setComponentZOrder(actual, 0);
        }
        invMonedas.updateUI();
    }
    private void actualizarInventario() {
        ArrayList<Bebida> comprasComprador = comp.getCompras();
        int columnas = 1;

        for (int i = 0, posX = 4, posY = 25; i < comprasComprador.size(); i++, posX += 34) {
            Bebida actual = comprasComprador.get(i);
            
            if (i % 8 == 0 && i != 0) {
                posX = 4;
                posY += 62;
                columnas++;
            }
            if (columnas > 3) break;
            
            actual.setLocation(posX, posY);
            actual.setVisible(true);
            actual.addMouseListener(new MouseAdapter() {
                private ImageIcon img = (ImageIcon) actual.getIcon();

                @Override
                public void mouseEntered(MouseEvent e) {
                    actual.setIcon(new ImageIcon(img.getImage().getScaledInstance(img.getIconWidth() - 2, img.getIconHeight() - 2, Image.SCALE_SMOOTH)));
                    actual.setBorder(BorderFactory.createLineBorder(Color.white));
                }
                public void mouseExited(MouseEvent e) {
                    actual.setIcon(img);
                    actual.setBorder(null);
                }
                @Override
                public void mouseClicked(MouseEvent evt) {
                    invBebidas.remove(actual);
                    invBebidas.updateUI();
                    
                    int index = comprasComprador.indexOf(actual);
                    if (index != -1) System.out.println(comp.beberBebida(index)); //TODO: PQ NO FUNCIONA SIN ESTE IF!!!!
                }
            });
            invBebidas.add(actual);
            invBebidas.setComponentZOrder(actual, 0);
        }
        invBebidas.updateUI();
    }

    //* Administracion de eventos */
    private void m1000MouseClicked(MouseEvent evt) { //* ELEGIR MONEDA DE 1000 */
        comp.setMoneda(new Moneda1000(false));    
    }
   
    private void m500MouseClicked(MouseEvent evt) { //* ELEGIR MONEDA DE 500 */
        comp.setMoneda(new Moneda500(false));
    }
    
    private void m100MouseClicked(MouseEvent evt) {  //* ELEGIR MONEDA DE 100 */
        comp.setMoneda(new Moneda100(false));
    }
    
    private void insertarMouseClicked(MouseEvent evt) { //* INSERTAR MONEDA */
        comp.ingresarMoneda(exp);
    }
    
    private void botonCocacolaMouseClicked(MouseEvent evt) { //* APRETAR COCACOLA (COMPRAR COCACOLA) */
        comp.comprarBebida(1, exp);
    }
    private void botonSpriteMouseClicked(MouseEvent evt) { //* APRETAR SPRITE (COMPRAR SPRITE) */
        comp.comprarBebida(2, exp);
    }
    private void botonFantaMouseClicked(MouseEvent evt) { //* APRETAR FANTA (COMPRAR FANTA) */
        comp.comprarBebida(3, exp);
    }

    private void vueltoMouseClicked(MouseEvent evt) { //* RECUPERAR VUELTO */
        if (exp.hayVuelto()) {
            comp.getVuelto(exp);
            actualizarMonedero();
        }
    }
    
    private void depCompraMouseClicked(MouseEvent evt) { //* RECOGER COMPRA */
        if (exp.hayCompra()) {
            comp.getBebida(exp);
            actualizarInventario();
        }
    }

    private void botonMonederoMouseCliked(MouseEvent evt) { //* VACIAR MONEDERO */
        for (Moneda moneda : comp.getMonedero()) {
            invMonedas.remove(moneda);
        }
        comp.vaciarMonedero();

        actualizarMonedero();
        botonMonedero.setEnabled(false);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);

        super.paint(g);
    }
}
