package tarea3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelPrincipal extends JPanel implements ActionListener {
    private Comprador com;
    private Expendedor exp;

    private Image fondo;

    public PanelPrincipal() {
        super(null);

        fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage();

        exp = new Expendedor(6, 1000, 105, 50);
        this.add(exp);
    } 

    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        this.setOpaque(false);
        super.paint(g);

        // exp.paint(g);
        // com.paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }   
}  
//tanto expendedor como comprador deben definir sus propios métodos paint 
//bebidas y monedas tampien deben definir sus métodos paint 
//desde el paint del expendedor se llama a los paint’s de los depositos 
//los paints de los depósitos llaman a los paint’s de bebidas y monedas; 
//(al agregar o remover algo en un Deposito, se llama setXY de todo lo que contiene) 
