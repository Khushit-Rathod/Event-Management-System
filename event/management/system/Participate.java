package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Participate extends JFrame implements ActionListener {

    JTextField tftname, tfname, tftm1, tftm2, tftm3, tfemail;
    JLabel lblteamname, lblname, lblemail, lbltm1, lbltm2, lbltm3;
    JButton submit, cancel;
    Choice cevent;

    Participate() {
        setTitle("Participate");
        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Participate in Event");
        heading.setBounds(280, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        add(heading);

        JLabel lblevent = new JLabel("Select Event Name");
        lblevent.setBounds(50, 100, 170, 20);
        lblevent.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblevent);

        cevent = new Choice();
        add(cevent);
        cevent.setBounds(250, 100, 170, 20);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from events");
            while (rs.next()) {
                cevent.add(rs.getString("eventname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblteamname = new JLabel("Team Name");
        lblteamname.setBounds(150, 150, 200, 30);
        lblteamname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblteamname);

        tftname = new JTextField();
        tftname.setBounds(430, 150, 230, 30);
        add(tftname);

        lblname = new JLabel("Your Name");
        lblname.setBounds(150, 200, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(430, 200, 230, 30);
        add(tfname);

        lbltm1 = new JLabel("Team member 1 Name");
        lbltm1.setBounds(150, 300, 200, 30);
        lbltm1.setFont(new Font("serif", Font.BOLD, 20));
        add(lbltm1);

        tftm1 = new JTextField();
        tftm1.setBounds(430, 300, 230, 30);
        add(tftm1);

        lbltm2 = new JLabel("Team member 2 Name");
        lbltm2.setBounds(150, 350, 200, 30);
        lbltm2.setFont(new Font("serif", Font.BOLD, 20));
        add(lbltm2);

        tftm2 = new JTextField();
        tftm2.setBounds(430, 350, 230, 30);
        add(tftm2);

        lbltm3 = new JLabel("Team member 3 Name");
        lbltm3.setBounds(150, 400, 200, 30);
        lbltm3.setFont(new Font("serif", Font.BOLD, 20));
        add(lbltm3);

        tftm3 = new JTextField();
        tftm3.setBounds(430, 400, 230, 30);
        add(tftm3);

        lblemail = new JLabel("Your Email Id");
        lblemail.setBounds(150, 250, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(430, 250, 230, 30);
        add(tfemail);

        cevent.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from events where eventname='" +
                            cevent.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        if (rs.getInt("teammembers") == 1) {
                            lbltm1.hide();
                            tftm1.hide();
                            lbltm2.hide();
                            tftm2.hide();
                            lbltm3.hide();
                            tftm3.hide();
                        } else if (rs.getInt("teammembers") == 2) {
                            lbltm1.show();
                            tftm1.show();
                            lbltm2.hide();
                            tftm2.hide();
                            lbltm3.hide();
                            tftm3.hide();
                        } else if (rs.getInt("teammembers") == 3) {
                            lbltm1.show();
                            tftm1.show();
                            lbltm2.show();
                            tftm2.show();
                            lbltm3.hide();
                            tftm3.hide();
                        } else {
                            lbltm1.show();
                            tftm1.show();
                            lbltm2.show();
                            tftm2.show();
                            lbltm3.show();
                            tftm3.show();
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Submit");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String eventname = cevent.getSelectedItem();
            String tname = tftname.getText();
            String name = tfname.getText();
            String tm1name = tftm1.getText();
            String tm2name = tftm2.getText();
            String tm3name = tftm3.getText();
            String email = tfemail.getText();
            if (tname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the name of your Team");
                setVisible(false);
                new Participate();
            } else if (email.contains("@") == false) {
                JOptionPane.showMessageDialog(null, "Please Enter a valid email address");
                setVisible(false);
                new Participate();
            } else if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your name");
                setVisible(false);
                new Participate();
            } else {
                try {
                    String query = "insert into participate values('" + eventname + "', '" + tname + "', '" + name
                            + "', '"
                            + tm1name
                            + "', '" + tm2name + "', '" + tm3name + "', '" + email + "')";
                    Conn con = new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Successfully Participated in the Event");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Participate();
    }
}
