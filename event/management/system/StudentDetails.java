package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener {

    JTable table;
    Choice prnno;
    JButton search, print, update, add, cancel;

    StudentDetails() {
        setTitle("Student Information");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by PRN");
        heading.setBounds(60, 20, 100, 20);
        add(heading);

        prnno = new Choice();
        prnno.setBounds(180, 20, 150, 20);
        add(prnno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                prnno.add(rs.getString("prn"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 900, 550);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(70, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(170, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        // add = new JButton("Add");
        // add.setBounds(220, 70, 80, 20);
        // add.addActionListener(this);
        // add(add);

        update = new JButton("Update");
        update.setBounds(270, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(370, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 650);
        setLocation(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student where prn = '" + prnno.getSelectedItem() + "'";
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
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateStudent();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
