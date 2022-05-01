package distributed;

import java.net.*;    
import java.io.*;
public class server   
{
  public static void main(String args[]) throws Exception { // establishing the connection with the server
     ServerSocket sersock = new ServerSocket(4000);
     System.out.println("Server ready for connection");
     
     Socket sock;
     while ((sock = sersock.accept()) != null) {
	     System.out.println("Connection is successful and wating for chatting");
	                                                                                                 
	     // reading the file name from client
	     InputStream istream = sock.getInputStream();
	     BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));
	     int value =  Integer.parseInt(fileRead.readLine());
	     
	     String metreString = String.valueOf(value * 0.3048);
	     
				           
	     // keeping output stream ready to send the contents
	     OutputStream ostream = sock.getOutputStream();
	     PrintWriter pwrite = new PrintWriter(ostream, true);
	     
	     pwrite.println("The value in metres is:" + metreString);   
	     pwrite.close();
	     fileRead.close();
	     sock.close();
    }
    sersock.close();       // closing network sockets
  }
}