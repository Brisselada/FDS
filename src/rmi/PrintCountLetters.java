import java.rmi.*;

public interface LetterCounter extends Remote{
  public int printAndCountLetters(String message) throws RemoteException;
}