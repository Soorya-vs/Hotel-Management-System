/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author ash
 */
public class AddRooms extends JFrame implements ActionListener{
    
    JTextField tfroom,tfprice;
    JComboBox availablecombo,cleancombo,typecombo;
    JButton add,cancel;
    
    AddRooms(){
        
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblroomno=new JLabel("ROOM NO");
        lblroomno.setBounds(150, 50, 100, 30);
        lblroomno.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblroomno);
        
        tfroom=new JTextField();
        tfroom.setBounds(300, 50, 250, 30);
        tfroom.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfroom);
        
        JLabel lblavailable=new JLabel("AVAILABLE");
        lblavailable.setBounds(150, 100, 100, 30);
        lblavailable.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblavailable);
        
        String availableOptions[]={"Available", "Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(300, 100, 250, 30);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setFont(new Font("Quicksand", Font.BOLD, 18));
        availablecombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(availablecombo);
        
        JLabel lblclean=new JLabel("STATUS");
        lblclean.setBounds(150, 150, 100, 30);
        lblclean.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblclean);
        
        String cleanOptions[]={"Cleaned", "Uncleaned"};
        cleancombo=new JComboBox(cleanOptions);
        cleancombo.setBounds(300, 150, 250, 30);
        cleancombo.setBackground(Color.WHITE);
        cleancombo.setFont(new Font("Quicksand", Font.BOLD, 18));
        cleancombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(cleancombo);
        
        JLabel lblprice=new JLabel("PRICE");
        lblprice.setBounds(150, 200, 100, 30);
        lblprice.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(300, 200, 250, 30);
        tfprice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfprice);
        
        JLabel lbltype=new JLabel("BED TYPE");
        lbltype.setBounds(150, 250, 100, 30);
        lbltype.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lbltype);
        
        String typeOptions[]={"Single Bed", "Double Bed"};
        typecombo=new JComboBox(typeOptions);
        typecombo.setBounds(300, 250, 250, 30);
        typecombo.setBackground(Color.WHITE);
        typecombo.setFont(new Font("Quicksand", Font.BOLD, 18));
        typecombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(typecombo);
        
        add=new JButton("ADD ROOM");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(150, 350, 150, 30);
        add.setFont(new Font("Quicksand", Font.BOLD, 14));
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(400, 350, 150, 30);
        cancel.setFont(new Font("Quicksand", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(650, 50, 250, 250);
        add(image);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource()==add){
             String roomnumber=tfroom.getText();
             String availability=(String) availablecombo.getSelectedItem();
             String status=(String) cleancombo.getSelectedItem();
             String price=tfprice.getText();
             String type=(String) typecombo.getSelectedItem();
             
             try{
             
             Conn conn=new Conn();
             String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
             
             conn.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null, "Room Updated Successfully");
             setVisible(false);
             
             }catch (Exception e){
             
                 e.printStackTrace();
             
             }
             
        }else{
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new AddRooms();
    }
}
