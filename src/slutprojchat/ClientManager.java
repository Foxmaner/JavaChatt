/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author eskil
 */
public class ClientManager implements Runnable {
    public Thread t;
    Socket socket;
    DataInputStream streamIn;
    DataOutputStream streamOut;
    
    public ClientManager(Socket s) throws IOException {
        socket = s;
        t = new Thread(this);
        streamIn = new DataInputStream(socket.getInputStream());
        streamOut = new DataOutputStream(socket.getOutputStream());
        t.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                int tal1 = streamIn.readInt();
                int tal2 = streamIn.readInt();
                
                streamOut.writeInt(tal1 + tal2);
            } catch (IOException ex) {
                break; //User disconnected
            }
        }
        System.out.println(socket.getInetAddress().getHostName() + " disconnected.");
        Server.decreaseNoOfConnections();
        try {
            socket.close();    
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }    
}

