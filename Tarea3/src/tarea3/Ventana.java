package tarea3;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    private PanelPrincipal panelPrincipal;
    
    public Ventana() {
        super("Tarea3");
        
        //* */ Configurar ventana
        this.setSize(1100 + 15, 700 + 40); //? Lo sumado corresponde al margen superior de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //* Agregar JPanel principal con expendedor y comprador */
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal);
        
        setVisible(true);
    }
}