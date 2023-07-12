/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PL;

import BL.CLS_Employee;
import Models.Employee;
import PL.ButtonAction.TableActionCellEditor;
import PL.ButtonAction.TableActionCellRender;
import PL.ButtonAction.TableActionEvent;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ryadh
 */
public class FRM_EmployeePanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    CLS_Employee cls = new CLS_Employee();
    DefaultTableModel model;
    int selectedNum = 0;

    public FRM_EmployeePanel() {
        initComponents();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println(table.getModel().getValueAt(row, 0).toString());
                FRM_AddOrEditOrDetailsEmployee faedu = new FRM_AddOrEditOrDetailsEmployee();
                faedu.editOperation(table.getModel().getValueAt(row, 0).toString());
                initAddOrEditOrDetailsSection(faedu);
            }

            @Override
            public void onDelete(int row) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "هل متأكد من الحذف", "عملية حذف", JOptionPane.YES_NO_OPTION)) {
                    System.out.print("" + row);
                    cls.deleteOne(table.getValueAt(row, 0).toString());
                    countRows();
                    showData();

                }

            }

            @Override
            public void onView(int row) {
                FRM_AddOrEditOrDetailsEmployee faedu = new FRM_AddOrEditOrDetailsEmployee();
                faedu.detailsOperation(table.getModel().getValueAt(row, 0).toString());
                initAddOrEditOrDetailsSection(faedu);

            }
        };
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"القيد", "الاسم", "القسم", "الموقع", "العمليات", "الصورة"}) {
            Class[] cloumnTypes = new Class[]{
                Object.class, Object.class, Object.class, Object.class, Object.class, ImageIcon.class,};

            @Override
            public Class getColumnClass(int columnIndex) {
                return cloumnTypes[columnIndex];
            }
        });

//table.getColumnModel().getColumn(4).
        table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        selectedNum = 0;
        countRows();


        showData();
    }

    void initAddOrEditOrDetailsSection(FRM_AddOrEditOrDetailsEmployee faedu) {
        faedu.initJPanel(this);
        faedu.setVisible(true);
        faedu.pack();
        faedu.hasFocus();
        faedu.setLocationRelativeTo(this);
        faedu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void showData() {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
//        int rowCount=table.getRowCount();
//        for(int i=rowCount;i>=0;i++){
//       model.removeRow(i);
//        }
        model = (DefaultTableModel) table.getModel();
        ArrayList<Employee> employees = cls.search(txt_search.getText().trim(), selectedNum * 20);
        Object[] row = new Object[6];
        for (Employee employee : employees) {
            row[0] = employee.getId();
            row[1] = employee.getName();
            row[2] = employee.getSection();
            row[3] = employee.getLocation();

            if (employee.getImage() != null) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(employee.getImage()).getImage()
                        .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                row[5] = imageIcon;
            } else {
                row[5] = null;
            }

            model.addRow(row);
        }
        table.setRowHeight(100);
        table.getColumnModel().getColumn(5).setMaxWidth(100);
        table.getColumnModel().getColumn(5).setMinWidth(100);

        table.getColumnModel().getColumn(4).setMaxWidth(200);
        table.getColumnModel().getColumn(4).setMinWidth(200);

    }

    void countRows() {
        int amount = cls.amountOfRows(txt_search.getText().trim());
        int i = 20, j = 1;

        if (cb_amountOFRows.getItemCount() > 1) {
            for (; j < cb_amountOFRows.getItemCount(); j++) {
                cb_amountOFRows.removeItemAt(j);
            }

        }
        j = 1;
        if (amount > 20) {

            for (; i <= amount - 20; i += 20) {
                cb_amountOFRows.insertItemAt((i + 20) + "-" + (i + 1), j);
                j++;
            }
            if (cb_amountOFRows.getItemCount() - 1 == j) {
                cb_amountOFRows.removeItemAt(j);
            }
            if (amount > i) {

                cb_amountOFRows.insertItemAt(amount + "-" + (i + 1), j);
                j++;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panel1 = new java.awt.Panel();
        jButton1 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_clearSearch = new javax.swing.JButton();
        cb_amountOFRows = new javax.swing.JComboBox<>();
        btn_goLastTable = new javax.swing.JButton();
        btn_goNextTable = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "age", "image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(125, 176, 116));
        jScrollPane1.setViewportView(table);

        panel1.setBackground(new java.awt.Color(51, 255, 204));

        jButton1.setText("إضافة");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        btn_clearSearch.setText("مسح البحث");
        btn_clearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearSearchActionPerformed(evt);
            }
        });

        cb_amountOFRows.setMaximumRowCount(1000);
        cb_amountOFRows.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20-1" }));
        cb_amountOFRows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_amountOFRowsActionPerformed(evt);
            }
        });

        btn_goLastTable.setText(">");
        btn_goLastTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goLastTableActionPerformed(evt);
            }
        });

        btn_goNextTable.setText("<");
        btn_goNextTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goNextTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_goNextTable)
                .addGap(5, 5, 5)
                .addComponent(cb_amountOFRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_goLastTable)
                .addGap(22, 22, 22)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clearSearch)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clearSearch)
                    .addComponent(cb_amountOFRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_goLastTable)
                    .addComponent(btn_goNextTable))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        FRM_AddOrEditOrDetailsEmployee faedu = new FRM_AddOrEditOrDetailsEmployee();
        faedu.addOperation();
        initAddOrEditOrDetailsSection(faedu);
    }//GEN-LAST:event_jButton1MouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        showData();
    }//GEN-LAST:event_txt_searchKeyReleased

    private void btn_clearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearSearchActionPerformed
        txt_search.setText("");
        showData();
    }//GEN-LAST:event_btn_clearSearchActionPerformed
    void fetchTable() {
        selectedNum = cb_amountOFRows.getSelectedIndex();
        System.out.println(cb_amountOFRows.getSelectedIndex());
        showData();
    }
    private void cb_amountOFRowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_amountOFRowsActionPerformed
        fetchTable();
    }//GEN-LAST:event_cb_amountOFRowsActionPerformed

    private void btn_goNextTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goNextTableActionPerformed
        if ((cb_amountOFRows.getItemCount() - 1 > cb_amountOFRows.getSelectedIndex())) {
            cb_amountOFRows.setSelectedIndex(1 + cb_amountOFRows.getSelectedIndex());
            fetchTable();
        }
    }//GEN-LAST:event_btn_goNextTableActionPerformed

    private void btn_goLastTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goLastTableActionPerformed
        if ((0 < cb_amountOFRows.getSelectedIndex())) {
            cb_amountOFRows.setSelectedIndex((cb_amountOFRows.getSelectedIndex() - 1));
            fetchTable();
        }
    }//GEN-LAST:event_btn_goLastTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clearSearch;
    private javax.swing.JButton btn_goLastTable;
    private javax.swing.JButton btn_goNextTable;
    private javax.swing.JComboBox<String> cb_amountOFRows;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
