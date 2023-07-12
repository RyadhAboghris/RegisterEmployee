/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import Models.Employee;
import javax.swing.JOptionPane;

/**
 *
 * @author ryadh
 */
public class EmployeeNameHandler extends BaseHandler<Employee>{
    @Override
    public void HandlerRequest(Employee employee) {
        if(employee.getName()==null || "".equals(employee.getName()) ){
            JOptionPane.showMessageDialog(null,"الاسم مطلوب");
        check=false;
        }else{
        if(_nextHandler!=null){
        _nextHandler.HandlerRequest(employee);
        }
        
        }
    }
}
