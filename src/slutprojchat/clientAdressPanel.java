/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slutprojchat;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author eskil
 */
public class clientAdressPanel extends JPanel {

    JLabel hostAdressLabel = new JLabel("Host Address: ");
    JLabel hostPortLabel = new JLabel("HostPort: ");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");

    JTextField hostAddressTextField = new JTextField();
    JTextField hostPortTextField = new JTextField();
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordPasswordField = new JPasswordField();

    JButton connectButton = new JButton("Connect");
    JButton loginButton = new JButton("Login");

    public clientAdressPanel() {

        this.setPreferredSize(new Dimension(760, 80));
        this.setLayout(new FlowLayout());

        hostAddressTextField.setPreferredSize(new Dimension(230, 25));
        hostPortTextField.setPreferredSize(new Dimension(230, 25));
        usernameTextField.setPreferredSize(new Dimension(230, 25));
        passwordPasswordField.setPreferredSize(new Dimension(230, 25));
        
        
        
        this.add(hostAdressLabel);
        this.add(hostAddressTextField);
        this.add(hostPortLabel);
        this.add(hostPortTextField);
        this.add(connectButton);
        this.add(usernameLabel);
        this.add(usernameTextField);
        this.add(passwordLabel);
        this.add(passwordPasswordField);
        this.add(loginButton);

        this.setVisible(true);
    }
}
