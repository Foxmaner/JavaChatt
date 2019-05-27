/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author eskil
 */
public class Server extends JFrame {

    JLabel ipAddressLabel = new JLabel("IP Address: ");
    JLabel portLabel = new JLabel("Port: ");
    JLabel numberOfConnectionsLabel = new JLabel("Number of connections: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel changePasswordLabel = new JLabel("Change Password: ");

    JLabel ipAddressLabelOutput = new JLabel("xxx.xx.xxx.x");
    JLabel portLabelOutput = new JLabel("xxxx");
    JLabel numberOfConnectionsLabelOutput = new JLabel("x");
    JLabel passwordLabelOutput = new JLabel("x");
    

    JTextField changePasswordTF = new JTextField();

    JButton changePasswordBTN = new JButton("Change password");

    public Server() {
        this.setLayout(new GridLayout(6, 2));
        this.setPreferredSize(new Dimension(300, 500));

        this.add(ipAddressLabel);
        this.add(ipAddressLabelOutput);
        this.add(portLabel);
        this.add(portLabelOutput);
        this.add(numberOfConnectionsLabel);
        this.add(numberOfConnectionsLabelOutput);
        this.add(passwordLabel);
        this.add(passwordLabelOutput);
        this.add(changePasswordLabel);
        

        this.add(changePasswordTF);

        this.add(changePasswordBTN);

        setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
}
