package event.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setTitle("About");
        setSize(900, 520);
        setLocation(300, 100);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 300, 200);
        add(image);

        JLabel heading = new JLabel("<html>Event<br/>Management System</html>");
        heading.setBounds(120, 40, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Developed By:");
        name.setBounds(50, 260, 500, 35);
        name.setFont(new Font("Tahoma", Font.BOLD, 27));
        add(name);

        JLabel mname = new JLabel("Name: Manali Jain");
        mname.setBounds(55, 320, 200, 30);
        mname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(mname);

        JLabel mrollno = new JLabel("Roll number: 332035");
        mrollno.setBounds(55, 340, 200, 30);
        mrollno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(mrollno);

        JLabel mprn = new JLabel("PRN: 22110360");
        mprn.setBounds(55, 360, 200, 30);
        mprn.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(mprn);

        JLabel pname = new JLabel("Name: Prasad Nathe");
        pname.setBounds(260, 320, 200, 30);
        pname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pname);

        JLabel prollno = new JLabel("Roll number: 332038");
        prollno.setBounds(260, 340, 200, 30);
        prollno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(prollno);

        JLabel pprn = new JLabel("PRN: 22110206");
        pprn.setBounds(260, 360, 200, 30);
        pprn.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pprn);

        JLabel nname = new JLabel("Name: Navneet Tiwari");
        nname.setBounds(465, 320, 200, 30);
        nname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(nname);

        JLabel nrollno = new JLabel("Roll number: 332039");
        nrollno.setBounds(465, 340, 200, 30);
        nrollno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(nrollno);

        JLabel nprn = new JLabel("PRN: 22110002");
        nprn.setBounds(465, 360, 200, 30);
        nprn.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(nprn);

        JLabel kname = new JLabel("Name: Khushit Rathod");
        kname.setBounds(670, 320, 200, 30);
        kname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(kname);

        JLabel krollno = new JLabel("Roll number: 332049");
        krollno.setBounds(670, 340, 200, 30);
        krollno.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(krollno);

        JLabel kprn = new JLabel("PRN: 22110024");
        kprn.setBounds(670, 360, 200, 30);
        kprn.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(kprn);

        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
