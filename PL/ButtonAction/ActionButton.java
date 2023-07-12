/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PL.ButtonAction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ryadh
 */
public class ActionButton extends JButton{
 private boolean mousePress;
    public ActionButton(){
    setContentAreaFilled(false);
    setBorder(new EmptyBorder(3,3,3,3));
        addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
mousePress=true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
mousePress=false;
        }
        
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
Graphics2D q2=(Graphics2D) g.create();
q2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
int width= getWidth();
int height= getHeight();
int size= Math.min(width, height);
int x= (width - size)/2;
int y= (height - size)/2;
if(mousePress){
    q2.setColor(new Color(158,158,158));
    
    }else{
        q2.setColor(new Color(199,199,199));
}
    q2.fill(new Ellipse2D.Double(x, y, size, size));
    q2.dispose();
    super.paintComponent(g);
    }
    
}
