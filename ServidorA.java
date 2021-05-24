import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorA extends AnimalImplementor{

    public ServidorA(){
        
    }
    public static void main(String[] args) {
         try {
            System.out.println("Preparando servidor RMI...");
            // Instanciamos la clase implementada
            AnimalImplementor animal = new AnimalImplementor();
            // Exportamos el objeto de la clase implementada
            // Con port=0 se usará el puerto por defecto de RMI, el 1099
            Animal stub = (Animal) UnicastRemoteObject.exportObject(animal, 0);
            // Vinculamos el objeto remoto (stub) en el registro (rmiregistry)
            Registry registry = LocateRegistry.getRegistry();
            // Enlazamos el stub y nombramos el objeto remoto RMI como "rmiPrimo"
            registry.bind("animal", stub);
            System.out.println("Servidor RMI escuchando...");
        } catch (Exception e) {
            System.out.println("Error en Servidor: " + e.getMessage());
        }
    }
    
}
