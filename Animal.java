/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.rmi.Remote;

public interface Animal extends Remote {
	//Devuelve un Animal de manera aleatoria
	 String obtenerUnAnimal () throws java.rmi.RemoteException;
	//Comprueba si <animal> es un animal
     boolean esAnimal(String animal) throws java.rmi.RemoteException;
}
