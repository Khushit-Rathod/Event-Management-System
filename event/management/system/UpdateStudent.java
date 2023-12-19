package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {

    JTextField tfyear, tfphone, tfemail;
    JLabel labelprn, tfbranch, labelfname, labelmname, labellname, labeldob;
    JButton submit, cancel;
    Choice cprn;

    UpdateStudent() {
        setTitle("Update Student Information");
        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(280, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        add(heading);

        JLabel lblprn = new JLabel("Select PRN");
        lblprn.setBounds(50, 100, 200, 20);
        lblprn.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblprn);

        cprn = new Choice();
        add(cprn);
        cprn.setBounds(250, 100, 200, 20);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                cprn.add(rs.getString("prn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblfname = new JLabel("First Name");
        lblfname.setBounds(50, 150, 100, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblmname = new JLabel("Middle Name");
        lblmname.setBounds(50, 200, 200, 30);
        lblmname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmname);

        JLabel labelmname = new JLabel();
        labelmname.setBounds(200, 200, 150, 30);
        labelmname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelmname);

        JLabel lbllname = new JLabel("Last Name");
        lbllname.setBounds(50, 250, 200, 30);
        lbllname.setFont(new Font("serif", Font.BOLD, 20));
        add(lbllname);

        JLabel labellname = new JLabel();
        labellname.setBounds(200, 250, 150, 30);
        labellname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labellname);

        JLabel lbprn = new JLabel("PRN");
        lbprn.setBounds(50, 300, 200, 30);
        lbprn.setFont(new Font("serif", Font.BOLD, 20));
        add(lbprn);

        labelprn = new JLabel();
        labelprn.setBounds(200, 300, 200, 30);
        labelprn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelprn);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 175, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 175, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 225, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 225, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 350, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 350, 150, 30);
        add(tfemail);

        JLabel lblyear = new JLabel("Year");
        lblyear.setBounds(400, 275, 200, 30);
        lblyear.setFont(new Font("serif", Font.BOLD, 20));
        add(lblyear);

        tfyear = new JTextField();
        tfyear.setBounds(600, 275, 150, 30);
        add(tfyear);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 325, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        JLabel tfbranch = new JLabel();
        tfbranch.setBounds(600, 325, 150, 30);
        tfbranch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfbranch);

        try {
            Conn c = new Conn();
            String query = "select * from student where prn='" + cprn.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelfname.setText(rs.getString("firstname"));
                labelmname.setText(rs.getString("middlename"));
                labellname.setText(rs.getString("lastname"));
                labelprn.setText(rs.getString("prn"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                labeldob.setText(rs.getString("dob"));
                tfyear.setText(rs.getString("year"));
                tfbranch.setText(rs.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cprn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where prn='" + cprn.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        labelfname.setText(rs.getString("firstname"));
                        labelmname.setText(rs.getString("middlename"));
                        labellname.setText(rs.getString("lastname"));
                        labelprn.setText(rs.getString("prn"));
                        tfemail.setText(rs.getString("email"));
                        tfphone.setText(rs.getString("phone"));
                        labeldob.setText(rs.getString("dob"));
                        tfyear.setText(rs.getString("year"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
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
            String prn = labelprn.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String year = tfyear.getText();

            try {
                String query = "update student set phone='" + phone + "', year='" + year + "', email='" + email
                        + "' where prn='" + prn + "'";
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
