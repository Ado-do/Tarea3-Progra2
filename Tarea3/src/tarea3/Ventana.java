package tarea3;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private Expendedor exp;
    private Comprador comp;

    private JPanel panel;
    
    public Ventana() {
        super();

        exp = new Expendedor(5, 500);
        comp = new Comprador();

        setTitle("Maquina Expendedora");
        setSize(1100,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        iniciarTodo();
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