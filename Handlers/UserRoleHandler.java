/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import Models.User;
import javax.swing.JOptionPane;

/**
 *
 * @author ryadh
 */
public class UserRoleHandler extends BaseHandler<User>{

    @Override
    public void HandlerRequest(User user) {
        if(user.getRole()==null || "".equals(user.getRole()) ){
            JOptionPane.showMessageDialog(null,"الصلاحية مطلوبة");
        check=false;
        }else{
        if(_nextHandler!=null){
        _nextHandler.HandlerRequest(user);
        }
        
        }
    }
    
}
