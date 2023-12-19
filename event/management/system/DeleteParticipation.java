package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;

public class DeleteParticipation extends JFrame implements ActionListener {

    JTable table;
    Choice ename, tname;
    JButton submit, cancel;

    DeleteParticipation() {

        setTitle("Delete Participants");

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Delete Participation Details");
        heading.setBounds(300, 20, 300, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblename = new JLabel("Search by Event Name");
        lblename.setBounds(40, 70, 150, 20);
        add(lblename);

        ename = new Choice();
        ename.setBounds(200, 70, 150, 20);
        add(ename);

        try {
            Conn c = new Conn();
            String query = "select distinct eventname from participate";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                ename.add(rs.getString("eventname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbltname = new JLabel("Select Team Name to remove");
        lbltname.setBounds(450, 70, 220, 20);
        add(lbltname);

        tname = new Choice();
        tname.setBounds(680, 70, 150, 20);
        add(tname);

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from participate");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        ename.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                tname.removeAll();
                try {
                    Conn c = new Conn();
                    String query = "select * from participate where eventname='" + ename.getSelectedItem()
                            + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Conn c = new Conn();
                    String query = "select * from participate where eventname='" + ename.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        tname.add(rs.getString("teamname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 180, 900, 550);
        add(jsp);

        submit = new JButton("Submit");
        submit.setBounds(320, 120, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(470, 120, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setSize(900, 650);
        setLocation(300, 50);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String teamname = tname.getSelectedItem();
            String query = "delete from participate where eventname='" + teamname + "'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Participation Deleted");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteParticipation();
    }
}
