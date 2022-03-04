package fds.lab2.rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.concurrent.ThreadLocalRandom;

public class Server implements LetterCounter {

  // Constant for (client) transport timeout setting
  static final int RMI_TIMEOUT_MS = 2000;

  private Server() {}
  
  // Implement the LetterCounter interface
  public int printAndCountLetters(String message){
    // Server-side method for printing the input message and returning its length
    System.out.println("message = " + message);
    int count = message.length();

    // To simulate time-outs, sleep for a random amount of time either just within or outside the client timeout setting (2000)
    try {
      int minSleep = (int) Math.round(0.995 * RMI_TIMEOUT_MS);
      int maxSleep = (int) Math.round(1.01 * RMI_TIMEOUT_MS);
      int randomSleep = ThreadLocalRandom.current().nextInt(minSleep, maxSleep);
      Thread.sleep(randomSleep);
    } catch (InterruptedException ie) {
      Thread.currentThread().interrupt();
    }

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
