/* AUTORES: Binhui Chen Zhou (779799), Sergio García-Campero Hernández (721520) */
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServidorB extends ContadorDeLetrasImplementor{

    public ServidorB() throws RemoteException
	{
		super();//Llama al constructor de ContadorDeLetrasImplementor
	}
	
    public static void main(String[] args) {
		//Fijar el directorio donde se encuentra el java.policy
		System.setProperty("java.security.policy", "./java.policy");
		if (System.getSecurityManager() == null) {
			//Crear administrador de seguridad
			System.setSecurityManager(new SecurityManager());
		}
		//Nombre o IP del host donde reside el broker
		String hostBroker = args[0];
		//Nombre del broker
		String nombreBroker = "Broker520";
		///Nombre o IP del host donde reside el objeto servidor
		String hostServidor = args[1];
		//Nombre del servidor
		String nombreServidor = "ServidorB520";
		try {
			System.out.println("Preparando servidor RMI...");
		    // Instanciar el objeto servidor
			ContadorDeLetrasImplementor contador = new ContadorDeLetrasImplementor();
			// Registrar el objeto remoto
	        Naming.rebind("//"+hostServidor+"/"+nombreServidor, contador);
	        System.out.println("Buscando broker");
	        // Buscar el Broker
	        Servicio servicio = (Servicio) Naming.lookup("//"+hostBroker+"/"+nombreBroker);
	        System.out.println("Registrando servidor");
	        // Registrar el servidor
	        servicio.registrar_servidor(nombreServidor, hostServidor);
	        System.out.println("Servidor "+nombreServidor+" escuchando...");
		} catch (Exception e) {
			System.out.println("Error en Servidor: " + e.getMessage());
		}
    }
    
}
