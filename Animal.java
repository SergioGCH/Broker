import java.rmi.Remote;

public interface Animal extends Remote {
     boolean esAnimal(String animal) throws java.rmi.RemoteException;
     boolean esPato(String animal) throws java.rmi.RemoteException;
     boolean esTiburon(String animal) throws java.rmi.RemoteException;
     boolean esTortuga(String animal) throws java.rmi.RemoteException;
}
