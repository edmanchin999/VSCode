package main.src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JPanel panel;
    JLabel userLabel, passwordLabel, message;
    JTextField usernameText;
    JPasswordField passwordText;
    JButton submit, cancel;

    Login() {
        userLabel = new JLabel();
        userLabel.setText("Username :");
        usernameText = new JTextField();

        passwordLabel = new JLabel();
        passwordLabel.setText("Password :");
        passwordText = new JPasswordField();

        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(userLabel);
        panel.add(passwordLabel);
        panel.add(usernameText);
        panel.add(passwordText);
        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login Page");
        setSize(450, 450);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent e) {
        String userName = usernameText.getText();
        String password = passwordText.getText();
        if (userName.trim().equals("admin") && password.trim().equals("123")) {
            message.setText("Hello " + userName + " Welcome!");
        } else {
            message.setText("Invalid User , please try again");
        }
    }
}
