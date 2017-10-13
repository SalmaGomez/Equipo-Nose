/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import XMLL.archivoXML;
import java.util.Vector;
import javax.swing.JFileChooser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Calculos.*;


/**
 *
 * @author Yosse
 */
public class FrmInterfaz1 extends javax.swing.JFrame {

    /**
     * Creates new form FrmInterfaz1
     */
        private String url;
        String nombree;
        Calculos mCalculos = new Calculos();
        double impuesto;

    public FrmInterfaz1() {
        initComponents();
        url="";
        impuesto = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnSalir = new javax.swing.JButton();
        BtnCargar = new javax.swing.JButton();
        TxtRFC = new javax.swing.JTextField();
        LblImpuestos = new javax.swing.JLabel();
        Lbl2 = new javax.swing.JLabel();
        LblFecha = new javax.swing.JLabel();
        Lbl3 = new javax.swing.JLabel();
        LblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LblTipo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LblRFC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnCargar.setText("Abrir archivo");
        BtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarActionPerformed(evt);
            }
        });

        LblImpuestos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LblImpuestos.setForeground(new java.awt.Color(0, 0, 204));
        LblImpuestos.setText("_______________");

        Lbl2.setText("Fecha:");

        LblFecha.setText("_______________________");

        Lbl3.setText("Nombre:");

        LblNombre.setText("___________________________");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("IMPUESTOS");

        LblTipo.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        LblTipo.setText("___________");

        jLabel2.setText("Introduzca RFC:");

        jLabel3.setText("RFC:");

        LblRFC.setText("___________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lbl3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblNombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Lbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(LblRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(LblImpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BtnCargar)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblTipo)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl2)
                    .addComponent(LblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(LblRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl3)
                    .addComponent(LblNombre))
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblImpuestos)
                    .addComponent(BtnSalir))
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarActionPerformed
        // TODO add your handling code here:

          try{
        JFileChooser dato = new JFileChooser();
        int op = dato.showOpenDialog(this);
        
        if (op == JFileChooser.APPROVE_OPTION) {
            
            url = dato.getSelectedFile().getPath();
            
        }	
      
            archivoXML mi_archivo=new archivoXML(url);
            mi_archivo.open();
            
            Vector vector_resultado=new Vector();
            NodeList root = mi_archivo.getRoot();
           
           //Padre
           Node comprobante=mi_archivo.getNode("cfdi:Comprobante", root);
           String folio = mi_archivo.getNodeAttr("folio", comprobante);
           String importe = mi_archivo.getNodeAttr("subTotal", comprobante);
           String fecha = mi_archivo.getNodeAttr("fecha", comprobante);
              System.out.println(folio);
              System.out.println(importe);
              System.out.println(fecha);
           //Emisor
           Node emisor=mi_archivo.getNode("cfdi:Emisor", comprobante.getChildNodes());
              String rfce = mi_archivo.getNodeAttr("rfc", emisor);
              nombree = mi_archivo.getNodeAttr("nombre", emisor);
             System.out.println(rfce);
             System.out.println(nombree);
           //Receptor
           Node receptor=mi_archivo.getNode("cfdi:Receptor", comprobante.getChildNodes());
              String rfcr = mi_archivo.getNodeAttr("rfc", receptor);
              String nombrer = mi_archivo.getNodeAttr("nombre", receptor);
             System.out.println(rfcr);
             System.out.println(nombrer);
           //Traslados
           Node Traslados =mi_archivo.getNode("cfdi:Impuestos", comprobante.getChildNodes());
            String traslados = mi_archivo.getNodeAttr("totalImpuestosTrasladados", Traslados);
            String retenciones = mi_archivo.getNodeAttr("totalImpuestosRetenidos", Traslados);
            System.out.println(traslados);
            System.out.println(retenciones);
           
             
            if(TxtRFC.getText().equals(rfce.toString())){
                 //Recibo
                 LblNombre.setText(nombree);
                 LblFecha.setText(fecha);
                 LblTipo.setText("Recibo");
                 LblRFC.setText(rfce);
                 impuesto = mCalculos.CalcularImpuestosRecibo(Float.parseFloat(importe));
                 LblImpuestos.setText(String.valueOf(impuesto));
                
                              
             }else
             if(TxtRFC.getText().equals(rfcr.toString())){
                 //Factura
                 LblNombre.setText(nombrer);
                 LblFecha.setText(fecha);
                 LblTipo.setText("Factura");
                 LblRFC.setText(rfcr);                
                 impuesto = mCalculos.CalcularImpuestosFactura(Float.parseFloat(importe));
                 this.LblImpuestos.setText(String.valueOf(impuesto));
                 
                 
                 
             }
             
             
            
//            Node comprobante=root.item(0);
//            Node receptor=comprobante.getChildNodes().item(2);
//           
//          Node m=  mi_archivo.getNode("cfdi:emisor",root);
//            System.out.println("atributos"+m.getAttributes());
//            System.out.println(mi_archivo.getNodeAttr("nombre", receptor));
//            String total=mi_archivo.getNodeAttr("total", comprobante);
//            System.out.println(total);
//            
        }catch(Exception error){
            System.out.println(error.toString());
        }
    }//GEN-LAST:event_BtnCargarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_BtnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInterfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInterfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JLabel Lbl2;
    private javax.swing.JLabel Lbl3;
    private javax.swing.JLabel LblFecha;
    private javax.swing.JLabel LblImpuestos;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JLabel LblRFC;
    private javax.swing.JLabel LblTipo;
    private javax.swing.JTextField TxtRFC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
