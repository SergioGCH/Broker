import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Broker extends ServicioImplementor{
	public Broker() throws RemoteException
	{
		super();//Llama al constructor de UnicastRemoteObject
		//Inicializar las variables privadas
	}
    public static void main(String[] args) {
        //Fijar el directorio donde se encuentra el java.policy
	//El segundo argumento es la ruta al java.policy
	System.setProperty("java.security.policy", "./java.policy");
	//Crear administrador de seguridad
	System.setSecurityManager(new SecurityManager());

	//Nombre o IP del host donde reside el broker
	String hostBroker = args[0];;
	//Nombre del broker
	String nombreBroker = "Broker520";
	//Por defecto RMI usa el puerto 1099
         try {
            System.out.println("Creando objeto servicio");
            ServicioImplementor servicio = new ServicioImplementor();
            System.out.println("Creando referencia a objecto remoto");
            Naming.rebind("//" + hostBroker + "/"+nombreBroker, servicio);
            System.out.println("El broker se ha registrado");
        } catch (Exception e) {
            System.out.println("Error en Broker: " + e.getMessage());
        }
    }
}
