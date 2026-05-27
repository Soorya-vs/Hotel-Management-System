/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;

/**
 *
 * @author ash
 */
public class HotelManagementSystem extends JFrame {
    
    HotelManagementSystem (){
        setBounds(480, 270, 960, 540);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 960, 540);
        add(image);
        
        Timer timer = new Timer(1000, e -> {
            setVisible(false);
            new Login();
        });
        timer.setRepeats(false);
        timer.start();
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}