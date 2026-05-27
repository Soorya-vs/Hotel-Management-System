/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ash
 */
public class Dashboard extends JFrame implements ActionListener {
    Dashboard() {

        setBounds(480, 270, 960, 540);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dash.png"));
        Image i2 = i1.getImage().getScaledInstance(960, 540, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 960, 540);
        add(image);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 960, 30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.black);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.black);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("Add Employee");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms = new JMenuItem("Add Room");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddrivers = new JMenuItem("Add Drivers");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Add Employee")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("Add Room")) {
            new AddRooms();
        }else if (ae.getActionCommand().equals("Add Drivers")) {
            new AddDriver();
        }else if (ae.getActionCommand().equals("Reception")) {
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
