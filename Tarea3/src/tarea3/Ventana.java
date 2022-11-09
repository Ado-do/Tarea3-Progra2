package tarea3;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    public  JPanel panel;
    public Ventana() {
        super();
        this.setTitle("Maquina Expendedora");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout());
        this.setVisible(true);
    }
    private void iniciarTodo() {
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
    }
    private void colocarPaneles() {
        panel = new JPanel();
        panel.setLayout(null); // Diseño del panel desactivado
        this.getContentPane().add(panel); 
    }
    private void colocarBotones() {
        JButton Pagar = new JButton();
        
    }
    private void colocarEtiquetas() {
        
    }
}