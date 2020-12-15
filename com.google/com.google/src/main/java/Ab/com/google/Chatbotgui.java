package Ab.com.google;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
//import java.sql.Date;


import Ab.com.google.Voice;






//import bitoflife.chatterbean.AliceBot;
//import bitoflife.chatterbean.AliceBotMother;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

import java.util.*;
import java.util.List;


public class Chatbotgui extends JFrame implements ActionListener 
{
	public int y=0;
	private static final boolean TRACE_MODE = false;
	static String botName = "super";
	static String textLine = "";
	
	Time t=null;
	//Time T=null;
	
	 static int countb=0;
	 static int countc=0;
	static int flag1=0;
	static int counta=0;
	String td="";
	int id2=0;
	int up=0;
	private JFrame f1,f2,f3;
	private JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11;
	private JButton b1,b2,b3;
	private JComboBox<?> cb,cb2;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	
	public Chatbotgui()
	{
		f1=new JFrame("CHATBOT PATIENT APPOINTMENT");
		f2=new JFrame("REGISTRATION");
		//f3=new JFrame("CHATBOT");
		
		
		t1=new JTextField(10);
		t2=new JTextField(20);
		t3=new JTextField(10);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		t8=new JTextField(20);
		t9=new JTextField(20);
		t10=new JTextField(20);
		
		
		L1=new JLabel("Human");        
		L2=new JLabel("Bot");
		L3=new JLabel("Welcome!");
		L4=new JLabel("Patient Name:");
		L5=new JLabel("Gender");
		L6=new JLabel("Doctor Name:");
		L7=new JLabel("Reason For appointment");
		L8=new JLabel("Name:");
		L9=new JLabel("Gender:");
		L10=new JLabel("Medical History:");
		L11=new JLabel("Contact number");
		
		
		
       
		b2=new JButton("Submit");
		b3=new JButton("Submit");
		
		
		String ct[] = {"Check-Up","Diagnosis","Report Checking",""};
		String ct2[] = {"Ankita Kulkarni","Siddhiraj Dalvi","Kunali Patil"};
		cb  = new JComboBox<Object>(ct);
		cb2  = new JComboBox<Object>(ct2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
		
		Appointment();
		Register();
		
		
		Voice voice =new Voice("kevin16");
			
			try
			{
				String resourcesPath = getResourcesPath();
	            //System.out.println(resourcesPath);
	            MagicBooleans.trace_mode = TRACE_MODE;
	            Bot bot = new Bot("super", resourcesPath);
	            Chat chatSession = new Chat(bot);
	            bot.brain.nodeStats();
	            
	           
	            while(true) 
	            {
	            	t5.setText("");
	            	t10.setText("");
	            	System.out.print("Human : ");
	                textLine = IOUtils.readInputTextLine();
	                if ((textLine == null) || (textLine.length() < 1))
	                    textLine = MagicStrings.null_input;
	                else if (textLine.equals("q")) {
	                    System.exit(0);
	                } else if (textLine.equals("wq")) {
	                    bot.writeQuit();
	                    System.exit(0);
	                } 
	                else if(textLine.equalsIgnoreCase("I want an appointment"))
	                {
	                	final String q1="Are you registered?";
	                	System.out.println("Robot:"+q1);
	                	voice.say(q1);
	                	//System.out.print("Human : ");
	                }
	                	//textLine = IOUtils.readInputTextLine();
	                else if (textLine.equalsIgnoreCase("Yes"))
	                	{
	                		final String q2="Then fill the appointment form";
	                		System.out.println("Robot:"+q2);
	                		voice.say(q2);
	                		//System.out.print("Human : ");
	                	}
	                		// textLine = IOUtils.readInputTextLine();
	                else if (textLine.equalsIgnoreCase("no"))
	                		 {
	                			  final  String q3="fill the registration form and then fill the apppointment form.";
	                			 System.out.println("Robot:"+q3);
	                			 voice.say(q3);
	                		 }
	                			
	                else 
	                {
	                    String request = textLine;
	                    if (MagicBooleans.trace_mode)
	                        System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
	                    String response = chatSession.multisentenceRespond(request);
	                    while (response.contains("&lt;"))
	                        response = response.replace("&lt;", "<");
	                    while (response.contains("&gt;"))
	                        response = response.replace("&gt;", ">");
	                    System.out.println("Robot : " + response);
	                    voice.say(response);
			}
	            }
			}
			catch (Exception e)
			{
				System.err.println("Got an exception! ");
				System.err.println(e.getMessage());
			}
	}
	               
	
	public void actionPerformed(ActionEvent ae)
	                {
		
		
		if(ae.getSource()==b2)
	        			{
	        				
	        				try
	        				{
	        				Class.forName("com.mysql.jdbc.Driver");
             				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor","root","ankita@1212"); 
             				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_information","root","ankita@1212");
	   
	       
	        						        				
	        					Statement stmt1=con1.createStatement();  
	        					Statement stmt3 =con.createStatement();
	        					Statement stmt4 = con1.createStatement();
	        					Statement stmt5=con1.createStatement();
	        					
	        					Date date=new Date();
	        					int d=date.getDate();
	        					int m=date.getMonth()+1;
	        					int y=date.getYear()+1900;
	        					//System.out.println(date);
	        					
	        					
	        					final String str1=t3.getText();
	        					final String str2=t4.getText();
	        				
	        					//System.out.println(str1+str2);
	        					
	        					String reason=cb.getSelectedItem().toString();
	        					String docname=cb2.getSelectedItem().toString();
	        					int id1=0;
	        					 
	        					 
	        					ResultSet rss2 = stmt3.executeQuery("select * from information where name='"+str1+"'");
								while(rss2.next())
									{
									id1=rss2.getInt(1);
									}
								
								
	        					if(docname.equals("Ankita Kulkarni"))
	        					{
	        						//flag1++;
	        						counta++;
	        						
	        						if(reason.equals("Check-Up"))
	        						{
	        							
	        						
	        							if (counta==1)
	        							{	
	        								int min=0;
	        								

	        								String tt="";
	        								String inct="";
	        								String inct2="";
	        								String tm="";
	        								String tr="";
	        								int tmm=0;
	        								String Date1=String.valueOf(date);
	        								
	        								
	        								
	        								
	        								ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
	        	        					
	        									while(rss.next())
	        										
	        								{
	        									t = rss.getTime(4);
	        									
	        									 tt =String.valueOf(t);
	        									inct = tt.substring(0,4);
	        									 tm =String.valueOf(min);
	        					    	         tr = inct+tm;
	        					    	         //tmm = String.valueOf(tr); 
	        					    	        //rsn=rss.get
	        					    	        
	        					    	       // String id=String.valueOf(rss2.getInt(1));
	        								}
	        					    	        
	        					    	       stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values("+id1+",'"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
	        					    	       ResultSet rss4 = stmt5.executeQuery("select * from ankita where name='"+str1+"'");
	        									while(rss4.next())
	        										{
	        										id2=rss4.getInt(1);
	        										}
	        									System.out.println(id2);
	        								System.out.println(tt);
	        								System.out.println(inct);
	        								System.out.println(tr);
	        									System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									//flag=flag+1;
	        									//System.out.println(date);
	        							//flag=0;
	        							}
	        							
	        							else
	        							{
	        								counta--;
                                             int min=counta*20;
	        								
                                             System.out.println(min);
	        								String tt="";
	        								String inct="";
	        								String inct2="";
	        								String inct3="";
	        								String inct4="";
	        								String tm="";
	        								String tr="";
	        								int tmm=0;
	        								String tmm1="";
	        								String w="";
	        								String w2="";
	        								String Date1=String.valueOf(date);
	        								String T="";
	        								
	        								
	        								
	        								System.out.println(counta);
	        								System.out.println(id2);
	        								ResultSet rss3 = stmt4.executeQuery("select * from ankita where Serial_no="+id2+"");
	        	        					
	        								
	        									while(rss3.next())
	        										
	        								{
	        								
	        									if(min==60)
	        									{
	        										flag1++;
	        										int min1=(flag1-1)*20;
	        										System.out.println("Min"+min1);
	        										 tm =String.valueOf(min1);
	        										 td = rss3.getString(7);
	        										 System.out.println("td " +td);
	        										inct3 = td.substring(0,2);
	        										inct4 = td.substring(2,5);
	        										System.out.println("inct3 " +inct3);
	        										System.out.println("inct4 " +inct4);
	        								    	  int tt2 = Integer.valueOf(inct3);
	        								    	   int uptt = tt2+1;
	        								    	   System.out.println("Uptt " +uptt);
	        								    	  String u=""+uptt+":00";
	        								    	  // tr = td.replace(inct4,tm);
	        								    	  // tmm1 = String.valueOf(tr);
	        								    	   //System.out.println("tmm1 " +tmm1);
	        								    	  w2=String.valueOf(u);
	        								    	  // w2 = ""+uptt;
	        								    	  System.out.println("w2 " +w2);
	        								    	   stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+w2+"','"+Date1+"')");
	        								    	   System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+w2+" pm on "+d+"/"+m+"/"+y);	
	        									}
	        									else if(min==80)
	        									{
	        										flag1++;
	        										int min1=(flag1-1)*20;
	        										System.out.println("Min"+min1);
	        										 tm =String.valueOf(min1);
	        										 td = rss3.getString(7);
	        										 System.out.println("td " +td);
	        										 inct = td.substring(0,3);
			        									inct2=td.substring(4,5);
			        									tmm=Integer.valueOf(inct2);
			        									w=String.valueOf(tmm+min1);
			        									 //tm =String.valueOf(min1);
			        									  tr = inct+w;	 
			        									  stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
			        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									}
	        									else
	        									{
	        										td = rss3.getString(7);
		        									//T=String.valueOf(t);
		        									// tt = ""+T;
		        									 System.out.println(td);
		        									inct = td.substring(0,3);
		        									inct2=td.substring(4,5);
		        									tmm=Integer.valueOf(inct2);
		        									w=String.valueOf(tmm+min);
		        									 tm =String.valueOf(min);
		        									  tr = inct+w;	 
		        									  stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
		        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									}
	        					    	       
	        					    	       counta++;
	        					    	       System.out.println(td);
	        					    	       System.out.println(counta);
	        					    	       System.out.println(tr);
	        					    	       //System.out.println(tt);
		        								System.out.println(inct);
		        								//System.out.println(tr);
		        								
		        								ResultSet rss4 = stmt5.executeQuery("select * from ankita where name='"+str1+"'");
		        								while(rss4.next())
		        									{
		        									id2=rss4.getInt(1);
		        									}
		        								System.out.println(id2);
	        									//System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									//flag=flag+1;
	        									//System.out.println(date);
	        							//flag=0;
	        									
	        							}
	        							
	        							}
	        						}
	        						else if(reason.equals("Diagnosis"))
	        						{
	        						if (counta==1)
        							{	
        								int min=0;
        								

        								String tt="";
        								String inct="";
        								String inct2="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String Date1=String.valueOf(date);
        								
        								
        								
        								
        								ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
        	        					
        									while(rss.next())
        										
        								{
        									t = rss.getTime(4);
        									
        									 tt =String.valueOf(t);
        									inct = tt.substring(0,4);
        									 tm =String.valueOf(min);
        					    	         tr = inct+tm;
        					    	         //tmm = String.valueOf(tr); 
        					    	        //rsn=rss.get
        					    	        
        					    	       // String id=String.valueOf(rss2.getInt(1));
        								}
        					    	        
        					    	       stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values("+id1+",'"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
        					    	       ResultSet rss4 = stmt5.executeQuery("select * from ankita where name='"+str1+"'");
        									while(rss4.next())
        										{
        										id2=rss4.getInt(1);
        										}
        									System.out.println(id2);
        								System.out.println(tt);
        								System.out.println(inct);
        								System.out.println(tr);
        									System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        							}
        							
        							else
        							{
        								counta--;
                                         int min=counta*20;
        								
                                         System.out.println(min);
        								String tt="";
        								String inct="";
        								String inct2="";
        								String inct3="";
        								String inct4="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String tmm1="";
        								String w="";
        								String w2="";
        								String Date1=String.valueOf(date);
        								String T="";
        								
        								
        								
        								System.out.println(counta);
        								System.out.println(id2);
        								ResultSet rss3 = stmt4.executeQuery("select * from ankita where Serial_no="+id2+"");
        	        					
        								
        									while(rss3.next())
        										
        								{
        								
        									if(min==60)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										inct3 = td.substring(0,2);
        										inct4 = td.substring(2,5);
        										System.out.println("inct3 " +inct3);
        										System.out.println("inct4 " +inct4);
        								    	  int tt2 = Integer.valueOf(inct3);
        								    	   int uptt = tt2+1;
        								    	   System.out.println("Uptt " +uptt);
        								    	  String u=""+uptt+":00";
        								    	  // tr = td.replace(inct4,tm);
        								    	  // tmm1 = String.valueOf(tr);
        								    	   //System.out.println("tmm1 " +tmm1);
        								    	  w2=String.valueOf(u);
        								    	  // w2 = ""+uptt;
        								    	  System.out.println("w2 " +w2);
        								    	   stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+w2+"','"+Date1+"')");
        								    	   System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+w2+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else if(min==80)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										 inct = td.substring(0,3);
		        									inct2=td.substring(4,5);
		        									tmm=Integer.valueOf(inct2);
		        									w=String.valueOf(tmm+min1);
		        									 //tm =String.valueOf(min1);
		        									  tr = inct+w;	 
		        									  stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
		        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else
        									{
        										td = rss3.getString(7);
	        									//T=String.valueOf(t);
	        									// tt = ""+T;
	        									 System.out.println(td);
	        									inct = td.substring(0,3);
	        									inct2=td.substring(4,5);
	        									tmm=Integer.valueOf(inct2);
	        									w=String.valueOf(tmm+min);
	        									 tm =String.valueOf(min);
	        									  tr = inct+w;	 
	        									  stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
	        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        					    	       
        					    	       counta++;
        					    	       System.out.println(td);
        					    	       System.out.println(counta);
        					    	       System.out.println(tr);
        					    	       //System.out.println(tt);
	        								System.out.println(inct);
	        								//System.out.println(tr);
	        								
	        								ResultSet rss4 = stmt5.executeQuery("select * from ankita where name='"+str1+"'");
	        								while(rss4.next())
	        									{
	        									id2=rss4.getInt(1);
	        									}
	        								System.out.println(id2);
        									//System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        									
        							}
        							
        							}
        						}
	        							
	        						//System.out.println(Date1);
	        							
	        						else if(reason.equals("Report Checking"))
	        						{
	        						if (counta==1)
        							{	
        								int min=0;
        								

        								String tt="";
        								String inct="";
        								String inct2="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String Date1=String.valueOf(date);
        								
        								
        								
        								
        								ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
        	        					
        									while(rss.next())
        										
        								{
        									t = rss.getTime(4);
        									
        									 tt =String.valueOf(t);
        									inct = tt.substring(0,4);
        									 tm =String.valueOf(min);
        					    	         tr = inct+tm;
        					    	         //tmm = String.valueOf(tr); 
        					    	        //rsn=rss.get
        					    	        
        					    	       // String id=String.valueOf(rss2.getInt(1));
        								}
        					    	        
        					    	       stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values("+id1+",'"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
        					    	       ResultSet rss4 = stmt5.executeQuery("select * from ankita where name='"+str1+"'");
        									while(rss4.next())
        										{
        										id2=rss4.getInt(1);
        										}
        									System.out.println(id2);
        								System.out.println(tt);
        								System.out.println(inct);
        								System.out.println(tr);
        									System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        							}
        							
        							else
        							{
        								counta--;
                                         int min=counta*20;
        								
                                         System.out.println(min);
        								String tt="";
        								String inct="";
        								String inct2="";
        								String inct3="";
        								String inct4="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String tmm1="";
        								String w="";
        								String w2="";
        								String Date1=String.valueOf(date);
        								String T="";
        								
        								
        								
        								System.out.println(counta);
        								System.out.println(id2);
        								ResultSet rss3 = stmt4.executeQuery("select * from ankita where Serial_no="+id2+"");
        	        					
        								
        									while(rss3.next())
        										
        								{
        								
        									if(min==60)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										inct3 = td.substring(0,2);
        										inct4 = td.substring(2,5);
        										System.out.println("inct3 " +inct3);
        										System.out.println("inct4 " +inct4);
        								    	  int tt2 = Integer.valueOf(inct3);
        								    	   int uptt = tt2+1;
        								    	   System.out.println("Uptt " +uptt);
        								    	  String u=""+uptt+":00";
        								    	  // tr = td.replace(inct4,tm);
        								    	  // tmm1 = String.valueOf(tr);
        								    	   //System.out.println("tmm1 " +tmm1);
        								    	  w2=String.valueOf(u);
        								    	  // w2 = ""+uptt;
        								    	  System.out.println("w2 " +w2);
        								    	   stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+w2+"','"+Date1+"')");
        								    	   System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+w2+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else if(min==80)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										 inct = td.substring(0,3);
		        									inct2=td.substring(4,5);
		        									tmm=Integer.valueOf(inct2);
		        									w=String.valueOf(tmm+min1);
		        									 //tm =String.valueOf(min1);
		        									  tr = inct+w;	 
		        									  stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
		        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else
        									{
        										td = rss3.getString(7);
	        									//T=String.valueOf(t);
	        									// tt = ""+T;
	        									 System.out.println(td);
	        									inct = td.substring(0,3);
	        									inct2=td.substring(4,5);
	        									tmm=Integer.valueOf(inct2);
	        									w=String.valueOf(tmm+min);
	        									 tm =String.valueOf(min);
	        									  tr = inct+w;	 
	        									  stmt1.executeUpdate("insert into ankita (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
	        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        					    	       
        					    	       counta++;
        					    	       System.out.println(td);
        					    	       System.out.println(counta);
        					    	       System.out.println(tr);
        					    	       //System.out.println(tt);
	        								System.out.println(inct);
	        								//System.out.println(tr);
	        								
	        								ResultSet rss4 = stmt5.executeQuery("select * from ankita where name='"+str1+"'");
	        								while(rss4.next())
	        									{
	        									id2=rss4.getInt(1);
	        									}
	        								System.out.println(id2);
        									//System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        									
        							}
        							
        							}
        						}
	        						
	        					}
	        						
	        					
	        					
	        					if(docname.equals("Siddhiraj Dalvi")) 
	        					{
	        						//flag1++;
	        						countb++;
	        						
	        						if(reason.equals("Check-Up"))
	        						{
	        							
	        						
	        							if (countb==1)
	        							{	
	        								int min=0;
	        								

	        								String tt="";
	        								String inct="";
	        								String inct2="";
	        								String tm="";
	        								String tr="";
	        								int tmm=0;
	        								String Date1=String.valueOf(date);
	        								
	        								
	        								
	        								
	        								ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
	        	        					
	        									while(rss.next())
	        										
	        								{
	        									t = rss.getTime(4);
	        									
	        									 tt =String.valueOf(t);
	        									inct = tt.substring(0,4);
	        									 tm =String.valueOf(min);
	        					    	         tr = inct+tm;
	        					    	         //tmm = String.valueOf(tr); 
	        					    	        //rsn=rss.get
	        					    	        
	        					    	       // String id=String.valueOf(rss2.getInt(1));
	        								}
	        					    	        
	        					    	       stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values("+id1+",'"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
	        					    	       ResultSet rss4 = stmt5.executeQuery("select * from siddhiraj where name='"+str1+"'");
	        									while(rss4.next())
	        										{
	        										id2=rss4.getInt(1);
	        										}
	        									System.out.println(id2);
	        								System.out.println(tt);
	        								System.out.println(inct);
	        								System.out.println(tr);
	        									System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									//flag=flag+1;
	        									//System.out.println(date);
	        							//flag=0;
	        							}
	        							
	        							else
	        							{
	        								countb--;
                                             int min=countb*20;
	        								
                                             System.out.println(min);
	        								String tt="";
	        								String inct="";
	        								String inct2="";
	        								String inct3="";
	        								String inct4="";
	        								String tm="";
	        								String tr="";
	        								int tmm=0;
	        								String tmm1="";
	        								String w="";
	        								String w2="";
	        								String Date1=String.valueOf(date);
	        								String T="";
	        								
	        								
	        								
	        								System.out.println(countb);
	        								System.out.println(id2);
	        								ResultSet rss3 = stmt4.executeQuery("select * from siddhiraj where Serial_no="+id2+"");
	        	        					
	        								
	        									while(rss3.next())
	        										
	        								{
	        								
	        									if(min==60)
	        									{
	        										flag1++;
	        										int min1=(flag1-1)*20;
	        										System.out.println("Min"+min1);
	        										 tm =String.valueOf(min1);
	        										 td = rss3.getString(7);
	        										 System.out.println("td " +td);
	        										inct3 = td.substring(0,2);
	        										inct4 = td.substring(2,5);
	        										System.out.println("inct3 " +inct3);
	        										System.out.println("inct4 " +inct4);
	        								    	  int tt2 = Integer.valueOf(inct3);
	        								    	   int uptt = tt2+1;
	        								    	   System.out.println("Uptt " +uptt);
	        								    	  String u=""+uptt+":00";
	        								    	  // tr = td.replace(inct4,tm);
	        								    	  // tmm1 = String.valueOf(tr);
	        								    	   //System.out.println("tmm1 " +tmm1);
	        								    	  w2=String.valueOf(u);
	        								    	  // w2 = ""+uptt;
	        								    	  System.out.println("w2 " +w2);
	        								    	   stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+w2+"','"+Date1+"')");
	        								    	   System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+w2+" pm on "+d+"/"+m+"/"+y);	
	        									}
	        									else if(min==80)
	        									{
	        										flag1++;
	        										int min1=(flag1-1)*20;
	        										System.out.println("Min"+min1);
	        										 tm =String.valueOf(min1);
	        										 td = rss3.getString(7);
	        										 System.out.println("td " +td);
	        										 inct = td.substring(0,3);
			        									inct2=td.substring(4,5);
			        									tmm=Integer.valueOf(inct2);
			        									w=String.valueOf(tmm+min1);
			        									 //tm =String.valueOf(min1);
			        									  tr = inct+w;	 
			        									  stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
			        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									}
	        									else
	        									{
	        										td = rss3.getString(7);
		        									//T=String.valueOf(t);
		        									// tt = ""+T;
		        									 System.out.println(td);
		        									inct = td.substring(0,3);
		        									inct2=td.substring(4,5);
		        									tmm=Integer.valueOf(inct2);
		        									w=String.valueOf(tmm+min);
		        									 tm =String.valueOf(min);
		        									  tr = inct+w;	 
		        									  stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
		        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									}
	        					    	       
	        					    	       countb++;
	        					    	       System.out.println(td);
	        					    	       System.out.println(countb);
	        					    	       System.out.println(tr);
	        					    	       //System.out.println(tt);
		        								System.out.println(inct);
		        								//System.out.println(tr);
		        								
		        								ResultSet rss4 = stmt5.executeQuery("select * from siddhiraj where name='"+str1+"'");
		        								while(rss4.next())
		        									{
		        									id2=rss4.getInt(1);
		        									}
		        								System.out.println(id2);
	        									//System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
	        									//flag=flag+1;
	        									//System.out.println(date);
	        							//flag=0;
	        									
	        							}
	        							
	        							}
	        						}
	        						else if(reason.equals("Diagnosis"))
	        						{
	        						if (countb==1)
        							{	
        								int min=0;
        								

        								String tt="";
        								String inct="";
        								String inct2="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String Date1=String.valueOf(date);
        								
        								
        								
        								
        								ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
        	        					
        									while(rss.next())
        										
        								{
        									t = rss.getTime(4);
        									
        									 tt =String.valueOf(t);
        									inct = tt.substring(0,4);
        									 tm =String.valueOf(min);
        					    	         tr = inct+tm;
        					    	         //tmm = String.valueOf(tr); 
        					    	        //rsn=rss.get
        					    	        
        					    	       // String id=String.valueOf(rss2.getInt(1));
        								}
        					    	        
        					    	       stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values("+id1+",'"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
        					    	       ResultSet rss4 = stmt5.executeQuery("select * from siddhiraj where name='"+str1+"'");
        									while(rss4.next())
        										{
        										id2=rss4.getInt(1);
        										}
        									System.out.println(id2);
        								System.out.println(tt);
        								System.out.println(inct);
        								System.out.println(tr);
        									System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        							}
        							
        							else
        							{
        								countb--;
                                         int min=countb*20;
        								
                                         System.out.println(min);
        								String tt="";
        								String inct="";
        								String inct2="";
        								String inct3="";
        								String inct4="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String tmm1="";
        								String w="";
        								String w2="";
        								String Date1=String.valueOf(date);
        								String T="";
        								
        								
        								
        								System.out.println(countb);
        								System.out.println(id2);
        								ResultSet rss3 = stmt4.executeQuery("select * from siddhiraj where Serial_no="+id2+"");
        	        					
        								
        									while(rss3.next())
        										
        								{
        								
        									if(min==60)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										inct3 = td.substring(0,2);
        										inct4 = td.substring(2,5);
        										System.out.println("inct3 " +inct3);
        										System.out.println("inct4 " +inct4);
        								    	  int tt2 = Integer.valueOf(inct3);
        								    	   int uptt = tt2+1;
        								    	   System.out.println("Uptt " +uptt);
        								    	  String u=""+uptt+":00";
        								    	  // tr = td.replace(inct4,tm);
        								    	  // tmm1 = String.valueOf(tr);
        								    	   //System.out.println("tmm1 " +tmm1);
        								    	  w2=String.valueOf(u);
        								    	  // w2 = ""+uptt;
        								    	  System.out.println("w2 " +w2);
        								    	   stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+w2+"','"+Date1+"')");
        								    	   System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+w2+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else if(min==80)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										 inct = td.substring(0,3);
		        									inct2=td.substring(4,5);
		        									tmm=Integer.valueOf(inct2);
		        									w=String.valueOf(tmm+min1);
		        									 //tm =String.valueOf(min1);
		        									  tr = inct+w;	 
		        									  stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
		        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else
        									{
        										td = rss3.getString(7);
	        									//T=String.valueOf(t);
	        									// tt = ""+T;
	        									 System.out.println(td);
	        									inct = td.substring(0,3);
	        									inct2=td.substring(4,5);
	        									tmm=Integer.valueOf(inct2);
	        									w=String.valueOf(tmm+min);
	        									 tm =String.valueOf(min);
	        									  tr = inct+w;	 
	        									  stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
	        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        					    	       
        					    	       countb++;
        					    	       System.out.println(td);
        					    	       System.out.println(countb);
        					    	       System.out.println(tr);
        					    	       //System.out.println(tt);
	        								System.out.println(inct);
	        								//System.out.println(tr);
	        								
	        								ResultSet rss4 = stmt5.executeQuery("select * from siddhiraj where name='"+str1+"'");
	        								while(rss4.next())
	        									{
	        									id2=rss4.getInt(1);
	        									}
	        								System.out.println(id2);
        									//System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        									
        							}
        							
        							}
        						}
	        							
	        						//System.out.println(Date1);
	        							
	        						else if(reason.equals("Report Checking"))
	        						{
	        						if (countb==1)
        							{	
        								int min=0;
        								

        								String tt="";
        								String inct="";
        								String inct2="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String Date1=String.valueOf(date);
        								
        								
        								
        								
        								ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
        	        					
        									while(rss.next())
        										
        								{
        									t = rss.getTime(4);
        									
        									 tt =String.valueOf(t);
        									inct = tt.substring(0,4);
        									 tm =String.valueOf(min);
        					    	         tr = inct+tm;
        					    	         //tmm = String.valueOf(tr); 
        					    	        //rsn=rss.get
        					    	        
        					    	       // String id=String.valueOf(rss2.getInt(1));
        								}
        					    	        
        					    	       stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values("+id1+",'"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
        					    	       ResultSet rss4 = stmt5.executeQuery("select * from siddhiraj where name='"+str1+"'");
        									while(rss4.next())
        										{
        										id2=rss4.getInt(1);
        										}
        									System.out.println(id2);
        								System.out.println(tt);
        								System.out.println(inct);
        								System.out.println(tr);
        									System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        							}
        							
        							else
        							{
        								countb--;
                                         int min=countb*20;
        								
                                         System.out.println(min);
        								String tt="";
        								String inct="";
        								String inct2="";
        								String inct3="";
        								String inct4="";
        								String tm="";
        								String tr="";
        								int tmm=0;
        								String tmm1="";
        								String w="";
        								String w2="";
        								String Date1=String.valueOf(date);
        								String T="";
        								
        								
        								
        								System.out.println(countb);
        								System.out.println(id2);
        								ResultSet rss3 = stmt4.executeQuery("select * from siddhiraj where Serial_no="+id2+"");
        	        					
        								
        									while(rss3.next())
        										
        								{
        								
        									if(min==60)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										inct3 = td.substring(0,2);
        										inct4 = td.substring(2,5);
        										System.out.println("inct3 " +inct3);
        										System.out.println("inct4 " +inct4);
        								    	  int tt2 = Integer.valueOf(inct3);
        								    	   int uptt = tt2+1;
        								    	   System.out.println("Uptt " +uptt);
        								    	  String u=""+uptt+":00";
        								    	  // tr = td.replace(inct4,tm);
        								    	  // tmm1 = String.valueOf(tr);
        								    	   //System.out.println("tmm1 " +tmm1);
        								    	  w2=String.valueOf(u);
        								    	  // w2 = ""+uptt;
        								    	  System.out.println("w2 " +w2);
        								    	   stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+w2+"','"+Date1+"')");
        								    	   System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+w2+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else if(min==80)
        									{
        										flag1++;
        										int min1=(flag1-1)*20;
        										System.out.println("Min"+min1);
        										 tm =String.valueOf(min1);
        										 td = rss3.getString(7);
        										 System.out.println("td " +td);
        										 inct = td.substring(0,3);
		        									inct2=td.substring(4,5);
		        									tmm=Integer.valueOf(inct2);
		        									w=String.valueOf(tmm+min1);
		        									 //tm =String.valueOf(min1);
		        									  tr = inct+w;	 
		        									  stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
		        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        									else
        									{
        										td = rss3.getString(7);
	        									//T=String.valueOf(t);
	        									// tt = ""+T;
	        									 System.out.println(td);
	        									inct = td.substring(0,3);
	        									inct2=td.substring(4,5);
	        									tmm=Integer.valueOf(inct2);
	        									w=String.valueOf(tmm+min);
	        									 tm =String.valueOf(min);
	        									  tr = inct+w;	 
	        									  stmt1.executeUpdate("insert into siddhiraj (User_Id,Name,Gender,Doc_name,Reason,Time,Date) values('"+id1+"','"+str1+"','"+str2+"','"+docname+"','"+reason+"','"+tr+"','"+Date1+"')");
	        									  System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									}
        					    	       
        					    	       countb++;
        					    	       System.out.println(td);
        					    	       System.out.println(countb);
        					    	       System.out.println(tr);
        					    	       //System.out.println(tt);
	        								System.out.println(inct);
	        								//System.out.println(tr);
	        								
	        								ResultSet rss4 = stmt5.executeQuery("select * from siddhiraj where name='"+str1+"'");
	        								while(rss4.next())
	        									{
	        									id2=rss4.getInt(1);
	        									}
	        								System.out.println(id2);
        									//System.out.println("\nRobot:Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tr+" pm on "+d+"/"+m+"/"+y);	
        									//flag=flag+1;
        									//System.out.println(date);
        							//flag=0;
        									
        							}
        							
        							}
        						}
	        						
	        					}
	        						
	        						
	        					
	        					
	        						
	        					
	        				t3.setText("");
	        				t4.setText("");
	        				t5.setText("Appointment given");
	        				
	        				
	        				con.close();
	        				con1.close();
	        				}
	        				catch (Exception e)
	        				{
	        					System.err.println("Got an exception! ");
	        					System.err.println(e.getMessage());
	        				}
	        				
	        				System.out.println("Human:");
	        				
	        			}
	        			
	        			else if(ae.getSource()==b3)
             			{
	        				
	        				
	        				try
	        				{
	        				
	        				
	        				Class.forName("com.mysql.jdbc.Driver");
	         				//Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor","root","ankita@1212"); 
	         				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_information","root","ankita@1212");
	         				
	         				
	         					
	         					
	         				final String str3=t6.getText();
	         				final String str4=t7.getText();
	         				final String str5=t9.getText();
	         				final String str6=t8.getText();
	         				
	         				
	         				//System.out.println("name " +str3);
	         				
	         				Statement stmt2 =con.createStatement();
	         				stmt2.executeUpdate("insert into information (Name,Gender,Contact_num,Medical_History) values('"+str3+"','"+str4+"','"+str5+"','"+str6+"')");
	         				
	         				int id = 0;
	         				ResultSet rss1 = stmt2.executeQuery("select * from information where name='"+str3+"'");
	         				
	         				while(rss1.next())
	         				{
	         					 id = rss1.getInt(1);
	         					
	         				
	         				//break;
	         				}
	         				
	         				System.out.println("\nRobot:Your ID is "+id+".Now fill the appointment form.");
	         				
	         				t10.setText("Registered.");
	         			
	         				
	         				t6.setText("");
	         				t7.setText("");
	         				t8.setText("");
	         				t9.setText("");
	         				rss1.close();
	         		
	         				con.close();
	        				}
	        				catch (Exception e)
	         				{
	         					System.err.println("Got an exception! ");
	         					System.err.println(e.getMessage());
	         				}
	        				
	        				System.out.println("Human:");
	        				/*if(textLine.equalsIgnoreCase("YES"))
	        				{
	        					Appointment();
	        				}*/
             			}
		
	        			
	                		 }
	               
	               
	                    	
	       
	                		 
	                	
			
			
			
			
			

	 private static String getResourcesPath() {
	        File currDir = new File(".");
	        String path = currDir.getAbsolutePath();
	        path = path.substring(0, path.length() - 2);
	        System.out.println(path);
	        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
	        return resourcesPath;
	    }
	 
	 public void Appointment()
	 {
		 
		f1.add(L3);
	    f1.add(L4);
		f1.add(t3);
		f1.add(L5);
		f1.add(t4);
		f1.add(L6);
		f1.add(cb2);
		f1.add(L7);
		f1.add(cb);
		f1.add(t5);
		f1.add(b2);
		
		f1.setLayout(new GridLayout(11,1));
		f1.setSize(400,300);
		f1.setVisible(true);
		
		b2.addActionListener(this);
	 }
	 
	 public void Register()
	 {
		 f2.add(L8);
		    f2.add(t6);
			f2.add(L9);
			f2.add(t7);
			f2.add(L11);
			f2.add(t9);
			f2.add(L10);
			f2.add(t8);
			f2.add(t10);
		    f2.add(b3);
		    
			f2.setLayout(new GridLayout(10,1));
		    f2.setSize(400,300);
			f2.setVisible(true);
			
			b3.addActionListener(this);
	 }
	 
	 
	public static void main(String[] args) 
	{
		new Chatbotgui();
		
	}

}