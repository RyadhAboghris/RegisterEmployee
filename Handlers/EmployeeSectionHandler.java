/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import Models.Employee;
import Models.User;
import javax.swing.JOptionPane;

/**
 *
 * @author ryadh
 */
public class EmployeeSectionHandler extends BaseHandler<Employee>{
    @Override
    public void HandlerRequest(Employee employee) {
        if(employee.getSection()==null || "".equals(employee.getSection()) ){
            JOptionPane.showMessageDialog(null,"القسم مطلوب");
        check=false;
        }else{
        if(_nextHandler!=null){
        _nextHandler.HandlerRequest(employee);
        }
        
        }
    }
}
