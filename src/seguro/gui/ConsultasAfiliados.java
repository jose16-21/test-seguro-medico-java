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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.json.JSONException;
import org.json.JSONObject;
import static seguro.modelos.a.readJsonFromUrl;
      import java.text.SimpleDateFormat;

/**
 *
 * @author A
 */
public class ConsultasAfiliados extends javax.swing.JInternalFrame {

    DefaultTableModel mdlTblAfiliados = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    TableCellRenderer rendererFromHeader;
    String estado;
    String monto;
    String acumulado;
    String pendiente;

    public ConsultasAfiliados() {
        initComponents();
        cargarColumnasTabla();
        jProgressBarPersonas.setVisible(false);

        txtCodigoPaciente.setText("");
        //cargarModeloTabla();
    }

    private void configTitleColumn() {
        final TableCellRenderer tcrOs = tblAfiliados.getTableHeader().getDefaultRenderer();
        tblAfiliados.getTableHeader().setDefaultRenderer(new TableCellRenderer() {

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

    private void consultarAfiliados(String codigo, String fecha) throws IOException, JSONException {

        try {
            
            JSONObject json = readJsonFromUrl("http://localhost:54335/api/Java/"+ codigo+"/"+fecha);


            //nombres = json.get("nombres").toString();
           // apellidos = json.get("apellidos").toString();
           // direccion = json.get("direccion").toString();
          //  telefono = json.get("telefono").toString();
         // JOptionPane.showMessageDialog(this,json.toString());

            estado = json.get("estado").toString();
            monto = json.get("deducible").toString();
            acumulado = json.get("totalAcumulado").toString();
            pendiente = json.get("pendiente").toString();
            
             // JOptionPane.showMessageDialog(this,estado+','+ monto+','+acumulado+','+pendiente);

            System.out.println(json);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ConsultasAfiliados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ocurrió un eror: " + ex.getMessage());

        } catch (JSONException ex) {
            Logger.getLogger(ConsultasAfiliados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ocurrió un eror: " + ex.getMessage());

        }

    }

    private void cargarColumnasTabla() {
        mdlTblAfiliados.addColumn("");
        mdlTblAfiliados.addColumn("Estado Afiliado");
        mdlTblAfiliados.addColumn("Monto a cumplir");
        mdlTblAfiliados.addColumn("Monto acumulado");
        mdlTblAfiliados.addColumn("Monto pendiente");

        tblAfiliados.getColumnModel().getColumn(0).setMaxWidth(0);
        tblAfiliados.getColumnModel().getColumn(0).setMinWidth(0);

        tblAfiliados.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tblAfiliados.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        configTitleColumn();

        //OCULTAR COLUMNAS PRECIOS PORQUE LAS MUESTRA EN CERO
        /* tblAfiliados.getColumnModel().getColumn(7).setMaxWidth(0);
        tblAfiliados.getColumnModel().getColumn(7).setMinWidth(0);
        
        tblAfiliados.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        tblAfiliados.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);*/
    }

    void cargarModeloTabla() {
        limpiarTabla();

        mdlTblAfiliados.setNumRows(1);
        mdlTblAfiliados.setValueAt("1", 0, 0);
        mdlTblAfiliados.setValueAt(estado, 0, 1);
        mdlTblAfiliados.setValueAt(monto, 0, 2);
        mdlTblAfiliados.setValueAt(acumulado, 0, 3);
        mdlTblAfiliados.setValueAt(pendiente, 0, 4);

    }

    private void limpiarTabla() {
        int numFilas = mdlTblAfiliados.getRowCount();
        if (numFilas > 0) {
            for (int i = (numFilas - 1); i >= 0; i--) {
                mdlTblAfiliados.removeRow(i);
            }
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

        mnClicDerecho = new javax.swing.JPopupMenu();
        mnModificar = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAfiliados = new javax.swing.JTable();
        /*tblAfiliados.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tblAfiliados.getSelectedRow()>=0)){
                        int filaSeleccionada = tblAfiliados.getSelectedRow();
                        com.soluciones.ferreteria.objetos.ObjetoProducto producto = (com.soluciones.ferreteria.objetos.ObjetoProducto)mdlTblAfiliados.getValueAt(filaSeleccionada, 1);

                        txtClave.setText(producto.getIdProducto());
                        txtClave.setEnabled(false);
                        txtNombre.setText(producto.getNombreProducto());
                        txtNombre.setEnabled(false);
                        String existencia = String.valueOf(producto.getExistencia());
                        txtExistencia.setText(existencia);
                        txtExistencia.setEnabled(false);
                        productoSeleccionado = producto;
                        desplegarFoto(producto);

                    }
                }
            }

        );*/
        lblDisponibles = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoPaciente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnGetService = new javax.swing.JButton();
        jProgressBarPersonas = new javax.swing.JProgressBar();

        mnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mnModificar.setForeground(new java.awt.Color(0, 102, 0));
        mnModificar.setText("Modificar");
        mnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnModificarActionPerformed(evt);
            }
        });
        mnClicDerecho.add(mnModificar);

        setTitle("Consulta de afiliados");
        setToolTipText("");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        tblAfiliados.setAutoCreateRowSorter(true);
        tblAfiliados.setModel(mdlTblAfiliados);
        tblAfiliados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAfiliadosMousePressed(evt);
            }
        });
        tblAfiliados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAfiliadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAfiliados);

        lblDisponibles.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblDisponibles.setForeground(new java.awt.Color(51, 0, 153));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 102, 0))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1034, 211));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Código del paciente:");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de nacimiento:");

        txtFechaNacimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnGetService.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGetService.setText("Buscar");
        btnGetService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(txtCodigoPaciente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jProgressBarPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGetService, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnGetService, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBarPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtCodigoPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPacienteKeyReleased


    }//GEN-LAST:event_txtCodigoPacienteKeyReleased

    private void txtCodigoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPacienteActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //txtAgregar.setText("");
        //txtClave.setText("");
        //txtExistencia.setText("");
        //txtNombre.setText("");
    }//GEN-LAST:event_formMouseClicked

    private void btnGetServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetServiceActionPerformed

        if (txtCodigoPaciente.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "El código no puede ser vacío");
            return;
        } else {
            try {
                 SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                String date = dcn.format(txtFechaNacimiento.getDate() );
    
                consultarAfiliados(txtCodigoPaciente.getText().toString(), date);

            } catch (IOException ex) {
                Logger.getLogger(ConsultasAfiliados.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(ConsultasAfiliados.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarModeloTabla();
        }


    }//GEN-LAST:event_btnGetServiceActionPerformed

    private void mnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnModificarActionPerformed

    }//GEN-LAST:event_mnModificarActionPerformed

    private void tblAfiliadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAfiliadosKeyReleased

    }//GEN-LAST:event_tblAfiliadosKeyReleased

    private void tblAfiliadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAfiliadosMousePressed
        infoDisponibles();
    }//GEN-LAST:event_tblAfiliadosMousePressed

    private void infoDisponibles() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetService;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBarPersonas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDisponibles;
    private javax.swing.JPopupMenu mnClicDerecho;
    private javax.swing.JMenuItem mnModificar;
    private javax.swing.JTable tblAfiliados;
    private javax.swing.JTextField txtCodigoPaciente;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    // End of variables declaration//GEN-END:variables

}
