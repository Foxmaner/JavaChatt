/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author eskil
 */
public class clientChatPanel extends JPanel{
    JTextArea ta1 = new JTextArea();
    JList l1 = new JList();
    JLabel label1 = new JLabel("Meddelande:");
    JTextField tf1 = new JTextField();
    JButton b1 = new JButton("Skicka");
    
    
    
    public clientChatPanel(){
        
        this.setPreferredSize(new Dimension(760, 500));
        
        this.setLayout(new FlowLayout());    
        
        ta1.setPreferredSize(new Dimension(500, 400));
        l1.setPreferredSize(new Dimension(250, 400));
        
        tf1.setPreferredSize(new Dimension(570, 25));        
        b1.setPreferredSize(new Dimension(100, 25));
        
        ta1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        l1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        tf1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        
       
        
        ta1.setEditable(false);
        
        this.add(ta1);
        this.add(l1);
        this.add(label1);
        this.add(tf1);
        this.add(b1);
        
        this.setVisible(true);
        
    }
}
