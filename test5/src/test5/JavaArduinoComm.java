package test5;

import arduino.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
//import test4.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.sql.*;
import javax.swing.JLabel;


public class JavaArduinoComm {
	static String rfid,read,read1,book1,book,name,dor,bok_name,doer,pass1,bnn="",ph2;
	//static java.sql.Date  doer;
	static java.sql.Date doi;
	static int books_issue;
	static long fine=0;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	static Date date = new Date();
	static	Arduino  obj =new Arduino("COM5", 9600);
	static String ph="";



	public static void issuemain() {

		obj.openConnection();

		while(true)
		{
			read = obj.serialRead();
			int length = read.length();
			System.out.println(read);
			if(length>=10)
			{
				System.out.println(read);
				read1 = (read.substring(0, read.length() - 2));
				break;
			}

		}
}

	
	public static void returnmain() {
		
		obj.openConnection();
		System.out.print("Scan the book to return");
		while(true)
		{
			book = obj.serialRead();
			int length = book.length();
			if(length>=10)
			{
				System.out.println(book);
				book1 = (book.substring(0, book.length() - 2));
				System.out.println(book1);
				
				break;
			}
		}
		obj.closeConnection();
		System.out.println("connection terminated");


}






	public static void issue()
	{

		try {
			Connection con = Database.dataConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from library.student where rfid='"+read1+"'");

			while(rs.next())
			{  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8));

			books_issue = rs.getInt(8);
			name = rs.getString(2); 
			String 	phone=rs.getString(5);
			ph=phone;	
			System.out.println(ph);
			System.out.println("You have issued "+books_issue+" books");	
			
			break;
			}
			con.close();
			if(books_issue<3)
			{
				gui6.issuegui2(name);

			}
			else
			{
				gui6.issuegui1(name);
			}


		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public static void bookconn() {



	//	obj.openConnection();

		
		while(true)
		{	
			book = obj.serialRead();
			int length1 = book.length();
			
			if(length1>=10)
			{
				System.out.println(book);
				book1 = (book.substring(0, book.length() - 2));
				break;
			}
		}
		obj.closeConnection();
	}

	public static void bookissue() {
		try {
			Connection con = Database.dataConnection();
			Statement stmt=con.createStatement();


			ResultSet rs1=stmt.executeQuery("select * from library.books where rfid='"+book1+"'");

			while(rs1.next())
			{  System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  "+rs1.getString(4)+"	"+rs1.getInt(5)+"  "+rs1.getString(6)+"  "+rs1.getString(7)+"  "+rs1.getInt(8));
				
			break;
			}
			rs1.close();


			int x=stmt.executeUpdate("UPDATE books SET issued_to='"+name+"' WHERE rfid='"+book1+"'"); 
			books_issue++;
			stmt.executeUpdate("UPDATE student SET books_issue='"+books_issue+"' WHERE rfid='"+read1+"'");

			System.out.println(sdf.format(date));
			String doi = (sdf.format(date));
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(doi));
			c.add(Calendar.DATE, 15);
			doer = sdf.format(c.getTime());
			int zz=stmt.executeUpdate("UPDATE library.books SET dor=null WHERE rfid='"+book1+"'");
			int z=stmt.executeUpdate("UPDATE books SET doi='"+doi+"' WHERE rfid='"+book1+"'");
			int d=stmt.executeUpdate("UPDATE books SET doer='"+doer+"' WHERE rfid='"+book1+"'");
			int i=stmt.executeUpdate("UPDATE books SET status='issued' WHERE rfid='"+book1+"'");

			ResultSet rs2=stmt.executeQuery("select * from library.books where rfid='"+book1+"'");
			
			while(rs2.next())
			{  System.out.println(rs2.getInt(1)+"  "+rs2.getString(2)+"  "+rs2.getString(3)+"  "+rs2.getString(4)+"	"+rs2.getInt(5)+"  "+rs2.getString(6)+"  "+rs2.getString(7)+"  "+rs2.getString(8)+"  ");

			String 	bn=rs2.getString(2);
			bnn=bn;
			break;

			}
			con.close();
			
		
			System.out.println("Sucessfullyupdated");
			gsmissue(doi);
			
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}



	}

	public static void gotoguiissue3()
	{
		gui6.issuegui3(bnn,doer);
	}
	
	public static void gsmreturn() throws Exception{
		obj.openConnection();
		String msg2;
		Thread.sleep(1000);
		
		msg2="Hello, You have returned book "+bok_name+" on " +dor+" and fine is "+fine+".";
		Thread.sleep(1500);
		obj.serialWrite(msg2);
		Thread.sleep(1500);

		

		Thread.sleep(1500);
		obj.serialWrite(ph2);
		Thread.sleep(1500);

		System.out.println("successfully returned");
obj.closeConnection();


		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

		public static void gsmissue(String doi) throws Exception
				{
			
			obj.openConnection();
			Thread.sleep(1000);
			String pp1;
			
			pp1=ph+"\0";
			String msg,msg1;
			

			msg="You have issued "+bnn+" book on " +doi+" ";
			msg1="and should return it on or before "+doer+".\n";
			
			

			Thread.sleep(1000);
			obj.serialWrite(msg);
			
			
		Thread.sleep(1000);
			obj.serialWrite(msg1);
			
			Thread.sleep(1000);
			obj.serialWrite(pp1);
			Thread.sleep(1000);
			System.out.println("Sucessfullyupdated");
obj.closeConnection();
	}


	 



	public static void returnbook()
	{
		try {
			Connection con = Database.dataConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from library.books where rfid='"+book1+"'");
			while(rs.next())
			{
			doi = rs.getDate(7);
			//doer =rs.getDate(8);
			name = rs.getString(6);
			bok_name = rs.getString(2);
			// System.out.println(doer);
			//System.out.println(doer + name);
			break;
			}
			rs.close();
			
			
			
			ResultSet rs5=stmt.executeQuery("select * from library.student where name='"+name+"'");
			while(rs5.next())
			{ String ph3=rs5.getString(5);// System.out.println(doer);
			ph2=ph3;
			//System.out.println(doer + name);
			break;
			}
			rs5.close();

			String s1  = (sdf.format(date));
			Date s11=sdf.parse(s1);
			System.out.println(s11);

			String a=sdf.format(doi);
			dor  = (sdf.format(date));
			Date dor1=sdf.parse(dor);
			long diff=dor1.getTime()-doi.getTime();

			long diffDays = diff / (24 * 60 * 60 * 1000);


			if (diff==1||diff==0) {
				System.out.print("You have returned book ater "+diffDays + " day.\n ");
			}
			else {
				System.out.print("You have returned book ater "+diffDays + " days.\n ");}




			int x=stmt.executeUpdate("UPDATE library.books SET dor='"+dor+"' WHERE rfid='"+book1+"'");
			int z=stmt.executeUpdate("UPDATE library.books SET doi=null WHERE rfid='"+book1+"'");
			int d=stmt.executeUpdate("UPDATE library.books SET doer=null WHERE rfid='"+book1+"'");
			int i=stmt.executeUpdate("UPDATE library.books SET status='unissued' WHERE rfid='"+book1+"'");
			int u=stmt.executeUpdate("UPDATE library.books SET issued_to=null WHERE rfid='"+book1+"'"); 

			ResultSet rs1=stmt.executeQuery("select * from library.student where name='"+name+"'");
			while(rs1.next())
			{
				books_issue = rs1.getInt(8);
				break;
			}
			books_issue--;
			stmt.executeUpdate("UPDATE library.student SET books_issue='"+books_issue+"' WHERE name='"+name+"'");

			long diffDays1;
			if (diffDays>15)
			{System.out.println(diffDays);
			diffDays1=diffDays-15;
			System.out.println(diffDays1);
			if(diffDays1>15)
			{
				fine=fine+((diffDays1)+(2*(diffDays1-15)));
				System.out.println(fine);
				System.out.println("\nYour fine is " + fine + " rupees");

			}
			else 
			{
				fine=fine+((diffDays1));

				System.out.println("\nYour fine is " + fine+ "rupees");

			}
			
			gsmreturn();
			gui6.returngui1(bok_name,fine);
			


			}
			else {
				gsmreturn();
				
			gui6.returngui2(bok_name);
			
			
			}
				System.out.println("successfully returned");
		}

		catch(Exception e) {}

	}
}
