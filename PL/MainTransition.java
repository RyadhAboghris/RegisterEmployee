/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PL;

import Models.User;
import javax.swing.JFrame;

/**
 *
 * @author ryadh
 */
public  class MainTransition {
    void  goToMain(User user,FRM_Login oldFrm){
    FRM_Main frm = new FRM_Main();
        frm.setValues(user);
        initAddOrEditOrDetailsUser(frm,oldFrm);
    }
    void initAddOrEditOrDetailsUser(FRM_Main frm,FRM_Login oldFrm) {
//        frm.initJPanel(this);
        frm.setVisible(true);
        oldFrm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oldFrm.dispose();
        frm.pack();
        frm.hasFocus();
        frm.setLocationRelativeTo(oldFrm);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
