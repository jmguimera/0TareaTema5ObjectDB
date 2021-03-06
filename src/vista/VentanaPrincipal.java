package vista;

/* modificado por josem */
import entity.Clientes; // añadida clase creada por hibernate entidad cliente 
import DAO.ClientesDAO; // clase que contiene operacion admin base de datos (CRUD)

import javax.swing.table.DefaultTableModel;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 * @author Fermin Velez Bello modificado por jose miguel guimera padron (josem)
 * para las partes de persistencia hibernate
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    String nifPinchado;

    private DefaultTableModel modelo;  // DECIRLE QUE LA REJILLA USE ESTE MODLO : BOTON DERECHO EN REJILLA-->TABLE CONTENT->CUSTOM ->PONER EL NOMBRE Del atributo , en este caso modelo

    /* añadido por josem */
    // objeto que da acceso a las operaciones de insertar, editar, eliminar y otras con hibernate
    private ClientesDAO cdao = new ClientesDAO();
    /* fin josem*/

    private VentanaDetalle wDetalle;

    public VentanaPrincipal() {

        this.creaModeloRejilla();
        this.cargaDatos();
        this.wDetalle = new VentanaDetalle();

        initComponents();

    }

    public void creaModeloRejilla() {
        this.modelo = new DefaultTableModel() // Esto define el contenido de la rejilla.
        // DESCOMENTAR PARA HACER QUE EL CONTENIDO DE LA REJILLA NO SE PUEDA MODIFICAR POR EL OPERADOR
        {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false; //Con esto conseguimos que la tabla no se pueda editar
            }
        };

        // a?adirmos las columnas al modelo.
        this.modelo.addColumn("NIF");
        this.modelo.addColumn("Nombre");
    }

    private void cargaDatos() {

        this.modelo.getDataVector().removeAllElements(); // borramos todos los elementos anteriores..

        /* modificado por josem */
        // aqui el llenado del modelo se obtiene del llamado a la rutina
        // llenaRejilla que la pesa el modelo que la misma debe llenar
        this.modelo = cdao.llenaRejilla(this.modelo);
        /*fin modificaicon josem */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

   //     entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(null).createEntityManager();
        jScrollPane1 = new javax.swing.JScrollPane();
        rejillaDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnIrAlPrincipio = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnIrAlFinal = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        btnBorrar = new javax.swing.JToggleButton();
        btnNuevaFila = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rejilla /Detalle");

        rejillaDatos.setModel(modelo);
        rejillaDatos.setToolTipText("");
        rejillaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rejillaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rejillaDatos);

        btnIrAlPrincipio.setText("<<");
        btnIrAlPrincipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAlPrincipioActionPerformed(evt);
            }
        });

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnIrAlFinal.setText(">>");
        btnIrAlFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAlFinalActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.setToolTipText("Termina la aplicación y cierra la ventana");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrAlPrincipio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSiguiente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIrAlFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnIrAlFinal)
                    .addComponent(btnAnterior)
                    .addComponent(btnIrAlPrincipio)
                    .addComponent(jButtonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBorrar.setText("Eliminar");
        btnBorrar.setToolTipText("Borrar fila actual");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnNuevaFila.setText("Agregar");
        btnNuevaFila.setToolTipText("Añadir nueva fila");
        btnNuevaFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaFilaActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar la fila actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnNuevaFila)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addGap(57, 57, 57)
                        .addComponent(btnBorrar)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaFila)
                    .addComponent(btnModificar)
                    .addComponent(btnBorrar))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String dameElNifPinchado(int fila) {
        return (String) this.rejillaDatos.getModel().getValueAt(fila, 0);

    }

    private String dameElNifPinchado(java.awt.event.MouseEvent evt) {
        Point p = evt.getPoint();   // da la posici\F3n del click 
        int row = this.rejillaDatos.rowAtPoint(p); // dada la posici\F3n del click en la rejilla nos da la fila.
        return dameElNifPinchado(row);
    }

    private void recargaDatos(java.awt.event.MouseEvent evt) //sobrecarga
    {
        this.wDetalle.recargaDatos(this.dameElNifPinchado(evt));
    }

    private void recargaDatos(int fila) {
        this.wDetalle.recargaDatos(this.dameElNifPinchado(fila));

    }
    private void rejillaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejillaDatosMouseClicked

        if (evt.getClickCount() == 2) {

            this.recargaDatos(evt);
            this.wDetalle.modoConsulta(); // solo boton cerrar
            this.wDetalle.setVisible(true);
            return;
        }

        if (this.wDetalle.isVisible()) // si esta visible
        {
            this.recargaDatos(evt);
        }

    }//GEN-LAST:event_rejillaDatosMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int n = this.rejillaDatos.getSelectedRow();

        if (this.rejillaDatos.getRowCount() - 1 == n) {
            return;
        }
        n++;
        this.rejillaDatos.changeSelection(n, 1, false, false);
        if (this.wDetalle.isVisible()) {
            this.recargaDatos(n);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnIrAlFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlFinalActionPerformed

        int n = this.rejillaDatos.getSelectedRow();

        if (this.rejillaDatos.getRowCount() - 1 == n) {
            return;
        }

        n = this.rejillaDatos.getRowCount() - 1;
        this.rejillaDatos.changeSelection(n, 1, false, false);
        if (this.wDetalle.isVisible()) {
            this.recargaDatos(n);
        }
    }//GEN-LAST:event_btnIrAlFinalActionPerformed

    private void btnIrAlPrincipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAlPrincipioActionPerformed
        int n = this.rejillaDatos.getSelectedRow();

        if (0 == n) {
            return;
        }
        n = 0;
        this.rejillaDatos.changeSelection(n, 1, false, false);
        if (this.wDetalle.isVisible()) {
            this.recargaDatos(n);
        }
    }//GEN-LAST:event_btnIrAlPrincipioActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        int n = this.rejillaDatos.getSelectedRow();

        if (0 == n) {
            return;
        }
        n--;
        this.rejillaDatos.changeSelection(n, 1, false, false);
        if (this.wDetalle.isVisible()) {
            this.recargaDatos(n);
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    /*
      BOTON DE BORRADO
     */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int n = this.rejillaDatos.getSelectedRow();

        if (n < 0) {
            return;       // si no estamos sobre ninguna fila nos vamos.
        }
        String nif = this.dameElNifPinchado(n);

        if (JOptionPane.showConfirmDialog(null, "?Borramos el registro fila con el NIF ='" + nif.trim() + "'?") != JOptionPane.YES_OPTION) {
            return;
        }

        /*modificado por josem */
        // creamos la instruccion de borrado que maneja las rutinas creadas para hibernate
        try {
            cdao.eliminaCliente(cdao.getCliente(nif));
        } catch (Exception ex) {
            System.out.println("Error eliminando cliente: " + nif);
            System.out.println("mensaje que se lanza desde la linea 332 VentanaPrincipal");
        }

        this.cargaDatos();
        this.modelo.fireTableDataChanged();

    }//GEN-LAST:event_btnBorrarActionPerformed

    /*
    INSERTAR NUEVA FILA 
     */

    private void btnNuevaFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaFilaActionPerformed

        this.wDetalle.modoEditar(); // ahora aparecen los botones de grabar y cancelar y se nos pone en modal
        this.wDetalle.limpiaCampos();// todos los datos en blanco para empezar a editar

        boolean ok; // para hace run bucle si da error al grabar el INSERT INTO ...

        do {
            this.wDetalle.setVisible(true); // aparece la ventana como MODAL , luego la siguiente linea a esta no se ejecuta hasta que se cierre esa ventana modal.

            // preguntamos si quiere grabar o no..
            if (!this.wDetalle.grabar) {
                return; // si no quiere grabar nos vamos..              
            }
            /*modificado por josem */
            Clientes cliente = new Clientes(this.wDetalle.getNif(), this.wDetalle.getNombre(), this.wDetalle.getDireccion(), this.wDetalle.getTlf());

            try {
                cdao.guardaCliente(cliente);
            } catch (Exception ex) {
                System.out.println("Error guardando el cliente: " + cliente.getNif());
            }
            /*modificacion josem */

            this.cargaDatos();
            this.modelo.fireTableDataChanged();

            ok = true;

        } while (!ok);

    }//GEN-LAST:event_btnNuevaFilaActionPerformed

    /*
    MODIFICAR FILA 
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        int n = this.rejillaDatos.getSelectedRow();

        if (n < 0) {
            return;       // si no estamos sobre ninguna fila nos vamos.
        }

        this.wDetalle.modoEditar(); // ahora aparecen los botones de grabar y cancelar y se nos pone en modal
        String nifOriginal = this.dameElNifPinchado(n); // guardamos el nif (clave principal) para poder hacer el UPDATE ... WHERE NIF = este nif 

        this.wDetalle.recargaDatos(nifOriginal);// cargamos los datos para este NIF para despues modificarlos

        boolean ok; // para hace run bucle si da error al grabar el INSERT INTO ...

        do {
            this.wDetalle.setVisible(true); // aparece la ventana como MODAL , luego la siguiente linea a esta no se ejecuta hasta que se cierre esa ventana modal.

            // preguntamos si quiere grabar o no..
            if (!this.wDetalle.grabar) {
                return; // si no quiere grabar nos vamos..              
            }
            /*modificado por josem */
            Clientes cliente = new Clientes();
            cliente.setNif(this.wDetalle.getNif());
            cliente.setNombre(this.wDetalle.getNombre());
            cliente.setDireccion(this.wDetalle.getDireccion());
            cliente.setTelefono(this.wDetalle.getTlf());

            // luego enviamos el objeto a ser actualizado 
            cdao.actualizaCliente(nifOriginal, cliente);

            /*fin modificacion josem */
            this.cargaDatos(); // recargamos datos
            this.modelo.fireTableDataChanged(); // decimos que han cambiado los datos para que se repinte la rejilla
            ok = true; // todo ok .. nos vamos...

        } while (!ok);

    }//GEN-LAST:event_btnModificarActionPerformed

    //añadido por josem
    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // cierra la aplicacion completa y sale de la misma
        System.exit(0);

    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JToggleButton btnBorrar;
    private javax.swing.JButton btnIrAlFinal;
    private javax.swing.JButton btnIrAlPrincipio;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevaFila;
    private javax.swing.JButton btnSiguiente;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rejillaDatos;
    // End of variables declaration//GEN-END:variables
}
