import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContadorDeLetrasImplementor extends UnicastRemoteObject implements ContadorDeLetras {
	public ContadorDeLetrasImplementor() throws RemoteException{
		super();
	}
    @Override
    public int cuentaLetras(String linea) throws RemoteException {
    	int cuenta = 0;
    	for (int i=0; i<linea.length(); i++){
    		if (Character.isLetter(linea.charAt(i)))
    			cuenta++;
    	}
        return cuenta;
    }

    @Override
    public int cuentaNumeros(String linea) throws RemoteException {
    	int cuenta = 0;
    	for (int i=0; i<linea.length(); i++){
    		if (Character.isDigit(linea.charAt(i)))
    			cuenta++;
    	}
        return cuenta;
    }
    
}
