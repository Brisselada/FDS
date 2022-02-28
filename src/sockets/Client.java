import java.io.*;
import java.net.*;

public class Client {

  public static void main(String[] args){
    try {
      Socket s = new Socket("localhost", 4242);

      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      dout.writeUTF("Hello Server");

      String letterCount = (String) din.readUTF();
      System.out.println("length = " + letterCount);

      dout.flush();
      dout.close();
      s.close();
    } catch(Exception e){
      System.out.println(e);
    }
  }
}