import java.io.*;
import java.net.*;

public class Server {

  private static int printAndCountLetters(String message){
    // Server-side method for printing the input message and returning its length
    System.out.println("message = " + message);
    int count = message.length();

    return count;
  }

  public static void main(String[] args){
    try {
      // Instantiate the server's socket
      ServerSocket ss = new ServerSocket(4242);
      // Accept client connection
      Socket s = ss.accept();
      
      // Instantiate input and output data streams
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      // Receive input message from client over the input data stream
      String msg = (String) din.readUTF();

      // Process the input message
      int letterCount = printAndCountLetters(msg);

      // Send the message length back to the client
      dout.writeUTF(Integer.toString(letterCount));

      System.out.println("Press any key to exit...");
      try{
        System.in.read();
      } catch(Exception e){}
      
      // Clean up
      dout.flush();
      dout.close();
      ss.close();
    } catch(Exception e){
      System.out.println(e);
    }
  }

}
