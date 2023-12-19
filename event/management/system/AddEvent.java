package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddEvent extends JFrame implements ActionListener {

    JTextField tfeventname, tfedescription, tfteammembers;
    JButton submit, cancel;

    AddEvent() {
        setTitle("Add new Event");
        setSize(700, 560);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("New Event Details");
        heading.setBounds(230, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Event Name");
        lblname.setBounds(150, 130, 200, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfeventname = new JTextField();
        tfeventname.setBounds(350, 130, 150, 30);
        add(tfeventname);

        JLabel lbledesc = new JLabel("Event Description");
        lbledesc.setBounds(150, 200, 200, 30);
        lbledesc.setFont(new Font("serif", Font.BOLD, 20));
        add(lbledesc);

        tfedescription = new JTextField();
        tfedescription.setBounds(350, 200, 200, 30);
        add(tfedescription);

        JLabel lblmembers = new JLabel("Team Members");
        lblmembers.setBounds(150, 270, 200, 30);
        lblmembers.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmembers);

        tfteammembers = new JTextField();
        tfteammembers.setBounds(350, 270, 150, 30);
        add(tfteammembers);

        submit = new JButton("Submit");
        submit.setBounds(190, 400, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(370, 400, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String eventname = tfeventname.getText();
            String description = tfedescription.getText();
            int teammembers = Integer.parseInt(tfteammembers.getText());

            if (eventname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an event");
                setVisible(false);
                new AddEvent();
            } else if (description.equals("")) {
                JOptionPane.showMessageDialog(null, "Please explain in brief about the event");
                setVisible(false);
                new AddEvent();
            } else if (teammembers == 0 || teammembers > 4) {
                JOptionPane.showMessageDialog(null, "Maximum 4 team members can be in a team");
                setVisible(false);
                new AddEvent();
            } else {
                try {
                    String query = "insert into events values('" + eventname + "', '" + description + "', "
                            + teammembers + ")";
                    String query1 = "select * from events where eventname='" + eventname + "'";
                    Conn con = new Conn();
                    ResultSet rs = con.s.executeQuery(query1);
                    if (rs.next()) {
                        if (rs.getString("eventname").equals(eventname)) {
                            JOptionPane.showMessageDialog(null, "An event with the same name already exists");
                            setVisible(false);
                            new AddEvent();
                        }
                    } else {
                        con.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Event Details Added Successfully");
                        setVisible(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEvent();
    }
}
