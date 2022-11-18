package tarea3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private Comprador comp;
    private Expendedor exp;
    
    private int eleccion;
    
    private Moneda m100, m500, m1000;
    private JLabel insertar, vuelto, depCompra;

    private ImageIcon[][] imagenes;
    private Image fondo;

    public PanelPrincipal() {
        super(null);

        //* Imagen de fondo del panel */
        fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();

        //* Inicializar OBJETOS PRINCIPALES */
        exp = new Expendedor(7, 1000, 80, 50);
        comp = new Comprador(exp.getX() + 460, exp.getY() + 160);
        
        //* Inicializar imagenes a reutilizar
        imagenes = new ImageIcon[][] {
            {new ImageIcon(getClass().getResource("/imagenes/M1000_1.png")), new ImageIcon(getClass().getResource("/imagenes/M1000_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/M500_1.png")), new ImageIcon(getClass().getResource("/imagenes/M500_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/M100_1.png")), new ImageIcon(getClass().getResource("/imagenes/M100_2.png"))}
        };
       
        //* Inicialiar monedas de interfaz
        m1000 = new Moneda1000();
        m1000.setLocation(exp.getX() + 410, exp.getY() + 120);
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

        m500 = new Moneda500();
        m500.setLocation(exp.getX() + 410, exp.getY() + 180);
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

        m100 = new Moneda100();
        m100.setLocation(exp.getX() + 410, exp.getY() + 240);
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
        this.add(comp);
        this.add(exp);
    }

    //* Administracion de eventos */
    private void m1000MouseEntered(MouseEvent evt){
        m1000.setIcon(imagenes[0][1]);
    }
    private void m1000MouseExited(MouseEvent evt){
        m1000.setIcon(imagenes[0][0]);
    } 
    private void m1000MouseClicked(MouseEvent evt){
        eleccion = 1;
        comp.setMoneda(1000);    
    }
    private void m500MouseEntered(MouseEvent evt){
        m500.setIcon(imagenes[1][1]);
    }
    private void m500MouseExited(MouseEvent evt){
        m500.setIcon(imagenes[1][0]);
    }
    private void m500MouseClicked(MouseEvent evt){
        eleccion = 2;
        comp.setMoneda(500);
    }
    private void m100MouseEntered(MouseEvent evt){
        m100.setIcon(imagenes[2][1]);
    }
    private void m100MouseExited(MouseEvent evt){
        m100.setIcon(imagenes[2][0]);
    }
    private void m100MouseClicked(MouseEvent evt){
        eleccion = 3 ;
        comp.setMoneda(100);
    }
    private void insertarMouseEntered(MouseEvent evt) {
        exp.insertarMouseEntered(evt);
    }
    private void insertarMouseExited(MouseEvent evt) {
        exp.insertarMouseExited(evt);
    }
    private void insertarMouseClicked(MouseEvent evt) {
        
        switch(eleccion){
            case 1:
                exp.cambiarInfoPantallaSup("Moneda de $1000 ingresada");
                exp.cambiarContDinero("$1000");
                break;
            case 2:
                exp.cambiarInfoPantallaSup("Moneda de $500 ingresada");
                exp.cambiarContDinero("$ 500");
                break;
            case 3:
                exp.cambiarInfoPantallaSup("Moneda de $100 ingresada");
                exp.cambiarContDinero("$ 100");
                break;
        }
        exp.recibirMoneda(comp.MonedaSeleccionada());
    }
    private void vueltoMouseEntered(MouseEvent evt) {
        exp.vueltoMouseEntered(evt);
    }
    private void vueltoMouseExited(MouseEvent evt) {
        exp.vueltoMouseExited(evt);
    }
    private void vueltoMouseClicked(MouseEvent evt) {
        System.out.println("SEXOOOOOOOOOOOOOOOOOOO"); //! ESTA WEA NO FUNCIONA
    }
    private void depCompraMouseEntered(MouseEvent evt) {
        exp.depCompraMouseEntered(evt);
    }
    private void depCompraMouseExited(MouseEvent evt) {
        exp.depCompraMouseExited(evt);
    }
    private void depCompraMouseClicked(MouseEvent evt) {
        System.out.println("SEXOOOOOOOOOOOOOOOOOOO"); //! ESTA WEA NO FUNCIONA TAMPOCO
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);

        super.paint(g);
    }
}
