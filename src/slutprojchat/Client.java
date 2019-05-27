/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author eskil
 */
public class Client extends JFrame implements ActionListener, Runnable {

    public Thread t;
    Socket socket;

    DataInputStream streamIn;
    DataOutputStream streamOut;
    ObjectOutputStream objectStreamOut;
    public ObjectInputStream objectStreamIn = null;

    public ObjectInputStream In;
    public ObjectOutputStream Out;

    clientAdressPanel p1 = new clientAdressPanel();
    clientChatPanel p2 = new clientChatPanel();

    String username;

    public Client() throws IOException {
        
        t = new Thread(this);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(760, 600));

        this.add(p1);

        this.add(p2);

        p1.connectButton.addActionListener(this);
        p2.b1.addActionListener(this);

        setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        t.start();
    }

    private void connectToHost() throws IOException {
        p1.connectButton.setEnabled(false);
        socket = new Socket(p1.hostAddressTextField.getText(), Integer.parseInt(p1.hostPortTextField.getText()));
        username = p1.usernameTextField.getText();
        streamIn = new DataInputStream(socket.getInputStream());
        streamOut = new DataOutputStream(socket.getOutputStream());
        objectStreamOut = new ObjectOutputStream(socket.getOutputStream());
        objectStreamIn = new ObjectInputStream(socket.getInputStream());

        if (socket.isConnected()) {
            p2.ta1.append("Connected to server: " + p1.hostAddressTextField.getText());

        } else {
            p2.ta1.append("Could´t connect to server: " + p1.hostAddressTextField.getText());
        }

    }

    public void send(Message msg) {
        try {
            objectStreamOut.writeObject(msg);
            objectStreamOut.flush();
            System.out.println("Skickat:" + msg.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void createMessage() {
        String text = p2.tf1.getText();
        p2.tf1.setText("");
        System.out.println(text);
        send(new Message("upload_res", username, text, ""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == p1.connectButton) {
            try {
                connectToHost();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == p2.b1) {
            createMessage();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message incMessage = (Message) objectStreamIn.readObject();
                System.out.println(incMessage.content);
            } catch (IOException ex) {
                
            } catch (ClassNotFoundException ex) {
                
            }
        }

    }
}
