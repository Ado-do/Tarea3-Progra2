package tarea3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * //TODO: Quitar JLabels que no hacen falta ser declaradas en las propiedades de todas las clases
 * //TODO: Hacer que el expendedor avise de alguna forma que hay vuelto (resaltar boton de vuelto cuando haya)
 */

public class PanelPrincipal extends JPanel {
    private Comprador comp;
    private Expendedor exp;

    private JLabel m100, m500, m1000;
    private JLabel insertar, botonCocacola, botonSprite, botonFanta, vuelto, depCompra;

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
            {new ImageIcon(getClass().getResource("/imagenes/M100_1.png")), new ImageIcon(getClass().getResource("/imagenes/M100_2.png"))}
        };
       
        //* Inicialiar monedas de interfaz
        m1000 = new JLabel(imagenes[0][0]);
        m1000.setBounds(exp.getX() + 410, exp.getY() + 120, 54, 54);
        m1000.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                m1000MouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                m1000MouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                m1000MouseClicked(evt);
            }
        });

        m500 = new JLabel(imagenes[1][0]);
        m500.setBounds(exp.getX() + 410, exp.getY() + 180, 54, 54);
        m500.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                m500MouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                m500MouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                m500MouseClicked(evt);
            }
        });

        m100 = new JLabel(imagenes[2][0]);
        m100.setBounds(exp.getX() + 410, exp.getY() + 240, 54, 54);
        m100.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
               m100MouseEntered(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                m100MouseClicked(evt);    
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                m100MouseExited(evt);
            }
        });

        //* Inicializar interfaz de botones de interaccion Comprador-Expendedor */
        insertar = new JLabel();
        Rectangle insertarBounds = exp.getInsertarBounds();
        insertarBounds.setLocation((int)insertarBounds.getX() + exp.getX(), (int)insertarBounds.getY() + exp.getY());
        insertar.setBounds(insertarBounds);
        insertar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                insertarMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                insertarMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                insertarMouseClicked(evt);
            }
        });

        botonCocacola = new JLabel();
        Rectangle cocacolaBounds = exp.getCocacolaBounds();
        cocacolaBounds.setLocation((int)cocacolaBounds.getX() + exp.getX(), (int)cocacolaBounds.getY() + exp.getY());
        botonCocacola.setBounds(cocacolaBounds);
        botonCocacola.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                botonCocacolaMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                botonCocacolaMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonCocacolaMouseClicked(evt);
            }
        });

        botonSprite = new JLabel();
        Rectangle spriteBounds = exp.getSpriteBounds();
        spriteBounds.setLocation((int)spriteBounds.getX() + exp.getX(), (int)spriteBounds.getY() + exp.getY());
        botonSprite.setBounds(spriteBounds);
        botonSprite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                botonSpriteMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                botonSpriteMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonSpriteMouseClicked(evt);
            }
        });

        botonFanta = new JLabel();
        Rectangle fantaBounds = exp.getFantaBounds();
        fantaBounds.setLocation((int)fantaBounds.getX() + exp.getX(), (int)fantaBounds.getY() + exp.getY());
        botonFanta.setBounds(fantaBounds);
        botonFanta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                botonFantaMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                botonFantaMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                botonFantaMouseClicked(evt);
            }
        });

        vuelto = new JLabel();
        Rectangle vueltoBounds = exp.getVueltoBounds();
        vueltoBounds.setLocation((int)vueltoBounds.getX() + exp.getX(), (int)vueltoBounds.getY() + exp.getY());
        vuelto.setBounds(vueltoBounds);
        vuelto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                vueltoMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                vueltoMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                vueltoMouseClicked(evt);
            }
        });

        depCompra = new JLabel();
        Rectangle depCompraBounds = exp.getDepCompraBounds();
        depCompraBounds.setLocation((int)depCompraBounds.getX() + exp.getX(), (int)depCompraBounds.getY() + exp.getY());
        depCompra.setBounds(depCompraBounds);
        depCompra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                depCompraMouseEntered(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                depCompraMouseExited(evt);
            }
            @Override
            public void mouseClicked(MouseEvent evt) {
                depCompraMouseClicked(evt);
            }
        });

        // Agregar todo a JPanel principal
        this.add(m1000);
        this.add(m500);        
        this.add(m100);
        this.add(insertar);
        this.add(botonCocacola);
        this.add(botonSprite);
        this.add(botonFanta);
        this.add(vuelto);
        this.add(depCompra);
        this.add(comp);
        this.add(exp);
    }

    //* Administracion de eventos */
    //TODO: CUANDO NO SE PUEDA PRESIONAR UN BOTON, SEGUN PROCESO DE COMPRA, QUE NO RESALTE AL PASAR EL MOUSE ENCIMA
    private void m1000MouseEntered(MouseEvent evt) {
        m1000.setIcon(imagenes[0][1]);
    }
    private void m1000MouseExited(MouseEvent evt) {
        m1000.setIcon(imagenes[0][0]);
    } 
    private void m1000MouseClicked(MouseEvent evt) { //* ELEGIR MONEDA DE 1000 */
        comp.setMoneda(new Moneda1000(false));    
    }
   
    private void m500MouseEntered(MouseEvent evt) {
        m500.setIcon(imagenes[1][1]);
    }
    private void m500MouseExited(MouseEvent evt) {
        m500.setIcon(imagenes[1][0]);
    }
    private void m500MouseClicked(MouseEvent evt) { //* ELEGIR MONEDA DE 500 */
        comp.setMoneda(new Moneda500(false));
    }
    
    private void m100MouseEntered(MouseEvent evt) {
        m100.setIcon(imagenes[2][1]);
    }
    private void m100MouseExited(MouseEvent evt) {
        m100.setIcon(imagenes[2][0]);
    }
    private void m100MouseClicked(MouseEvent evt) {  //* ELEGIR MONEDA DE 100 */
        comp.setMoneda(new Moneda100(false));
    }
    
    private void insertarMouseEntered(MouseEvent evt) {
        exp.insertarMouseEntered(evt);
    }
    private void insertarMouseExited(MouseEvent evt) {
        exp.insertarMouseExited(evt);
    }
    private void insertarMouseClicked(MouseEvent evt) { //* INSERTAR MONEDA */
        // if (comp.tieneMonedaElegida()) exp.insertarMouseClicked(evt, eleccionBebida, comp.getMonedaElegida());
        comp.ingresarMoneda(exp);
    }
    
    private void botonCocacolaMouseEntered(MouseEvent evt) {
        exp.logoCocacolaMouseEntered(evt);
    }
    private void botonCocacolaMouseExited(MouseEvent evt) {
        exp.logoCocacolaMouseExited(evt);
    }
    private void botonCocacolaMouseClicked(MouseEvent evt) { //* APRETAR COCACOLA (COMPRAR COCACOLA) */
        comp.comprarBebida(1, exp);
    }

    private void botonSpriteMouseEntered(MouseEvent evt) {
        exp.logoSpriteMouseEntered(evt);
    }
    private void botonSpriteMouseExited(MouseEvent evt) {
        exp.logoSpriteMouseExited(evt);
    }
    private void botonSpriteMouseClicked(MouseEvent evt) { //* APRETAR SPRITE (COMPRAR SPRITE) */
        comp.comprarBebida(2, exp);
    }

    private void botonFantaMouseEntered(MouseEvent evt) {
        exp.logoFantaMouseEntered(evt);
    }
    private void botonFantaMouseExited(MouseEvent evt) {
        exp.logoFantaMouseExited(evt);
    }
    private void botonFantaMouseClicked(MouseEvent evt) { //* APRETAR FANTA (COMPRAR FANTA) */
        comp.comprarBebida(3, exp);
    }

    private void vueltoMouseEntered(MouseEvent evt) {
        exp.vueltoMouseEntered(evt);
    }
    private void vueltoMouseExited(MouseEvent evt) {
        exp.vueltoMouseExited(evt);
    }
    private void vueltoMouseClicked(MouseEvent evt) { //* RECUPERAR VUELTO */
        comp.getVuelto(exp);
    }
    
    private void depCompraMouseEntered(MouseEvent evt) {
        exp.depCompraMouseEntered(evt);
    }
    private void depCompraMouseExited(MouseEvent evt) {
        exp.depCompraMouseExited(evt);
    }
    private void depCompraMouseClicked(MouseEvent evt) { //* RECOGER COMPRA */
        comp.getBebida(exp);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);

        super.paint(g);
    }
}
