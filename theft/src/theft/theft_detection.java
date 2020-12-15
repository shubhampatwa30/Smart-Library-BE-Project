
package theft;

import arduino.*;
import theft.Database;

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


import java.util.*;
import java.sql.*;


public class theft_detection {
	static String rfid,read,read1,book1,book,name,dor,logout="0";
static	String is="",ph="",name1="";
	static java.sql.Date  doer;
	static java.sql.Date doi;
	static int books_issue;
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	static Date date = new Date();
	static SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");

	//static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");// HH:mm:ss");
	static	Arduino  obj =new Arduino("COM4", 9600);
	public static void main(String[] args) throws Exception {
		

		


		/*System.out.println("Do you want Issue or return");
		System.out.println("Press 1 to issue and 2 to return");
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();

		switch(x) {
		case 1://issue
			System.out.print("Scan your card");*/
		obj.openConnection();
		while(true)
		{
			
			//LocalTime localTime = LocalTime.now();
		//	System.out.println(localTime);
			//LocalDate localDate = LocalDate.now();
			
			
			read = obj.serialRead();
			int length = read.length();
			//System.out.println(length);
			if(length>=10)
			{
				//System.out.println(read);
				read1 = (read.substring(0, read.length() - 2));
				int length1 = read1.length();
				System.out.println(length1);
				System.out.println(read1);
				Connection con = Database.dataConnection();
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from library.books where rfid='"+read1+"'");

				while(rs.next())
				{  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getInt(8));
				 is = rs.getString(10); 
				//ph=is;	 
				System.out.print(is);
				System.out.println(is.length()); 
				rs.close();	
				break;
				}
				if((is.length())==8||(is.length())==6)
				{
					detect();
					is="";
				}

				ResultSet rs1=stmt.executeQuery("select * from library.student where rfid='"+read1+"'");
				int bis,ph1=10;
				while(rs1.next())
				{  System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getInt(3)+"  "+rs1.getString(4)+"  "+rs1.getString(5)+"  "+rs1.getString(6)+"  "+rs1.getString(7)+"  "+rs1.getInt(8));
				bis = rs1.getInt(8); 
				ph1=bis;	 
				name=rs1.getString(2);
				name1=name;
				System.out.println(name1);
				rs1.close();	
				break;
				}
				if(ph1==0||ph1==1||ph1==2||ph1==3)
				{
					login();
				}


			}

		}

	}



	public static void detect()
	{

		try {
		//	Connection con = Database.dataConnection();
			//Statement stmt=con.createStatement();
					if((is.length())==8)
			{
				Thread.sleep(2000);
				obj.serialWrite(is);
				Thread.sleep(2000);

//				String re="",ree="";
	//			re=obj.serialRead();
		//		System.out.println(re);
			//	ree=re.substring(0, 2);
				//System.out.println(ree);
				//obj.closeConnection();
				}
			//else {
				//login();
		//	}
		}
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}


	public static void login()
	{

		try {
			Connection con = Database.dataConnection();
			Statement stmt=con.createStatement();

			ResultSet rs2=stmt.executeQuery("SELECT * FROM `login` WHERE RFID='"+read1+"' AND Log_out IS NULL");
			
		while(rs2.next())
		{
		
						logout=rs2.getString(5);
			
		}
		
		if(logout=="0") {
			
			Date timeobj=new Date();
			String time1=sdt.format(timeobj);
			System.out.println(time1);
			
			String doi = (sdf.format(date));
					
			int zz=stmt.executeUpdate("INSERT INTO `login` (`Name`, `RFID`, `Login_Date`, `Login_Time`) VALUES ('"+name1+"' , '"+read1+"', '"+doi+"', '"+time1+"')");
		}
		else {
			Date timeobj1=new Date();
		String time2=sdt.format(timeobj1);
		System.out.println(time2);
		
		//String doi = (sdf.format(date));
				//	int zz=stmt.executeUpdate("INSERT INTO `login` (`Name`, `RFID`, `Login_Date`, `Login_Time`) VALUES ('"+name1+"' , '"+read1+"', '"+doi+"', '"+time1+"')");
					//int z1= stmt.executeUpdate("INSERT INTO `login` (`Sr no`, `Name`, `RFID`, `Login_Date`, `Login_Time`, `Log_out`) VALUES (NULL, '', '', '', '', '"+time1+"')");
		stmt.executeUpdate("UPDATE login SET Log_out='"+time2+"' WHERE rfid='"+read1+"' AND Log_out IS NULL");	
		
		logout="0";
		}
		
				
		}
		
		catch (Exception e) {
			System.err.println(e.toString());
		}
	}



}