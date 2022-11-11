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
    }
    public void iniciarTodo() {
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
        Pagar.setText("hola");
        Pagar.setBounds(10,80,1000,700);
        
    }
    private void colocarEtiquetas() {
        JLabel Muro = new JLabel(new ImageIcon(""));
        Muro.setBounds(10, 80, 1000, 700);
        panel.add(Muro);
        


    }
}