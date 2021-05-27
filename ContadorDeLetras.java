/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.rmi.Remote;

public interface ContadorDeLetras extends Remote{
	//Cuenta el número de letras que contiene <line>
    int cuentaLetras(String linea) throws java.rmi.RemoteException;
    //Cuenta el número de veces que <num> aparece en <line>
    int cuentaDigito(String linea, int num) throws java.rmi.RemoteException;
}
