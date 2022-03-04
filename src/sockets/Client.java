import java.io.*;
import java.net.*;

public class Client {

  public static void main(String[] args){
    try {
      // Connect to the server over the socket
      Socket s = new Socket("localhost", 4242);

      // Instantiate input and output data streams
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      // Send the message to the server over the output data stream
      dout.writeUTF("Hello Server");

      // Receive and print the output
      String letterCount = (String) din.readUTF();
      System.out.println("length = " + letterCount);

      System.out.println("Press any key to exit...");
      try{
        System.in.read();
      } catch(Exception e){}

      // Clean up
      dout.flush();
      dout.close();
      s.close();
    } catch(Exception e){
      System.out.println(e);
    }
  }
}
