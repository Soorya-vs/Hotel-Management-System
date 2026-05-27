package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author ash
 */
public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit, cancel;
    JComboBox cbjob;
    
    AddEmployee() {
        setLayout(null);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(150, 30, 100, 30);
        lblname.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(270, 30, 250, 30);
        tfname.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(150, 70, 100, 30);
        lblage.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(270, 70, 250, 30);
        tfage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(150, 110, 100, 30);
        lblgender.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(270, 110, 80, 30);
        rbmale.setFont(new Font("Quicksand", Font.BOLD, 15));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(350, 110, 80, 30);
        rbfemale.setFont(new Font("Quicksand", Font.BOLD, 15));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(150, 150, 100, 30);
        lbljob.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lbljob);
        
        String str[] = {"Front Desk Clerk", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(270, 150, 150, 30);
        cbjob.setBackground(Color.WHITE);
        cbjob.setFont(new Font("Quicksand", Font.BOLD, 14));
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(150, 190, 100, 30);
        lblsalary.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(270, 190, 250, 30);
        tfsalary.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(150, 230, 100, 30);
        lblphone.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(270, 230, 250, 30);
        tfphone.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfphone);
        
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(150, 270, 100, 30);
        lblemail.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(270, 270, 250, 30);
        tfemail.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(150, 310, 100, 30);
        lblaadhar.setFont(new Font("Quicksand", Font.BOLD, 18));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(270, 310, 250, 30);
        tfaadhar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(tfaadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(150, 375, 150, 30);
        submit.setFont(new Font("Quicksand", Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(370, 375, 150, 30);
        cancel.setFont(new Font("Quicksand", Font.BOLD, 14));
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(650, 50, 250, 250);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(480, 270, 960, 540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        
        String gender = null;
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }
        
        if (age.equals("") || !age.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid age");
            return;
        }
        
        if (gender == null && !rbmale.isSelected() && !rbfemale.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select a gender");
            return;
        }
        
        if (salary.equals("") || !salary.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid salary");
            return;
        }
        
        if (phone.equals("") || !phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number");
            return;
        }
        
        if (email.equals("") || !email.contains("@") || !email.matches(".*\\.[a-z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return;
        }

        if (aadhar.equals("") || !aadhar.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit Aadhar number");
            return;
        }

        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }
        
        String job = (String) cbjob.getSelectedItem();
        try {
            Conn conn = new Conn();
            
            String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            
            setVisible(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new AddEmployee();
    }
}
