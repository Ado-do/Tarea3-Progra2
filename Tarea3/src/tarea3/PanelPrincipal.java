package tarea3;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private Comprador com;
    private Expendedor exp;

    public PanelPrincipal () { 
        exp = new Expendedor(69, 69); 
        com = new Comprador(null, 69, null); 
        // this.setBackground(Color.white); // Importar alguna librería de color
    } 
    public void paint (Graphics g) {  // todo se dibuja a partir de este método 
            super.paint(g); //llama al método pint al que hace override en la super clase 
                            //el de la super clase solo pinta el fondo (background)          
            com.paint(g);   //llama al metodo paint definido en el comprador 
            exp.paint(g);   //llama al metodo paint definido en el expendedor 
    }
    // tanto expendedor como comprador deben definir sus propios métodos paint 
    // bebidas y monedas también deben definir sus métodos paint
    // desde el paint del expendedor se llama a los paint’s de los depósitos
    // los paints de los depósitos llaman a los paint’s de bebidas y monedas; 
    // (al agregar o remover algo en un Deposito, se llama setXY de todo lo que contiene) 
}
