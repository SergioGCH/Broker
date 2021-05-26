import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServidorA extends AnimalImplementor{
	public ServidorA() throws RemoteException
	{
		super();//Llama al constructor de AnimalImplementor
		//Inicializar las variables privadas
	}
    public static void main(String[] args) {
	//Fijar el directorio donde se encuentra el java.policy
	System.setProperty("java.security.policy", "./java.policy");
	if (System.getSecurityManager() == null) {
		//Crear administrador de seguridad
		System.setSecurityManager(new SecurityManager());
	}
	//Nombre o IP del host donde reside el broker
	String hostBroker = args[0];;
	//Nombre del broker
	String nombreBroker = "Broker520";
	///Nombre o IP del host donde reside el objeto servidor
	String hostServidor = args[1];; //se puede usar "IP" o "IP:puerto"
	//Por defecto RMI usa el puerto 1099
	//Nombre del servidor
	String nombreServidor = "ServidorA520";

         try {
            System.out.println("Preparando servidor RMI...");
            // Instanciar el objeto servidor
            AnimalImplementor animal = new AnimalImplementor();
            System.out.println("Creando referencia a objecto remoto");
	    // Registrar el objeto remoto
            Naming.rebind("//"+hostServidor+"/"+nombreServidor, animal);
            System.out.println("Buscando broker");
            Servicio servicio = (Servicio) Naming.lookup("//"+hostBroker+"/"+nombreBroker);
            System.out.println("Registrando servidor");
            servicio.registrar_servidor(nombreServidor, hostServidor);
            System.out.println("El servidorA se ha registrado");
        } catch (Exception e) {
            System.out.println("Error en Servidor: " + e.getMessage());
        }
    }
    
}
