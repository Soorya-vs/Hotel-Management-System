/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import net.proteanit.sql.*;

/**
 *
 * @author ash
 */
public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Document");
        l1.setBounds(30,10,100,20);
        l1.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l1);
        
        JLabel l2=new JLabel("Number");
        l2.setBounds(140,10,100,20);
        l2.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(255,10,100,20);
        l3.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(370,10,100,20);
        l4.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l4);
        
        JLabel l5=new JLabel("Country");
        l5.setBounds(480,10,100,20);
        l5.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l5);
        
        JLabel l6=new JLabel("Room No");
        l6.setBounds(595,10,100,20);
        l6.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l6);
        
        JLabel l7=new JLabel("Checkin Time");
        l7.setBounds(705,10,100,20);
        l7.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l7);
        
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(820,10,100,20);
        l8.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l8);
        
        table=new JTable();
        table.setBounds(30, 50, 900, 350);
        table.setBorder(new LineBorder(Color.BLACK, 2));
        table.setRowHeight(20);
        table.setFont(new Font("Quicksand", Font.BOLD, 14));
        table.setForeground(Color.DARK_GRAY);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(370, 430, 150, 30);
        back.setFont(new Font("Quicksand", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new CustomerInfo();
    }
}
