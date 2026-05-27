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
public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(30,100,100,20);
        lblbed.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(lblbed);
        
        bedType=new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        bedType.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(bedType);
        
        available=new JCheckBox("Only display available");
        available.setBounds(570,100,200,25);
        available.setBackground(Color.WHITE);
        available.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(available);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(30,150,100,20);
        l1.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l1);
        
        JLabel l2=new JLabel("Availability");
        l2.setBounds(205,150,100,20);
        l2.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(390,150,100,20);
        l3.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(570,150,100,20);
        l4.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l4);
        
        JLabel l5=new JLabel("Bedtype");
        l5.setBounds(750,150,100,20);
        l5.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(l5);
        
        table=new JTable();
        table.setBounds(30, 200, 900, 200);
        table.setBorder(new LineBorder(Color.BLACK, 2));
        table.setRowHeight(20);
        table.setFont(new Font("Quicksand", Font.BOLD, 14));
        table.setForeground(Color.DARK_GRAY);
        
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
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
                String query1="select * from room where bed_type ='"+bedType.getSelectedItem()+"'";
                String query2="select * from room where availability = 'Available' AND bed_type='"+bedType.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                if (available.isSelected()){
                    rs=conn.s.executeQuery(query2);
                }else{
                    rs=conn.s.executeQuery(query1);              
                }
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
        new SearchRoom();
    }
}
