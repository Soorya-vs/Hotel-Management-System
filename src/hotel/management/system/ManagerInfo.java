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
public class ManagerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    ManagerInfo(){
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(30,10,100,20);
        l1.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(145,10,100,20);
        l2.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(255,10,100,20);
        l3.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l3);
        
        JLabel l4=new JLabel("Job");
        l4.setBounds(370,10,100,20);
        l4.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l4);
        
        JLabel l5=new JLabel("Salary");
        l5.setBounds(480,10,100,20);
        l5.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l5);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(595,10,100,20);
        l6.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l6);
        
        JLabel l7=new JLabel("Email");
        l7.setFont(new Font("Quicksand", Font.BOLD, 14));
        l7.setBounds(710,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Aadhar");
        l8.setFont(new Font("Quicksand", Font.BOLD, 14));
        l8.setBounds(820,10,100,20);
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
            ResultSet rs=c.s.executeQuery("select * from employee where job='Manager'");
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
        new ManagerInfo();
    }
}
