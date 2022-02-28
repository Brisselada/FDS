import java.io.*;
import java.net.*;

public class Server {

  public static void main(String[] args){
    try {  
      ServerSocket ss = new ServerSocket(4242);
      Socket s = ss.accept();
      
      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      String str = (String) din.readUTF();

      int letterCount = printAndCountLetters(str);
      dout.writeUTF(Integer.toString(letterCount));
      
      dout.flush();
      dout.close();
      ss.close();
    } catch(Exception e){
      System.out.println(e);
    }
  }

  private static int printAndCountLetters(String message){
    System.out.println("message = " + message);
    int count = message.length();
    return count;
  }
}