package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;

/**
 *
 * @author ash
 */
public class Checkout extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back,check;
    
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(50, 50, 150, 30);
        lblid.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblid);
                
        ccustomer = new Choice();
        ccustomer.setBounds(250, 50, 250, 30);
        add(ccustomer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(650, 50, 250, 250);
        add(image);
        
        JLabel lblroom = new JLabel("Room No");
        lblroom.setBounds(50, 100, 150, 30);
        lblroom.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblroom);
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(250, 100, 300, 30);
        lblroomnumber.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(50, 150, 150, 30);
        lblcheckin.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblcheckin);
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(250, 150, 300, 30);
        lblcheckintime.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(50, 200, 150, 30);
        lblcheckout.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblcheckout);
        
        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(250, 200, 300, 30);
        lblcheckouttime.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblcheckouttime);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(405, 430, 150, 30);
        checkout.setFont(new Font("Quicksand", Font.BOLD, 14));
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(590, 430, 150, 30);
        back.setFont(new Font("Quicksand", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(220, 430, 150, 30);
        check.setFont(new Font("Quicksand", Font.BOLD, 14));
        check.addActionListener(this);
        add(check);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkout) {
            String query1 = "delete from customer where number = '" + ccustomer.getSelectedItem() + "'";
            String query2 = "update room set availability = 'Available' where roomnumber = '" + lblroomnumber.getText() + "'";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1); // Remove customer from the database
                c.s.executeUpdate(query2); // Update room availability
                
                JOptionPane.showMessageDialog(null, "Checkout done");
                
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == check) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer where number = '" + ccustomer.getSelectedItem() + "'");
                if (rs.next()) {
                    lblroomnumber.setText(rs.getString("room"));
                    lblcheckintime.setText(rs.getString("checkintime"));
                    lblcheckouttime.setText(new Date().toString());
                }
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Checkout();
    }
}