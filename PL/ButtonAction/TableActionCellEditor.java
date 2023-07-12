/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PL.ButtonAction;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author ryadh
 */
public class TableActionCellEditor extends DefaultCellEditor{

    private TableActionEvent event;
    
    public TableActionCellEditor(TableActionEvent e) {
        super(new JCheckBox());
        this.event=e;
    }

    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       Component com= super.getTableCellEditorComponent(table, value, isSelected, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    PanelAction action  = new PanelAction();
    action.initEvent(event,row);
    action.setBackground(table.getSelectionBackground());
    return action;
    }
 
    
}
