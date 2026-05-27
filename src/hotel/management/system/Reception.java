/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author ash
 */
public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,department,allEmployee,customers,managerInfo,checkout,update,roomStatus,pickup,searchRoom,logout;
    
    Reception(){
        
        getContentPane() .setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer=new JButton("New Customer");
        newCustomer.setBounds(100, 20, 240, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setFont(new Font("Quicksand", Font.BOLD, 18));
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms=new JButton("Rooms");
        rooms.setBounds(100, 60, 240, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFont(new Font("Quicksand", Font.BOLD, 18));
        rooms.addActionListener(this);
        add(rooms);
        
        department=new JButton("Department");
        department.setBounds(100, 100, 240, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setFont(new Font("Quicksand", Font.BOLD, 18));
        department.addActionListener(this);
        add(department);
        
        allEmployee=new JButton("All Employees");
        allEmployee.setBounds(100, 140, 240, 30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setFont(new Font("Quicksand", Font.BOLD, 18));
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customers=new JButton("Customer Info");
        customers.setBounds(100, 180, 240, 30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.setFont(new Font("Quicksand", Font.BOLD, 18));
        customers.addActionListener(this);
        add(customers);
        
        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(100, 220, 240, 30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setFont(new Font("Quicksand", Font.BOLD, 18));
        managerInfo.addActionListener(this);
        add(managerInfo);
        
        checkout=new JButton("Checkout");
        checkout.setBounds(100, 260, 240, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Quicksand", Font.BOLD, 18));
        checkout.addActionListener(this);
        add(checkout);
        
        update=new JButton("Update Status");
        update.setBounds(100, 300, 240, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Quicksand", Font.BOLD, 18));
        update.addActionListener(this);
        add(update);
        
        roomStatus=new JButton("Update Room Status");
        roomStatus.setBounds(100, 340, 240, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setFont(new Font("Quicksand", Font.BOLD, 18));
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickup=new JButton("Pickup Service");
        pickup.setBounds(100, 380, 240, 30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setFont(new Font("Quicksand", Font.BOLD, 18));
        pickup.addActionListener(this);
        add(pickup);
        
        searchRoom=new JButton("Search Room");
        searchRoom.setBounds(100, 420, 240, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setFont(new Font("Quicksand", Font.BOLD, 18));
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logout=new JButton("Logout");
        logout.setBounds(100, 460, 240, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Quicksand", Font.BOLD, 18));
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(400, 55, 400, 400);
        add(image);
        
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if (ae.getSource()==newCustomer){
        setVisible(false);
        new AddCustomer();
    }else if(ae.getSource()==rooms){
        setVisible(false);
        new Room();
    }else if(ae.getSource()==department){
        setVisible(false);
        new Department();
    }else if(ae.getSource()==allEmployee){
        setVisible(false);
        new EmployeeInfo();
    }else if(ae.getSource()==managerInfo){
        setVisible(false);
        new ManagerInfo();
    }else if(ae.getSource()==customers){
        setVisible(false);
        new CustomerInfo();
    }else if(ae.getSource()==searchRoom){
        setVisible(false);
        new SearchRoom();
    }else if(ae.getSource()==update){
        setVisible(false);
        new UpdateCheck();
    }else if(ae.getSource()==roomStatus){
        setVisible(false);
        new UpdateRoom();
    }else if(ae.getSource()==pickup){
        setVisible(false);
        new Pickup();
    }else if(ae.getSource()==checkout){
        setVisible(false);
        new Checkout();       
    }else if(ae.getSource()==logout){
        setVisible(false);
        System.exit(0);       
    }
    }
    public static void main(String[] args){
        new Reception();
    }
}
