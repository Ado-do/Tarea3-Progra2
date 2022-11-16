
package tarea3;

import java.awt.*;
import java.awt.event.ActionListener;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class winAlfa extends JFrame{
    private JLabel comprador = new JLabel();
    private JButton fantacola = new JButton();
    private JButton spritecola = new JButton();
    private JButton colacoca = new JButton();
    private JScrollPane  jScrollPane2 = new JScrollPane();
    private JTextArea chatComprador = new JTextArea();
    private JTextField tecladoComprador = new JTextField();
    private JLabel jLabel4 = new JLabel();
    private JPanel jPanel1 = new JPanel();
    private JLabel Pantalla = new JLabel();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel slot1 = new JLabel();
    private JLabel slot2 = new JLabel();
    private JLabel slot3 = new JLabel();
    private JLabel Parry = new JLabel();
    private String Comprador;
    private int ciclos=0;
    private int xp,yp;
    
        public winAlfa(String title) {
            this.setLocationRelativeTo(null);
            this.setTitle(title);
            this.setPreferredSize(new Dimension(790, 590));
            pack();
            iniciarTodo();
        }
        private void iniciarTodo(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // AGREGANDO IMAGENES Y DISEÑANDO LOS BOTONES
        comprador.setIcon(new ImageIcon("C:\\Users\\crisf\\OneDrive\\Documentos\\GitHub\\Tarea3-Progra2\\imagenes\\poncho.png")); // NOI18N
        getContentPane().add(comprador);
        comprador.setBounds(0, 180, 610, 220);
        
        fantacola.setBackground(new Color(204, 153, 0));
        fantacola.setFont(new Font("Segoe UI", 3, 12)); // NOI18N
        fantacola.setForeground(new Color(255, 255, 255));
        fantacola.setText("Fanta");
        fantacola.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fantacolaActionPerformed(evt);
            }
        });
        getContentPane().add(fantacola);
        fantacola.setBounds(290, 160, 72, 30);
        
        spritecola.setBackground(new Color(51, 204, 255));
        spritecola.setFont(new Font("Segoe UI", 3, 12)); // NOI18N
        spritecola.setForeground(new Color(255, 255, 255));
        spritecola.setText("Sprite");
        getContentPane().add(spritecola);
        spritecola.setBounds(290, 200, 72, 30);

        colacoca.setBackground(new Color(255, 0, 0));
        colacoca.setForeground(new Color(255, 255, 255));
        colacoca.setText("Coca");
        getContentPane().add(colacoca);
        colacoca.setBounds(290, 240, 72, 30);

        chatComprador.setColumns(20);
        chatComprador.setRows(5);
        jScrollPane2.setViewportView(chatComprador);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 420, 330, 100);
        
        getContentPane().add(tecladoComprador);
        tecladoComprador.setBounds(30, 520, 240, 30);
        tecladoComprador.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tecladoCompradorKeyPressed(evt);
            }
        });

        jLabel4.setIcon(new ImageIcon("C:\\Users\\crisf\\OneDrive\\Documentos\\GitHub\\Tarea3-Progra2\\imagenes\\Ahorasi.png"));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 50, 40, 50);

        jPanel1.setLayout(null);

        Pantalla.setText("$500");
        jPanel1.add(Pantalla);
        Pantalla.setBounds(10, 20, 60, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(300, 80, 50, 60);

        jLabel1.setFont(new Font("Segoe UI", 3, 24));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 160, 100, 50);

        jLabel2.setIcon(new ImageIcon("C:\\Users\\crisf\\OneDrive\\Documentos\\GitHub\\Tarea3-Progra2\\imagenes\\MaquinaExpendedora.png"));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-20, -10, 480, 440);

        slot1.setText("slot1");
        getContentPane().add(slot1);
        slot1.setBounds(630, 460, 30, 20);
        
        slot2.setText("slot2");
        getContentPane().add(slot2);
        slot2.setBounds(670, 460, 30, 20);

        slot3.setText("slot3");
        getContentPane().add(slot3);
        slot3.setBounds(590, 460, 30, 20);
        
        getContentPane().add(Parry);
        Parry.setBounds(1,1,30,20);

        pack();
        }
        private void tecladoCompradorKeyPressed(KeyEvent evt) {                                            
           if(evt.getKeyCode() == VK_ENTER){
           int x = slot3.getX();
           int y = slot3.getY();
           Comprador = tecladoComprador.getText();
           chatComprador.append("Hola "+Comprador+"!\n");
           System.out.println(x+" "+y);
           jLabel1.setText(Comprador);
           tecladoComprador.setEnabled(false);
      
          }
           

    } 
        private void fantacolaActionPerformed(ActionEvent evt) {                                          
            Timer timer = new Timer();
            TimerTask tarea = new TimerTask(){
            
                    @Override
            public void run(){
                        jLabel4.setLocation(jLabel4.getX(),jLabel4.getY()+1);
                        ciclos++;
                        if(ciclos==250){

                            ciclos=0;
                            jLabel4.setLocation(slot1.getX(), slot1.getY());
                            timer.cancel();}
  
            }
     
        };
        timer.schedule(tarea, 0,1);
    }                                         
}
