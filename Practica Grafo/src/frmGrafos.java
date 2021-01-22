import java.util.Map;
import java.util.PriorityQueue;
import javax.swing.*;
public class frmGrafos extends javax.swing.JFrame {
 Grafo G1;
 Grafo G2;
 Grafo H;
 
    /** Creates new form Formulario */
    public frmGrafos() {
        initComponents();
        G1=new Grafo();
        G2=new Grafo();
        H=new Grafo();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLeerGrafo = new javax.swing.JToggleButton();
        btnImprimirGrafo = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();
        btnExisteCamino = new javax.swing.JButton();
        btnDFS = new javax.swing.JButton();
        btnBFS = new javax.swing.JButton();
        btnSonIguales = new javax.swing.JButton();
        btnExisteCamino1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("GRAFOS DIRIGIDOS");

        btnLeerGrafo.setText("Leer Grafo");
        btnLeerGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerGrafoActionPerformed(evt);
            }
        });

        btnImprimirGrafo.setText("Imprimir Grafo");
        btnImprimirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirGrafoActionPerformed(evt);
            }
        });

        jta.setColumns(20);
        jta.setRows(5);
        jScrollPane1.setViewportView(jta);

        btnExisteCamino.setText("existe Camino");
        btnExisteCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExisteCaminoActionPerformed(evt);
            }
        });

        btnDFS.setText("DFS");
        btnDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDFSActionPerformed(evt);
            }
        });

        btnBFS.setText("BFS");
        btnBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBFSActionPerformed(evt);
            }
        });

        btnSonIguales.setText("Son Iguales?");
        btnSonIguales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonIgualesActionPerformed(evt);
            }
        });

        btnExisteCamino1.setText("Cantidad Caminos");
        btnExisteCamino1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExisteCamino1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDFS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBFS, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnLeerGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnImprimirGrafo))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExisteCamino, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSonIguales, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExisteCamino1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLeerGrafo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimirGrafo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnExisteCamino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExisteCamino1)
                        .addGap(7, 7, 7)
                        .addComponent(btnSonIguales))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDFS)
                    .addComponent(btnBFS))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeerGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerGrafoActionPerformed
        leerGrafos();
    }//GEN-LAST:event_btnLeerGrafoActionPerformed
    
    private void leerGrafos(){
    // TODO add your handling code here:        
        G1.crearVertice("A");             
        G1.crearVertice("B");         
        G1.crearVertice("C");     
        G1.crearVertice("D");
        G1.crearVertice("E");
        G1.crearVertice("F");
        G1.crearVertice("G");
        G1.crearVertice("H");                      
        G1.insertarArco("A", "B", 10);
        G1.insertarArco("A", "C", 8);           
        G1.insertarArco("B", "D", 4);        
        G1.insertarArco("C", "B", 8);
        G1.insertarArco("C", "E", 5);        
        G1.insertarArco("D", "F", 5);
        G1.insertarArco("E", "D", 5);
        G1.insertarArco("E", "F", 7);        
        G1.insertarArco("F", "G", 12);
        G1.insertarArco("F", "H", 4);          
        G1.insertarArco("G", "E", 2);        
        G1.insertarArco("G", "C", 7); 
        G1.insertarArco("G", "H", 5);
        
        /*
        PriorityQueue<Arco> pq = new PriorityQueue<Arco>(new ArcoComparator());
        pq.add(new Arco(null, 15));
        pq.add(new Arco(null, 3));
        pq.add(new Arco(null, 10));
        pq.add(new Arco(null, 12));
        pq.add(new Arco(null, 1));
        while(!pq.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, pq.poll().getCosto());
        }
        */
        
        
        G2.crearVertice("A");             
        G2.crearVertice("B");         
        G2.crearVertice("C");     
        G2.crearVertice("D");
        G2.crearVertice("E");
        G2.crearVertice("F");
        G2.crearVertice("G");
        G2.crearVertice("H");                      
        G2.insertarArco("A", "B", 10);
        G2.insertarArco("A", "C", 8);           
        G2.insertarArco("B", "D", 4);        
        G2.insertarArco("C", "B", 8);
        G2.insertarArco("C", "E", 5);        
        G2.insertarArco("D", "F", 5);
        G2.insertarArco("E", "D", 5);
        G2.insertarArco("E", "F", 7);        
        G2.insertarArco("F", "G", 12);  
        G2.insertarArco("F", "H", 4);          
        G2.insertarArco("G", "E", 2);        
        G2.insertarArco("G", "C", 7); 
        G2.insertarArco("G", "H", 5); 
        
        Map<Vertice, Float> costos = G1.dijkstra(G1.buscarVertice("A"));
        
        for (Map.Entry<Vertice, Float> item : costos.entrySet()) {
            JOptionPane.showMessageDialog(rootPane, item.getKey() + " " + item.getValue());
        }
        
        /*G.crearVertice("A");         
        G.crearVertice("B");         
        G.crearVertice("C");     
        G.crearVertice("D");
        G.crearVertice("E");         
        G.crearVertice("F");         
        G.crearVertice("G");         
        G.crearVertice("H");         
        G.crearVertice("I");         
        G.crearVertice("J");         
        G.insertarArco("A", "B",3);
        G.insertarArco("A", "C", 3);
        G.insertarArco("A", "D", 3);        
        G.insertarArco("B", "E", 3);
        G.insertarArco("B", "F", 3);
        G.insertarArco("C", "G", 3);
        G.insertarArco("C", "H", 3);
        G.insertarArco("G", "I", 3);
        G.insertarArco("G", "J", 3);*/
    }
    
    private void btnImprimirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirGrafoActionPerformed
        // TODO add your handling code here:   
        //G.ordenarVertices();
        G1.imprimir(jta);
    }//GEN-LAST:event_btnImprimirGrafoActionPerformed

    private void btnExisteCaminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExisteCaminoActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice Origen:");
        String B=JOptionPane.showInputDialog("Vertice Destino:"); 
        if(G1.existeCaminoBFS(A, B))
          JOptionPane.showMessageDialog(rootPane, "Existe camino..!!");
        else
          JOptionPane.showMessageDialog(rootPane, "No existe camino..!!");              
    }//GEN-LAST:event_btnExisteCaminoActionPerformed

    private void btnDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDFSActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice inicial (DFS):");        
        G1.ordenarVerticesAlf();                
        G1.DFS(A,jta);
    }//GEN-LAST:event_btnDFSActionPerformed

    private void btnBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBFSActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice inicial (BFS):");        
        G1.ordenarVerticesAlf();        
        G1.BFS(A,jta);
    }//GEN-LAST:event_btnBFSActionPerformed

    private void btnSonIgualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonIgualesActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, G1.sonIguales(G2));
    }//GEN-LAST:event_btnSonIgualesActionPerformed

    private void btnExisteCamino1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExisteCamino1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, G1.cantidadCaminosBFS("A", "C"));
    }//GEN-LAST:event_btnExisteCamino1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGrafos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBFS;
    private javax.swing.JButton btnDFS;
    private javax.swing.JButton btnExisteCamino;
    private javax.swing.JButton btnExisteCamino1;
    private javax.swing.JToggleButton btnImprimirGrafo;
    private javax.swing.JToggleButton btnLeerGrafo;
    private javax.swing.JButton btnSonIguales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jta;
    // End of variables declaration//GEN-END:variables

}
