package fds.lab2.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

  private Client() {}

  public static void main(String[] args){
    String host = (args.length < 1) ? null : args[0];
    try {  
      Registry registry = LocateRegistry.getRegistry(host);
      LetterCounter stub = (LetterCounter) registry.lookup("LetterCounter");

      int letterCount = stub.printAndCountLetters("Hello Server");
      System.out.println("length = " + Integer.toString(letterCount));
    } catch(Exception e){
      System.out.println(e);
    }
  }
}
