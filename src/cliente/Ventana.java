/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataOutputStream;
import java.net.*;

public class Ventana extends javax.swing.JFrame {

    DataOutputStream salida; 
    
    public Ventana(Socket socket) {
        initComponents();
        try{
        salida = new DataOutputStream
        (socket.getOutputStream());
        }catch(Exception e) {
            System.out.println("No pudo enviar");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        mensaje = new javax.swing.JTextField();
        enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mensaje.setColumns(23);
        jPanel1.add(mensaje);

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel1.add(enviar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
        try {
            String cadena = mensaje.getText(); 
            salida.writeUTF(cadena);
            mensaje.setText("");
        } catch (Exception e) {
            System.out.println("Error al enviar");
        }
    }//GEN-LAST:event_enviarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mensaje;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
