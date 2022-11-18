package tarea3;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;
    
    public Ventana() {
        super("Tarea3");
        
        // Configurar ventana
        setSize(1100 + 15, 700 + 40); //? Lo sumado corresponde al margen superior de la ventana
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //* Agregar JPanel principal con expendedor y comprador */
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);
        
        setVisible(true);
    }
}