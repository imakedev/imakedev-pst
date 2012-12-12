package th.co.aoe.imake.pst.backoffice.service.impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class FileRead {
	public static void main(String args[])
	  {
	  try{
	  // Open the file that is the first 
	  // command line parameter
	  FileInputStream fstream = new FileInputStream("/usr/local/data/BACK_UP/Work/Server/apache-tomcat-7.0.27/aoe3.txt");
	  // Get the object of DataInputStream
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  //Read File Line By Line
	  String x="";
      handleCharacters(br);
	 /* StringBuffer buString=new StringBuffer();
	  while ((strLine = br.readLine()) != null)   {
	  // Print the content on the console
	  System.out.println (strLine);
	  buString.append(strLine);
	  x=x+strLine;
	  }*/
	  //Close the input stream
	 /* System.out.println("debug str="+x);
	  byte[] bs=buString.toString().getBytes("UTF-8");
	  for (int i = 0; i < bs.length; i++) {
		byte b = bs[i];
		//-78
		System.out.println(""+b);
	}*/
	  /*System.out.println("xx"+new String(buString.toString().getBytes()));
	  System.out.println("xx2"+new String(bs));*/
	  in.close();
	    }catch (Exception e){//Catch exception if any
	  System.err.println("Error: " + e.getMessage());
	  }
	  }

    private static void handleCharacters(BufferedReader reader)
            {
    	try{
        int r;
        StringBuffer buString =new StringBuffer(); 
    
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            byte bValue = (byte)ch;
            System.out.println("Byte is:=" + bValue);
            if(bValue==11){
            	//ch="้";
            	/*ch=11;
            	byte[] bV=new byte[1];            	
            	bV[0]=bValue;
            	String sss=new String(bV);
            	char[] chars = sss.toCharArray();
                System.out.println(chars.length+",้");*/
            	System.out.println(" recplace with ้" );
                buString.append("้");
            }else if(bValue==18){
            	System.out.println(" recplace with ็" );
            	 buString.append("็");
            }else if(bValue==10 && ch!='ช' && ch!='\n'){
            	System.out.println(" recplace with ่" );
           	 buString.append("่");
            	
            }else{
            	 buString.append(ch);
            }
            
            System.out.println("Do something with x" + ch+"x");
        }
        System.out.println("xxxxxxxxxxxx"+buString.toString());
      
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
}
