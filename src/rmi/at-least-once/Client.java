package fds.lab2.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

  // Constant for (client) transport timeout setting
  static final int RMI_TIMEOUT_MS = 2000;

  private Client() {}

  public static void main(String[] args){
    // Set the RMI transport timeout property (default is 2 hours)
    System.setProperty("sun.rmi.transport.tcp.responseTimeout", Integer.toString(RMI_TIMEOUT_MS));

    // Read the RMI registry host from the cli arguments if provided
    String host = (args.length < 1) ? null : args[0];

    try {  
      // Locate the RMI regsitry
      Registry registry = LocateRegistry.getRegistry(host);

      // Look up the LetterCounter stub in the RMI registry
      LetterCounter stub = (LetterCounter) registry.lookup("LetterCounter");

      // Flag for success to achieve at-least-once semantics
      Boolean success = false;
      int letterCount = -1;

      // Retry until a result is received within the timeout
      while(!success){
        try{
          // Attempt to invoke the remote method with the message
          letterCount = stub.printAndCountLetters("Hello Server");
          success = true;
        } catch(java.rmi.UnmarshalException ste){
          // Catch the exception, print and continue with a retry
          System.out.println("RMI timed out after " + Integer.toString(RMI_TIMEOUT_MS) + " ms, retrying...");
          success = false;
        } 
      }

      // Print the output
      System.out.println("length = " + Integer.toString(letterCount));

      System.out.println("Press any key to exit...");
      try{
        System.in.read();
      } catch(Exception e){}
      
    } catch(Exception e){
      System.out.println(e);
    }
  }
}
