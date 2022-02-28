import java.rmi.*;

public class Client {

  private Client() {}

  public static void main(String[] args){
    try {  
      Registry registry = LocateRegistry.getRegistry();
      LetterCounter stub = (LetterCounter) registry.lookup("LetterCounter");
      String letterCount = stub.printAndCountLetters("Hello Server");
      System.out.println("length = " + letterCount);
    } catch(Exception e){
      System.out.println(e);
    }
  }

}