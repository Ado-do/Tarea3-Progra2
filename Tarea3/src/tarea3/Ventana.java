package tarea3;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private JPanel panelPrincipal;
    
    public Ventana() {
        super("Tarea3");

        panelPrincipal = new PanelPrincipal();
        this.getContentPane().add(panelPrincipal);
        // this.add(principal);

        setSize(1100,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setVisible(true);
    }

    private void iniciarTodo() {
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
    }
    private void colocarPaneles() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Diseño del panel desactivado
        this.getContentPane().add(panelPrincipal);
        
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