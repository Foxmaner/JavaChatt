/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author eskil
 */
public class Server extends JFrame implements ActionListener, Runnable {
    public Thread t = new Thread(this);
    public static int noOfConnections, port;
    private ServerSocket listeningSocket;
    
    ArrayList<String> connectedUsers  = new ArrayList<String>();
    
    JLabel ipAddressLabel = new JLabel("IP Address: ");
    JLabel portLabel = new JLabel("Port: ");
    JLabel numberOfConnectionsLabel = new JLabel("Number of connections: ");
    JLabel passwordLabel = new JLabel("Password: ");
    JLabel changePasswordLabel = new JLabel("Change Password: ");

    JLabel ipAddressLabelOutput = new JLabel("xxx.xx.xxx.x");
    JLabel portLabelOutput = new JLabel("xxxx");
    
    JLabel passwordLabelOutput = new JLabel("x");

    JTextField changePasswordTF = new JTextField();

    JButton changePasswordBTN = new JButton("Change password");

    private static JLabel numberOfConnectionsLabelOutput;
    public Server() throws UnknownHostException, IOException{
        this.setLayout(new GridLayout(6, 2));
        this.setPreferredSize(new Dimension(300, 500));
        port = 3000;
        noOfConnections = 0;
        
        numberOfConnectionsLabelOutput = new JLabel("" + noOfConnections);
        
        listeningSocket = new ServerSocket(port);
        
        
        
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

        changePasswordBTN.addActionListener(this);

        setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        
        t.start(); 
    }

    public void writeToPasswordFile(String password) throws IOException {
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("notPassword.txt", false)));

        output.print(password);

        output.close();
        passwordLabelOutput.setText(password);
    }

    public static void increaseNoOfConnections() {
        noOfConnections++;
        numberOfConnectionsLabelOutput.setText("" + noOfConnections);
    }

    public static void decreaseNoOfConnections() {
        noOfConnections--;
        numberOfConnectionsLabelOutput.setText("" + noOfConnections);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changePasswordBTN) {
            try {
                writeToPasswordFile(changePasswordTF.getText());
                System.out.println("Byter lösen");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                
                Socket clientSocket = listeningSocket.accept();
                System.out.println(clientSocket.getInetAddress().getHostName() + " connected.");
                increaseNoOfConnections();
                connectedUsers.add(clientSocket.getInetAddress().getHostName());
                
                new ClientManager(clientSocket);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
