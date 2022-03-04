package fds.lab2.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

  private Client() {}

  public static void main(String[] args){
    // Read the RMI registry host from the cli arguments if provided
    String host = (args.length < 1) ? null : args[0];

    try {  
      // Locate the RMI regsitry
      Registry registry = LocateRegistry.getRegistry(host);

      // Look up the LetterCounter stub in the RMI registry
      LetterCounter stub = (LetterCounter) registry.lookup("LetterCounter");

      // Invoke the remote method with the message
      int letterCount = stub.printAndCountLetters("Hello Server");

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
