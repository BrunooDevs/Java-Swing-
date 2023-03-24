/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Usuario;

import Views.Medico.*;
import java.awt.Color;
import javax.swing.JProgressBar;

/**
 *
 * @author Owner
 */
public class CircleProgressBar extends JProgressBar {
    
     public CircleProgressBar() {
         
        setOpaque(false);
        setBackground(new Color(220, 220, 220));
        setForeground(new Color(97, 97, 97));
        setStringPainted(true);
        setUI(new ProgressCircleUI(this));
    }

    
}
