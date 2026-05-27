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
public class AddDriver extends JFrame implements ActionListener{
    
    JTextField tfname, tfage, tfbrand, tfmodel, tflocation;
    JComboBox gendercombo, availablecombo;
    JButton add, cancel;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblroomno = new JLabel("NAME");
        lblroomno.setBounds(150, 50, 150, 30);
        lblroomno.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblroomno);
        
        tfname = new JTextField();
        tfname.setBounds(325, 50, 250, 30);
        tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(150, 100, 150, 30);
        lblage.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(325, 100, 250, 30);
        tfage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfage);
        
        JLabel lblclean = new JLabel("GENDER");
        lblclean.setBounds(150, 150, 150, 30);
        lblclean.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblclean);
        
        String cleanOptions[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleanOptions);
        gendercombo.setBounds(325, 150, 250, 30);
        gendercombo.setBackground(Color.WHITE);
        gendercombo.setFont(new Font("Quicksand", Font.BOLD, 18));
        gendercombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(gendercombo);
        
        JLabel lblprice = new JLabel("CAR BRAND");
        lblprice.setBounds(150, 200, 150, 30);
        lblprice.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblprice);
        
        tfbrand = new JTextField();
        tfbrand.setBounds(325, 200, 250, 30);
        tfbrand.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfbrand);
        
        JLabel lbltype = new JLabel("CAR MODEL");
        lbltype.setBounds(150, 250, 150, 30);
        lbltype.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lbltype);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(325, 250, 250, 30);
        tfmodel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("AVAILABILITY");
        lblavailable.setBounds(150, 300, 150, 30);
        lblavailable.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblavailable);
        
        String driverOptions[] = {"Available", "Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(325, 300, 250, 30);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setFont(new Font("Quicksand", Font.BOLD, 18));
        availablecombo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("LOCATION");
        lbllocation.setBounds(150, 350, 150, 30);
        lbllocation.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(325, 350, 250, 30);
        tflocation.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tflocation);
        
        add = new JButton("ADD DRIVER");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(150, 425, 150, 30);
        add.setFont(new Font("Quicksand", Font.BOLD, 14));
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(425, 425, 150, 30);
        cancel.setFont(new Font("Quicksand", Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(650, 50, 250, 250);
        add(image);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == add){
             String name = tfname.getText();
             String age = tfage.getText();
             String gender = (String) gendercombo.getSelectedItem();
             String brand = tfbrand.getText();
             String model = tfmodel.getText();
             String available = (String) availablecombo.getSelectedItem();
             String location = tflocation.getText();
             
             try{
                 Conn conn = new Conn();
                 String str = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + brand + "','" + model + "','" + available + "','" + location + "')";
                 
                 conn.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                 setVisible(false);
             
             } catch (Exception e){
                 e.printStackTrace();
             }
             
        } else {
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new AddDriver();
    }
}
