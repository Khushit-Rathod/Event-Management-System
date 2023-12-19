package event.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentProject extends JFrame implements ActionListener {

    StudentProject() {
        setTitle("Student Home Page");
        setSize(1350, 740);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1260, 670, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        // New Student Information
        JMenu newInformation = new JMenu("View Details");
        newInformation.setForeground(Color.BLUE);
        newInformation.addActionListener(this);
        mb.add(newInformation);

        JMenuItem studentinfo = new JMenuItem("Student Details");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newInformation.add(studentinfo);

        JMenuItem participationinfo = new JMenuItem("View Participation Details");
        participationinfo.setBackground(Color.WHITE);
        participationinfo.addActionListener(this);
        newInformation.add(participationinfo);

        // Add Event
        JMenu mbevent = new JMenu("Events");
        mbevent.setForeground(Color.RED);
        mb.add(mbevent);

        JMenuItem addevent = new JMenuItem("Events List");
        addevent.setBackground(Color.WHITE);
        addevent.addActionListener(this);
        mbevent.add(addevent);

        // Details
        JMenu details = new JMenu("Participate");
        details.setForeground(Color.BLUE);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("Participate in Event");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);

        JMenuItem upstudentinfo = new JMenuItem("Update Your Information");
        upstudentinfo.setBackground(Color.WHITE);
        upstudentinfo.addActionListener(this);
        updateInfo.add(upstudentinfo);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        // about
        JMenu about = new JMenu("About");
        about.setForeground(Color.RED);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand(); // to get string info of written content

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {

            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {

            }
        } else if (msg.equals("Student Details")) {
            new StudentDetails();
        } else if (msg.equals("Events List")) {
            new EventDetails();
        } else if (msg.equals("Participate in Event")) {
            new Participate();
        } else if (msg.equals("Update Your Information")) {
            new UpdateStudent();
        } else if (msg.equals("View Participation Details")) {
            new ParticipationDetails();
        } // else if (msg.equals("Remove Participants")) {
          // new RemoveParticipants();
          // }
        else if (msg.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new StudentProject();
    }
}
