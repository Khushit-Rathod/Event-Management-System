package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, register;
    JTextField tfemail, tfpassword;

    Login() {
        setTitle("Login");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // if set then we have to explicitly set position using setBounds

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(40, 30, 100, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(150, 30, 150, 25);
        add(tfemail);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 90, 100, 25);
        add(lblpassword);

        tfpassword = new JPasswordField(); // will hide password
        tfpassword.setBounds(150, 90, 150, 25);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 160, 120, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(login);

        register = new JButton("Register");
        register.setBounds(210, 160, 120, 35);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        register.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(register);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) { // getsource gets the text of button
            String email = tfemail.getText();
            String password = tfpassword.getText();
            int a = 0;
            if (email.contains("@") == false) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address");
                setVisible(false);
                new Login();
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty");
                setVisible(false);
                new Login();
            } else {
                String query = "select * from login where email='" + email + "' and password='" + password + "'";

                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    if ((email.equals("admin@viit.ac.in")) && (password.equals("12345"))) {
                        setVisible(false);
                        new Project();
                    } else {
                        while (rs.next()) {
                            if ((email.equals(rs.getString("email"))) && (password.equals(rs.getString("password")))) {
                                a = 1;
                                break;
                            }
                        }
                        if (a == 1) {
                            setVisible(false);
                            new StudentProject();
                        } else {
                            JOptionPane.showMessageDialog(null, "You have not registered. Please Register first");
                            setVisible(false);
                            new Register();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == register) {
            setVisible(false);
            new Register();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
