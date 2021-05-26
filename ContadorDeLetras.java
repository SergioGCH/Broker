import java.rmi.Remote;

public interface ContadorDeLetras extends Remote{
    int cuentaLetras(String linea) throws java.rmi.RemoteException;
    int cuentaNumeros(String linea) throws java.rmi.RemoteException;
}
