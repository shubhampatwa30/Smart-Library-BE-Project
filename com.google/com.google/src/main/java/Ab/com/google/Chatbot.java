package Ab.com.google;

//import Chatbot;

import java.io.File;

//import Chatbot.Voice;






import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.History;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

 
public class Chatbot extends JFrame implements ActionListener 
{
    private static final boolean TRACE_MODE = false;
    static String botName = "super";
   private JTextField text;
	private JTextArea Chatarea;
	public Chatbot()
	{
		this.setSize(600,600);
		this.setVisible(true);
		this.setTitle("Chat");
		text = new JTextField(10);
		Chatarea=new JTextArea();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		 
		
		text.setLocation(2,540);
		text.setSize(590, 30);
		
		Chatarea.setLocation(15, 5);
		Chatarea.setSize(540, 510);
		
		this.add(text);
	   this. add(Chatarea);
	
	    
		text.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent ae)
	{
		Voice voice =new Voice("kevin16");
        try {
 
            String resourcesPath = getResourcesPath();
            System.out.println(resourcesPath);
            MagicBooleans.trace_mode = TRACE_MODE;
            Bot bot = new Bot("super", resourcesPath);
            Chat chatSession = new Chat(bot);
            bot.brain.nodeStats();
           // String utext = "";
            
            while(true) {	
     			
            		String utext=text.getText();
            		if (utext.equals("q"))
                   	{
                           System.exit(0);
                       } 
                   	else if (utext.equals("wq"))
                   	{
                           bot.writeQuit();
                           System.exit(0);
                       }
                   	else if ((utext == null) || (utext.length() < 1))
            	utext = MagicStrings.null_input;
         
                   /*	else if(utext.equals("YES"))
                   	{
            	    Chatarea.append("Robot:Do you want an  appointment?\n   Press Y for yes\n    Press N for No");
                	 utext=text.getText();
                	
         			
                	text.setText("");
              
                   // System.out.print("Human : ");
                    //textLine = IOUtils.readInputTextLine();
                    if (utext.equals("Y"))
                    {
                    	 Chatarea.append("\nYou: " + utext +"\n");
                    	
                    	 Chatarea.append("Robot:Are you a registered patient?\n    Press Y for yes\n      Press N for No");
                    	String t=text.getText();
             			
                   	 
                   	 text.setText("");
                   	if (t.equals("Y"))
                   			{
                   		Chatarea.append("\nYou: " + t +"\n");
                   		Chatarea.append("Robot: Fill the following form ");
                       	
                   		//appointment registration form gui should be called here
                   			}
                   	else if (t.equals("N"))
                   	{
                   		Chatarea.append("Robot:Register yourself by filling the following form");
                   		//registration form gui should be called here
                   	}
                    
                    }
                   	}*/                   	
                   	else
            	{
            			
                    String request = utext;
                    Chatarea.append("\nYou: " + utext +"\n");
                    text.setText("");
                    if (MagicBooleans.trace_mode)
                        System.out.println("STATE=" + request + ":THAT=" + ((History) chatSession.thatHistory.get(0)).get(0) + ":TOPIC=" + chatSession.predicates.get("topic"));
                    String response = chatSession.multisentenceRespond(request);
                    while (response.contains("&lt;"))
                        response = response.replace("&lt;", "<");
                    while (response.contains("&gt;"))
                        response = response.replace("&gt;", ">");
                    Chatarea.append("Robot : " + response+ "\n");
                    //voice.say(response);
            	}
                    
                   
                
            
            	
                
                break;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public static void main(String[] args)
    {
    	new Chatbot();
    }
    private static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        System.out.println(path);
        String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
        return resourcesPath;
    }
}