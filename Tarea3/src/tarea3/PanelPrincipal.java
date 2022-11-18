package tarea3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel {
    private Comprador comp;
    private Expendedor exp;

    private Moneda m100, m500, m1000;
    private ImageIcon[][] imagenes;
    private Image fondo;

    public PanelPrincipal() {
        super(null);

        fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();

        exp = new Expendedor(7, 1000, 80, 50);
        // comp = new Comprador(580, 200);
        comp = new Comprador(exp.getX() + 460, exp.getY() + 160);
        
        imagenes = new ImageIcon[][] {
            {new ImageIcon(getClass().getResource("/imagenes/M1000_1.png")), new ImageIcon(getClass().getResource("/imagenes/M1000_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/M500_1.png")), new ImageIcon(getClass().getResource("/imagenes/M500_2.png"))},
            {new ImageIcon(getClass().getResource("/imagenes/M100_1.png")), new ImageIcon(getClass().getResource("/imagenes/M100_2.png"))}
        };        
       
        //* Inicialiar monedas de interfaz
        m1000 = new Moneda1000();     
        m500 = new Moneda500();
        m100 = new Moneda100();
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

        this.add(m1000);
        this.add(m500);        
        this.add(m100);
        this.add(comp);
        this.add(exp);
    }
    // Acciones de la moneda 1000
    private void m1000MouseEntered(MouseEvent evt){
        m1000.setIcon(imagenes[0][1]);
    }
    private void m1000MouseExited(MouseEvent evt){
        m1000.setIcon(imagenes[0][0]);
    } 
    private void m1000MouseClicked(MouseEvent evt){
        comp.setMoneda(1000);
        exp.CambiarInfoPantallita("$1000");
    }
    // Acciones de la moneda 500
    private void m500MouseEntered(MouseEvent evt){
        m500.setIcon(imagenes[1][1]);
    }
    private void m500MouseExited(MouseEvent evt){
        m500.setIcon(imagenes[1][0]);
    }
    public void m500MouseClicked(MouseEvent evt){
        comp.setMoneda(500);
        exp.CambiarInfoPantallita("$ 500");
    }
    // Acciones de la moneda 100
    private void m100MouseEntered(MouseEvent evt){
        m100.setIcon(imagenes[2][1]);
    }
    private void m100MouseExited(MouseEvent evt){
        m100.setIcon(imagenes[2][0]);
    }
    private void m100MouseClicked(MouseEvent evt){
        comp.setMoneda(100);
        exp.CambiarInfoPantallita("$ 100");
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);

        super.paint(g);
    }
}
