package com;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class Employee extends JFrame implements ActionListener
{
     private JTextField t1,t2,t3;
     private JLabel l1,l2,l3;
     private JButton bins,bsrch;
     
	public Employee()
	{
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		l1 = new JLabel("Enter Id");
		l2 = new JLabel("Enter Name");
		l3 = new JLabel("Enter Salary");
		bins = new JButton("Save");
		bsrch = new JButton("Search");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout gl = new GridLayout(4,2);
		setLayout(gl);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(bins);
		add(bsrch);
		
		setSize(400,300);
		setVisible(true);
		bins.addActionListener(this);
		bsrch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bins)
		{
			int id = Integer.valueOf(t1.getText());
			double sal = Double.valueOf(t3.getText());
			try
			{
	Connection con = Database.dataConnection();
				String str = "insert into employee values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1,id);
		ps.setString(2,t2.getText());
		ps.setDouble(3,sal);
		boolean b = ps.execute();
		if(b=true)
		{
			JOptionPane.showInputDialog(null,"Value inserted");
		}
		ps.close();
		t1.setText("");
		t2.setText("");
		t3.setText("");
			}catch(Exception e)
			{
				JOptionPane.showInputDialog(null,"Error " +e);
			}
		}
		//search
		if(ae.getSource()==bsrch)
		{
			try
			{
				int id = Integer.valueOf(t1.getText());
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","adi123");
				System.out.println("Database connected....");

				Statement stmt = con.createStatement();
				String str = "select * from employee where id = "+id+"";
				ResultSet rs = stmt.executeQuery(str);
				while(rs.next())
				{
					t1.setText(""+rs.getInt(1));
					t2.setText(rs.getString(2));
					t3.setText(""+rs.getDouble(3));
				}

			}catch(Exception e)
			{
				
			}
		}
	}
	public static void main(String[] args) 
	{
		new Employee();
	}
}
