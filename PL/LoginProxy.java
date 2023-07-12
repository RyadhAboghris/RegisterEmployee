package PL;

import Models.User;
import javax.swing.JOptionPane;

/**
 *
 * @author ryadh
 */
public  class LoginProxy {
    void checkLogin(User user,FRM_Login oldFrm){
         if(user!=null){
             if(user.getActive()==1){
             MainTransition mt=new MainTransition();
mt.goToMain(user, oldFrm);
             }else{
                        JOptionPane.showMessageDialog(null, "هذا الحساب ممنوع من الولوج تواصل مع المسؤول");
             }


       }else{
           JOptionPane.showMessageDialog(null, "اسم المستخدم أو كلمة المرور خاطئة");
       }
    }
}
