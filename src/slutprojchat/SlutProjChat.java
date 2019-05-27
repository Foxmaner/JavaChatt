/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import javax.swing.*;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
 * @author eskil.brannerud
 */
public class SlutProjChat extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    JButton btnClient = new JButton("New Client");
    JButton btnServer = new JButton("New Server");

    public SlutProjChat() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(Box.createRigidArea(new Dimension(20, 50)));
        this.add(btnClient);
        this.add(btnServer);
        add(Box.createRigidArea(new Dimension(20, 50)));

        btnClient.addActionListener(this);
        btnServer.addActionListener(this);
        
        setResizable(false);
        this.pack();
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SlutProjChat j1 = new SlutProjChat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnClient) {
            System.out.println("KlientStartas");
            new Client();
        }else if (e.getSource()==btnServer) {
            System.out.println("ServerStartas");
            new Server();
            btnServer.setEnabled(false);
        }
    }

}
