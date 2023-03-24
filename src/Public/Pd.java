/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Public;

import Views.Usuario.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Owner
 */
public class Pd extends javax.swing.JPanel {

    private Color color1 = new Color(0, 0, 0);
    private Color color2 = new Color(0, 0, 0);

    public Pd() {
    }

    public Pd(Color c1, Color c2) {
        color1 = c1;
        color2 = c2;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        g2.setPaint(new GradientPaint(220.0f, 0.0f, color1.darker(), -200.0f, getHeight(), color2.darker()));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }

    public void setRandomColor() {
        Random rand = new Random();
        this.color1 = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        this.color2 = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
    
    public void setVistaColor(){        
        this.color1 = new Color(0, 158, 191 );
        this.color2 = new Color(158, 58, 175);        
    }
    
    

}
