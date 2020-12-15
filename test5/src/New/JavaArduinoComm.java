package New;
import arduino.*;


public class JavaArduinoComm {
	static	Arduino  obj =new Arduino("COM4", 9600);
	static String read,read1;
	
	
	
		public static void readmain() {
			
		obj.openConnection();
		while(true) {
			read = obj.serialRead();
if(read.length()>=2)
	
{	System.out.println(read.length());
	System.out.println(read);
break;
	}
		
			
		}}

			//obj.closeConnection();
			//System.out.println("connection terminated");
		
	
		public static void main(String args[])
		{
			JavaArduinoComm.readmain();
		}
		}
		
		
