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
public class UserPasswordHandler extends BaseHandler<User>{

    @Override
    public void HandlerRequest(User user) {
        if(user.getPassword()==null || "".equals(user.getPassword()) ){
            JOptionPane.showMessageDialog(null,"كلمة المرور مطلوبة");
        check=false;
        }else{
        if(_nextHandler!=null){
        _nextHandler.HandlerRequest(user);
        }
        
        }
    }
    
}
