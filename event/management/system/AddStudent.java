package event.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener {

    JTextField tfname, tfmiddlename, tflastname, tfphone, tfemail, tfprn;
    JDateChooser dcdob;
    JComboBox cbyear, cbbranch;
    JButton submit, cancel;

    AddStudent() {
        setTitle("Insert Student Record");
        setSize(900, 600);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("First Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblmiddlename = new JLabel("Middle Name");
        lblmiddlename.setBounds(50, 200, 200, 30);
        lblmiddlename.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmiddlename);

        tfmiddlename = new JTextField();
        tfmiddlename.setBounds(200, 200, 150, 30);
        add(tfmiddlename);

        JLabel lbllastname = new JLabel("Last Name");
        lbllastname.setBounds(50, 250, 200, 30);
        lbllastname.setFont(new Font("serif", Font.BOLD, 20));
        add(lbllastname);

        tflastname = new JTextField();
        tflastname.setBounds(200, 250, 150, 30);
        add(tflastname);

        JLabel lblprn = new JLabel("PRN");
        lblprn.setBounds(50, 350, 200, 30);
        lblprn.setFont(new Font("serif", Font.BOLD, 20));
        add(lblprn);

        tfprn = new JTextField();
        tfprn.setBounds(200, 350, 150, 30);
        add(tfprn);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(415, 175, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 175, 150, 30);
        add(dcdob);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(415, 225, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 225, 150, 30);
        add(tfphone);

        JLabel lblyear = new JLabel("Year");
        lblyear.setBounds(415, 275, 200, 30);
        lblyear.setFont(new Font("serif", Font.BOLD, 20));
        add(lblyear);

        String course[] = { "First Year", "2nd Year", "3rd Year", "Final Year" };
        cbyear = new JComboBox(course);
        cbyear.setBounds(600, 275, 150, 30);
        cbyear.setBackground(Color.WHITE);
        add(cbyear);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(415, 325, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String branch[] = { "IT", "Computer Science", "ENTC", "Mechanical", "Civil", "AIDS" };
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600, 325, 150, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250, 450, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 450, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String middlename = tfmiddlename.getText();
            String lastname = tflastname.getText();
            String prn = tfprn.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String year = (String) cbyear.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your name");
                setVisible(false);
                new AddStudent();
            } else if (lastname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your sirname");
                setVisible(false);
                new AddStudent();
            } else if (email.contains("@") == false) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address");
                setVisible(false);
                new AddStudent();
            } else if (phone.length() != 10) {
                JOptionPane.showMessageDialog(null, "Phone number should be of 10 digits");
                setVisible(false);
                new AddStudent();
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Date of Birth");
                setVisible(false);
                new AddStudent();
            } else {
                try {
                    String query = "insert into student values('" + name + "', '" + middlename + "', '" + lastname
                            + "', '"
                            + prn + "', '" + email
                            + "', '" + phone + "', '" + dob + "', '" + year + "', '" + branch + "')";

                    Conn con = new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
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
        new AddStudent();
    }
}
