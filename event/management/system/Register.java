package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Register extends JFrame implements ActionListener {

    JButton register, cancel;
    JTextField tfemail, tfpassword, tfusername, tfconfirmpassword;
    JLabel lblprn, lbltext;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    Register() {
        setTitle("New User Registration");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // if set then we have to explicitly set position using setBounds

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 150, 25);
        add(tfusername);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(40, 70, 100, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 70, 150, 25);
        add(tfemail);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 120, 100, 25);
        add(lblpassword);

        tfpassword = new JPasswordField(); // will hide password
        tfpassword.setBounds(200, 120, 150, 25);
        add(tfpassword);

        JLabel lblconfirmpassword = new JLabel("Confirm Password");
        lblconfirmpassword.setBounds(40, 170, 150, 25);
        add(lblconfirmpassword);

        tfconfirmpassword = new JPasswordField(); // will hide password
        tfconfirmpassword.setBounds(200, 170, 150, 25);
        add(tfconfirmpassword);

        JLabel labelprn = new JLabel("PRN");
        labelprn.setBounds(40, 220, 150, 25);
        add(labelprn);

        lblprn = new JLabel("2211" + first4);
        lblprn.setFont(new Font("serif", Font.BOLD, 20));
        lblprn.setBounds(200, 220, 150, 25);
        add(lblprn);

        lbltext = new JLabel("Remember this for future use");
        lbltext.setBounds(190, 240, 200, 25);
        add(lbltext);

        register = new JButton("Submit");
        register.setBounds(120, 300, 120, 35);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        register.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(register);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 300, 120, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon2.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(430, 30, 200, 200);
        add(image);

        setSize(700, 430);
        setLocation(450, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = tfusername.getText();
        String email = tfemail.getText();
        String password = tfpassword.getText();
        String prn = lblprn.getText();
        if (ae.getSource() == register) { // getsource gets the text of button
            if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Username");
                setVisible(false);
                new Register();
            } else if (email.contains("@") == false) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address");
                setVisible(false);
                new Register();
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty");
                setVisible(false);
                new Register();
            } else if (tfpassword.getText().equals(tfconfirmpassword.getText()) == false) {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                setVisible(false);
                new Register();
            } else {
                String query = "insert into register values('" + prn + "', '" + username + "', '" + email + "', '"
                        + password + "')";
                String query1 = "insert into login values('" + email + "', '" + password + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Registered Successfully");
                    setVisible(false);
                    new Login();
                    c.s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Register();
    }
}
