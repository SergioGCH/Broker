/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AnimalImplementor extends UnicastRemoteObject implements Animal{
    public AnimalImplementor() throws RemoteException{
        super();//Llama al constructor de UnicastRemoteObject
    }
	//Devuelve un Animal de manera aleatoria
    @Override
    public String obtenerUnAnimal () {
    	String [] animals = {"Pato","Tortuga", "Tiburón"};
        return animals[(int)(Math.random() * 2)];
    }
	//Comprueba si <animal> es un animal
    @Override
    public boolean esAnimal(String animal) {
        return animal.equals("Pato") || animal.equals("Tortuga") || 
                animal.equals("Tiburón");
    }
	//Comprueba si <animal> es "Pato"
    private boolean esPato(String animal) throws RemoteException {
        return animal.equals("Pato");
    }
	//Comprueba si <animal> es "Tiburon"
    private boolean esTiburon(String animal) throws RemoteException {
        return animal.equals("Tiburón");
    }
	//Comprueba si <animal> es "Tortuga"
    private boolean esTortuga(String animal) throws RemoteException {
        return animal.equals("Tortuga");
    }
    
}
