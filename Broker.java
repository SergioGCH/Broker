/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
 import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Broker extends ServicioImplementor{
	public Broker() throws RemoteException
	{
		super();//Llama al constructor de ServicioImplementor
	}
    public static void main(String[] args) {
    //Fijar el directorio donde se encuentra el java.policy
	System.setProperty("java.security.policy", "./java.policy");
	//Crear administrador de seguridad
	System.setSecurityManager(new SecurityManager());

	//Nombre o IP del host donde reside el broker
	String hostBroker = args[0];;
	//Nombre del broker
	String nombreBroker = "Broker520";
         try {
            System.out.println("Creando objeto servicio");
            //Instanciar el objeto 
            ServicioImplementor servicio = new ServicioImplementor();
            System.out.println("Creando referencia a objecto remoto");
            // Registrar el objeto remoto
            Naming.rebind("//" + hostBroker + "/"+nombreBroker, servicio);
            System.out.println("El broker se ha registrado");
        } catch (Exception e) {
            System.out.println("Error en Broker: " + e.getMessage());
        }
    }
}
