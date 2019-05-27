/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eskil
 */
public class ClientManager implements Runnable {

    public Thread t;
    Socket socket;
    DataInputStream streamIn;
    DataOutputStream streamOut;
    ObjectOutputStream objectStreamOut;
    public ObjectInputStream objectStreamIn  =  null;

    public ClientManager(Socket s) throws IOException {
        socket = s;
        t = new Thread(this);
        streamIn = new DataInputStream(socket.getInputStream());
        streamOut = new DataOutputStream(socket.getOutputStream());
        objectStreamOut = new ObjectOutputStream(socket.getOutputStream());
        objectStreamIn = new ObjectInputStream(socket.getInputStream());
        t.start();
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

    @Override
    public void run() {
        while (true) {
            try {
                Message incMessage = (Message) objectStreamIn.readObject();
                
                send()

               // streamOut.writeInt(tal1 + tal2);
            } catch (IOException ex) {
                break; //User disconnected
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(socket.getInetAddress().getHostName() + " disconnected.");
        Server.decreaseNoOfConnections();
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
