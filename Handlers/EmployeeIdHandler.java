
package Handlers;

import Models.Employee;
import javax.swing.JOptionPane;

/**
 *
 * @author ryadh
 */
public class EmployeeIdHandler extends BaseHandler<Employee>{
    @Override
    public void HandlerRequest(Employee employee) {
        if(employee.getId()==null || "".equals(employee.getId()) ){
            JOptionPane.showMessageDialog(null,"القيد مطلوب");
        check=false;
        }else{
        if(_nextHandler!=null){
        _nextHandler.HandlerRequest(employee);
        }
        
        }
    }
}
