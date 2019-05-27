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
import java.net.Socket;
import javax.swing.JFrame;

/**
 *
 * @author eskil
 */
public class Client extends JFrame implements ActionListener {

    Socket so;
    DataInputStream streamIn;
    DataOutputStream streamOut;

    clientAdressPanel p1 = new clientAdressPanel();
    clientChatPanel p2 = new clientChatPanel();

    public Client() {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(760, 600));

        this.add(p1);

        this.add(p2);

        p1.connectButton.addActionListener(this);

        setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    private void connectToHost() throws IOException {
        p1.connectButton.setEnabled(false);
        so = new Socket(p1.hostAddressTextField.getText(), Integer.parseInt(p1.hostPortTextField.getText()));
        streamIn = new DataInputStream(so.getInputStream());
        streamOut = new DataOutputStream(so.getOutputStream());
        if (so.isConnected()) {
            p2.ta1.append("Connected to server: " + p1.hostAddressTextField.getText());

        } else {
            p2.ta1.append("Could´t connect to server: " + p1.hostAddressTextField.getText());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == p1.connectButton) {
            try {
                connectToHost();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
