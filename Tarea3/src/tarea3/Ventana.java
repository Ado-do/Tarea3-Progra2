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

        // Iniciar componentes
        initPanel();
        
        setVisible(true);
    }

    private void iniciarTodo() {
        colocarEtiquetas();
        colocarBotones();
    }

    private void initPanel() {
        panelPrincipal = new PanelPrincipal();
        // this.getContentPane().add(panelPrincipal);
        this.add(panelPrincipal);
    }

    private void colocarBotones() {
        JButton Pagar = new JButton();
        Pagar.setText("hola");
        Pagar.setBounds(10,80,1000,700);
    }
    
    private void colocarEtiquetas() {
        JLabel Muro = new JLabel(new ImageIcon(""));
        Muro.setBounds(10, 80, 1000, 700);
        panelPrincipal.add(Muro);
    }
}