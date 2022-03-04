package fds.lab2.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Decleare the interface for the RMI method
public interface LetterCounter extends Remote{
  public int printAndCountLetters(String message) throws RemoteException;
}
