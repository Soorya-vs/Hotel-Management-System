/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

/**
 *
 * @author ash
 */
public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblbed=new JLabel("Car Type");
        lblbed.setBounds(30,100,100,20);
        lblbed.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(lblbed);
        
        typeofcar=new Choice();
        typeofcar.setBounds(150,100,150,25);        
        add(typeofcar);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(30,150,100,20);
        l1.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(160,150,100,20);
        l2.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(290,150,100,20);
        l3.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l3);
        
        JLabel l4=new JLabel("Company");
        l4.setBounds(415,150,100,20);
        l4.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l4);
        
        JLabel l5=new JLabel("Brand");
        l5.setBounds(545,150,100,20);
        l5.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l5);
        
        JLabel l6=new JLabel("Availability");
        l6.setBounds(675,150,100,20);
        l6.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(800,150,100,20);
        l7.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l7);
        
        table=new JTable();
        table.setBounds(30, 200, 900, 200);
        table.setBorder(new LineBorder(Color.BLACK, 2));
        table.setRowHeight(20);
        table.setFont(new Font("Quicksand", Font.BOLD, 14));
        table.setForeground(Color.DARK_GRAY);
        
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(590, 430, 150, 30);
        back.setFont(new Font("Quicksand", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(220, 430, 150, 30);
        submit.setFont(new Font("Quicksand", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            try{
                String query="select * from driver where brand ='"+typeofcar.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                
                rs=conn.s.executeQuery(query);                              
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
        setVisible(false);
        new Reception();
        }
    }
    public static void main(String[] args){
        new Pickup();
    }
}