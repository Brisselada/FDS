package fds.lab2.rmi;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements LetterCounter {

  private Server() {}
  
  public int printAndCountLetters(String message){
    System.out.println("message = " + message);
    int count = message.length();
    return count;
  }

  public static void main(String[] args){
    try {  
      System.out.println("Server starting...");
      Server obj = new Server();
      LetterCounter stub = (LetterCounter) UnicastRemoteObject.exportObject(obj, 0);

      Registry registry = LocateRegistry.getRegistry();
      registry.bind("LetterCounter", stub);

      System.out.println("Server ready!");
    } catch(Exception e){
      System.out.println(e);
      e.printStackTrace();
    }
  }
}
