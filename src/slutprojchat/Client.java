/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author eskil
 */
public class Client extends JFrame {
    clientAdressPanel p1 = new clientAdressPanel();
    clientChatPanel p2 = new clientChatPanel(); 
    
    public Client() {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(760,600));
        
        
        this.add(p1);
        
        
        this.add(p2);
        
        setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
}
