package fds.lab2.rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements LetterCounter {

  private Server() {}
  
  // Implement the LetterCounter interface
  public int printAndCountLetters(String message){
    // Server-side method for printing the input message and returning its length
    System.out.println("message = " + message);
    int count = message.length();

    return count;
  }

  public static void main(String[] args){
    try {  
      System.out.println("Server starting...");

      // Instantiate the server
      Server obj = new Server();

      // Create the RMI stub by marshalling the Server object containing the interface implementation
      LetterCounter stub = (LetterCounter) UnicastRemoteObject.exportObject(obj, 0);

      // Locate the RMI regsitry (localhost)
      Registry registry = LocateRegistry.getRegistry();

      // Bind the RMI stub to the 'LetterCounter' name in the RMI registry to expose it for RMI
      registry.bind("LetterCounter", stub);

      System.out.println("Server ready!");
    } catch(Exception e){
      System.out.println(e);
      e.printStackTrace();
    }
  }
}
