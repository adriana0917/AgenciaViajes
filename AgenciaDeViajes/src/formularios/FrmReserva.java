/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import conexion.Conexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Paquete;
import modelo.Reservacion;

/**
 *
 * @author Adriana
 */
public class FrmReserva extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmReserva
     */
    int perSeleccion = 0;
    public FrmReserva() {
        initComponents();
        cargarDatos();
        CargarPaquete();
        CargarCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbPaquete = new javax.swing.JComboBox<>();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReserva = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFechaSalida = new javax.swing.JFormattedTextField();
        txtFechaIngreso = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(0, 51, 51));
        setClosable(true);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Paquete");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cliente");
        jLabel6.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MANTENIMIENTO RESERVACION");

        tablaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Reserva", "Cliente", "Paquete", "Fecha Salida", "Fecha Ingreso"
            }
        ));
        tablaReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReservaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaReserva);

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btninsert.png"))); // NOI18N
        btnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarMouseClicked(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnEdit.png"))); // NOI18N
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnclean.png"))); // NOI18N
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnDelete.png"))); // NOI18N
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Salida");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha Ingreso");
        jLabel8.setToolTipText("");

        try {
            txtFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaSalida.setToolTipText("yyyy-MM-dd");

        try {
            txtFechaIngreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaIngreso.setToolTipText("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFechaSalida, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, 183, Short.MAX_VALUE)))
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnEditar)
                    .addComponent(btnInsertar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservaMouseClicked
        cbPaquete.setSelectedItem(tablaReserva.getValueAt(tablaReserva.getSelectedRow(), 1).toString());
        cbCliente.setSelectedItem(tablaReserva.getValueAt(tablaReserva.getSelectedRow(), 2).toString());
        txtFechaSalida.setText(tablaReserva.getValueAt(tablaReserva.getSelectedRow(), 3).toString());
        txtFechaIngreso.setText(tablaReserva.getValueAt(tablaReserva.getSelectedRow(), 4).toString());
        perSeleccion = Integer.parseInt(tablaReserva.getValueAt(tablaReserva.getSelectedRow(), 0).toString());

    }//GEN-LAST:event_tablaReservaMouseClicked
    private void limpiar() {        
        txtFechaIngreso.setText("");
        txtFechaSalida.setText("");
        cbPaquete.setSelectedItem(0);
        cbCliente.setSelectedItem(0);        
        perSeleccion = 0;
    }
    
    public void cargarDatos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaReserva.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Object Fila[] = new Object[tablaReserva.getColumnCount()];
        Reservacion p = new Reservacion();
        for (Reservacion pqu : p.mostrarReservacion()) {
            Fila[0] = pqu.getCodReserva();
            Fila[1] = pqu.getCodPaquete();
            Fila[2] = pqu.getCodCliente();
            Fila[3] = pqu.getFechaSalida();
            Fila[4] = pqu.getFechaIngreso();                     
            modelo.addRow(Fila);
        }
        tablaReserva.setModel(modelo);        
        
    }
    private void btnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseClicked
        Reservacion p = new Reservacion();
        p.setCodPaquete(Integer.parseInt(cbPaquete.getSelectedItem().toString()));
        p.setCodCliente(Integer.parseInt(cbCliente.getSelectedItem().toString()));
        p.setFechaSalida(txtFechaSalida.getText());
        p.setFechaIngreso(txtFechaIngreso.getText());
        p.insertarReservacion(p);
        limpiar();
        cargarDatos();
        CargarPaquete();
        CargarCliente();        
    }//GEN-LAST:event_btnInsertarMouseClicked
    public void CargarPaquete() {
        try
        {
        Conexion cone = new Conexion();
                String sql = "select * from tb_paquete";
                ResultSet rs = cone.consultar(sql);
            while(rs.next()){                            
                cbPaquete.addItem(rs.getString(1));
            }
            cone.desconectar();
            }
        catch(Exception e)
        {
            System.out.println("Error"+e);
        }    
    }
    
    public void CargarCliente() {
        try
        {
        Conexion cone = new Conexion();
                String sql = "select * from tb_cliente";
                ResultSet rs = cone.consultar(sql);
            while(rs.next()){                            
                cbCliente.addItem(rs.getString(1));
            }
            cone.desconectar();
            }
        catch(Exception e)
        {
            System.out.println("Error"+e);
        }    
    }
    
    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        Reservacion p = new Reservacion();
        p.setCodPaquete(Integer.parseInt(cbPaquete.getSelectedItem().toString()));
        p.setCodCliente(Integer.parseInt(cbCliente.getSelectedItem().toString()));
        p.setFechaSalida(txtFechaSalida.getText());
        p.setFechaIngreso(txtFechaIngreso.getText());
        p.setCodReserva(perSeleccion);
        int dialogResult = JOptionPane.showConfirmDialog(null, "Esta seguro de Editar esta Reserva", "Agencia de Viajes", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            p.editarReservacion(p);
            limpiar();
            cargarDatos();
            CargarPaquete();
            CargarCliente(); 
        } else {
            limpiar();
        }
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        Reservacion p = new Reservacion();
        int dialogResult = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta reserva", "Agencia de Viajes", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            p.eliminarReservacion(perSeleccion);
            limpiar();
            cargarDatos();
            CargarPaquete();
            CargarCliente(); ;
        } else {
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbPaquete;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaReserva;
    private javax.swing.JFormattedTextField txtFechaIngreso;
    private javax.swing.JFormattedTextField txtFechaSalida;
    // End of variables declaration//GEN-END:variables
}
