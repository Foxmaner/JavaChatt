/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author eskil.brannerud
 */
public class SlutProjChat extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    String namn;
    InetAddress iadr;
    int port;
    MulticastSocket so;
    JTextArea txt = new JTextArea();
    JScrollPane sp = new JScrollPane();
    JTextField skriv = new JTextField();
    JButton sluta = new JButton("Koppla ner");
    
    public static void main(String[] args) {
        // TODO code application logic here
        //ballt är coolt
        //ballare är ballast
        //Collare
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
