import java.rmi.RemoteException;

public class AnimalImplementor implements Animal{

    @Override
    public boolean esAnimal(String animal) {
        return animal.equals("Pato") || animal.equals("Tortuga") || 
                animal.equals("Tiburón");
    }

    @Override
    public boolean esPato(String animal) throws RemoteException {
        return animal.equals("Pato");
    }

    @Override
    public boolean esTiburon(String animal) throws RemoteException {
        return animal.equals("Tiburón");
    }

    @Override
    public boolean esTortuga(String animal) throws RemoteException {
        return animal.equals("Tortuga");
    }
    
}
