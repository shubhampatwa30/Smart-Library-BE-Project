package com;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
	private JTextField t1,t2;
	private JButton b1;
	private JLabel L1,L2;
	
	public MyFrame()
	{
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		b1 = new JButton("Click");
		L1=new JLabel("Open");
		L2=new JLabel("Close");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(5,1));
		add(L1);
		add(t1);
		
		add(L2);
		add(t2);
		add(b1);
		
		setSize(400,300);
		setVisible(true);
		
		b1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String str = t1.getText();
			t2.setText(str);
			t1.setText("");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new MyFrame();
	}

}
