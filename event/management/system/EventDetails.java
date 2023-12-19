package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class EventDetails extends JFrame implements ActionListener {

    JTable table;
    Choice ename;
    JButton search, print, update, add, cancel;

    EventDetails() {
        setTitle("Events Information");
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
            ResultSet rs = c.s.executeQuery("select * from events");
            while (rs.next()) {
                ename.add(rs.getString("eventname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from events");
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

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 600);
        setLocation(250, 60);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from events where eventname = '" + ename.getSelectedItem() + "'";
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
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EventDetails();
    }
}
