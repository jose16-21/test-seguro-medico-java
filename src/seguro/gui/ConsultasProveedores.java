/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguro.gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.json.JSONException;
import org.json.JSONObject;
import static seguro.modelos.a.readJsonFromUrl;
/**
 *
 * @author A
 */
public class ConsultasProveedores extends javax.swing.JInternalFrame {
   

    boolean vendido = false;
    int idProduct = 0;
    DefaultTableModel mdlTblProveedores = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    String nit;
    String codigo;
    String respuesta;
    String FechaCobertura;
    String FechaConsulta;
     
    public ConsultasProveedores() {
        initComponents();
        cargarColumnasTabla();
        cargarListenerModeloTabla();
    }
    
    private void configTitleColumn() {
        final TableCellRenderer tcrOs = tblProveedores.getTableHeader().getDefaultRenderer();
        tblProveedores.getTableHeader().setDefaultRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel lbl = (JLabel) tcrOs.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);

                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                lbl.setBackground(Color.black);
                lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
                return lbl;
            }
        });
    }

    
    private void cargarColumnasTabla(){
        mdlTblProveedores.addColumn("");
        mdlTblProveedores.addColumn("Nit Proveedor");
        mdlTblProveedores.addColumn("Código Paciente");
        mdlTblProveedores.addColumn("Fecha Cobertura");
        mdlTblProveedores.addColumn("Respuesta Ser. Web");
        mdlTblProveedores.addColumn("Fecha de consulta");
        
        tblProveedores.getColumnModel().getColumn(0).setMaxWidth(0);
        tblProveedores.getColumnModel().getColumn(0).setMinWidth(0);
        tblProveedores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblProveedores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

       
        
        configTitleColumn();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        lblImagenProducto = new javax.swing.JLabel();
        pnlInfoProducto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtNitProveedor = new javax.swing.JTextField();
        txtCodigoPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtFechaCobertura = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Consultas de proveedores");
        setPreferredSize(new java.awt.Dimension(1020, 539));

        tblProveedores.setModel(mdlTblProveedores);
        /*tblProveedores.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tblProveedores.getSelectedRow()>=0)){
                        int filaSeleccionada = tblProveedores.getSelectedRow();
                        ObjetoProducto producto = (ObjetoProducto)mdlTblProveedores.getValueAt(filaSeleccionada, 0);

                        System.out.print(producto.getNomProd());
                    }
                }
            }

        );*/
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProveedoresMousePressed(evt);
            }
        });
        tblProveedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProveedoresKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        pnlInfoProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nit del proveedor de servicios:");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setText("Buscar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("id");

        txtNitProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNitProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitProveedorActionPerformed(evt);
            }
        });
        txtNitProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNitProveedorKeyReleased(evt);
            }
        });

        txtCodigoPaciente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPacienteActionPerformed(evt);
            }
        });
        txtCodigoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoPacienteKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Código de paciente (Afiliado):");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de nacimiento:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha de cobertura:");

        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtFechaCobertura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlInfoProductoLayout = new javax.swing.GroupLayout(pnlInfoProducto);
        pnlInfoProducto.setLayout(pnlInfoProductoLayout);
        pnlInfoProductoLayout.setHorizontalGroup(
            pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoProductoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(741, 741, 741))
            .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                .addGap(646, 646, 646)
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaCobertura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(359, 359, 359)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );
        pnlInfoProductoLayout.setVerticalGroup(
            pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblId)
                        .addGap(11, 11, 11)
                        .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoProductoLayout.createSequentialGroup()
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoProductoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlInfoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 50, Short.MAX_VALUE)
                        .addComponent(lblImagenProducto)
                        .addGap(710, 710, 710))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblImagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(544, 544, 544))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInfoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void tblProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMousePressed
       
        
    }//GEN-LAST:event_tblProveedoresMousePressed
    
    
        
    private void cargarListenerModeloTabla(){
        mdlTblProveedores.addTableModelListener(new TableModelListener(){
            
            @Override
            public void tableChanged(TableModelEvent e){
                int numFilas = mdlTblProveedores.getRowCount();
                double sumatoria = 0;
                for(int i = 0; i < numFilas; i++){
                    String importe = (String)mdlTblProveedores.getValueAt(i, 5);
                    sumatoria += Double.parseDouble(importe);
                }
               
            }       
        }); 
       
    }
    
    
    private void tblProveedoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProveedoresKeyReleased

    }//GEN-LAST:event_tblProveedoresKeyReleased

    
    public void limpiarTabla(){
        int numFilas = mdlTblProveedores.getRowCount();
        if(numFilas > 0){
            for(int i = (numFilas - 1); i >= 0; i--){
                mdlTblProveedores.removeRow(i);
            }
        }
    }
    
    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProveedoresMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        if(txtNitProveedor.getText().toString().equals("")){
            JOptionPane.showMessageDialog(this, "Ingrese datos no puede ser vacio");
         return ;   
        }else{
            try{
                  SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                String nacimiento = dcn.format(txtFechaNacimiento.getDate() );
                String cobertura = dcn.format(txtFechaCobertura.getDate() );
                                
                 consultarProveedores(txtNitProveedor.getText().toString(), txtCodigoPaciente.getText().toString(),nacimiento,cobertura);
            } catch (IOException ex) {
                Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE, null, ex);
            } catch(JSONException ex){
            Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE,null,ex);
            }            
           // cargaModelTabla();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    void cargaModelTabla(){
    mdlTblProveedores.setNumRows(1);
    mdlTblProveedores.setValueAt(nit, 0, 0);
    mdlTblProveedores.setValueAt(codigo, 0, 1);
    mdlTblProveedores.setValueAt(FechaCobertura, 0, 2);
    mdlTblProveedores.setValueAt(respuesta, 0, 3);
    mdlTblProveedores.setValueAt(FechaConsulta, 0, 4);
                    
    }
    private void consultarProveedores(String Nit, String Codigo, String Nacimiento, String Cobertura )throws IOException, JSONException {
        try {
             JSONObject json = readJsonFromUrl("http://localhost:54335/api/Java/"+ Nit+"/"+Codigo+"/"+Nacimiento +"/"+Cobertura);
 JOptionPane.showMessageDialog(this,json.toString());
             System.out.println(json);
    } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ocurrió un eror: " + ex.getMessage());

        } catch (JSONException ex) {
            Logger.getLogger(ConsultasProveedores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ocurrió un eror: " + ex.getMessage());

        }
    }
    private void txtNitProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitProveedorActionPerformed

    private void txtNitProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitProveedorKeyReleased

    }//GEN-LAST:event_txtNitProveedorKeyReleased

    private void txtCodigoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPacienteActionPerformed

    private void txtCodigoPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPacienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPacienteKeyReleased

  
    
  
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImagenProducto;
    private javax.swing.JPanel pnlInfoProducto;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtCodigoPaciente;
    private com.toedter.calendar.JDateChooser txtFechaCobertura;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNitProveedor;
    // End of variables declaration//GEN-END:variables
}
