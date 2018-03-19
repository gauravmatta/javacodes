/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapp;

import javax.swing.JApplet;
import java.awt.Graphics;

/**
 *
 * @author Gaurav Matta
 */
public class MyFirstApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    
    // TODO overwrite start(), stop() and destroy() methods
    public void paint(Graphics g)
    {
        g.drawString("To climb a ladder, start at the bottom rung", 20, 90);
    }
}
