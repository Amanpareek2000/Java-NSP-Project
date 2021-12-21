
package com.mycompany.facultyfeedbackform;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


class MyFrame extends JFrame implements ActionListener {
    
      Connection con=null;
      PreparedStatement pat = null;
      ResultSet rs = null;
      
     
    JLabel heading,studentName,rollNo,subject,q1,q2,q3,q4,q5,q6;
    JFrame frame = new JFrame();
    JButton jButton;
    TextField nameTextField = new TextField(20);
    TextField rollNoTextField = new TextField(20);
    Choice sub = new Choice();
    Choice ec1 = new Choice();
    Choice ec2 = new Choice();
    Choice ec3 = new Choice();
    Choice ec4 = new Choice();
    Choice ec5 = new Choice();
    Choice ec6 = new Choice();

    MyFrame(){
        con = DbConnection.connectionDb();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,50,800,700);
        frame.setTitle("Faculty FeedBack Form");
        Container container = frame.getContentPane();
        container.setLayout(null);
        heading = new JLabel("Faculty FeedBack Form");
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        heading.setBounds(250,30,250,20);
        studentName = new JLabel("Name : ",JLabel.LEFT);
        rollNo = new JLabel("RollNo : ",JLabel.LEFT);
        subject = new JLabel("Subject : ",JLabel.LEFT);

        q1=new JLabel("1. Teacher is prepared for class : ",JLabel.LEFT);
        q2=new JLabel("2. Teacher knows His/Her Subject : ",JLabel.LEFT);
        q3=new JLabel("3. Teacher is Organised and neet : ",JLabel.LEFT);
        q4=new JLabel("4. Teacher Plans class time and Assignments : ",JLabel.LEFT);
        q5= new JLabel("5. Teacher is flexible : ",JLabel.LEFT);
        q6=new JLabel("6. Teacher is clear about assignments and test : ",JLabel.LEFT);


        studentName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        studentName.setBounds(10,100,350,20);
        rollNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rollNo.setBounds(10,150,350,20);
        subject.setFont(new Font("Tahoma", Font.PLAIN, 20));
        subject.setBounds(10,200,310,20);
        q1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        q1.setBounds(10,300,310,30);
        q2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        q2.setBounds(10,350,340,30);
        q3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        q3.setBounds(10,400,340,30);
        q4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        q4.setBounds(10,450,420,30);
        q5.setBounds(10,500,420,30);
        q5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        q6.setBounds(10,550,450,30);
        q6.setFont(new Font("Tahoma", Font.PLAIN, 20));


        container.add(heading);
        container.add(studentName);
        container.add(rollNo);
        container.add(subject);
        container.add(q1);
        container.add(q2);
        container.add(q3);
        container.add(q4);
        container.add(q5);
        container.add(q6);




        nameTextField.setBounds(600,100,100,20);
        rollNoTextField.setBounds(600,150,100,20);
        container.add(nameTextField);
        container.add(rollNoTextField);




        sub.add("TOC"); sub.add("CD"); sub.add("WC"); sub.add("Java"); sub.add("OOPS");
        ec1.add("Strongly Disagree"); ec1.add("Disagree"); ec1.add("Neutral"); ec1.add("Agree"); ec1.add("Strongly Agree");
        ec2.add("Strongly Disagree"); ec2.add("Disagree"); ec2.add("Neutral"); ec2.add("Agree"); ec2.add("Strongly Agree");
        ec3.add("Strongly Disagree"); ec3.add("Disagree"); ec3.add("Neutral"); ec3.add("Agree"); ec3.add("Strongly Agree");
        ec4.add("Strongly Disagree"); ec4.add("Disagree"); ec4.add("Neutral"); ec4.add("Agree"); ec4.add("Strongly Agree");
        ec5.add("Strongly Disagree"); ec5.add("Disagree"); ec5.add("Neutral"); ec5.add("Agree"); ec5.add("Strongly Agree");
        ec6.add("Strongly Disagree"); ec6.add("Disagree"); ec6.add("Neutral"); ec6.add("Agree"); ec6.add("Strongly Agree");

        sub.setBounds(600, 200, 150, 20);
        ec1.setBounds(600, 450, 150, 20);
        ec2.setBounds(600, 400, 150, 20);
        ec3.setBounds(600, 350, 150, 20);
        ec4.setBounds(600, 300, 150, 20);
        ec5.setBounds(600, 500, 150, 20);
        ec6.setBounds(600, 555, 150, 20);

        container.add(sub);
        container.add(ec1);
        container.add(ec2);
        container.add(ec3);
        container.add(ec4);
        container.add(ec5);
        container.add(ec6);

        jButton = new JButton("Submit Feedback");
        jButton.setBounds(300,610,200,40);
        container.add(jButton);

        jButton.addActionListener(this);


        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String studentName = nameTextField.getText();
        String rollNo = rollNoTextField.getText();
        String subjectSelected = sub.getItem(sub.getSelectedIndex());
        String question1_Output = ec1.getItem(ec1.getSelectedIndex());
        String question2_Output = ec2.getItem(ec2.getSelectedIndex());
        String question3_Output = ec3.getItem(ec3.getSelectedIndex());
        String question4_Output = ec4.getItem(ec4.getSelectedIndex());
        String question5_Output = ec5.getItem(ec5.getSelectedIndex());
        String question6_Output = ec6.getItem(ec6.getSelectedIndex());
      
    String sql = "INSERT INTO Faculty(StudentName,RollNo,SubjectName,Question1,Question2,Question3,Question4,Question5,Question6)VALUES(?,?,?,?,?,?,?,?,?)";
   try{
       pat = con.prepareStatement(sql);
       pat.setString(1,studentName);
       pat.setString(2,rollNo);
       pat.setString(3,subjectSelected);
       pat.setString(4,question1_Output);
       pat.setString(5,question2_Output);
       pat.setString(6,question3_Output);
       pat.setString(7,question4_Output);
       pat.setString(8,question5_Output);
       pat.setString(9,question6_Output);
       pat.execute();
       JOptionPane.showMessageDialog(null,"Inserted Successfully");
        
   }catch(SQLException error){
       JOptionPane.showMessageDialog(null,error);
        System.out.println(error.getMessage());
   }finally{
            try {
                pat.close();
            } catch (SQLException ex) {
                Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
      
        
    }
}


public class FacultyForm {
    
    public static void main(String[] args)
    {
        MyFrame myFrame = new MyFrame();
    }
}
