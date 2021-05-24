import java.rmi.RemoteException;

public class ContadorDeLetrasImplementor implements ContadorDeLetras{

    @Override
    public int cuentaLetras(String palabra) throws RemoteException {
        return palabra.length();
    }
    
}
