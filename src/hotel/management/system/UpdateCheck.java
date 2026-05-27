/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author ash
 */
public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfpaid, tfpending;
    JButton check, update, back;
    
    UpdateCheck() {       
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(50, 50, 150, 30);
        lblid.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(250, 50, 250, 30);
        add(ccustomer);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room No");
        lblroom.setBounds(50, 100, 150, 30);
        lblroom.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(250, 100, 250, 30);
        tfroom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(250, 150, 250, 30);
        tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfname);
        
        JLabel lblcheckin = new JLabel("Check in time");
        lblcheckin.setBounds(50, 200, 150, 30);
        lblcheckin.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(250, 200, 250, 30);
        tfcheckin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount paid");
        lblpaid.setBounds(50, 250, 150, 30);
        lblpaid.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(250, 250, 250, 30);
        tfpaid.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Pending amount");
        lblpending.setBounds(50, 300, 150, 30);
        lblpending.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(250, 300, 250, 30);
        tfpending.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfpending);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(220, 430, 150, 30);
        check.setFont(new Font("Quicksand", Font.BOLD, 14));
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(405, 430, 150, 30);
        update.setFont(new Font("Quicksand", Font.BOLD, 14));
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(590, 430, 150, 30);
        back.setFont(new Font("Quicksand", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/checkin.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(650, 50, 250, 250);
        add(image);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkintime"));
                    tfpaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                while (rs2.next()){
                    String price=rs2.getString("price");
                    int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
                    tfpending.setText(""+amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfpaid.getText();
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room = '"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"'");
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args) {
        new UpdateCheck();
    }
}
