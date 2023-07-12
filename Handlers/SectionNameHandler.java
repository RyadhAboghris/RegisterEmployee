/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import Models.Section;
import javax.swing.JOptionPane;

/**
 *
 * @author ryadh
 */
public class SectionNameHandler extends BaseHandler<Section>{

    @Override
    public void HandlerRequest(Section section) {
        if(section.getName()==null || "".equals(section.getName()) ){
            JOptionPane.showMessageDialog(null,"الاسم مطلوب");
        check=false;
        }else{
        if(_nextHandler!=null){
        _nextHandler.HandlerRequest(section);
        }
        
        }
    }
    
}
