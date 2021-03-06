/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

/**
 *
 * @author Adriana
 */
public class LoginParent extends javax.swing.JFrame {

    /**
     * Creates new form LoginParent
     */
    public LoginParent() {
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        MantenimientosMenu = new javax.swing.JMenu();
        MAerolinea = new javax.swing.JMenuItem();
        MClientes = new javax.swing.JMenuItem();
        MHoteles = new javax.swing.JMenuItem();
        MPais = new javax.swing.JMenuItem();
        MPaquetes = new javax.swing.JMenuItem();
        MReserva = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 102));

        desktopPane.setBackground(new java.awt.Color(0, 51, 51));
        desktopPane.setForeground(new java.awt.Color(0, 51, 51));

        MantenimientosMenu.setMnemonic('f');
        MantenimientosMenu.setText("Mantenimientos");

        MAerolinea.setMnemonic('o');
        MAerolinea.setText("Aerolineas");
        MAerolinea.setActionCommand("");
        MAerolinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAerolineaActionPerformed(evt);
            }
        });
        MantenimientosMenu.add(MAerolinea);

        MClientes.setMnemonic('s');
        MClientes.setText("Clientes");
        MClientes.setActionCommand("");
        MClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MClientesActionPerformed(evt);
            }
        });
        MantenimientosMenu.add(MClientes);

        MHoteles.setMnemonic('a');
        MHoteles.setText("Hoteles");
        MHoteles.setActionCommand("");
        MHoteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MHotelesActionPerformed(evt);
            }
        });
        MantenimientosMenu.add(MHoteles);

        MPais.setText("Pais");
        MPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPaisActionPerformed(evt);
            }
        });
        MantenimientosMenu.add(MPais);

        MPaquetes.setText("Paquetes");
        MPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPaquetesActionPerformed(evt);
            }
        });
        MantenimientosMenu.add(MPaquetes);

        MReserva.setText("Reservación");
        MReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MReservaActionPerformed(evt);
            }
        });
        MantenimientosMenu.add(MReserva);

        menuBar.add(MantenimientosMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Salir");
        helpMenu.setActionCommand("");
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MAerolineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAerolineaActionPerformed
        FrmAerolinea h = new FrmAerolinea();
        this.desktopPane.add(h);
        h.show();
    }//GEN-LAST:event_MAerolineaActionPerformed

    private void MPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPaisActionPerformed
        FrmPais h = new FrmPais();
        this.desktopPane.add(h);
        h.show();
    }//GEN-LAST:event_MPaisActionPerformed

    private void MPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPaquetesActionPerformed
        FrmPaquete h = new FrmPaquete();
        this.desktopPane.add(h);
        h.show();
    }//GEN-LAST:event_MPaquetesActionPerformed

    private void MHotelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MHotelesActionPerformed
        FrmHotel h = new FrmHotel();
        this.desktopPane.add(h);
        h.show();
    }//GEN-LAST:event_MHotelesActionPerformed

    private void MClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MClientesActionPerformed
        FrmCliente h = new FrmCliente();
        this.desktopPane.add(h);
        h.show();
    }//GEN-LAST:event_MClientesActionPerformed

    private void MReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MReservaActionPerformed
        FrmReserva h = new FrmReserva();
        this.desktopPane.add(h);
        h.show();
    }//GEN-LAST:event_MReservaActionPerformed

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
            java.util.logging.Logger.getLogger(LoginParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginParent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MAerolinea;
    private javax.swing.JMenuItem MClientes;
    private javax.swing.JMenuItem MHoteles;
    private javax.swing.JMenuItem MPais;
    private javax.swing.JMenuItem MPaquetes;
    private javax.swing.JMenuItem MReserva;
    private javax.swing.JMenu MantenimientosMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
