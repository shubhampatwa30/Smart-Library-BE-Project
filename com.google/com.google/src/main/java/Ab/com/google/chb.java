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

public class chb extends JFrame implements ActionListener 
{
	private static final boolean TRACE_MODE = false;
	static String botName = "super";
	private static chb ch;
	Time t=null;
	int count1=0;
	int count2=0;
	int count3=0;
	private JFrame f1,f2,f3;
	private JLabel L1,L2,L3,L4,L5,L6,L7,L8,L9,L10;
	private JButton b1,b2,b3;
	private JComboBox<?> cb,cb2;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	public chb ()
	{
		f1=new JFrame("CHATBOT PATIENT APPOINTMENT");
		f2=new JFrame("REGISTRATION");
		f3=new JFrame("CHATBOT");
		
		
		t1=new JTextField(10);
		t2=new JTextField(20);
		t3=new JTextField(10);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		t8=new JTextField(20);
		t9=new JTextField(20);
		
		
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
		//L11=new JLabel("Welcome");
		
		//b1=new JButton("Enter");
		b1 = new JButton("Enter");
       
		b2=new JButton("Submit");
		b3=new JButton("Submit");
		//b4=new JButton("New Patient");
		//b5=new JButton("Existing Patient");
		
		String ct[] = {"Check-Up","Diagnosis","Report Checking",""};
		String ct2[] = {"Ankita Kulkarni","Siddhiraj Dalvi","Kunali Patil"};
		cb  = new JComboBox<Object>(ct);
		cb2  = new JComboBox<Object>(ct2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
		f3.setLayout(new GridLayout(5,1));
		//f4.setLayout(new GridLayout(3,1));
		
		/*f4.add(L11);
	    f4.add(b4);
		f4.add(b5);*/
		
		f3.add(L1);
	    f3.add(t1);
		f3.add(L2);
		f3.add(t2);
		f3.add(b1);
		f3.setSize(400,300);
		f3.setVisible(true);
		
	   // f4.setSize(400,300);
		//f4.setVisible(true);
		
		
		
		
			
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		}
	public void actionPerformed(ActionEvent ae)
	{
		//try
		//{
			
			if(ae.getSource()==b1)
		{
			Voice voice =new Voice("kevin16");
			
			try
			{
				String resourcesPath = getResourcesPath();
	            //System.out.println(resourcesPath);
	            MagicBooleans.trace_mode = TRACE_MODE;
	            Bot bot = new Bot("super", resourcesPath);
	            Chat chatSession = new Chat(bot);
	            bot.brain.nodeStats();
	            String textLine = "";
	           
	            while(true) {
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
	                else if(textLine.equals("Y"))
	                {
	                	System.out.println("Robot:Do you want an appointment?");
	                	System.out.print("Human : ");
	                	 textLine = IOUtils.readInputTextLine();
	                	if (textLine.equalsIgnoreCase("Yeah"))
	                	{
	                		System.out.println("Robot:are you registered?");
	                		System.out.print("Human : ");
	                		 textLine = IOUtils.readInputTextLine();
	                		 if (textLine.equalsIgnoreCase("Yes"))
	                		 {
	                			 System.out.println("Robot:fill this form to get a new appointment.");
	                			try
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
	                				 break;
	                			}
	                			catch (Exception e)
	            				{
	            					System.err.println("Got an exception! ");
	            					System.err.println(e.getMessage());
	            				}
	                			//b2 la scheduling
	                			
	                		 }
	                		 else if(textLine.equalsIgnoreCase("No"))
	                		 {
	                			 System.out.println("Robot:Then fill this form to register yourself and then fill the appointment forms");
	                			
	                				 try
	                				 {
	                			
	             				f2.add(L8);
	             			    f2.add(t6);
	             				f2.add(L9);
	             				f2.add(t7);
	             				f2.add(L10);
	             				f2.add(t8);
	             				f2.add(t9);
	             			    f2.add(b3);
	             			    
	             				f2.setLayout(new GridLayout(8,1));
	             			    f2.setSize(400,300);
	             				f2.setVisible(true);
	             				
	             				b3.addActionListener(this);
	             				//break;
	             				/*}
	             				catch (Exception e)
	             				{
	             					System.err.println("Got an exception! ");
	             					System.err.println(e.getMessage());
	             				}*/
	                				 //ch.actionPerformed(ae);
	                				 
	             			if(ae.getSource()==b3)
	             			{
	             			update();
	             			}
	                				 }
             				catch (Exception e)
             				{
             					System.err.println("Got an exception! ");
             					System.err.println(e.getMessage());
             				}
	             				
	             			
	                				 
	             			try
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
        			catch (Exception e)
    				{
    					System.err.println("Got an exception! ");
    					System.err.println(e.getMessage());
    				}
        			//b2 la scheduling
	                	
	        			if(ae.getSource()==b2)
	        			{
	        				Class.forName("com.mysql.jdbc.Driver");
             				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor","root","ankita@1212"); 
             				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_information","root","ankita@1212");
	   
	        				try

	        				{
	        						        				
	        					Statement stmt1=con1.createStatement();  
	        					Statement stmt3 =con.createStatement();
	        					
	        					Date date=new Date();
	        					int d=date.getDate()+1;
	        					int m=date.getMonth()+1;
	        					int y=date.getYear();
	        					final String str1=t3.getText();
	        					final String str2=t4.getText();
	        					
	        					String reason=cb.getSelectedItem().toString();
	        					String docname=cb2.getSelectedItem().toString();
	        					
	        					
	        					
	        					if(docname.equals("Ankita Kulkarni"))
	        					{
	        						ResultSet rss = stmt1.executeQuery("select * from doctorinfo where name='"+docname+"'");
	        						ResultSet rss2 = stmt3.executeQuery("select * from information where name='"+str1+"'");
	        						if(reason.equals("Check-Up"))
	        						{
	        							
	        							count1++;
	        							if(count1==1)
	        							{
	        								
	        								while(rss2.next())
	        								{
	        								
	        									while(rss.next())
	        									{
	        											t2.setText("Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+rss.getTime(4)+" pm on "+d+"/"+m+"/"+y);
	        											stmt1.executeUpdate("insert into appointments (Id,Name,Gender,Time) values("+rss2.getInt(1)+",'"+str1+"','"+str2+"',"+rss.getTime(4)+")");
	        									}
	        								}
	        							}
	        							else
	        							{
	        								
	        								int min=(count1-1)*20;
	        								while(rss.next())
	        								{
	        									t = rss.getTime(4);
	        									String tt = ""+t;
	        									String inct = tt.substring(3,5);
	        									String tm =String.valueOf(min);
	        					    	        String tr = tt.replace(inct,tm);
	        					    	        Time tmm = Time.valueOf(tr);
	        					    	        
	        					    	        
	        					    	        t2.setText("Hello "+str1+",Your appointment with Dr. "+docname+" requires 20 mins. Your appointment is scheduled at "+tmm+" pm on "+d+"/"+m+"/"+y);
	        					    	        stmt1.executeUpdate("insert into appointments (Id,Name,Gender,Time) values("+rss2.getInt(1)+",'"+str1+"','"+str2+"',"+tmm+")");
	        								}
	        							}
	        						}
	        					}
	        				}
	        				catch (Exception e)
	        				{
	        					System.err.println("Got an exception! ");
	        					System.err.println(e.getMessage());
	        				}
	        				t3.setText("");
	        				t4.setText("");
	        				t5.setText("Appointment given");
	        				
	        				con.close();
	        				con1.close();
	        				break;
	        			}
	        			break;
	                		 }
	                	}
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
	                		 
	                	
			
			catch (Exception ex)
			{
				System.err.println(ex.toString());
			}
		}
		
			}
			
			public void update()
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
 				//Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor","root","ankita@1212"); 
 				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_information","root","ankita@1212");
 				
 				try
 				{
 					
 				
 				final String str3=t6.getText();
 				final String str4=t7.getText();
 				final String str5=t8.getText();
 				System.out.println(t6);
 				Statement stmt2 =con.createStatement();
 				
 				stmt2.executeUpdate("insert into information (Name,Gender,Medical_history) values('"+str3+"','"+str4+"','"+str5+"')");
 				ResultSet rss1 = stmt2.executeQuery("select * from information where name='"+str3+"'");
 				while(rss1.next())
 				{
 				System.out.println("Robot:Your ID is "+rss1.getInt(1)+"");
 				}
 				t9.setText("Registered.");
 				t6.setText("");
 				t7.setText("");
 				t8.setText("");
 				con.close();

 				}
 				catch (Exception e)
 				{
 					System.err.println("Got an exception! ");
 					System.err.println(e.getMessage());
 				}
				}
				catch (Exception e)
 				{
 					System.err.println("Got an exception! ");
 					System.err.println(e.getMessage());
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
	public static void main(String[] args) 
	{
		new chb();
		
	}

}