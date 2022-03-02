package fds.lab2.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LetterCounter extends Remote{
  public int printAndCountLetters(String message) throws RemoteException;
}
