package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ParticipationDetails extends JFrame implements ActionListener {

    JTable table;
    Choice ename;
    JButton search, print, update, add, cancel;

    ParticipationDetails() {
        setTitle("Participation Details");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Event Name");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        ename = new Choice();
        ename.setBounds(180, 20, 150, 20);
        add(ename);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select distinct eventname from participate");
            while (rs.next()) {
                ename.add(rs.getString("eventname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from participate");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 900, 550);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(40, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(160, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        // add = new JButton("Add");
        // add.setBounds(220, 70, 80, 20);
        // add.addActionListener(this);
        // add(add);

        // update = new JButton("Update");
        // update.setBounds(320, 70, 80, 20);
        // update.addActionListener(this);
        // add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 650);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from participate where eventname = '" + ename.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // else if (ae.getSource() == add) {
          // setVisible(false);
          // new AddStudent();
          // } else if (ae.getSource() == update) {
          // setVisible(false);
          // new UpdateStudent();
          // }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ParticipationDetails();
    }
}
