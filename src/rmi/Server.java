import java.rmi.*;

public class Server {

  private Server() {}
  
  public int printAndCountLetters(String message){
    System.out.println("message = " + message);
    int count = message.length();
    return count;
  }

  public static void main(String[] args){
    try {  
      Server obj = new Server();
      LetterCounter stub = (LetterCounter) UnicastRemoteObject.exportObject(obj, 0);

      Registry registry = LocateRegistry.getRegistry();
      registry.bind("LetterCounter", stub);

      System.out.println("Server ready!");
    } catch(Exception e){
      System.out.println(e);
    }
  }
}