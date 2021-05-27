/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContadorDeLetrasImplementor extends UnicastRemoteObject implements ContadorDeLetras {
	public ContadorDeLetrasImplementor() throws RemoteException{
		super();//Llama al constructor de UnicastRemoteObject
	}
	
	//Cuenta el número de letras que contiene <line>
    @Override
    public int cuentaLetras(String linea) throws RemoteException {
    	int cuenta = 0;
    	for (int i=0; i<linea.length(); i++){
    		if (Character.isLetter(linea.charAt(i)))
    			cuenta++;
    	}
        return cuenta;
    }
    
    //Cuenta el número de veces que <num> aparece en <line>
    @Override    
    public int cuentaDigito(String linea, int num) throws RemoteException{
    	int cuenta = 0;
    	for (int i=0; i<linea.length(); i++){
    		if (Character.getNumericValue(linea.charAt(i))==num)
    			cuenta++;
    	}
        return cuenta;
    }
}
