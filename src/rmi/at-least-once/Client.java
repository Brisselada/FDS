package fds.lab2.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

  static final int RMI_TIMEOUT_MS = 2000;

  private Client() {}

  public static void main(String[] args){
    System.setProperty("sun.rmi.transport.tcp.responseTimeout", Integer.toString(RMI_TIMEOUT_MS));
    String host = (args.length < 1) ? null : args[0];

    try {  
      Registry registry = LocateRegistry.getRegistry(host);
      LetterCounter stub = (LetterCounter) registry.lookup("LetterCounter");

      Boolean success = false;
      int letterCount = -1;

      while(!success){
        try{
          letterCount = stub.printAndCountLetters("Hello Server");
          success = true;
        } catch(java.rmi.UnmarshalException ste){
          System.out.println("RMI timed out after " + Integer.toString(RMI_TIMEOUT_MS) + " ms, retrying...");
        } 
      }


      System.out.println("length = " + Integer.toString(letterCount));
    } catch(Exception e){
      System.out.println(e);
    }
  }
}
