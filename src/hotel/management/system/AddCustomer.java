/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
/**
 *
 * @author ash
 */
public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    AddCustomer(){
        
        
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblid=new JLabel("ID");
        lblid.setBounds(150, 30, 100, 30);
        lblid.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblid);
        
        String options[]={"Aadhar Card","Passport","Driving License","Voter-id"};
        comboid=new JComboBox(options);
        comboid.setBounds(270, 30, 250, 30);
        comboid.setBackground(Color.WHITE);
        comboid.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(comboid);
        
        JLabel lblnumber=new JLabel("NUMBER");
        lblnumber.setBounds(150, 80, 100, 30);
        lblnumber.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(270, 80, 250, 30);
        tfnumber.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfnumber);
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(150, 130, 100, 30);
        lblname.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(270, 130, 250, 30);
        tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfname);
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(150, 180, 100, 30);
        lblgender.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblgender);
        
        rmale=new JRadioButton("Male");
        rmale.setBounds(270, 180, 80, 30);
        rmale.setFont(new Font("Quicksand",Font.BOLD, 15));
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(350, 180, 80, 30);
        rfemale.setFont(new Font("Quicksand",Font.BOLD, 15));
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        JLabel lblcountry=new JLabel("COUNTRY");
        lblcountry.setBounds(150, 230, 100, 30);
        lblcountry.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(270, 230, 250, 30);
        tfcountry.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfcountry);
        
        JLabel lblroom=new JLabel("ROOM NO");
        lblroom.setBounds(150, 280, 100, 30);
        lblroom.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblroom);
        
        croom = new Choice();
        croom.setFont(new Font("Quicksand", Font.BOLD, 16));
        try {
            Conn conn = new Conn();
            String query = "select * from room where availability ='Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(270, 280, 250, 30);
        add(croom);
        
        JLabel lbltime=new JLabel("CHECKIN");
        lbltime.setBounds(150, 330, 100, 30);
        lbltime.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lbltime);
        
        Date date=new Date();
        
        checkintime=new JLabel(""+date);
        checkintime.setBounds(270, 330, 300, 30);
        checkintime.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(checkintime);
        
        JLabel lbldeposit=new JLabel("DEPOSIT");
        lbldeposit.setBounds(150, 380, 100, 30);
        lbldeposit.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lbldeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(270, 380, 250, 30);
        tfdeposit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfdeposit);
        
        add=new JButton("ADD");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(150, 430, 150, 30);
        add.setFont(new Font("Quicksand", Font.BOLD, 14));
        add.addActionListener(this);
        add(add);
        
        back=new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(370, 430, 150, 30);
        back.setFont(new Font("Quicksand", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(650, 50, 250, 250);
        add(image);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==add){
            String id = (String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            
            if(rmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=checkintime.getText();
            String deposit=tfdeposit.getText();
            
            try{
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2="update room set availability='Occupied' where roomnumber = '"+room+"'";
                
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New customer added successfully");
                
                setVisible(false);
                new Reception();
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        
        new AddCustomer();
    }
}

