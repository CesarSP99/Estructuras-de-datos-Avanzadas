/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.de.matrices;

import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {
    Lista lista;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        lista = new Lista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBotonLeer = new javax.swing.JButton();
        jTFTamano = new javax.swing.JTextField();
        jBotonMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA = new javax.swing.JTextArea();
        jBotonMostrarMayores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBotonLeer.setText("Leer");
        jBotonLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonLeerActionPerformed(evt);
            }
        });

        jBotonMostrar.setText("Mostrar Lista");
        jBotonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonMostrarActionPerformed(evt);
            }
        });

        jTA.setColumns(20);
        jTA.setRows(5);
        jScrollPane1.setViewportView(jTA);

        jBotonMostrarMayores.setText("Mostrar Mayores de cada lista");
        jBotonMostrarMayores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonMostrarMayoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTFTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jBotonLeer)
                                .addGap(49, 49, 49)
                                .addComponent(jBotonMostrarMayores))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jBotonMostrar)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jBotonLeer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBotonMostrarMayores))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotonMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarMatriz(Matriz mat){
        int y = Integer.parseInt(JOptionPane.showInputDialog("Tamanho en y:"));
        int x = Integer.parseInt(JOptionPane.showInputDialog("Tamanho en x"));
        mat.setN(y);
        mat.setM(x);
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                mat.setYX(i, j, Integer.parseInt(JOptionPane.showInputDialog(
                        "Valor para pos " + i + " " + j)));
            }
        }
    }
    
    private void jBotonLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonLeerActionPerformed
        int n=Integer.parseInt(jTFTamano.getText());
        for(int i=0;i<n;i++)
        {
            Matriz matriz = new Matriz();
            cargarMatriz(matriz);
            lista.insertarUltimo(matriz);
        }
    }//GEN-LAST:event_jBotonLeerActionPerformed

    private void jBotonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonMostrarActionPerformed
        Nodo nodo = lista.Primero();
        jTA.setText("");
        while(nodo != null){
            MostrarMatriz(nodo.getElem());
            nodo = nodo.getProx();
        }
    }//GEN-LAST:event_jBotonMostrarActionPerformed

    private void jBotonMostrarMayoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonMostrarMayoresActionPerformed
        Nodo nodo = lista.Primero();
        int posNodo = 1;
        while(nodo != null){
            jTA.append(posNodo + " -> " + MayorEnMatriz(nodo.getElem()) + "\n");
            posNodo++;
            nodo = nodo.getProx();
        }
    }//GEN-LAST:event_jBotonMostrarMayoresActionPerformed
    
    private int MayorEnMatriz(Matriz elem){
        int mayor = -9999;
        for(int i = 0; i < elem.getN(); i++){
            for(int j = 0; j < elem.getM(); j++){
                if(elem.getYX(i,j) > mayor)
                    mayor = elem.getYX(i,j);
            }
        }
        return mayor;
    }
    
    private void MostrarMatriz(Matriz elem) {
        for(int i = 0; i < elem.getN(); i++){
            for(int j = 0; j < elem.getM(); j++){
                jTA.append(elem.getYX(i,j) + " ");
            }
            jTA.append("\n");
        }
        jTA.append("\n");
    }
    
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotonLeer;
    private javax.swing.JButton jBotonMostrar;
    private javax.swing.JButton jBotonMostrarMayores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTA;
    private javax.swing.JTextField jTFTamano;
    // End of variables declaration//GEN-END:variables

}
