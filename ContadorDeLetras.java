import java.rmi.Remote;

public interface ContadorDeLetras extends Remote{
    int cuentaLetras(String palabra) throws java.rmi.RemoteException;
}
