/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author crisf
 */
public class GraficaFinal extends javax.swing.JFrame {

    String Comprador;
    int ciclos=0;
    int xp,yp;
    
    public GraficaFinal() {
        ArrayList<JLabel> faanta = new ArrayList<JLabel>(); 
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comprador = new javax.swing.JLabel();
        fantacola = new javax.swing.JButton();
        spritecola = new javax.swing.JButton();
        colacoca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatComprador = new javax.swing.JTextArea();
        tecladoComprador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Pantalla = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        slot1 = new javax.swing.JLabel();
        slot2 = new javax.swing.JLabel();
        slot3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(790, 590));
        getContentPane().setLayout(null);

        comprador.setIcon(new javax.swing.ImageIcon("C:\\Users\\crisf\\OneDrive\\Documentos\\GitHub\\Tarea3-Progra2\\imagenes\\poncho.png")); // NOI18N
        comprador.setText("jLabel1");
        getContentPane().add(comprador);
        comprador.setBounds(0, 180, 610, 220);

        fantacola.setBackground(new java.awt.Color(204, 153, 0));
        fantacola.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        fantacola.setForeground(new java.awt.Color(255, 255, 255));
        fantacola.setText("Fanta");
        fantacola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fantacolaActionPerformed(evt);
            }
        });
        getContentPane().add(fantacola);
        fantacola.setBounds(290, 160, 72, 30);

        spritecola.setBackground(new java.awt.Color(51, 204, 255));
        spritecola.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        spritecola.setForeground(new java.awt.Color(255, 255, 255));
        spritecola.setText("Sprite");
        getContentPane().add(spritecola);
        spritecola.setBounds(290, 200, 72, 30);

        colacoca.setBackground(new java.awt.Color(255, 0, 0));
        colacoca.setForeground(new java.awt.Color(255, 255, 255));
        colacoca.setText("Coca");
        getContentPane().add(colacoca);
        colacoca.setBounds(290, 240, 72, 30);

        chatComprador.setColumns(20);
        chatComprador.setRows(5);
        jScrollPane2.setViewportView(chatComprador);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 420, 330, 100);

        tecladoComprador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tecladoCompradorKeyPressed(evt);
            }
        });
        getContentPane().add(tecladoComprador);
        tecladoComprador.setBounds(30, 520, 240, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\crisf\\OneDrive\\Documentos\\GitHub\\Tarea3-Progra2\\imagenes\\Ahorasi.png")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 50, 40, 50);

        jPanel1.setLayout(null);

        Pantalla.setText("$500");
        jPanel1.add(Pantalla);
        Pantalla.setBounds(10, 20, 60, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(300, 80, 50, 60);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(470, 160, 100, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\crisf\\OneDrive\\Documentos\\GitHub\\Tarea3-Progra2\\imagenes\\MaquinaExpendedora.png")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-20, -10, 480, 440);

        slot1.setText("slot2");
        getContentPane().add(slot1);
        slot1.setBounds(630, 460, 30, 20);

        slot2.setText("slot3");
        getContentPane().add(slot2);
        slot2.setBounds(670, 460, 30, 20);

        slot3.setText("slot1");
        getContentPane().add(slot3);
        slot3.setBounds(590, 460, 30, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tecladoCompradorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tecladoCompradorKeyPressed
           if(evt.getKeyCode() == evt.VK_ENTER){
           Comprador = tecladoComprador.getText();
           chatComprador.append("Hola "+Comprador+"!\n");
           jLabel1.setText(Comprador);
           tecladoComprador.setEnabled(false);
      
          }

    }//GEN-LAST:event_tecladoCompradorKeyPressed

    private void fantacolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fantacolaActionPerformed
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
    }//GEN-LAST:event_fantacolaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraficaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficaFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pantalla;
    private javax.swing.JTextArea chatComprador;
    private javax.swing.JButton colacoca;
    private javax.swing.JLabel comprador;
    private javax.swing.JButton fantacola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel slot1;
    private javax.swing.JLabel slot2;
    private javax.swing.JLabel slot3;
    private javax.swing.JButton spritecola;
    private javax.swing.JTextField tecladoComprador;
    // End of variables declaration//GEN-END:variables
}