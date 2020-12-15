package com.google;
import java.sql.*;

public class Main
{
	public static void main(String args[])
	{
		String tt = "13:00";
		String time = tt.substring(0,3);
		System.out.println(time);
		
		String t1 = "20";
		String upt = time+t1;
		System.out.println(upt);
		
		  String str1 = "13:60";
	      if(str1.equals("13:60"))
	      {
	    	  String str2 = str1.substring(0,2);
	    	  int tt2 = Integer.valueOf(str2);
	    	   int uptt = tt2+1;
	    	   String str = ""+uptt+":00";
	    	   System.out.println(str);
	      }
	      else
	      {
	    	  System.out.println("time is not updated");
	      }
	}
}
